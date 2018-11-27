package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


import io.renren.modules.generator.dao.PushDao;
import io.renren.modules.generator.entity.PushEntity;
import io.renren.modules.generator.service.PushService;


@Service("pushService")
public class PushServiceImpl extends ServiceImpl<PushDao, PushEntity> implements PushService {



}
