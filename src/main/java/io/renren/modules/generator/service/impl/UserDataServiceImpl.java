package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.UserDataDao;
import io.renren.modules.generator.entity.UserDataEntity;
import io.renren.modules.generator.service.UserDataService;


@Service("userDataService")
public class UserDataServiceImpl extends ServiceImpl<UserDataDao, UserDataEntity> implements UserDataService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserDataEntity> page = this.selectPage(
                new Query<UserDataEntity>(params).getPage(),
                new EntityWrapper<UserDataEntity>()
        );

        return new PageUtils(page);
    }

}
