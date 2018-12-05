package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.entity.UserEntity;
import io.renren.modules.generator.utils.BaseResp;
import io.renren.modules.generator.utils.JWTUtil;
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

import javax.servlet.http.HttpServletRequest;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("/userData")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;


    /**
     * 新增用户资料
     */
    @RequestMapping("/saveUserData")
    public BaseResp saveUserData(HttpServletRequest request, String dataType, String dataTitle, String dataContent){

        String username = JWTUtil.getCurrentUsername(request);

        if (StringTools.isNullOrEmpty(dataType)){
            return BaseResp.error("用户资料类型不能为空");
        }
        if (StringTools.isNullOrEmpty(dataTitle)){
            return BaseResp.error("用户资料标题不能为空");
        }
        if (StringTools.isNullOrEmpty(dataContent)){
            return BaseResp.error("用户资料内容不能为空");
        }

        UserDataEntity userDataEntity = new UserDataEntity();

        userDataEntity.setUsername(username);

        userDataEntity.setDataType(dataType);

        userDataEntity.setDataTitle(dataTitle);

        userDataEntity.setDataContent(dataContent);

        userDataEntity.setCreatedTime(new Date());

        boolean result =  userDataService.insert(userDataEntity);

        if (!result){
            return BaseResp.error("新增用户资料失败");
        }

        return BaseResp.ok("新增用户资料成功");
    }

    /**
     * 更新用户资料
     */
    @RequestMapping("/updateUserData")
    public BaseResp updateUserData(HttpServletRequest request,@RequestBody UserDataEntity userDataEntity){

        if (null == userDataEntity){
            return BaseResp.error("数据为空");
        }
        String username = JWTUtil.getCurrentUsername(request);
        userDataEntity.setUsername(username);
        int result =userDataService.updateUserData(userDataEntity);

        if (result==1){
            return BaseResp.ok("更新用户资料成功");
        }
        return BaseResp.error("更新用户资料失败");
    }

    /**
     * 删除用户信息
     */
    @RequestMapping("/deleteuserdata")
    public BaseResp deleteUserData(int id){

        boolean result =  userDataService.delete(new EntityWrapper<UserDataEntity>().eq("id",id));

        if (!result){
            return BaseResp.error("删除用户信息失败");
        }

        return BaseResp.ok("删除用户信息成功");
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
