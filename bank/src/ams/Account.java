package ams;
/*
 * @
 * @
 * @ Stroy : 은행고객쪽 기능 정의 
 */
public interface Account {
	public static final String BANK_NAME = "아이티뱅크";

	public void deposit(int money); // 입금
	public void withdraw(int money); //출금

}
