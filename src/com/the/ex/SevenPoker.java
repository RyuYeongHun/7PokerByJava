package com.the.ex;

import com.the.dto.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



public class SevenPoker {
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
		//사용자 로그인 및 회원가입
		System.out.println("1.로그인 2.회원가입");
		int input = Integer.parseInt(sc.nextLine());

		int deck[] = new int[52];
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		String CardNum[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		String CardShape[] = { "스페이드", "다이아", "하트", "클로버" };
		for (int i = 0; i < deck.length; i++) {
			System.out.println("카드번호:" + deck[i] + CardShape[deck[i] / 13] + CardNum[deck[i] % 13]);
		}
		for (int i = 0; i < 10000; i++) {
			int CardIndex = (int) (Math.random() * 52);
			int TempCard = deck[0];
			deck[0] = deck[CardIndex];
			deck[CardIndex] = TempCard;
		}
		for (int i = 0; i < deck.length; i++) {
			System.out.println(CardShape[deck[i] / 13] + CardNum[deck[i] % 13]);
		}
		int DeckIndex = 0;
		int p1Deck[] = new int[7];
		int p1DeckIndex = 0;
		int p2Deck[] = new int[7];
		int p2DeckIndex = 0;
		boolean p1PlayFlag = true;
		boolean p2PlayFlag = true;
		int p1DrowCount = 0;
		int p2DrowCount = 0;
		java.util.Scanner sc = new java.util.Scanner(System.in);
		// p1에게 카드 5장 주기
		for (int i = 1; i < 6; i++) {
			p1Deck[p1DeckIndex] = deck[DeckIndex];
			DeckIndex++;
			p1DeckIndex++;
		}
		// p2에게 카드 5장 주기
		for (int i = 1; i < 6; i++) {
			p2Deck[p2DeckIndex] = deck[DeckIndex];
			DeckIndex++;
			p2DeckIndex++;
		}
		System.out.println("******************************************");
		System.out.println("카드 섞기 및 기본 5장 분배가 끝났습니다. 게임을 시작하겠습니다.");
		System.out.println("******************************************");
		for (int i = 0; i < 5; i++) {
			System.out.println("p1 카드번호:" + i + CardShape[p1Deck[i] / 13] + CardNum[p1Deck[i] % 13]);
		}
		System.out.print("******************************************\n");
		for (int i = 0; i < 5; i++) {
			System.out.println("p2 카드번호:" + i + CardShape[p2Deck[i] / 13] + CardNum[p2Deck[i] % 13]);
		}
		System.out.println("******************************************");
		while (p1PlayFlag || p2PlayFlag) {
			if (p1PlayFlag) {
				System.out.println("p1카드를 한장 받으시겠습니까? 1.yse 2.no(기본5장 보유중 최대2장 뽑기가능)");
				String AnswerP1 = sc.nextLine();
				if (AnswerP1.equals("1")) {
					p1Deck[p1DeckIndex++] = deck[DeckIndex++];
					p1DrowCount++;
					for (int i = 0; i < p1DeckIndex; i++) {
						System.out.println("p1 카드번호:" + i + CardShape[p1Deck[i] / 13] + CardNum[p1Deck[i] % 13]);
					}
				} else {
					p1PlayFlag = false;
				}
				if (p1DrowCount == 2) {
					p1PlayFlag = false;
				}
			}
			if (p2PlayFlag) {
				System.out.println("p2카드를 한장 받으시겠습니까? 1.yes 2.no(기본5장 보유중 최대2장 뽑기가능)");
				String AnswerP2 = sc.nextLine();
				if (AnswerP2.equals("1")) {
					p2Deck[p2DeckIndex++] = deck[DeckIndex++];
					p2DrowCount++;
					for (int i = 0; i < p2DeckIndex; i++) {
						System.out.println("p2 카드번호:" + i + CardShape[p2Deck[i] / 13] + CardNum[p2Deck[i] % 13]);
					}
				} else {
					p2PlayFlag = false;
				}
				if (p1DrowCount == 2) {
					p2PlayFlag = false;
				}
			}
		}
		System.out.println("********************p1********************");
		System.out.println("p1이 가지고 있는 카드: ");
			for (int i = 0; i < p1DeckIndex; i++) {
				System.out.println(i + "카드" + CardShape[p1Deck[i] / 13] + CardNum[p1Deck[i] % 13]);
			}
			if(p1DeckIndex > 5) {
			String DrowP1 = "0";
			for (int i = 0; i < 2; i++) {
				if(p1DeckIndex == 5) {
					break;
				}
				System.out.println("p1버리실 카드 번호를 입력해 주세요");
				DrowP1 = sc.nextLine();
				int cardToRemoveP1 = Integer.parseInt(DrowP1);
				int p1DeckLast[] = new int[p1DeckIndex - 1];
				int newIndex = 0;
				for (int j = 0; j < p1DeckIndex; j++) {
					if (j == cardToRemoveP1) {
						continue;
					}
					p1DeckLast[newIndex++] = p1Deck[j];
				}
				p1Deck = p1DeckLast;
				p1DeckIndex--;
				p1Deck = Arrays.copyOf(p1DeckLast, p1DeckLast.length);
				for (int k = 0; k < p1DeckIndex; k++) {
					System.out.println("p1남은카드:" + k + "카드" + CardShape[p1Deck[k] / 13] + CardNum[p1Deck[k] % 13]);
				}
			}
		}
		System.out.println("******************************************\n");
		System.out.println("********************p2********************");
		System.out.println("p2이 가지고 있는 카드: ");
		for (int i = 0; i < p2DeckIndex; i++) {
			System.out.println(i + "카드" + CardShape[p2Deck[i] / 13] + CardNum[p2Deck[i] % 13]);
		}
		if(p2DeckIndex > 5) {	
			String DrowP2 = "0";
			for (int i = 0; i < 2; i++) {
				if(p2DeckIndex == 5 ) {
					break;
				}
				System.out.println("p2버리실 카드 번호를 입력해 주세요");
				DrowP2 = sc.nextLine();
				int cardToRemoveP2 = Integer.parseInt(DrowP2);
				int p2DeckLast[] = new int[p2DeckIndex - 1];
				int newIndex = 0;
				for (int j = 0; j < p2DeckIndex; j++) {
					if (j == cardToRemoveP2) {
						continue;
					}
					p2DeckLast[newIndex++] = p2Deck[j];
				}
				p2Deck = p2DeckLast;
				p2DeckIndex--;
				p2Deck = Arrays.copyOf(p2DeckLast, p2DeckLast.length);
				for (int k = 0; k < p2DeckIndex; k++) {
					System.out.println("p2남은카드:" + k + "카드" + CardShape[p2Deck[k] / 13] + CardNum[p2Deck[k] % 13]);
				}
			}
		}
		System.out.println("******************************************");
		int p1Cost = 0;
		int p1PairCount = 0;
		boolean p1 = true;
		int p1StraightCountF = 0;
		int p1StraightCount = 0;
		int p1NumDeck[] = new int[5];
		int p1ShapeCost = 0;
		int p1Count1 = 0;
		int p1Count2 = 0;
		int p1Sum = 0;
		int p1CostSum = 0;
		boolean same = true;
		
		for (int i = 0; i < p1NumDeck.length; i++) {
			p1NumDeck[i] = p1Deck[i] % 13;
		}
		Arrays.sort(p1NumDeck);
		for (int i = 0; i < p1NumDeck.length; i++) {
			p1ShapeCost = p1ShapeCost + (p1Deck[i] / 13);
		}
		// 로얄 스트레이트플러쉬
		if (p1) {
			if (p1Deck[0] / 13 == p1Deck[1] / 13 && p1Deck[1] / 13 == p1Deck[2] / 13 && p1Deck[2] / 13 == p1Deck[3] / 13
					&& p1Deck[3] / 13 == p1Deck[4] / 13) {
				if (p1NumDeck[1] == 9 && p1NumDeck[2] == 10 && p1NumDeck[3] == 11 && p1NumDeck[4] == 12
						&& p1NumDeck[0] == 0) {
					System.out.println("p1: 로얄스트레이트플러쉬");
					p1Cost = 13;
					p1 = false;
					same = false;
				} // 백 스트레이트플러쉬
				else if (p1Deck[0] % 13 == 0 && p1Deck[1] % 13 == 1 && p1Deck[2] % 13 == 2 && p1Deck[3] % 13 == 3
						&& p1Deck[4] % 13 == 4) {
					System.out.println("p1: 백스트레이트플러쉬");
					p1Cost = 12;
					p1 = false;
					same = false;
				} // 스트레이트플러쉬
				else if (same) {
					for (int i = 1; i < p1Deck.length; i++) {
						if (p1NumDeck[i] == p1NumDeck[i - 1] + 1) {
							p1StraightCountF++;
							if (p1StraightCountF == 4) {
								System.out.println("p1: 스트레이트 플러쉬");
								p1Cost = 11;
								p1 = false;
								same = false;
							}
						}
						// 플러쉬
						else {
							System.out.println("p1: 플러쉬");
							p1Cost = 8;
							p1 = false;
							same = false;
							break;
						}
					}
				}
			}
		}

		// 풀하우스
		if (p1) {
			for (int i = 0; i < p1NumDeck.length - 1; i++) {
				if (p1NumDeck[i] == p1NumDeck[i + 1]) {
					p1Count1++; // 같은 숫자 개수
				}
			}
			for (int i = 0; i < p1NumDeck.length - 2; i++) {
				if (p1NumDeck[i] == p1NumDeck[i + 1] && p1NumDeck[i + 1] == p1NumDeck[i + 2]) {
					p1Count2++; // 트리플 개수
					p1Count1--; // 중복값 제거
				}
			}
			p1Sum = p1Count1 + p1Count2;
			if (p1Sum == 3) {
				System.out.println("p1: 풀하우스");
				p1Cost = 9;
				p1 = false;
			}
		}
		// 포카드,트리플
		if (p1) {
			HashMap<Integer, Integer> p1Count = new HashMap<>();
			for (int i = 1; i < p1NumDeck.length; i++) {
				int num = p1NumDeck[i];
				if (p1Count.containsKey(num)) {
					p1Count.put(num, p1Count.get(num) + 1);
				} else {
					p1Count.put(num, 1);
				}
			}
			for (int value : p1Count.values()) {
				if (value >= 3) {
					if (value == 4) {
						System.out.println("p1: 포카드");
						p1Cost = 10;
						p1 = false;
					} else if (value == 3) {
						System.out.println("p1: 트리플");
						p1Cost = 4;
						p1 = false;
					}
				}
			}
		}
		// 마운틴
		if (p1) {
			if (p1NumDeck[1] == 9 && p1NumDeck[2] == 10 && p1NumDeck[3] == 11 && p1NumDeck[4] == 12
					&& p1NumDeck[0] == 0) {
				System.out.println("p1: 마운틴");
				p1Cost = 7;
				p1 = false;
			}
		}
		// 백스트레이트
		if (p1) {
			if (p1NumDeck[0] == 0 && p1NumDeck[1] == 1 && p1NumDeck[2] == 2 && p1NumDeck[3] == 3 && p1NumDeck[4] == 4) {
				System.out.println("p1: 백스트레이트");
				p1Cost = 6;
				p1 = false;
			}
		}
		// 스트레이트
		if (p1) {
			for (int i = 1; i < p1NumDeck.length; i++) {
				if (p1NumDeck[i] == p1NumDeck[i - 1] + 1) {
					p1StraightCount++;
					if (p1StraightCount == 4) {
						System.out.println("p1: 스트레이트");
						p1Cost = 5;
						p1 = false;
					}
				}
			}
		}
		// 투페어, 원페어, 탑
		if (p1) {
			for (int i = 0; i < p1NumDeck.length - 1; i++) {
				if (p1NumDeck[i] == p1NumDeck[i + 1]) {
					p1PairCount++; // 같은 숫자 개수
				}
			}
			if (p1PairCount == 2) {
				System.out.println("p1: 투페어");
				p1 = false;
				p1Cost = 3;
			} else if (p1PairCount == 1) {
				System.out.println("p1: 원페어");
				p1 = false;
				p1Cost = 2;
			} else if (p1PairCount == 0) {
				System.out.println("p1: 탑");
				p1 = false;
				p1Cost = 1;
			}
		}
		for (int i = 0; i < p1NumDeck.length; i++) {
			p1CostSum = p1CostSum + p1NumDeck[i];
		}
		int p2Cost = 0;
		int p2PairCount = 0;
		boolean p2 = true;
		int p2StraightCountF = 0;
		int p2StraightCount = 0;
		int p2NumDeck[] = new int[5];
		int p2Count1 = 0;
		int p2Count2 = 0;
		int p2Sum = 0;
		int p2CostSum = 0;
		int p2ShapeCost = 0;
		same = true;
		for (int i = 0; i < p2NumDeck.length; i++) {
			p2NumDeck[i] = p2Deck[i] % 13;
		}
		Arrays.sort(p2NumDeck);
		for (int i = 0; i < p2NumDeck.length; i++) {
			p2ShapeCost = p2ShapeCost + (p2Deck[i] / 13);
		}
		// 로얄 스트레이트플러쉬
		if (p2) {
			if (p2Deck[0] / 13 == p2Deck[1] / 13 && p2Deck[1] / 13 == p2Deck[2] / 13 && p2Deck[2] / 13 == p2Deck[3] / 13
					&& p2Deck[3] / 13 == p2Deck[4] / 13) {
				if (p2NumDeck[1] == 9 && p2NumDeck[2] == 10 && p2NumDeck[3] == 11 && p2NumDeck[4] == 12
						&& p2NumDeck[0] == 0) {
					System.out.println("p2: 로얄스트레이트플러쉬");
					p2Cost = 13;
					p2 = false;
					same = false;
				} // 백 스트레이트플러쉬
				else if (p2Deck[0] % 13 == 0 && p2Deck[1] % 13 == 1 && p2Deck[2] % 13 == 2 && p2Deck[3] % 13 == 3
						&& p2Deck[4] % 13 == 4) {
					System.out.println("p2: 백스트레이트플러쉬");
					p2Cost = 12;
					p2 = false;
					same = false;
				} // 스트레이트플러쉬
				else if (same) {
					for (int i = 1; i < p2Deck.length; i++) {
						if (p2NumDeck[i] == p2NumDeck[i - 1] + 1) {
							p2StraightCountF++;
							if (p2StraightCountF == 4) {
								System.out.println("p2: 스트레이트 플러쉬");
								p2Cost = 11;
								p2 = false;
								same = false;
							}
						}
						// 플러쉬
						else {
							System.out.println("p2: 플러쉬");
							p2Cost = 8;
							p2 = false;
							same = false;
							break;
						}
					}
				}
			}
			// 풀하우스
			if (p2) {
				for (int i = 0; i < p2NumDeck.length - 1; i++) {
					if (p2NumDeck[i] == p2NumDeck[i + 1]) {
						p2Count1++; // 같은 숫자 개수
					}
				}
				for (int i = 0; i < p2NumDeck.length - 2; i++) {
					if (p2NumDeck[i] == p2NumDeck[i + 1] && p2NumDeck[i + 1] == p2NumDeck[i + 2]) {
						p2Count2++; // 트리플 개수
						p2Count1--; // 중복값 제거
					}
				}
				p2Sum = p2Count1 + p2Count2;
				if (p2Sum == 3) {
					System.out.println("p2: 풀하우스");
					p2Cost = 9;
					p2 = false;
				}
			}
			// 포카드,트리플
			if (p2) {
				HashMap<Integer, Integer> p2Count = new HashMap<>();
				for (int i = 1; i < p2NumDeck.length; i++) {
					int num = p2NumDeck[i];
					if (p2Count.containsKey(num)) {
						p2Count.put(num, p2Count.get(num) + 1);
					} else {
						p2Count.put(num, 1);
					}
				}
				for (int value : p2Count.values()) {
					if (value >= 3) {
						if (value == 4) {
							System.out.println("p2: 포카드");
							p2Cost = 10;
							p2 = false;
						} else if (value == 3) {
							System.out.println("p2: 트리플");
							p2Cost = 4;
							p2 = false;
						}
					}
				}
			}
			// 마운틴
			if (p2) {
				if (p2NumDeck[1] == 9 && p2NumDeck[2] == 10 && p2NumDeck[3] == 11 && p2NumDeck[4] == 12
						&& p2NumDeck[0] == 0) {
					System.out.println("p2: 마운틴");
					p2Cost = 7;
					p2 = false;
				}
			}
			// 백스트레이트
			if (p2) {
				if (p2NumDeck[0] == 0 && p2NumDeck[1] == 1 && p2NumDeck[2] == 2 && p2NumDeck[3] == 3
						&& p2NumDeck[4] == 4) {
					System.out.println("p2: 백스트레이트");
					p2Cost = 6;
					p2 = false;
				}
			}
			// 스트레이트
			if (p2) {
				for (int i = 1; i < p2NumDeck.length; i++) {
					if (p2NumDeck[i] == p2NumDeck[i - 1] + 1) {
						p2StraightCount++;
						if (p2StraightCount == 4) {
							System.out.println("p2: 스트레이트");
							p2Cost = 5;
							p2 = false;
						}
					}
				}
			}
			// 투페어, 원페어, 탑
			if (p2) {
				for (int i = 0; i < p2NumDeck.length - 1; i++) {
					if (p2NumDeck[i] == p2NumDeck[i + 1]) {
						p2PairCount++; // 같은 숫자 개수
					}
				}
				if (p2PairCount == 1) {
					System.out.println("p2: 원페어");
					p2 = false;
					p2Cost = 2;
				} else if (p2PairCount == 2) {
					System.out.println("p2: 투페어");
					p2 = false;
					p2Cost = 3;
				} else if (p2PairCount == 0) {
					System.out.println("p2: 탑");
					p2 = false;
					p2Cost = 1;
				}
			}
		}
		for (int i = 0; i < p2NumDeck.length; i++) {
			p2CostSum = p2CostSum + p2NumDeck[i];
		}
		if (p1Cost > p2Cost) {
			System.out.println("p1이겼습니다.");
		} else if (p2Cost > p1Cost) {
			System.out.println("p2이겼습니다.");
		} else {
			System.out.println("비겼습니다.");
			
			
			
			
			
//			if (p1CostSum > p2CostSum) {
//				System.out.println("p1이 이겼습니다.(p1 숫자가 더 크므로 )");
//			} else if (p2CostSum > p1CostSum) {
//				System.out.println("p2이 이겼습니다.(p2 숫자가 더 크므로)");
//			} else {
//				if (p1ShapeCost < p2ShapeCost) {
//					System.out.println("p1이 이겼습니다.(p1모양이 더 높으므로)");	아직 구현중인 기능
//				} else if (p2ShapeCost < p1ShapeCost) {
//					System.out.println("p2이 이겼습니다.(p2모양이 더 높으므로");
//				} else {
//					System.out.println("비겼습니다.");
//				}
			}
		}

	}

