package com.arvinsulimto.grocerybilling;

import java.util.ArrayList;

public class ItemShop {
	private ArrayList<ItemShopDetail> item;
	private PaymentEnum paymentMethod;
	
	
	public ArrayList<ItemShopDetail> getItem() {
		return item;
	}
	public void setItem(ArrayList<ItemShopDetail> item) {
		this.item = item;
	}
	public PaymentEnum getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentEnum paymentEnum) {
		this.paymentMethod = paymentEnum;
	}
}
