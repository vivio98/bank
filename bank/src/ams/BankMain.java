package ams;

import java.util.Scanner;

// 이클립스 코드 자동정렬 단축기 : CTRL+SHIFT+F
//ALT+SHIFT+M
public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);
		int accountNo = (int) ((Math.random() * 9999999) + 11111110);
		// 6자리 정수향랜덤숫자 발생
		// valueof() 자바 api 에 있는 java.lang.String 클래스의 메소드로 숫자형을 문자열로 바꿔주는 역할을한다
		String strAccountNo = String.valueOf(accountNo);
		System.out.println("예금주 이름 :");
		String name = scanner.next();
		System.out.println("비밀번호");
		String pass = scanner.next();
		System.out.println("예금액 :");
		int inputMoney = scanner.nextInt();
		bank.openAccount(strAccountNo, name, pass, inputMoney);
		bank.openAccount("123-962" , "아이언맨", "123", 5544);
		bank.openAccount("123-900", "헐크", "123", 5511);
		bank.openAccount("123-914", "스파이더", "171", 4000);	
		bank.openAccount("123-942", "톰", "124", 1002);
		bank.openAccount("123-911", "제리", "137", 2100);
				
        
		
	//	serachByName(bank, scanner);
		
		//serachByNo(bank, scanner);
		
	//	serachList(bank);
		
		
		System.out.println("====계좌삭제 ====");
		System.out.println("삭제하려는 계좌번호 입력");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.cloesAccount(deleteAccount);
			if (isClose) {
				System.out.println("삭제완료");
			}else {
				System.out.println("삭제가 불가능합니다. 전산팀에 문의 바랍니다.");
			}
		}else{  
			
		
         
			
			System.out.println("삭제하려고 조회한 계좌가 존재하지 않습니다.");
		}   serachList(bank);
		
		
		
		
	}
	private static void serachList(Bank bank) {
		System.out.println("===계좌번호 전체 목록 출력 ====");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("계좌가 하나도 없습니다");

		}
	}
	private static void serachByNo(Bank bank, Scanner scanner) {
		System.out.println("===계좌번호조회(번호입력)====");
		System.out.println("계좌번호입력 :");
		String serachAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(serachAccountNo);
		if (account != null) {
			System.out.println(account.toString());
			
		} else {
        System.out.println("조회결과가 없습니다.");
		}
	}
/*
 * 메소드 리팩토링 기법
 * 복잡한 스파게티 소스를 가독성 있게 분리시키고
 * 메소드를 재사용 할수 있도록 모듈화 시키는 작업
 */
	private static void serachByName(Bank bank, Scanner scanner) {
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
	}
}
