package dto;

public class Cats {
protected String name;
protected int _age;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	System.out.println("get 호출");
	return _age;

}
public void setAge(int age) {
	this._age = age;
}
}
