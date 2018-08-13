
package com.framework.execute;

import com.framework.init.InitFramework;

public class ExecuteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		InitFramework in =new InitFramework();
		in.init();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.exit(0);
		}
		

	}

}
