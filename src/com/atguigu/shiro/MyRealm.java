package com.atguigu.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class MyRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		Object principal = arg0.getPrimaryPrincipal();
		
		Set<String> roles = new HashSet<>();
		roles.add("user");
		if("admin".equals(principal)){
			roles.add("admin");
		}
		
		 SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		 
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		
		String username = token.getUsername();
		System.out.println(username);
		
		ByteSource salt = ByteSource.Util.bytes(username);
		
		Object hashedCredentials = null;
		
		if ("admin".equals(username)) {
			
			hashedCredentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
		}
		
		if ("user".equals(username)) {
			hashedCredentials = "098d2c478e9c11555ce2823231e02ec1";
		}
		Object principal = username;
		
		String realmName = getName();
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,hashedCredentials,salt,realmName);
		
		return info;
	}

	public static void main(String[] args) {
		String algorithmName = "MD5";
		//源密码
		String source = "123456";
		//计算盐值. 盐值建议使用随机字符串, 或用户 id(唯一). 
		ByteSource salt = ByteSource.Util.bytes("admin");
		//加密次数
		int hashIterations = 1024;
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(result);
		
		
		
		
		
	}
	
}
