package afterClass;

public class Main {

	public static void main(String[] args) {
		ConstructorSemple_VOClass gAndsData = new ConstructorSemple_VOClass();
		gAndsData.setName("피카츄");
		gAndsData.setAge(100);
		gAndsData.setPhoneNum("123123123");
 		
		System.out.println(gAndsData.getName());
		System.out.println(gAndsData.getAge());
		System.out.println(gAndsData.getPhoneNum());
		
		
		System.out.println(gAndsData);
		
		String name = "꼬부기";
		int age = 1000;
		String phoneNum = "234234234";
		ConstructorSemple_VOClass cstData = new ConstructorSemple_VOClass(name, age, phoneNum);
		
	}

}
