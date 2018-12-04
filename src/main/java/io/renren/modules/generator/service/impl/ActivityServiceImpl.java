package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
//import io.renren.common.utils.PageUtils;
//import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.ActivityDao;
import io.renren.modules.generator.entity.ActivityEntity;
import io.renren.modules.generator.service.ActivityService;


@Service("activityService")
public class ActivityServiceImpl extends ServiceImpl<ActivityDao, ActivityEntity> implements ActivityService {

    @Override
    public List<ActivityEntity> getActivityInfo(Integer pageSize , Integer pageIndex , Integer start ){

        List<ActivityEntity> activityEntities = baseMapper.getActivityInfo(pageSize , pageIndex , start );

        return activityEntities;
    }

    @Override
    public Integer count() {

        return baseMapper.count();
    }
//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        Page<ActivityEntity> page = this.selectPage(
//                new Query<ActivityEntity>(params).getPage(),
//                new EntityWrapper<ActivityEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}
