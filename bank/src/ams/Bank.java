package ams;

public class Bank implements BankRole{
        private BankBook[] bankBookList; // ������ ����Ʈ �� �����ϴ� �迭 
        private int count; //���� �������� ����	
        public Bank(int count) {
			bankBookList = new BankBook[count];
			/*
			 * �迭 ���� ���
			 * �迭�� �޼ҵ� �Ʒ� ���������� ����� ���
			 * int[]nums = new int [10];
			 * ������ ���� �� bankBookList �迭�� �ʵ忡 ����� �ν��Ͻ� ���� �Դϴ�
			 * �ν��Ͻ� ������ �����ڸ� ���� �ʱ�ȭ �Ϸ��� ��� ���� ���� ó���մϴ�
			 * �׸��� �迭 ������ ���ڸ� ǥ�� �ϴ� coount �� �ݵ�� �ʵ忡 ������ �־�� �մϴ�
		      */
		  
        }
        //�ʵ忡 ����� �ν��Ͻ� ������ getter setter����
        
	
	

	public BankBook[] getBankBookList() {
		return bankBookList;
	}

	 

	public int getCount() {
		return count;
	}

	




	@Override
	public void openAccount(String accouontNo, String ownerName,
			String password, int restMoney) {
		// ��������� Account Ŭ���� �� ��ü�� ���� �����ϰ� �ذ� 
		Account bankBook = new BankBook(accouontNo, ownerName, password, restMoney);
		 // ĳ���� : ����(ū) ������ ��ü�� ���� ������ �������� �Ҷ�
		// �ʿ��� ����̰� �̰��� ������� ������ ��Ŭ������ ��� ������
		//�̶��� ��Ŭ���� Ŀ���� �뼭 �ڵ� �ذ��Ѵ�
		
		bankBookList[count] = (BankBook) bankBook;
		count++; //���尹���� ������Ų��.
		System.out.println(bankBook.toString()+"���� ���� ����");
		
	}




	@Override
	public Account searchAccountByAccountNo(String accouontNo) {
		 Account serachAccount =null; 
		/*
		 * �������� ����(������)�� ���� 3������ �ֽ��ϴ� 
		 * 1.������Ʈ ��ü �� ����Ǵ� ���� : Ŭ���� ����  ��) static �̶�� Ű����� ����� Pay.TAX
		 * 2.Ŭ���� ���ο� ����Ǵ� ���� : �ν��Ͻ� ���� �� ) �ʵ忡 ����� static�� ���� ���� 
		 * 3.�޼ҵ� ���ο� ����Ǵ� ���� : ����(����)���� ��) serachAccount 
		 */
		 for (int i = 0; i < getCount();  i++) {
			 /*
			  * bankBookList[i] �� bankBookList�� ����ִ� ���尴ü �ϳ��� ����ŵ�ϴ�.
			  * equals() �� �ڹ� API �� �ִ� java.lang.String Ŭ������ �޼ҵ�� ��Ʈ�� ���� �񱳸� �Ѵ� ������ true �� �����Ѵ�
			  */
			if (bankBookList[i].getAccouontNo().equals(accouontNo)) {
				serachAccount = bankBookList[i];
			/*
			 * ���� IF���� TRUE ����� ���¹�ȣ�� �־�Դٸ�
			 * ���¹�ȣ�� �� �ϳ� ���̹Ƿ� getCount() ���ڸ�ŭ �� Ǯ�� ���� ���� �� ���¿��� ȸ���� ���߰� ���� ��ȯ�ض�.
			 */
				return serachAccount;
			}
		}
		 return serachAccount;
	}




	@Override
	public Account[] serachAccountsByName(String ownerName) {
		int tempCount = serachCountByName(ownerName);
	    if (tempCount ==0) { // �˻��Ϸ��� �̸����� �� ������ �ϳ��� ���°��
			return null;
		}
		
	    BankBook[] tempList = new BankBook[count];
		count = 0; //���������� �ʱ�ȭ
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
	 int serachCount = 0; // ���������� ������ �ʱ�ȭ ==> �ڹٹ���
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
