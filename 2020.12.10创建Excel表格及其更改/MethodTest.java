public class MethodTest{
	public static void main(String[]args){
		MethodTest mt=new MethodTest();
		boolean loginResult=mt.login("LZF","LZF123");
		if(loginResult==true){
			System.out.println("登入成功");
		}else{
				System.out.println("用户名或者密码错误");
			}

	}
	public boolean login(String username,String password){
		if(username=="LZF"&&password=="LZF123"){
			return true;
		}
		else{
			return false;
		}
	}
}
