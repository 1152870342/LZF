public class MethodTest{
	public static void main(String[]args){
		MethodTest mt=new MethodTest();
		boolean loginResult=mt.login("LZF","LZF123");
		if(loginResult==true){
			System.out.println("����ɹ�");
		}else{
				System.out.println("�û��������������");
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
