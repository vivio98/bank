package ams;

public class BankBook implements Account{
	private String accouontNo; // ���¹�ȣ
	private String ownerName; // ��������
	private String password; // ������
	private int restMoney; // �ܾ�
	
	
	public BankBook(String accouontNo, String ownerName, String password, int restMoney) {
		 // �ʵ� ���� �Ķ���Ͱ��� ���� ��Ų�� �۾�
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
			System.out.println("�Աݾ��� 0���� Ŀ���մϴ�.");
		} else {
      this.restMoney += money;
 		}
		
	}

	@Override
	public void withdraw(int money) {
		 if (money <= 0) {
				System.out.println("��ݾ��� 0���� Ŀ���մϴ�.");
			} else if(getRestMoney()<=money){
			System.out.println("��ݾ��� �ܾ׺��� Ů�ϴ�.");
			}else{
			 this.restMoney -= money;
			}
		
	}
	@Override
	public String toString() {
		
		return "����� ����\n"
				+ "[ "+BANK_NAME+"]\n"
				+"���¹�ȣ : "+getAccouontNo()+"\n"
				+"���¸� :" +getOwnerName()+"\n"
				+"��� : ***********\n"
				+"�ܾ� :"+getRestMoney()+"\n"
				+"���� ������ �����Ǿ����ϴ�.";
	}

}
