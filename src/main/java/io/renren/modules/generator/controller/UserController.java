package io.renren.modules.generator.controller;

import java.sql.Time;
import java.sql.Wrapper;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.entity.CodeEntity;
import io.renren.modules.generator.utils.BaseResp;
import io.renren.modules.generator.utils.JWTUtil;
import io.renren.modules.generator.utils.MailUtil;
import io.renren.modules.generator.utils.StringTools;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.UserEntity;
import io.renren.modules.generator.entity.CodeEntity;
import io.renren.modules.generator.service.UserService;
import io.renren.modules.generator.service.CodeService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CodeService codeService;

    /**
     * 查找用户信息
     */
    @RequestMapping("/info")
    public BaseResp info(String username){

        if(StringTools.isNullOrEmpty(username)){
            return BaseResp.error("请输入用户名");
        }

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        if(null == userEntity){
            return BaseResp.error("没有该用户");
        }

        return BaseResp.ok(userEntity);
    }

    /**
     * 增加注册用户
     */
    @RequestMapping("/saveUser")
    public BaseResp saveUser(String username, String emailcode,String password, String firstName,String lastName,Integer gender,String personalProfile){

        if (StringTools.isNullOrEmpty(username)){
            return BaseResp.error("邮箱不能为空");
        }
        if (StringTools.isNullOrEmpty(emailcode)){
            return BaseResp.error("验证码不能为空");
        }
        if (StringTools.isNullOrEmpty(password)){
            return BaseResp.error("密码不能为空");
        }
        if (StringTools.isNullOrEmpty(firstName)){
            return BaseResp.error("名字不能为空");
        }
        if (StringTools.isNullOrEmpty(lastName)){
            return BaseResp.error("姓氏不能为空");
        }
        if (gender==null){
            return BaseResp.error("性别不能为空");
        }

        CodeEntity codeEntity = codeService.selectOne(new EntityWrapper<CodeEntity>().eq("username",username));

        if(codeEntity == null){
            return BaseResp.error("用户不存在");
        }

        UserEntity user = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        if (user != null){
            return BaseResp.error("用户已存在");
        }

        long time = System.currentTimeMillis();
        Date date = codeEntity.getCreatedTime();
        long codetime = date.getTime();

        if(time - codetime > 300000){
            return BaseResp.error("验证码已过期");
        }

        if (!codeEntity.getEmailCode().equals(emailcode) ){
            return BaseResp.error("验证码错误");
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(username);

        password = StringTools.Encrypt(password,null);

        userEntity.setPassword(password);

        userEntity.setFirstName(firstName);

        userEntity.setLastName(lastName);

        userEntity.setGender(gender);

        userEntity.setPersonalProfile(personalProfile);

        userEntity.setCreatedTime(new Date());

        boolean result =  userService.insert(userEntity);

        if (!result){
            return BaseResp.error("增加用户失败");
        }

        return BaseResp.ok("注册成功");
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/updateUser")
    @RequiresAuthentication
    public BaseResp updateUser(HttpServletRequest request,@RequestBody UserEntity userEntity){
        if (null == userEntity){
            return BaseResp.error("数据为空");
        }
        String username = JWTUtil.getCurrentUsername(request);
            userEntity.setUsername(username);
          int result =userService.updateUser(userEntity);

        if (result==1){
            return BaseResp.ok("更新用户信息成功");
        }
        return BaseResp.error("更新用户信息失败");
    }

    /**
     * 登录
     */
    @RequestMapping("/login")
    public BaseResp login(String username,String password){

        if (StringTools.isNullOrEmpty(username)){
            return BaseResp.error("邮箱不能为空");
        }
        if (StringTools.isNullOrEmpty(password)){
            return BaseResp.error("密码不能为空");
        }

        password = StringTools.Encrypt(password,null);

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        if(userEntity == null){
            return BaseResp.error("用户不存在");
        }

        if(!userEntity.getPassword() .equals(password) ){
            return BaseResp.error("密码错误，登录失败");
        }
        String token = JWTUtil.sign(username);
        BaseResp baseResp = new BaseResp();
        baseResp.setMsg("登录成功");
        baseResp.setData(token);
        return baseResp;
    }

    /**
     * 忘记密码(通过邮箱验证码修改密码)
     */
    @RequestMapping("/passwordChange")
    public BaseResp passwordChange(String username,String emailcode,String password) throws MessagingException {

        if (StringTools.isNullOrEmpty(username)){
            return BaseResp.error("邮箱不能为空");
        }
        if (StringTools.isNullOrEmpty(emailcode)){
            return BaseResp.error("验证码不能为空");
        }
        if (StringTools.isNullOrEmpty(password)){
            return BaseResp.error("密码不能为空");
        }

        CodeEntity codeEntity = codeService.selectOne(new EntityWrapper<CodeEntity>().eq("username",username));

        long now =System.currentTimeMillis();
        Date date = codeEntity.getCreatedTime();
        long codetime = date.getTime();

        if(now - codetime > 300000){
            return BaseResp.error("验证码已过期");
        }

        if(!codeEntity.getEmailCode().equals(emailcode) ){
            return BaseResp.error("验证码错误");
        }

        password = StringTools.Encrypt(password,null);

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        if (null==userEntity){
            return BaseResp.error("找不到用户名为 : "+username+"的用户");
        }
        userEntity.setPassword(password);

        boolean result1 = userService.update(userEntity,new EntityWrapper<UserEntity>().eq("username",username));

        if(!result1){
            return BaseResp.error("修改密码失败");
        }

        return BaseResp.ok("修改密码成功");

    }

}
