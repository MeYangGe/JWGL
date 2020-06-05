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

	/*//认证需要实现的方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken user = (UsernamePasswordToken) token;
		System.out.println("Two doGetAuthenticationInfo");
		String username = user.getUsername();
		// 未知账号异常unknown
		if ("0".equals(username)) {
			throw new UnknownAccountException("未知账号");
		}
		// 锁定账号异常
		if ("monster".equals(username)) {
			throw new LockedAccountException("账号被锁定");
		}
		// 根据账号情况定制返回
		// principal 认证实体信息 可以是username 也可以是数据表对应的实体类
		Object principal = username;
		// credentials 密码

		Object credentials = null;// "fc1709d0a95a6be30bc5926fdb7f22f4";

		if ("user".equals(username)) {
			credentials ="098d2c478e9c11555ce2823231e02ec1";
		}else if("admin".equals(username)) {
			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		}
		// realmName 当前realm 的name 调用父类的getname 即可
		String realmName = getName();
		// credentialsSalt 盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo authenticationInfo = null; // new SimpleAuthenticationInfo(principal, credentials,
		// realmName);
		authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return authenticationInfo;
	}*/

	public static void main(String[] args) {
		String algorithmName = "MD5";
		Object source = "123456";
		Object salt = ByteSource.Util.bytes(String.valueOf(100001));
		Integer hashIterations = 1;
		SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(simpleHash);
	}
	/*//授权需要重写的方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		Object primaryPrincipal = principal.getPrimaryPrincipal();
		Set<String> roles = new HashSet<String>();
		roles.add("index");
		if("admin".equals(primaryPrincipal)) {
			roles.add("admin");
		}
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
		return simpleAuthorizationInfo;
	}*/
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
		roles.add(userService.getPermissions(primaryPrincipal.toString()));
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
		System.out.println("这里是认证函数");
		UsernamePasswordToken user = (UsernamePasswordToken) authenticationToken;
//		String username = (String) authenticationToken.getPrincipal();
//		String password = new String((char[]) authenticationToken.getCredentials());


		//查询用户信息
		User upUser = userService.selectByPrimaryKey(Integer.valueOf(user.getUsername()));
		//账号不存在
		if(upUser == null) {
			throw new UnknownAccountException("用户名不正确");
		}
		//密码MD5加密
//		String algorithmName = "MD5";
//		Object source = upUser.getUname();
//		Object salt = ByteSource.Util.bytes(String.valueOf(upUser.getUid()));
//		Integer hashIterations = 1024;
//		SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
/*
		//账号禁用
		if("0".equals(user.getStatus())){
			throw new LockedAccountException("用户已被禁用,请联系管理员");
		}*/
		// principal 认证实体信息 可以是username 也可以是数据表对应的实体类
		Object principal = upUser.getUname();
		// credentials 密码

		Object credentials = upUser.getPwd();
		// realmName 当前realm 的name 调用父类的getname 即可
		String realmName = getName();
		// credentialsSalt 盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(String.valueOf(upUser.getUid()));
		SimpleAuthenticationInfo authenticationInfo = null; // new SimpleAuthenticationInfo(principal, credentials,
		// realmName);
		System.out.println(principal+"\t"+credentials+"\t"+credentialsSalt+"\t"+realmName);
		authenticationInfo = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return authenticationInfo;
	}

}
