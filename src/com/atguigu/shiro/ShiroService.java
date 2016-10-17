package com.atguigu.shiro;

import org.apache.shiro.authz.annotation.RequiresRoles;

public class ShiroService {

	
	@RequiresRoles("admin")
	public void doMyjob(){
		
		System.out.println("--------");
		
	}
	
}
