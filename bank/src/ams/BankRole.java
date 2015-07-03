package ams;
/*
 * @
 * @
 * @ Stroy : 은행관리자단 기능 정의 
 */
public interface BankRole {
    /*
     * 계좌를 개설기능
     */
	
	public void openAccount(String accouontNo, String ownerName, String password, int restMoney);
   /*
    * 계좌 번호 로 특정계좌를 조회(검색)기능
    */
	public Account searchAccountByAccountNo(String accouontNo);
	/*
	 * 예금주 이름으로 그 사람이 가지고 있는 계좌 조회 
	 */
	public Account[] serachAccountsByName(String ownerName);
	/*
	 * 계좌번호로 특정계좌 폐기(삭제) 기능
	 */
     public boolean cloesAccount(String accouontNo);
}
