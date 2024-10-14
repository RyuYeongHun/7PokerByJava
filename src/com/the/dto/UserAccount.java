package com.the.dto;

import java.util.Objects;

public class UserAccount {
	public String userId = "";
	public String userPw = "";
	public int userAccount = 0;
	
	public UserAccount() {
		
	}
	
	
	public UserAccount(String userId, String userPw, int userAccount) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userAccount = userAccount;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPw() {
		return userPw;
	}


	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public int getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(int userAccount) {
		this.userAccount = userAccount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(userAccount, userId, userPw);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		return userAccount == other.userAccount && Objects.equals(userId, other.userId)
				&& Objects.equals(userPw, other.userPw);
	}


	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", userPw=" + userPw + ", userAccount=" + userAccount + "]";
	}
}
