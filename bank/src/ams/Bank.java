package ams;

public class Bank implements BankRole{
        private BankBook[] bankBookList; // 통장을 리스트 로 관리하는 배열 
        private int count; //통장 수량관리 변수	
        public Bank(int count) {
			bankBookList = new BankBook[count];
			/*
			 * 배열 선언 방법
			 * 배열이 메소드 아래 지역변수로 선언될 경우
			 * int[]nums = new int [10];
			 * 하지만 지금 이 bankBookList 배열은 필드에 선언된 인스턴스 변수 입니다
			 * 인스턴스 변수를 생성자를 통해 초기화 하려는 경우 위의 예시 처럼합니다
			 * 그리고 배열 내부의 숫자를 표시 하는 coount 를 반드시 필드에 선언해 주어야 합니다
		      */
		  
        }
        //필드에 선언된 인스턴스 변수의 getter setter생성
        
	
	

	public BankBook[] getBankBookList() {
		return bankBookList;
	}

	 

	public int getCount() {
		return count;
	}

	




	@Override
	public void openAccount(String accouontNo, String ownerName,
			String password, int restMoney) {
		// 통장생성을 Account 클래스 의 객체를 통해 간단하게 해결 
		Account bankBook = new BankBook(accouontNo, ownerName, password, restMoney);
		 // 캐스팅 : 넓은(큰) 개념의 객체를 작은 범위에 담으려고 할때
		// 필요한 기능이고 이것이 수행되지 않으면 이클립스는 경고를 보낸다
		//이때는 이클립스 커서를 대서 자동 해결한다
		
		bankBookList[count] = (BankBook) bankBook;
		count++; //통장갯수를 증가시킨다.
		System.out.println(bankBook.toString()+"으로 계좌 개설");
		
	}




	@Override
	public Account searchAccountByAccountNo(String accouontNo) {
		 Account serachAccount =null; 
		/*
		 * 변수에는 영역(스코프)에 따라 3가지가 있습니다 
		 * 1.프로젝트 전체 에 적용되는 변수 : 클래스 변수  예) static 이라는 키워드로 선언된 Pay.TAX
		 * 2.클래스 내부에 적용되는 변수 : 인스턴스 변수 예 ) 필드에 선언된 static이 없는 변수 
		 * 3.메소드 내부에 적용되는 변수 : 지역(로컬)변수 예) serachAccount 
		 */
		 for (int i = 0; i < getCount();  i++) {
			 /*
			  * bankBookList[i] 는 bankBookList에 들어있는 통장객체 하나를 가리킵니다.
			  * equals() 는 자바 API 에 있는 java.lang.String 클래스외 메소드로 스트링 값의 비교를 한다 같으면 true 를 리턴한다
			  */
			if (bankBookList[i].getAccouontNo().equals(accouontNo)) {
				serachAccount = bankBookList[i];
			/*
			 * 만약 IF문을 TRUE 만드는 계좌번호가 넣어왔다면
			 * 계좌번호는 단 하나 뿐이므로 getCount() 숫자만큼 다 풀지 말고 지금 이 상태에서 회전을 멈추고 값을 반환해라.
			 */
				return serachAccount;
			}
		}
		 return serachAccount;
	}




	@Override
	public Account[] serachAccountsByName(String ownerName) {
		int tempCount = serachCountByName(ownerName);
	    if (tempCount ==0) { // 검색하려는 이름으로 된 통장이 하나도 없는경우
			return null;
		}
		
	    BankBook[] tempList = new BankBook[count];
		count = 0; //지역변수의 초기화
		for (int i = 0; i < getCount(); i++) {
			/*
			 * 
			 */
			if (bankBookList[i].getOwnerName().equals(ownerName)) {
				tempList[count] = bankBookList[i];
				count++;
				
			}
			
		}
	    return tempList;
	}




	private int serachCountByName(String ownerName) {
	 int serachCount = 0; // 지역변수는 무조건 초기화 ==> 자바문법
	 for (int i = 0; i < getCount(); i++) {
		
	}
		return 0;
	}




	@Override
	public boolean cloesAccount(String accouontNo) {
		// TODO Auto-generated method stub
		return false;
	}


}
