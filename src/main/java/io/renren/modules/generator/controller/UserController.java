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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.UserEntity;
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
    @RequestMapping("/saveuser")
    public BaseResp save(String username, String emailcode,String password, String nickname,Integer gender, String avatarUrl, String personalProfile){

        if (StringTools.isNullOrEmpty(username)){
            return BaseResp.error("邮箱不能为空");
        }
        if (StringTools.isNullOrEmpty(emailcode)){
            return BaseResp.error("验证码不能为空");
        }
        if (StringTools.isNullOrEmpty(password)){
            return BaseResp.error("密码不能为空");
        }
        if (StringTools.isNullOrEmpty(nickname)){
            return BaseResp.error("邮箱不能为空");
        }
        if (gender==null){
            return BaseResp.error("性别不能为空");
        }
        if (StringTools.isNullOrEmpty(avatarUrl)){
            return BaseResp.error("头像不能为空");
        }
        CodeEntity codeEntity = codeService.selectOne(new EntityWrapper<CodeEntity>().eq("username",username));

        if(codeEntity == null){
            return BaseResp.error("用户不存在");
        }

        long time = System.currentTimeMillis();
        Date date = codeEntity.getCreatedTime();
        long codetime = date.getTime();

        if(time - codetime > 60000){
            return BaseResp.error("验证码已过期");
        }

        if (codeEntity.getEmailCode() != emailcode){
            return BaseResp.error("验证码错误");
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(username);

        password = StringTools.Encrypt(password,null);

        userEntity.setPassword(password);

        userEntity.setNickname(nickname);

        userEntity.setGender(gender);

        userEntity.setAvatarUrl(avatarUrl);

        userEntity.setPersonalProfile(personalProfile);

        userEntity.setCreatedTime(new Date());

        userService.insert(userEntity);

        boolean result =  userService.insert(userEntity);

        if (!result){
            return BaseResp.error("增加用户失败");
        }

        return BaseResp.ok("增加用户成功");
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/updateuser")
    public BaseResp update(String username, String nickname, Integer gender,String avatarUrl, String personalProfile){

        if (StringTools.isNullOrEmpty(nickname)){
            return BaseResp.error("姓名不能为空");
        }
        if (gender==null){
            return BaseResp.error("性别不能为空");
        }
        if (StringTools.isNullOrEmpty(avatarUrl)){
            return BaseResp.error("头像不能为空");
        }

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        userEntity.setNickname(nickname);

        userEntity.setAvatarUrl(avatarUrl);

        userEntity.setPersonalProfile(personalProfile);

        userEntity.setUpdatedTime(new Date());

        boolean result =  userService.update(userEntity,new EntityWrapper<UserEntity>().eq("username",username));

        if (!result){
            return BaseResp.error("更新用户信息失败");
        }

        return BaseResp.ok("更新用户信息成功");
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

        if(userEntity.getPassword() != password){
            return BaseResp.error("密码错误，登录失败");
        }
        return BaseResp.ok("登录成功");

    }

    /**
     * 忘记密码(通过邮箱验证码修改密码)
     */
    @RequestMapping("/passwordchange")
    public BaseResp change(String username,String password) throws MessagingException {

        if (StringTools.isNullOrEmpty(username)){
            return BaseResp.error("邮箱不能为空");
        }

        String emailcode = MailUtil.sendMail(username);

        CodeEntity codeEntity = codeService.selectOne(new EntityWrapper<CodeEntity>().eq("username",username));

        long time = System.currentTimeMillis();
        Date date = codeEntity.getCreatedTime();
        long codetime = date.getTime();

        if(time - codetime > 60000){
            return BaseResp.error("验证码已过期");
        }

        if (StringTools.isNullOrEmpty(emailcode)){
            return BaseResp.error("验证码不能为空");
        }

        if(codeEntity.getEmailCode() != emailcode){
            return BaseResp.error("验证码错误");
        }

        password = StringTools.Encrypt(password,null);

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        userEntity.setPassword(password);

        boolean result = userService.update(userEntity,new EntityWrapper<UserEntity>().eq("username",username));

        if(!result){
            return BaseResp.error("修改密码失败");
        }

        return BaseResp.ok("修改密码成功");

    }

}
