package io.renren.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.generator.dao.CodeDao;
import io.renren.modules.generator.entity.CodeEntity;
import io.renren.modules.generator.service.CodeService;


@Service("codeService")
public class CodeServiceImpl extends ServiceImpl<CodeDao, CodeEntity> implements CodeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CodeEntity> page = this.selectPage(
                new Query<CodeEntity>(params).getPage(),
                new EntityWrapper<CodeEntity>()
        );

        return new PageUtils(page);
    }

}
