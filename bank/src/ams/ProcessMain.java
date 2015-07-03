package ams;

import java.util.Scanner;
/*
 * 컨트롤러 패턴(공항의 관제탑)
 */
public class ProcessMain {
	public static void main(String[] args) {
		Bank bank = new Bank(1000);
		Scanner scanner =new Scanner(System.in);
		int input =0,key= 0;
		while (true) { // 무한루프
			try {		System.out.println("1.계좌개설 2. 계좌조회(번호) 3.계좌조회(이름)4.전체조회5.계좌삭제");	
		input = scanner.nextInt();
		key = inputCheck(input,1,5);
		} catch (Exception e) {
				 e.printStackTrace();
				 System.out.println("ProcessMain의 try-catch 에러발생");
			switch (key) {
			case 1:
				int accountNo = (int) ((Math.random() * 9999999) + 11111110);
				 
				String strAccountNo = String.valueOf(accountNo);
				System.out.println("예금주 이름 :");
				String name = scanner.next();
				System.out.println("비밀번호");
				String pass = scanner.next();
				System.out.println("예금액 :");
				int inputMoney = scanner.nextInt();
				bank.openAccount(strAccountNo, name, pass, inputMoney);
				break;
			case 2:
				System.out.println("===계좌번호조회(번호입력)====");
				System.out.println("계좌번호입력 :");
				String serachAccountNo = scanner.next();
				Account account = bank.searchAccountByAccountNo(serachAccountNo);
				if (account != null) {
					System.out.println(account.toString());
					
				} else {
		        System.out.println("조회결과가 없습니다.");
				}
				break;

			
			case 3:
				System.out.println("===계좌번호 (이름입력)===");
				System.out.println("조회하려는 이름입력");
				String inputName = scanner.next();
				BankBook[] bankBooks = (BankBook[]) bank.serachAccountsByName(inputName);// 메소드 오리지날 찾아가는 방법 CTRL 누른채로 메소드 클릭
				
				//디버깅 : 에러를 봤을 때 데이터 값을 출력해보면서 버그 를 잡아가는 것
				
				if (bankBooks != null) {
					for (int i = 0; i < bankBooks.length; i++) {
						System.out.println(bankBooks[i].toString());
					}

				} else {
					System.out.println("조회이름 없음");
				}
				break;
			case 4: 
				System.out.println("===계좌번호 전체 목록 출력 ====");
				BankBook[] list = bank.getBankBookList();
				if (list != null) {
					for (int i = 0; i < bank.getCount(); i++) {
						System.out.println(list[i].toString());
					}
				} else {
					System.out.println("계좌가 하나도 없습니다");

				}
				break;
			case 5:
				System.out.println("====계좌삭제 ====");
				System.out.println("삭제하려는 계좌번호 입력");
				String deleteAccount = scanner.next();
				Account account2 = bank.searchAccountByAccountNo(deleteAccount);
				if (account2 != null) {
					boolean isClose = bank.cloesAccount(deleteAccount);
					if (isClose) {
						System.out.println("삭제완료");
					}else {
						System.out.println("삭제가 불가능합니다. 전산팀에 문의 바랍니다.");
					}
				}else{  
					
				
		         
					
					System.out.println("삭제하려고 조회한 계좌가 존재하지 않습니다.");
				}   
				
				break;
			default:
				break;
			}
		}
			
		}
	}

	private static int inputCheck(int input, int first, int last) {
		int key = input;
		if (key<first || key > last) {
			System.out.println("초기메뉴와 선택범위를 넘어섰습니다.");
			return 0;
			
		} else {

		}
		return key;
	}

}
