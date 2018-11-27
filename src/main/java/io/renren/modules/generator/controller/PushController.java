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

import io.renren.modules.generator.entity.PushEntity;
import io.renren.modules.generator.service.PushService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("generator/push")
public class PushController {
    @Autowired
    private PushService pushService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:push:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = pushService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:push:info")
//    public R info(@PathVariable("id") Integer id){
//			PushEntity push = pushService.selectById(id);
//
//        return R.ok().put("push", push);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:push:save")
//    public R save(@RequestBody PushEntity push){
//			pushService.insert(push);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:push:update")
//    public R update(@RequestBody PushEntity push){
//			pushService.updateById(push);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:push:delete")
//    public R delete(@RequestBody Integer[] ids){
//			pushService.deleteBatchIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
