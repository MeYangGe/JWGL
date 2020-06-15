package com.system.util;

import com.system.model.User;
import com.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		String md5 = MD5.getMD5("123456", "10022");
		System.out.println(md5);
	}
	/**
	 * @Author : MeYanGe
	 * @Description : 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
		System.out.println(primaryPrincipal);

		//用户权限列表
		Set<String> roles = new HashSet<String>();
		roles.add(userService.getPermissions((Integer)primaryPrincipal));
		System.out.println(roles.toString());
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
		return simpleAuthorizationInfo;
	}

	/**
	 * @Author : MeYanGe
	 * @Description : 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken user = (UsernamePasswordToken) authenticationToken;

		//查询用户信息
		User upUser = userService.selectByPrimaryKey(Integer.valueOf(user.getUsername()));
		System.out.println(user.getUsername());
		//账号不存在
		if(upUser == null) {
			throw new UnknownAccountException("用户名不正确");
		}
		//密码MD5加密
		//账号禁用
		// principal 认证实体信息 可以是username 也可以是数据表对应的实体类
		Object principal = upUser.getUid();
		// credentials 密码

		Object credentials = upUser.getPwd();
		// realmName 当前realm 的name 调用父类的getname 即可
		String realmName = getName();
		// credentialsSalt 盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(String.valueOf(upUser.getUid()));
		SimpleAuthenticationInfo authenticationInfo = null; // new SimpleAuthenticationInfo(principal, credentials,
		// realmName);
		authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return authenticationInfo;
	}

}
