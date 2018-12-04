package io.renren.modules.generator.controller;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import io.renren.modules.generator.utils.BaseResp;
import io.renren.modules.generator.utils.MailUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.generator.entity.CodeEntity;
import io.renren.modules.generator.service.CodeService;

import javax.mail.MessagingException;


/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-27 09:51:20
 */
@RestController
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private CodeService codeService;

    /**
     * 发送邮箱验证码
     */
    @RequestMapping("/sendCode")
    public BaseResp send(String username) throws MessagingException {

        String emailcode = MailUtil.sendMail(username);

        CodeEntity codeEntity = codeService.selectOne(new EntityWrapper<CodeEntity>().eq("username",username));

        if(codeEntity != null){

            codeEntity.setEmailCode(emailcode);

            codeEntity.setCreatedTime(new Date());

            boolean result = codeService.update(codeEntity,new EntityWrapper<CodeEntity>().eq("username",username));

            if (!result){
                return BaseResp.error("发送验证码失败");
            }
            return BaseResp.ok("发送验证码成功");
        }

        CodeEntity entity = new CodeEntity();

        entity.setUsername(username);

        entity.setEmailCode(emailcode);

        entity.setCreatedTime(new Date());

        boolean result = codeService.insert(entity);

        if(!result){
            BaseResp.error("发送验证码失败");
        }

        return BaseResp.ok("发送验证码成功");
    }

    /**
     * 校对邮箱验证码
     */
    @RequestMapping("/verifycode")
    public BaseResp verify(String username,String emailcode){

        CodeEntity codeEntity = codeService.selectOne(new EntityWrapper<CodeEntity>().eq("username",username));

        long time = System.currentTimeMillis();
        Date date = codeEntity.getCreatedTime();
        long codetime = date.getTime();

        if(time - codetime > 60000){
            return BaseResp.error("验证码已过期");
        }

        if (codeEntity.getEmailCode() != emailcode){
            return BaseResp.error("验证码错误");
        }



        return BaseResp.ok("验证成功");
    }



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
