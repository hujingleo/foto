package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.generator.entity.ActivityEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
public interface ActivityService extends IService<ActivityEntity> {


    List<ActivityEntity> getActivityInfo(Integer pageSize , Integer pageIndex, Integer start);
    Integer count();
}

