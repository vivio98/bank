package ams;
/*
 * @
 * @
 * @ Stroy : ��������ڴ� ��� ���� 
 */
public interface BankRole {
    /*
     * ���¸� �������
     */
	
	public void openAccount(String accouontNo, String ownerName, String password, int restMoney);
   /*
    * ���� ��ȣ �� Ư�����¸� ��ȸ(�˻�)���
    */
	public Account searchAccountByAccountNo(String accouontNo);
	/*
	 * ������ �̸����� �� ����� ������ �ִ� ���� ��ȸ 
	 */
	public Account[] serachAccountsByName(String ownerName);
	/*
	 * ���¹�ȣ�� Ư������ ���(����) ���
	 */
     public boolean cloesAccount(String accouontNo);
}
