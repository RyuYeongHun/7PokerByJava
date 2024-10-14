package com.the.ex;

import com.the.dto.*;
import java.util.Arrays;
import java.util.HashMap;

public class Exa {
	public static final int STATE_LOGOUT = 0;
	public static final int STATE_LOGIN = 1;
	public static String id[] = new String[100];
	public static String pw[] = new String[100];
	public static double accout[] = new double[100];
	public static UserLogin loginUserState = UserLogin.Logout;
	public static int totalUserCount = 0;
	public static int loginUserIndex = -1;
	public static java.util.Scanner sc = new java.util.Scanner(System.in);
	public static String inputId = "";
	public static String inputPw = "";
	public static double inputAccount = 0;

	public static void main(String[] args) {
		UserAccount userAccount[] = new UserAccount[5];
		Exa.totalUserCount = 5;
		boolean login = true;
		while(login) {
			System.out.println("1.로그인 2.회원가입 0.종료");
			String input=sc.nextLine();
		if(input.equals(0)) {
			System.out.println("시스템을 종료합니다.");
			login = false;
			break;
		}
		if(input.equals(1)) {
			System.out.println("id>>");
			Exa.inputId = sc.nextLine();
			System.out.println("pw>>");
			Exa.inputPw = sc.nextLine();
			for(int i = 0; Exa.totalUserCount>i; i++) {
				if(userAccount[i].userId.equals(Exa.inputId)) {
					if(userAccount[i].userPw.equals(Exa.inputPw)) {
						System.out.println(userAccount[i].userId + "님 로그인 하셨습니다.");
						Exa.loginUserIndex = i;
						loginUserState = UserLogin.Login;
					}
					else {
						System.out.println("잘못된 id,pw 입력입니다.");
					}
					break;
				}
			}
		}

		if(input.equals(2)) {
			System.out.println("신규ID>>");
			inputId = sc.nextLine();
			System.out.println("신규PW>>");
			inputPw = sc.nextLine();
			userAccount[Exa.totalUserCount] = new UserAccount();
			userAccount[Exa.totalUserCount].userId = inputId;
			userAccount[Exa.totalUserCount].userPw = inputPw;
			userAccount[Exa.totalUserCount].userAccount = 0;
			System.out.println(userAccount[Exa.totalUserCount].userId+"계정생성");
			Exa.totalUserCount++;
			break;
		}
	
		
		
		
		
		}
		
		
		
		
		
	}
}
