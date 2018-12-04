package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.entity.UserEntity;
import io.renren.modules.generator.utils.BaseResp;
import io.renren.modules.generator.utils.StringTools;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.UserDataEntity;
import io.renren.modules.generator.service.UserDataService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("/userdata")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;


    /**
     * 新增用户信息
     */
    @RequestMapping("/saveuserdata")
    public BaseResp save(String username, String dataType, String dataTitle, String dataContent){

        UserDataEntity userDataEntity = new UserDataEntity();

        userDataEntity.setUsername(username);

        userDataEntity.setDataType(dataType);

        userDataEntity.setDataTitle(dataTitle);

        userDataEntity.setDataContent(dataContent);

        userDataEntity.setCreatedTime(new Date());

        boolean result =  userDataService.insert(userDataEntity);

        if (!result){
            return BaseResp.error("更新用户信息失败");
        }

        return BaseResp.ok("更新用户信息成功");
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/update")
    public BaseResp update(String username, String dataType, String dataTitle, String dataContent){

        if(StringTools.isNullOrEmpty(username)){
            return BaseResp.error("请输入用户名");
        }
        if (StringTools.isNullOrEmpty(dataType)){
            return  BaseResp.error("信息类型不能为空");
        }

        UserDataEntity userDataEntity = userDataService.selectOne(new EntityWrapper<UserDataEntity>().eq("username",username));

        userDataEntity.setDataType(dataType);

        userDataEntity.setDataTitle(dataTitle);

        userDataEntity.setDataContent(dataContent);

        userDataEntity.setUpdatedTime(new Date());

        boolean result =  userDataService.update(userDataEntity,new EntityWrapper<UserDataEntity>().eq("username",username));

        if (!result){
            return BaseResp.error("更新用户信息失败");
        }

        return BaseResp.ok("更新用户信息成功");
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteuserdata")
    public BaseResp delete(int id){

        boolean result =  userDataService.delete(new EntityWrapper<UserDataEntity>().eq("id",id));

        if (!result){
            return BaseResp.error("更新用户信息失败");
        }

        return BaseResp.ok("更新用户信息成功");
    }
//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:userdata:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = userDataService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:userdata:info")
//    public R info(@PathVariable("id") Integer id){
//			UserDataEntity userData = userDataService.selectById(id);
//
//        return R.ok().put("userData", userData);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:userdata:save")
//    public R save(@RequestBody UserDataEntity userData){
//			userDataService.insert(userData);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:userdata:update")
//    public R update(@RequestBody UserDataEntity userData){
//			userDataService.updateById(userData);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:userdata:delete")
//    public R delete(@RequestBody Integer[] ids){
//			userDataService.deleteBatchIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
