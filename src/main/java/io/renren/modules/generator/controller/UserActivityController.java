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

import io.renren.modules.generator.entity.UserActivityEntity;
import io.renren.modules.generator.service.UserActivityService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("generator/useractivity")
public class UserActivityController {
    @Autowired
    private UserActivityService userActivityService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:useractivity:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userActivityService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:useractivity:info")
    public R info(@PathVariable("id") Integer id){
			UserActivityEntity userActivity = userActivityService.selectById(id);

        return R.ok().put("userActivity", userActivity);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:useractivity:save")
    public R save(@RequestBody UserActivityEntity userActivity){
			userActivityService.insert(userActivity);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:useractivity:update")
    public R update(@RequestBody UserActivityEntity userActivity){
			userActivityService.updateById(userActivity);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:useractivity:delete")
    public R delete(@RequestBody Integer[] ids){
			userActivityService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
