package OrderFood;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		int num = 0;
		boolean isExit = false;
		Scanner input = new Scanner(System.in);
		String[] names = new String[4];
		String[] dishMegs = new String[4];
		int[] times = new int[4];
		String[] addresses = new String[4];
		double[] sumPrices = new double[4];
		int[] states = new int[4];
		int[] praiseNum = new int[4];
		String[] dishNames = { "���մ���", "������˿", "ʱ���߲�" };
		double[] price = { 38, 20, 10 };
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		do {
			System.out.println("*************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("*************************");
			System.out.print("��ѡ��");
			int choose = input.nextInt();
			switch (choose) {
			case 1:// ��Ҫ����
				boolean isAdd = true;
				System.out.println("***��Ҫ����***");
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						isAdd = true;
						System.out.print("�����붩����������");
						String name = input.next();
						System.out.println("���\t����\t����\t������");
						for (int j = 0; j < dishNames.length; j++) {
//							String priaiseNum = (praiseNum[i]) > 0 ? praiseNum[i] + "��" : "0";
							System.out.println((j + 1) + "\t" + dishNames[j] + "\t" + price[j] + "Ԫ\t" + praiseNum[j]+"��");
						}
						System.out.print("��������Ҫ��Ĳ�Ʒ��ţ�");
						int chooseDish = input.nextInt();
						System.out.print("��ѡ������Ҫ�ķ�����");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + number + "��";
						double sumPrice = price[chooseDish - 1] * number;
						double deliCharge = (sumPrice >= 50) ? 0 : 5;// ��ʹﵽ50Ԫ�������ͷѡ�
						System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ����10����20��������Ͳ�)��");
						int time = input.nextInt();
						while (time > 20 || time < 10) {
							System.out.println("�Բ����������ʱ������������10~20��������");
						}
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();
						System.out.println("���ͳɹ���");
						System.out.println("�������ǣ�" + dishMeg + "\n�Ͳ�ʱ�䣺" + time + "��" + "\n�ͷѣ�" + sumPrice + "Ԫ���Ͳͷ�"
								+ deliCharge + "Ԫ���ܼƣ�" + (sumPrice + deliCharge) + "Ԫ");
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;
						break;
					}
					if (!isAdd) {
						System.out.println("�Բ��𣬲ʹ�������");
					}
				}
				break;
			case 2:// �鿴�ʹ�
				System.out.println("***�鿴�ʹ�***");
				System.out.println("���\t������\t��Ʒ��Ϣ\t\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String state = states[i] == 0 ? "��Ԥ��" : "�����";
						System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t\t" + times[i] + "��\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t" + state);
					}
				}
				break;
			case 3:// ǩ�ն���
				System.out.println("***ǩ�ն���***");
				System.out.print("��ѡ��ǩ�յĶ�����ţ�");
				int i = input.nextInt();
				if (names[i - 1] != null && states[i - 1] != 1) {
					states[i - 1] = 1;
					System.out.println("ǩ�ն����ɹ���");
				} else if (names[i - 1] == null) {
					System.out.println("��ѡ��Ķ��������ڣ�");
				} else if (states[i - 1] == 1) {
					System.out.println("��ѡ��Ķ��������ǩ�գ������ٴ�ǩ�գ�");
				}
				break;
			case 4:// ɾ������
				System.out.println("***ɾ������***");
				System.out.print("������Ҫɾ���Ķ�����ţ�");
				int a = input.nextInt();
				if (a < names.length && names[a - 1] != null && states[a - 1] == 1) {
					for (int j = a - 1; j < names.length - 1; j++) {
						names[j] = names[j + 1];
						dishMegs[j] = dishMegs[j + 1];
						times[j] = times[j + 1];
						addresses[j] = addresses[j + 1];
						sumPrices[j] = sumPrices[j + 1];
						states[j] = states[j + 1];
					}
					if (names[names.length - 1] != null) {
						names[names.length - 1] = null;
						dishMegs[names.length - 1] = null;
						times[names.length - 1] = 0;
						addresses[names.length - 1] = null;
						sumPrices[names.length - 1] = 0;
						states[names.length - 1] = 0;
					}
				System.out.println("ɾ�������ɹ���");
				} else if (a > names.length || names[a - 1] == null) {
					System.out.println("������Ķ��������ڣ�");
				} else if (states[a - 1] == 0) {
					System.out.println("������Ķ���δǩ�գ�����ɾ����");
				}
				break;
			case 5:// ��Ҫ����
				System.out.println("***��Ҫ����***");
				System.out.println("���\t����\t����\t������");
				for (int j = 0; j < dishNames.length; j++) {
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price[j]+"Ԫ\t"+praiseNum[j]+"��");
				}
				System.out.println("��ѡ����Ҫ���޵Ĳ�Ʒ��ţ�");
				int goodNum=input.nextInt();
				praiseNum[goodNum-1]++;
				System.out.println("���޳ɹ���");
				break;
			case 6:// �˳�ϵͳ
				System.out.println("ллʹ�ã���ӭ�´ι��٣�");
				isExit = true;
				break;
			default:// �˳�ϵͳ
//				isExit = true;
				System.out.println("��������");
				break;
			}
			if (!isExit) {
				System.out.print("����0���أ�");
				num = input.nextInt();
			} else {
				break;
			}
		} while (num == 0);
	}

}
