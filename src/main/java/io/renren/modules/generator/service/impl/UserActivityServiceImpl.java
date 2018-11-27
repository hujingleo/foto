package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.UserActivityDao;
import io.renren.modules.generator.entity.UserActivityEntity;
import io.renren.modules.generator.service.UserActivityService;


@Service("userActivityService")
public class UserActivityServiceImpl extends ServiceImpl<UserActivityDao, UserActivityEntity> implements UserActivityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserActivityEntity> page = this.selectPage(
                new Query<UserActivityEntity>(params).getPage(),
                new EntityWrapper<UserActivityEntity>()
        );

        return new PageUtils(page);
    }

}
