package vo;

public class Members {

	protected String email;
	protected String password;
	protected String name;
	protected String mphone;
	protected String addr;
	protected String recoverEmail;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRecoverEmail() {
		return recoverEmail;
	}
	public void setRecoverEmail(String recoverEmail) {
		this.recoverEmail = recoverEmail;
	}
	
	@Override
	public String toString() {
		return "Members [email=" + email + ", password=" + password + ", name=" + name + ", mphone=" + mphone
				+ ", addr=" + addr + ", recoverEmail=" + recoverEmail + "]";
	}
}
