package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.utils.BaseResp;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ActivityEntity;
import io.renren.modules.generator.service.ActivityService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:activity:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = activityService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:activity:info")
//    public R info(@PathVariable("id") Integer id){
//			ActivityEntity activity = activityService.selectById(id);
//
//        return R.ok().put("activity", activity);
//    }
//
    /**
     * 新增活动
     */
    @RequestMapping("/save")
    public BaseResp save(String creator,String activityTitle,String activityContent){

        ActivityEntity activity = new ActivityEntity();

        activity.setCreator(creator);

        activity.setActivityTitle(activityTitle);

        activity.setActivityContent(activityContent);

        activity.setCreatedTime(new Date());

        boolean result = activityService.insert(activity);

        if(!result){
            BaseResp.error("新增活动失败");
        }

        return BaseResp.ok("新增活动成功");
    }

    /**
     * 查找活动信息
     */
    @RequestMapping("/info")
    public BaseResp info(int id){

        ActivityEntity activity = activityService.selectById(id);

        if(activity == null){
            BaseResp.error("查找活动失败");
        }

        return BaseResp.ok(activity);
    }

    /**
     * 更改活动信息
     */
    @RequestMapping("/updateactivity")
    public BaseResp update(int id,String creator,String activityTitle,String activityContent){

        ActivityEntity activity = activityService.selectById(id);

        activity.setCreator(creator);

        activity.setActivityTitle(activityTitle);

        activity.setActivityContent(activityContent);

        activity.setUpdatedTime(new Date());

        boolean result = activityService.update(activity,new EntityWrapper<ActivityEntity>().eq("id",id));

        if(!result){
            BaseResp.error("更新活动信息失败");
        }

        return BaseResp.ok("更新活动信息成功");
    }

    /**
     * 删除活动
     */
    @RequestMapping("/deleteactivity")
    public BaseResp delete(int id){

        boolean result = activityService.delete(new EntityWrapper<ActivityEntity>().eq("id",id));

        if(!result){
            BaseResp.error("更新活动信息失败");
        }

        return BaseResp.ok("更新活动信息成功");
    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:activity:delete")
//    public R delete(@RequestBody Integer[] ids){
//			activityService.deleteBatchIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
