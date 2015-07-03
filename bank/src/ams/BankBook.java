package ams;

public class BankBook implements Account{
	private String accouontNo; // 계좌번호
	private String ownerName; // 계좌주인
	private String password; // 통장비번
	private int restMoney; // 잔액
	
	
	public BankBook(String accouontNo, String ownerName, String password, int restMoney) {
		 // 필드 값을 파라미터값과 매핑 시킨ㄴ 작업
		this.accouontNo = accouontNo;
		this.ownerName =  ownerName;
		this.password =  password;
		this.restMoney = restMoney;
	}
	
	public String getAccouontNo() {
		return accouontNo;
	}
	public void setAccouontNo(String accouontNo) {
		this.accouontNo = accouontNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRestMoney() {
		return restMoney;
	}
	public void setRestMoney(int restMoney) {
		this.restMoney = restMoney;
	}
	@Override
	public void deposit(int money) {
		if (money <= 0) {
			System.out.println("입금액은 0보다 커야합니다.");
		} else {
      this.restMoney += money;
 		}
		
	}

	@Override
	public void withdraw(int money) {
		 if (money <= 0) {
				System.out.println("출금액은 0보다 커야합니다.");
			} else if(getRestMoney()<=money){
			System.out.println("출금액이 잔액보다 큽니다.");
			}else{
			 this.restMoney -= money;
			}
		
	}
	@Override
	public String toString() {
		
		return "입출금 계좌\n"
				+ "[ "+BANK_NAME+"]\n"
				+"계좌번호 : "+getAccouontNo()+"\n"
				+"계좌명 :" +getOwnerName()+"\n"
				+"비번 : ***********\n"
				+"잔액 :"+getRestMoney()+"\n"
				+"으로 통장이 개설되었습니다.";
	}

}
