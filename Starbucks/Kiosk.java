import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Order {
	private List<Menu> orderList = new ArrayList<Menu>();
	private Menu[][] menuArray = new Menu[3][3];
	private static final int coffeeArraySize = 3;
	private static final int cakeArraySize = 3;
	private static final int tumblerArraySize = 3;

	public Order() {
		menuArray[0][0] = new Menu("\"Today\'s Coffee\"", 5, 3.0);
		menuArray[0][1] = new Menu("\"Cafe Latte\"", 10, 4.0);
		menuArray[0][2] = new Menu("\"Americano\"", 5, 3.5);

		menuArray[1][0] = new Menu("\"Cheese Cake\"", 3, 4.0);
		menuArray[1][1] = new Menu("\"Red Velvet Cake\"", 3, 4.0);
		menuArray[1][2] = new Menu("\"Cookie and Cream Cake\"", 3, 5.0);

		menuArray[2][0] = new Menu("\"Starbucks Limited Edition Tumbler(Pink)\"", 1, 7.0);
		menuArray[2][1] = new Menu("\"Starbucks Limited Edition Tumbler(Sky Blue)\"", 1, 7.0);
		menuArray[2][2] = new Menu("\"Starbucks Limited Edition Tumbler(Green)\"", 1, 7.0);

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
		String coffeeName = null;
		double cost = 0;

		for (int i = 0; i < coffeeArraySize; i++) {
			Menu currMenu = menuArray[0][i];
			coffeeName = currMenu.getName();
			cost = currMenu.getCost();
			System.out.println((i + 1) + ". \"" + coffeeName + "\" | Cost: " + cost);
		}
	}

	private void printCakeMenu() {
		System.out.println("=== Cake List ===");
		String cakeName = null;
		double cost = 0;

		for (int i = 0; i < coffeeArraySize; i++) {
			Menu currMenu = menuArray[1][i];
			cakeName = currMenu.getName();
			cost = currMenu.getCost();
			System.out.println((i + 1) + ". \"" + cakeName + "\" | Cost: " + cost);
		}
	}

	private void printTumblerMenu() {
		System.out.println("=== Tumbler List ===");
		String tumblerName = null;
		double cost = 0;

		for (int i = 0; i < coffeeArraySize; i++) {
			Menu currMenu = menuArray[2][i];
			tumblerName = currMenu.getName();
			cost = currMenu.getCost();
			System.out.println((i + 1) + ". \"" + tumblerName + "\" | Cost: " + cost);
		}
	}

	private Menu chooseMenu(int typeNum, int productionNum) {
		return menuArray[typeNum - 1][productionNum - 1];
	}

	private void PrintCompleteMsg(String str) {
		System.out.println("Your " + str + " has been added to your shopping cart.");
	}

	private boolean isItOutOfBound(int n1, int n2) {
		int temp = 0;

		if (n1 == 1) {
			temp = coffeeArraySize;
		} else if (n1 == 2) {
			temp = cakeArraySize;
		} else {
			temp = tumblerArraySize;
		}

		if (n2 > temp || n2 <= 0) {
			System.out.println("You entered a wrong number.");
			System.out.println();
			return true;
		} else
			return false;
	}

	private void orderMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			this.PrintMenu();
			int i = sc.nextInt();

			if (i == 1) {

				this.printCoffeeMenu();
				int j = sc.nextInt();
				if (isItOutOfBound(i, j))
					continue;
				this.orderList.add(this.chooseMenu(i, j));

			} else if (i == 2) {

				this.printCakeMenu();
				int j = sc.nextInt();
				if (isItOutOfBound(i, j))
					continue;
				this.orderList.add(this.chooseMenu(i, j));

			} else if (i == 3) {

				this.printTumblerMenu();
				int j = sc.nextInt();
				if (isItOutOfBound(i, j))
					continue;
				this.orderList.add(this.chooseMenu(i, j));

			} else {
				break;
			}
			Menu currMenu = this.orderList.get(this.orderList.size() - 1);
			PrintCompleteMsg(currMenu.getName());
			System.out.println();
		}

	}

	public void OrderStart() {
		this.orderMenu();
		System.out.println("Order Done.\n");
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

	public static double CalculateCost(Order order) {
		double costSum = 0.0;
		List<Menu> menuList = order.getOrderList();
		for (int i = 0; i < menuList.size(); i++) {
			Menu curr = menuList.get(i);
			costSum += curr.getCost();
		}
		return costSum;
	}

}

class Call {

	public static void callOrder() {

	}

}

class Menu {
	private String name;
	// private ??? type; -> Beverage Dessert Goods ??? ????????? ?????? ????????? ?????? ????????? ??????.
	private int time; // Call ?????? ????????? ?????? ????????? ???????????? ??????
	private double cost; // dollar ??? ???????????? ??????.

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

	public double getCost() {
		return this.cost;
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

// ?????? ???????????? ?????? ?????????

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

	private static void PrintCart(List<Menu> orderList) {
		// ???????????? ????????? coffee, cake, tumbler ??????
		// summary of cost ??????
		String currMenuName = "";
		double currMenuCost = 0.0;
		System.out.println("===== Shopping Cart Info =====");
		for (int i = 0; i < orderList.size(); i++) {
			currMenuName = orderList.get(i).getName();
			currMenuCost = orderList.get(i).getCost();
			System.out.println((i + 1) + ". " + currMenuName + " | Cost: " + currMenuCost);
		}
	}

	private static void PrintBill(double cost) {
		System.out.println("Total cost: " + cost);
	}

	public static void main(String[] args) {
		// ?????? ?????? ????????? Order
		// ?????? ????????? ????????? ???????????? ????????? Calculator
		// ????????? ???????????? ?????? ????????? ????????? Call

		PrintWelcomeMsg();

		Order kiosk = new Order();
		kiosk.OrderStart(); // Order??? Menu[] ??? return ??????.
		PrintCart(kiosk.getOrderList());
		PrintBill(Calculator.CalculateCost(kiosk));
		PrintTime(Calculator.CalculateTime(kiosk)); // calculateTime??? Order ??? ?????? ????????? ???????????? ??????????????? return ??????.
		Call.callOrder(); // ?????????????????? ?????? ?????? ???????????? +1??? ????????? ?????? ?????? ?????? ???????????? ????????????.

	}

}