package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

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
@RequestMapping("generator/userdata")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;

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
