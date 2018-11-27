package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


import io.renren.modules.generator.dao.UserDataDao;
import io.renren.modules.generator.entity.UserDataEntity;
import io.renren.modules.generator.service.UserDataService;


@Service("userDataService")
public class UserDataServiceImpl extends ServiceImpl<UserDataDao, UserDataEntity> implements UserDataService {


}
