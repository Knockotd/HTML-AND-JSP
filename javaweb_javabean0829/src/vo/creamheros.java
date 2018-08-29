package vo;

import java.util.Date;

public class creamheros {

protected String name;
protected String race;
protected Date birth;
protected String color;
protected String gender;
protected String size;
protected String nick;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRace() {
	return race;
}
public void setRace(String race) {
	this.race = race;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}

@Override
public String toString() {
	return "creamheros [name=" + name + ", race=" + race + ", birth=" + birth + ", color=" + color + ", gender="
			+ gender + ", size=" + size + ", nick=" + nick + "]";
}

public creamheros() {
	super();
	// TODO Auto-generated constructor stub
}

public creamheros(String name, String race, Date birth, String color, String gender, String size, String nick) {
	super();
	this.name = name;
	this.race = race;
	this.birth = birth;
	this.color = color;
	this.gender = gender;
	this.size = size;
	this.nick = nick;
}



}
