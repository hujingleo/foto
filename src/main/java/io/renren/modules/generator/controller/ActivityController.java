package io.renren.modules.generator.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.utils.BaseResp;
import io.renren.modules.generator.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.ActivityEntity;
import io.renren.modules.generator.service.ActivityService;

import javax.validation.constraints.Size;


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

    /**
     * 获取活动列表
     */
    @RequestMapping("/listActivity")
    public BaseResp listActivity(Integer pageSize ,Integer pageIndex,Integer start,Integer count){

       try {
           if (pageSize == null || pageSize == 0 ) {
               pageSize = 10;
           }
           if (pageIndex == null|| pageIndex == 0 ){
               pageIndex = 1;
           }
       }catch (Exception e ){
           e.printStackTrace();
       }

        count = activityService.count();
        start = (pageIndex-1) * pageSize;
        if(start >= count){
            return BaseResp.error("超出页数");
        }
        try {
            List<ActivityEntity> activityEntities = activityService.getActivityInfo(pageSize , pageIndex,start);
            if (null != activityEntities){
                return BaseResp.ok(activityEntities);
            }
        }catch ( Exception e){
            e.printStackTrace();
        }

        return BaseResp.error("查询失败");
    }


    /**
     * 新增活动
     */
    @RequestMapping("/saveActivity")
    public BaseResp saveActivity(String creator,String activityTitle,String activityContent,Long startTime,Long endTime){

        if (StringTools.isNullOrEmpty(creator)){
            return BaseResp.error("创建人不能为空");
        }
        if (StringTools.isNullOrEmpty(activityTitle)){
            return BaseResp.error("活动标题不能为空");
        }
        if (StringTools.isNullOrEmpty(activityContent)){
            return BaseResp.error("活动内容不能为空");
        }
        if(startTime == null||startTime == 0){
            return BaseResp.error("请输入正确的开始日期");
        }
        if(startTime == null||endTime == 0){
            return BaseResp.error("请输入正确的结束日期");
        }

        Date date = new Date(startTime);

        Date date1 = new Date(endTime);

        ActivityEntity activity = new ActivityEntity();

        activity.setCreator(creator);

        activity.setActivityTitle(activityTitle);

        activity.setActivityContent(activityContent);

        activity.setStartTime(date);

        activity.setEndTime(date1);

        activity.setCreatedTime(new Date());

        boolean result = activityService.insert(activity);

        if(!result){
            return BaseResp.error("新增活动失败");
        }

        return BaseResp.ok("新增活动成功");
    }

    /**
     * 查找活动信息
     */
    @RequestMapping("/activityInfo")
    public BaseResp activityInfo(int id){

        ActivityEntity activity = activityService.selectById(id);

        if(activity == null){
            return BaseResp.error("查找活动失败");
        }

        return BaseResp.ok(activity);
    }

    /**
     * 更改活动信息
     */
    @RequestMapping("/update")
    public BaseResp update(int id,String creator,String activityTitle,String activityContent,Long startTime,Long endTime){

        if (StringTools.isNullOrEmpty(creator)){
            return BaseResp.error("创建人不能为空");
        }
        if (StringTools.isNullOrEmpty(activityTitle)){
            return BaseResp.error("活动标题不能为空");
        }
        if (StringTools.isNullOrEmpty(activityContent)){
            return BaseResp.error("活动内容不能为空");
        }
        if(startTime == null||startTime == 0){
            return BaseResp.error("请输入正确的开始日期");
        }
        if(startTime == null||endTime == 0){
            return BaseResp.error("请输入正确的结束日期");
        }

        Date date = new Date(startTime);

        Date date1 = new Date(endTime);

        ActivityEntity activity = activityService.selectById(id);

        activity.setCreator(creator);

        activity.setActivityTitle(activityTitle);

        activity.setActivityContent(activityContent);

        activity.setStartTime(date)
        ;
        activity.setEndTime(date1);

        activity.setUpdatedTime(new Date());

        boolean result = activityService.update(activity,new EntityWrapper<ActivityEntity>().eq("id",id));

        if(!result){
            return BaseResp.error("更新活动信息失败");
        }

        return BaseResp.ok("更新活动信息成功");
    }

    /**
     * 删除活动
     */
    @RequestMapping("/delete")
    public BaseResp delete(int id){

        boolean result = activityService.delete(new EntityWrapper<ActivityEntity>().eq("id",id));

        if(!result){
            return BaseResp.error("更新活动信息失败");
        }

        return BaseResp.ok("更新活动信息成功");
    }


}
