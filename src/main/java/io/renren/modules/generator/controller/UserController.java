package io.renren.modules.generator.controller;

import java.sql.Time;
import java.sql.Wrapper;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.utils.BaseResp;
import io.renren.modules.generator.utils.JWTUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.UserEntity;
import io.renren.modules.generator.service.UserService;

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

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:user:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
    /**
     * 查找用户信息
     */
    @RequestMapping("/info")
    public BaseResp info(String username){

        UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("username",username));

        if(null == userEntity){
            BaseResp.error("没有该用户");
        }

        return BaseResp.ok(userEntity);
    }

    /**
     * 增加注册用户
     */
    @RequestMapping("/save")
    public BaseResp save(String username, String password, String nickname, String avatarUrl, String personalProfile){

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(username);

        userEntity.setPassword(password);

        userEntity.setNickname(nickname);

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
    @RequestMapping("/update")
    public BaseResp update(String username, String nickname, String avatarUrl, String personalProfile){

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
     * 删除用户
     */
    @RequestMapping("/delete")
    public BaseResp delete(String username){

        boolean result = userService.delete(new EntityWrapper<UserEntity>().eq("username",username));

        if(!result){
            return BaseResp.error("删除用户失败");
        }

        return BaseResp.ok("删除用户成功");
    }

}
