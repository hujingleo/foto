//package io.renren.modules.generator.shiro;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import io.renren.modules.generator.entity.UserEntity;
//import io.renren.modules.generator.service.UserService;
//import io.renren.modules.generator.utils.JWTUtil;
//import io.renren.modules.generator.utils.StringTools;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyRealm extends AuthorizingRealm {
//
//    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);
//
//    @Autowired
//    private UserService userService;
////    @Autowired
////    private SysRoleService sysRoleService;
////    @Autowired
////    private SysPermissionService sysPermissionService;
//
//
//
//    /**
//     * 大坑！，必须重写此方法，不然Shiro会报错
//     */
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof JWTToken;
//    }
//
//    /**
//     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
////        String username = JWTUtil.getUsername(principals.toString());
////        if (null==sysUserService.getByUsername(username)){
////            return null;
////        }
////        SysUser userInfo = sysUserService.getByUsername(username);
////        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
////        if (null==userInfo||userInfo.getRolenamelist()==null||userInfo.getPermissionnamelist()==null){
////            return null;
////        }else {
////            authorizationInfo.addRoles(userInfo.getRolenamelist());
////            authorizationInfo.addStringPermissions(userInfo.getPermissionnamelist());
////            return authorizationInfo;
////        }
//        return null;
//    }
//
//    /**
//     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
//        String token = (String) auth.getCredentials();
//        // 解密获得openId，用于和数据库进行对比
//        String openId = JWTUtil.getCurrentUserOpenIdByToken(token);
//        if (StringTools.isNullOrEmpty(openId)) {
//            throw new AuthenticationException("token invalid");
//        }
//
//        UserEntity userBean = userService.selectOne(new EntityWrapper<UserEntity>().eq("open_id",openId));
//        if (userBean == null) {
//            throw new AuthenticationException("User didn't existed!");
//        }
////
////        if (! JWTUtil.verify(token, username)) {
////            throw new AuthenticationException("Username or password error");
////        }
//
//        return new SimpleAuthenticationInfo(token, token, "my_realm");
//    }
//}
