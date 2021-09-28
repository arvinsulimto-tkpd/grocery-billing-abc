package com.arvinsulimto.grocerybilling;

import java.util.ArrayList;

public class User {
	private String userID;
	private boolean isMember = false;
	private ItemShop itemShop;
	private boolean wantToBeMember=false;
	private ArrayList<String>offerApplicableList;
	
	
	public ArrayList<String> getOfferApplicable() {
		return offerApplicableList;
	}
	public void setOfferApplicable(ArrayList<String> offerApplicable) {
		this.offerApplicableList = offerApplicable;
	}
	
	public String getUserID() {
		return userID;
	}
	public boolean isWantToBeMember() {
		return wantToBeMember;
	}
	public void setWantToBeMember(boolean wantToBeMember) {
		this.wantToBeMember = wantToBeMember;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public boolean isMember() {
		return isMember;
	}
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	public ItemShop getItemShop() {
		return itemShop;
	}
	public void setItemShop(ItemShop itemShop) {
		this.itemShop = itemShop;
	}
	
	
}
