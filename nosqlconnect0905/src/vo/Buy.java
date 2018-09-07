package vo;

public class Buy {
// num(정수), userid(문자열), productname(문자열), groupname(문자열), price(정수), amount(정수)
	protected int num;
	protected String userid;
	protected String productname;
	protected String groupname;
	protected int price;
	protected int amount;
	
// getter & setter 생성
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
// toString 생성
	@Override
	public String toString() {
		return "Buy [num=" + num + ", userid=" + userid + ", productname=" + productname + ", groupname=" + groupname
				+ ", price=" + price + ", amount=" + amount + "]";
	}
}
