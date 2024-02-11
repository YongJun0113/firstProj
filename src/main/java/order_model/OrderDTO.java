package order_model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderDTO {
	Date orderDate;
	String prodFile, prodInfo, deliveryStatus, orderStatus;
	int orderCnt, prodPrice, totalPrice;
	
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public String getOrderDateStr() {
		return sdf.format(orderDate);
	}
	public void setOrderDateStr(String orderDate) {
		try {
			this.orderDate = sdf.parse(orderDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getProdFile() {
		return prodFile;
	}
	public void setProdFile(String prodFile) {
		this.prodFile = prodFile;
	}
	public String getProdInfo() {
		return prodInfo;
	}
	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public int getTotalPrice() {
		totalPrice = prodPrice * orderCnt;
		return totalPrice;
	}
	public void setTotalPrice(int prodPrice ,int orderCnt) {
		this.totalPrice = prodPrice * orderCnt;
	}
	
	
	
	
}
