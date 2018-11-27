package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.PushDao;
import io.renren.modules.generator.entity.PushEntity;
import io.renren.modules.generator.service.PushService;


@Service("pushService")
public class PushServiceImpl extends ServiceImpl<PushDao, PushEntity> implements PushService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PushEntity> page = this.selectPage(
                new Query<PushEntity>(params).getPage(),
                new EntityWrapper<PushEntity>()
        );

        return new PageUtils(page);
    }

}
