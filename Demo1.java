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
		String[] dishNames = { "红烧带鱼", "鱼香肉丝", "时令蔬菜" };
		double[] price = { 38, 20, 10 };
		System.out.println("欢迎使用“吃货联盟订餐系统”");
		do {
			System.out.println("*************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("*************************");
			System.out.print("请选择：");
			int choose = input.nextInt();
			switch (choose) {
			case 1:// 我要订餐
				boolean isAdd = true;
				System.out.println("***我要订餐***");
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						isAdd = true;
						System.out.print("请输入订餐人姓名：");
						String name = input.next();
						System.out.println("序号\t菜名\t单价\t点赞数");
						for (int j = 0; j < dishNames.length; j++) {
//							String priaiseNum = (praiseNum[i]) > 0 ? praiseNum[i] + "赞" : "0";
							System.out.println((j + 1) + "\t" + dishNames[j] + "\t" + price[j] + "元\t" + praiseNum[j]+"赞");
						}
						System.out.print("请输入您要点的菜品编号：");
						int chooseDish = input.nextInt();
						System.out.print("请选择您需要的份数：");
						int number = input.nextInt();
						String dishMeg = dishNames[chooseDish - 1] + number + "份";
						double sumPrice = price[chooseDish - 1] * number;
						double deliCharge = (sumPrice >= 50) ? 0 : 5;// 点餐达到50元，免配送费。
						System.out.print("请输入送餐时间（送餐时间是10点至20点间整点送餐)：");
						int time = input.nextInt();
						while (time > 20 || time < 10) {
							System.out.println("对不起，您输入的时间有误，请输入10~20的整数！");
						}
						System.out.print("请输入送餐地址：");
						String address = input.next();
						System.out.println("订餐成功！");
						System.out.println("您订的是：" + dishMeg + "\n送餐时间：" + time + "点" + "\n餐费：" + sumPrice + "元，送餐费"
								+ deliCharge + "元，总计：" + (sumPrice + deliCharge) + "元");
						names[i] = name;
						dishMegs[i] = dishMeg;
						times[i] = time;
						addresses[i] = address;
						sumPrices[i] = sumPrice + deliCharge;
						break;
					}
					if (!isAdd) {
						System.out.println("对不起，餐袋已满！");
					}
				}
				break;
			case 2:// 查看餐袋
				System.out.println("***查看餐袋***");
				System.out.println("序号\t订餐人\t餐品信息\t\t送餐时间\t送餐地址\t总金额\t订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String state = states[i] == 0 ? "已预订" : "已完成";
						System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t\t" + times[i] + "点\t"
								+ addresses[i] + "\t" + sumPrices[i] + "\t" + state);
					}
				}
				break;
			case 3:// 签收订单
				System.out.println("***签收订单***");
				System.out.print("请选择签收的订单序号：");
				int i = input.nextInt();
				if (names[i - 1] != null && states[i - 1] != 1) {
					states[i - 1] = 1;
					System.out.println("签收订单成功！");
				} else if (names[i - 1] == null) {
					System.out.println("您选择的订单不存在！");
				} else if (states[i - 1] == 1) {
					System.out.println("您选择的订单已完成签收，不能再次签收！");
				}
				break;
			case 4:// 删除订单
				System.out.println("***删除订单***");
				System.out.print("请输入要删除的订单序号：");
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
				System.out.println("删除订单成功！");
				} else if (a > names.length || names[a - 1] == null) {
					System.out.println("您输入的订单不存在！");
				} else if (states[a - 1] == 0) {
					System.out.println("您输入的订单未签收，不能删除！");
				}
				break;
			case 5:// 我要点赞
				System.out.println("***我要点赞***");
				System.out.println("序号\t菜名\t单价\t点赞数");
				for (int j = 0; j < dishNames.length; j++) {
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price[j]+"元\t"+praiseNum[j]+"赞");
				}
				System.out.println("请选择你要点赞的菜品序号：");
				int goodNum=input.nextInt();
				praiseNum[goodNum-1]++;
				System.out.println("点赞成功！");
				break;
			case 6:// 退出系统
				System.out.println("谢谢使用，欢迎下次光临！");
				isExit = true;
				break;
			default:// 退出系统
//				isExit = true;
				System.out.println("输入有误！");
				break;
			}
			if (!isExit) {
				System.out.print("输入0返回：");
				num = input.nextInt();
			} else {
				break;
			}
		} while (num == 0);
	}

}
