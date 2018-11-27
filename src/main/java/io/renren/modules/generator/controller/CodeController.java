package io.renren.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.CodeEntity;
import io.renren.modules.generator.service.CodeService;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("generator/code")
public class CodeController {
    @Autowired
    private CodeService codeService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:code:list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = codeService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }
//
//
//    /**
//     * 信息
//     */
//    @RequestMapping("/info/{id}")
//    @RequiresPermissions("generator:code:info")
//    public R info(@PathVariable("id") Integer id){
//			CodeEntity code = codeService.selectById(id);
//
//        return R.ok().put("code", code);
//    }
//
//    /**
//     * 保存
//     */
//    @RequestMapping("/save")
//    @RequiresPermissions("generator:code:save")
//    public R save(@RequestBody CodeEntity code){
//			codeService.insert(code);
//
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    @RequiresPermissions("generator:code:update")
//    public R update(@RequestBody CodeEntity code){
//			codeService.updateById(code);
//
//        return R.ok();
//    }
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    @RequiresPermissions("generator:code:delete")
//    public R delete(@RequestBody Integer[] ids){
//			codeService.deleteBatchIds(Arrays.asList(ids));
//
//        return R.ok();
//    }

}
