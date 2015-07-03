package ams;

import java.util.Scanner;

// ��Ŭ���� �ڵ� �ڵ����� ����� : CTRL+SHIFT+F
//ALT+SHIFT+M
public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);
		Scanner scanner = new Scanner(System.in);
		int accountNo = (int) ((Math.random() * 9999999) + 11111110);
		// 6�ڸ� �����ⷣ������ �߻�
		// valueof() �ڹ� api �� �ִ� java.lang.String Ŭ������ �޼ҵ�� �������� ���ڿ��� �ٲ��ִ� �������Ѵ�
		String strAccountNo = String.valueOf(accountNo);
		System.out.println("������ �̸� :");
		String name = scanner.next();
		System.out.println("��й�ȣ");
		String pass = scanner.next();
		System.out.println("���ݾ� :");
		int inputMoney = scanner.nextInt();
		bank.openAccount(strAccountNo, name, pass, inputMoney);
		bank.openAccount("123-962" , "���̾��", "123", 5544);
		bank.openAccount("123-900", "��ũ", "123", 5511);
		bank.openAccount("123-914", "�����̴�", "171", 4000);	
		bank.openAccount("123-942", "��", "124", 1002);
		bank.openAccount("123-911", "����", "137", 2100);
				
        
		
	//	serachByName(bank, scanner);
		
		//serachByNo(bank, scanner);
		
	//	serachList(bank);
		
		
		System.out.println("====���»��� ====");
		System.out.println("�����Ϸ��� ���¹�ȣ �Է�");
		String deleteAccount = scanner.next();
		Account account = bank.searchAccountByAccountNo(deleteAccount);
		if (account != null) {
			boolean isClose = bank.cloesAccount(deleteAccount);
			if (isClose) {
				System.out.println("�����Ϸ�");
			}else {
				System.out.println("������ �Ұ����մϴ�. �������� ���� �ٶ��ϴ�.");
			}
		}else{  
			
		
         
			
			System.out.println("�����Ϸ��� ��ȸ�� ���°� �������� �ʽ��ϴ�.");
		}   serachList(bank);
		
		
		
		
	}
	private static void serachList(Bank bank) {
		System.out.println("===���¹�ȣ ��ü ��� ��� ====");
		BankBook[] list = bank.getBankBookList();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("���°� �ϳ��� �����ϴ�");

		}
	}
	private static void serachByNo(Bank bank, Scanner scanner) {
		System.out.println("===���¹�ȣ��ȸ(��ȣ�Է�)====");
		System.out.println("���¹�ȣ�Է� :");
		String serachAccountNo = scanner.next();
		Account account = bank.searchAccountByAccountNo(serachAccountNo);
		if (account != null) {
			System.out.println(account.toString());
			
		} else {
        System.out.println("��ȸ����� �����ϴ�.");
		}
	}
/*
 * �޼ҵ� �����丵 ���
 * ������ ���İ�Ƽ �ҽ��� ������ �ְ� �и���Ű��
 * �޼ҵ带 ���� �Ҽ� �ֵ��� ���ȭ ��Ű�� �۾�
 */
	private static void serachByName(Bank bank, Scanner scanner) {
		System.out.println("===���¹�ȣ (�̸��Է�)===");
		System.out.println("��ȸ�Ϸ��� �̸��Է�");
		String inputName = scanner.next();
		BankBook[] bankBooks = (BankBook[]) bank.serachAccountsByName(inputName);// �޼ҵ� �������� ã�ư��� ��� CTRL ����ä�� �޼ҵ� Ŭ��
		
		//����� : ������ ���� �� ������ ���� ����غ��鼭 ���� �� ��ư��� ��
		
		if (bankBooks != null) {
			for (int i = 0; i < bankBooks.length; i++) {
				System.out.println(bankBooks[i].toString());
			}

		} else {
			System.out.println("��ȸ�̸� ����");
		}
	}
}
