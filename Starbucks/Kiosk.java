import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
	private List<Menu> orderList = new ArrayList<Menu>();
	private Menu[][] menuArray = new Menu[3][3];

	public Order() {
		menuArray[0][0] = new Menu("\"Today\'s Coffee\"", 5, 3.0);
		menuArray[1][0] = new Menu("\"Cheese Cake\"", 5, 3.0);
		menuArray[2][0] = new Menu("\"Starbucks Limited Edition Tumbler\"", 5, 3.0);
	}

	private void PrintMenu() {
		System.out.println("== Menu List ==");
		System.out.println("1. Coffee");
		System.out.println("2. Cake");
		System.out.println("3. Tumbler");
		System.out.println("4. Finish the order and Check out.");
	}

	private void printCoffeeMenu() {
		System.out.println("=== Coffee List ===");
		System.out.println("1. \"Today\'s Coffee\" | Cost: 3.0$ ");
	}

	private void printCakeMenu() {
		System.out.println("=== Coffee List ===");
		System.out.println("1. \"Cheese Cake\" | Cost: 4.5$ ");
	}

	private void printTumblerMenu() {
		System.out.println("=== Coffee List ===");
		System.out.println("1. \"Starbucks Limited Edition Tumbler\" | Cost: 7.0$ ");
	}

	private Menu chooseMenu(int typeNum, int productionNum) {
		return menuArray[typeNum - 1][productionNum - 1];
	}

	private void PrintCompleteMsg(String str) {
		System.out.println("Your " + str + " has been added to your shopping cart.");
	}

	// 사용자가 실수로 입력할 것 차단 해야함.

	private boolean orderMenu() {
		this.PrintMenu();

		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		if (i == 1) {
			// coffee 메뉴 열기
			// coffee 메뉴 선택
			// coffee 메뉴 장바구니 추가
			this.printCoffeeMenu();
			int j = sc.nextInt();
			this.orderList.add(this.chooseMenu(i, j));
		} else if (i == 2) {
			// cake 메뉴 열기
			this.printCakeMenu();
			int j = sc.nextInt();
			this.orderList.add(this.chooseMenu(i, j));
		} else if (i == 3) {
			// tumbler 메뉴 열기
			this.printTumblerMenu();
			int j = sc.nextInt();
			this.orderList.add(this.chooseMenu(i, j));
		} else {
			return false;
		}

		Menu currMenu = this.orderList.get(this.orderList.size() - 1);
		PrintCompleteMsg(currMenu.getName());

		return true;
	}

	public void OrderStart() {
		while (this.orderMenu()) {

		}

		System.out.println("Order Done.");
	}

	public List<Menu> getOrderList() {
		return this.orderList;
	}

}

class Calculator {

	public static int CalculateTime(Order order) {
		int timeSum = 0;
		List<Menu> menuList = order.getOrderList();
		for (int i = 0; i < menuList.size(); i++) {
			Menu curr = menuList.get(i);
			timeSum += curr.getTime();
		}
		return timeSum;

	}

}

class Call {

	public static void callOrder() {

	}

}

class Menu {
	private String name;
	// private ??? type; -> Beverage Dessert Goods 중 하나로 하고 싶은데 아직 방법을 모름.
	private int time; // Call 이후 상품이 나올 때까지 소요되는 시간
	private double cost; // dollar 로 표시되는 가격.

	public Menu(String str, int time, double cost) {
		this.name = str;
		this.time = time;
		this.cost = cost;
	}

	public String getName() {
		return this.name;
	}

	public int getTime() {
		return this.time;
	}

	public void setName(String str) {
		this.name = str;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}

// 아래 클래스는 상속 클래스

class Beverage {

}

class Dessert {

}

class Goods {

}

public class Kiosk {

	private static void PrintWelcomeMsg() {
		System.out.println("Welcome! This is Starbucks Order Application.");
	}

	private static void PrintTime(int num) {
		System.out.println("Your foods and goods will be prepared in " + num + " minutes.");
	}

	public static void main(String[] args) {
		// 주문 받는 클래스 Order
		// 받은 주문의 계산을 도와주는 클래스 Calculator
		// 출품을 알려주는 알림 서비스 클래스 Call

		PrintWelcomeMsg();

//		List<Menu> orderList = new ArrayList<Menu>();

		Order kiosk = new Order();
		kiosk.OrderStart(); // Order는 Menu[] 를 return 한다.
		PrintTime(Calculator.CalculateTime(kiosk)); // calculate는 Menu[] 를 받아 가격을 계산하고 소요시간을 return 한다.
		Call.callOrder(); // 소요시간만큼 시간 이후 랜덤정수 +1의 번호와 함께 상품 회수 메세지를 출력한다.

	}

}
