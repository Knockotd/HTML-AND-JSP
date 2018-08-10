package afterClass;

public class ConstructorSemple_VOClass {

	private String name;
	private int age;
	private String phoneNum;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	public ConstructorSemple_VOClass() {
		
	}
	
	
	public ConstructorSemple_VOClass(String name, int age, String phoneNum) {
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		
		System.out.println("name = "+name+", age = "+age+", phoneNum = "+phoneNum);
	}
	
	@Override
	public String toString() {
		return "ConstructorSemple_VOClass [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + "]";
	}
	
	
}
