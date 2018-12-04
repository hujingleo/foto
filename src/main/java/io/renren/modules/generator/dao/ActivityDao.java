package io.renren.modules.generator.dao;

import io.renren.modules.generator.entity.ActivityEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@Mapper
public interface ActivityDao extends BaseMapper<ActivityEntity> {

    List<ActivityEntity> getActivityInfo(@Param("pageSize") Integer pageSize , @Param("pageIndex") Integer pageIndex, @Param("start") Integer start);

    Integer count();

}
