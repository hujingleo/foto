package io.renren.modules.generator.service;

import com.baomidou.mybatisplus.service.IService;
import io.renren.modules.generator.entity.UserEntity;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
public interface UserService extends IService<UserEntity> {

    int updateUser(UserEntity userEntity);

}

