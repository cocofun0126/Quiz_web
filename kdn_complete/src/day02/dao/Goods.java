package day02.dao;

public class Goods {
	private int gno;
	private String brand;//Α¦Η°Έν
	private int price;
	
	public Goods() {
	}
	public Goods(int gno, String brand, int price) {
		this.gno = gno;
		this.brand = brand;
		this.price = price;
	}
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [gno=");
		builder.append(gno);
		builder.append(", brand=");
		builder.append(brand);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
}
	
	
	
	
	
