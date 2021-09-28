package com.arvinsulimto.grocerybilling;

import java.util.*;

public class App 
{
	
	public ArrayList<User> allUser = new ArrayList<User>();
	public ArrayList<ItemShopDetail> itemShopDetailList = new ArrayList<ItemShopDetail>();
	public User user = new User();
	public ItemShop itemShop = new ItemShop();
	public ItemShopDetail itemShopDetail = new ItemShopDetail();

	
	public void initValue() {
		
		itemShopDetail.setItemName("ITEM 1");
		itemShopDetail.setItemPrice(2);
		itemShopDetail.setItemSize(10);
		itemShopDetailList.add(itemShopDetail);
		
		itemShopDetail = new ItemShopDetail();
		itemShopDetail.setItemName("ITEM 2");
		itemShopDetail.setItemPrice(3);
		itemShopDetail.setItemSize(10);
		itemShopDetailList.add(itemShopDetail);
		
		itemShop.setItem(itemShopDetailList);
		itemShop.setPaymentMethod(PaymentEnum.CASH);
		
		user.setUserID("USER1");
		user.setWantToBeMember(false);
		user.setMember(true);
		user.setItemShop(itemShop);
		
		allUser.add(user);
	}
	
	public App() {
		initValue();
		for(User user : allUser) {

			ArrayList<String>offerApplicable = new ArrayList<String>();
			float totalAmount=0;
			for(int i =0;i < user.getItemShop().getItem().size();i++) {
				totalAmount+=calculatePricePerItem(user.getItemShop().getItem().get(i));
			}
			
			float baseTotalAmount = totalAmount;
			
			if(isPaymentUsingCreditCard(user.getItemShop().getPaymentMethod())) {
				totalAmount = calculateWhenUsingCreditCard(totalAmount);
				offerApplicable.add("Payment Using Credit Card");
			}
			

			if(user.isWantToBeMember() && !user.isMember()) {
				totalAmount+=100;
				user.setMember(true);
				offerApplicable.add("Want to Be a Member");
			}
			
			if(user.isMember()) {
				totalAmount = calculateWhenIsMember(totalAmount);
				offerApplicable.add("Already Member");
			}
			
			if(isMoreThan100$(totalAmount)) {
				totalAmount-=10;
				offerApplicable.add("Payment More Than 100$");
			}
			
			user.setOfferApplicable(offerApplicable);
			
			System.out.println("=========BILLING========");
			System.out.println("Total Base Bill Amount : "+baseTotalAmount);
			System.out.println("========================");
			System.out.println("=====Items Name , Price ,  Quantity=====");
			for(int i =0;i < user.getItemShop().getItem().size();i++) {
				System.out.println(""
						+user.getItemShop().getItem().get(i).getItemName()+ " - Rp. "
						+user.getItemShop().getItem().get(i).getItemPrice()+ " - "
						+user.getItemShop().getItem().get(i).getItemSize() + " Kg");
			}
			System.out.println("==================================");
			System.out.println("=======OFFER APPLICABLE=======");
			for(int i=0 ; i < user.getOfferApplicable().size();i++) {
				System.out.println(user.getOfferApplicable().get(i));
			}
			System.out.println("===============================");
			System.out.println("Final Amount : "+totalAmount);
		}
	}
	
	public boolean isPaymentUsingCreditCard(PaymentEnum payment) {
		return payment == PaymentEnum.CREDIT_CARD;
	}
	
	public boolean isMoreThan100$(float totalAmount) {
		return totalAmount > 100;
	}
	
	public float calculatePricePerItem(ItemShopDetail item) {
		return (float)item.getItemPrice()*item.getItemSize();
	}
	
	public float calculateWhenUsingCreditCard(float totalAmount) {
		return (((float)2/100)*totalAmount)+totalAmount;
	}
	
	public float calculateWhenIsMember(float totalAmount) {
		return totalAmount-(((float)5/100)*totalAmount);
	}
	
    public static void main(String[] args){
    	new App();
    }
}
