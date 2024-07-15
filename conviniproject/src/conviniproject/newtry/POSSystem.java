package conviniproject.newtry;

import java.time.LocalDateTime;     
import java.time.format.DateTimeFormatter;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * POSSystem 클래스는 판매 시점 관리 시스템의 기능을 제공합니다.
 * 재고 관리, 사용자 관리, 거래 처리 등의 기능을 포함합니다.
 */
public class POSSystem {
	private Inventory inventory;
	private User currentUser;

	/*
	 * POSSystem 생성자. 초기 인벤토리를 설정하고 기본 사용자 정보를 설정합니다.
	 */
	public POSSystem() {
		inventory = new Inventory(); // 인벤토리 객체 생성
		currentUser = new User("DAHEE", 28, 390500); // 사용자 객체 생성, 초기 잔액을 390,500원으로 설정

		LocalDateTime datecheck2 = LocalDateTime.of(2024, 6, 7, 12, 00, 00); // 초기 인벤토리에 몇 가지 상품 추가

		inventory.addProduct(new Product("우유", "1", 3500, 100, datecheck2));
		datecheck2 = LocalDateTime.of(2024, 7, 8, 12, 00, 00);

		inventory.addProduct(new Product("계란", "2", 4560, 20, datecheck2));
		datecheck2 = LocalDateTime.of(2024, 7, 8, 12, 00, 00);

		inventory.addProduct(new Product("담배", "3", 5500, 50, datecheck2));
		datecheck2 = LocalDateTime.of(2026, 7, 8, 12, 00, 00);

		inventory.addProduct(new Product("소주", "4", 7500, 50, datecheck2));
		datecheck2 = LocalDateTime.of(2026, 7, 8, 12, 00, 00);

		inventory.addProduct(new Product("두부", "5", 2300, 30, datecheck2));
		inventory.addProduct(new Product("커피", "6", 3580, 100, datecheck2));
		inventory.addProduct(new Product("샌드위치", "7", 1500.12, 35, datecheck2));
		inventory.addProduct(new Product("주먹밥", "8", 3550.9, 20, datecheck2));
		inventory.addProduct(new Product("도시락", "9", 5500.04, 30, datecheck2));
		inventory.addProduct(new Product("체리", "10", 18000, 78, datecheck2));
		inventory.addProduct(new Product("고구마", "11", 15000, 55, datecheck2));
		inventory.addProduct(new Product("초콜릿", "12", 1500, 83, datecheck2));

	}

    /*
     * 사용자로부터 환불할 상품 정보를 입력받아 환불을 처리하는 메서드. 
     */
	public void getMyMoneyBack() {
		Scanner scanner = new Scanner(System.in);

		// 환불할 상품 번호 입력 받기
		System.out.println();
		System.out.printf("환불하고자 하는 상품 번호를 입력하시오. ");
		String productId = scanner.nextLine();
		Product product = inventory.getProduct(productId);

		// 상품이 존재하지 않을 경우 메시지 출력
		if (product == null) {
			System.out.printf("해당 상품이 존재하지 않습니다.");
			return;
		}

		// 환불할 수량 입력 받기
		System.out.println();
		System.out.printf("환불할 수량을 입력하시오. ");
		int quantity = scanner.nextInt();
		scanner.nextLine(); // 줄바꿈 문자 소모

		// 유효하지 않은 수량 입력 시 메시지 출력
		if (quantity <= 0) {
			System.out.printf("유효한 수량을 입력하시오.");
			return;
		}

		// 사용자가 구입한 해당 상품의 수량과 가격을 기준으로 환불 진행
		double refundAmount = product.getPrice() * quantity;// 환불 금액 계산

		// 환불 처리: 재고 수량 증가, 사용자 잔액 증가
		product.setStock(product.getStock() + quantity); // 재고 수량 증가
		currentUser.addFunds(refundAmount); // 사용자의 잔액 증가

		System.out.println();
		System.out.printf("환불이 완료되었습니다. 환불 금액: " + refundAmount + " 원 입니다.");
	}
	/*
     * 유통기한을 LocalDateTime 객체로 생성하는 메서드.
     * @param a 년도
     * @param b 월
     * @param c 일
     * @return LocalDateTime 유통기한
     */
	// 유통기한을 LocalDateTime 객체로 생성하는 메서드
	public LocalDateTime newww(int a, int b, int c) {

		LocalDateTime datecheck2 = LocalDateTime.of(a, b, c, 12, 00, 00);

		return datecheck2;
	}
	/*
     * 사용자로부터 상품 정보를 입력받아 인벤토리에 추가하는 메서드. 보류
     */
	public void addstuffs() {
		Scanner sc = new Scanner(System.in);

		System.out.println("상품명, 상품번호, 상품가격, 상품 수량, 유통기한(년,월,일)를 입력하시오.");

		String name = sc.next();
		String id = sc.next();
		double price = sc.nextDouble();
		int stock = sc.nextInt();

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		newww(a, b, c);

		inventory.addProduct(new Product(name, id, price, stock, newww(a, b, c))); // 인벤토리에 새 상품 추가
		// add하는거 물건 생성자 만들었음. String name, String id, double price, int stock,
		// LocalDateTime expiryDate 순서로
	}

	// 어제와 오늘의 총 매출을 출력하는 메서드 보류
	public static void printTotalSales() {
		int totalSalesYesterday = Transaction.getTotalSalesYesterday();
		int totalSalesToday = Transaction.getTotalSalesToday();
		int totalBalance = totalSalesYesterday + totalSalesToday;

		System.out.println("어제의 총 매출: " + totalSalesYesterday + " 원 입니다.");
		System.out.println("오늘의 총 매출: " + totalSalesToday + " 원 입니다.");
		System.out.println();
		System.out.println("어제와 오늘의 총 매출: " + totalBalance + " 원 입니다.");
		System.out.println();
	}
	/*
     * 상품명을 기준으로 상품을 검색하는 메서드.
     * @param name 검색할 상품명
     * @return 검색된 상품 객체, 없으면 null
     */
	// 상품명을 기준으로 상품을 검색하는 메서드 여기
	public Product searchProductByName(String name) {
		for (Product product : inventory.getProducts().values()) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		return null;
	}
	 /*
     * 사용자로부터 검색할 상품명을 입력받아 해당 상품을 출력하는 메서드. 
     */
	
	public void searchStuff() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.printf("검색할 상품명을 입력하시오. ");
		String productName = scanner.nextLine();
		System.out.println();
		Product product = searchProductByName(productName);

		if (product != null) {
			System.out.print("상품명: " + product.getName() + " ");
			System.out.print("상품번호: " + product.getId() + " ");
			System.out.print("가격: " + product.getPrice() + " ");
			System.out.print("재고 수량: " + product.getStock() + " ");
			System.out.print("유통기한: " + product.getExpiryDate().format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
			System.out.println("");
		} else {
			System.out.println();
			System.out.println("해당 상품이 존재하지 않습니다. નાસ નાસ નાસ!");
		}
	}
	
	 /*
     * POS 시스템을 시작하는 메서드.
     * 사용자 로그인, 메뉴 선택, 각 기능 호출을 처리합니다.
     */
	public void start() {

		int wagePerMinute = 9800; // 기본 시급 설정
		Scanner scanner = new Scanner(System.in);
		System.out.println("╔═╗╔╦╗╔═╗╦═╗╔╦╗  ╔═╗╔═╗╔═╗  ╔═╗╦ ╦╔═╗╔╦╗╔═╗╔╦╗\r\n"
				+ "╚═╗ ║ ╠═╣╠╦╝ ║   ╠═╝║ ║╚═╗  ╚═╗╚╦╝╚═╗ ║ ║╣ ║║║\r\n"
				+ "╚═╝ ╩ ╩ ╩╩╚═ ╩   ╩  ╚═╝╚═╝  ╚═╝ ╩ ╚═╝ ╩ ╚═╝╩ ╩");
		System.out.println();
		while (true) {
			if (currentUser == null || !currentUser.isLoggedIn()) {
				// 사용자 로그인 단계
				System.out.printf("" + "                  (\\____(\\ \r\n" + "                  (∩`' ω ')\r\n"
						+ "                 ＿/_ミつ/￣￣￣/\r\n" + "                      /CODE/\r\n"
						+ "                     /＿＿＿/\r\n" + "아이디를 입력하세요. ");
				String username = scanner.nextLine();
				System.out.println();
				System.out.printf("비밀번호를 입력하세요. ");
				String password = scanner.nextLine();
				// 입력 받은 사용자 정보를 사용해 User 객체 생성
				currentUser = new User(username, password);
				if (!currentUser.login(username, password)) {
					System.out.println();
					System.out.println("올바른 정보가 입력되지 않았습니다. 다시 입력해주세요.");
					System.out.println();
					currentUser = null;
				} else {
					System.out.println();
					System.out.printf("로그인 성공. ");
					Timecheck tm = new Timecheck();
					tm.setLoginTime();
					System.out.println("");
				}
				System.out.println("          ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄     \r\n║║╔║║╔╗ ║ "
						+ "██░░░░░░░░▀█▄▀▄▀██████░▀█▄▀▄▀████████  \r\n╠╣╠║║║║ ║"
						+ " ░░░░░░░░░░░░▀█▄█▄███▀░░░░▀██▄█▄███▀  \r\n║║╚╚╚╚╝ O" + "");
			} else {
				// 로그인 후 메뉴 선택 단계
				System.out.println();
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-MENU+-+-+-+-+-+-+-+-+-+-+-+-+");
				System.out.println();
				System.out.println("	███╗   ███╗███████╗███╗   ██╗██╗   ██╗\r\n"
						+ "	████╗ ████║██╔════╝████╗  ██║██║   ██║\r\n"
						+ "	██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║\r\n"
						+ "	██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║\r\n"
						+ "	██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝\r\n"
						+ "	╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ \r\n"
						+ "                                      ");
				System.out.println();
				System.out.println();
				System.out.println("   		   1. 재고 확인	");
				System.out.println();
				System.out.println("   		   2. 상품 판매	");
				System.out.println();
				System.out.println("   	 	   3. 로그 아웃	");
				System.out.println();
				System.out.println("   		   4. 일당 계산	");
				System.out.println();
				System.out.println("   		   5. 상품 환불	");
				System.out.println();
				System.out.println("   		   6. 상품 입고	");
				System.out.println();
				System.out.println("   		   7. 상품 검색	");
				System.out.println();
				System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

				int choice = scanner.nextInt();
				scanner.nextLine();// 줄바꿈 문자 소모

				switch (choice) {
				case 1:
					inventory.checkInventory();// 재고 확인
					break;
				case 2:
					// 미리 설정한 카드 유효번호 패턴
					String cardNumber = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";

					// 카드 번호를 입력 받음
					System.out.println();
					System.out.println("현금은 받지 않습니다. 카드 번호를 16자리를 입력하세요. ");
					String enteredCardNumber = scanner.nextLine();
					System.out.println();
					String enteredCardNumber_card = "";
					String cardnum = enteredCardNumber.replace("-", "");

					// 입력한 카드 번호와 미리 설정한 카드 유효번호를 비교
					if (!Pattern.matches(cardNumber, enteredCardNumber)) {
						System.out.println("નાસ! 유효하지 않은 카드 번호입니다.");
						System.out.println();
						break;
					}

					// 상품 번호를 입력 받음
					System.out.printf("유효한 카드번호 입니다.");
					System.out.printf(" 상품 번호를 입력하시오. ");
					String productId = scanner.nextLine();
					Product product = inventory.getProduct(productId);
					if (product == null) {
						System.out.println();
						System.out.println("નાસ! 상품을 찾을 수 없습니다.");
						System.out.println();
					} else {
						// 소주나 담배를 구매할 때 20살 이상인지 체크
						if ((product.getName().equals("소주") || product.getName().equals("담배"))) {
							// 나이를 입력받기
							System.out.println();
							System.out.printf("성인 인증을 위한 생년월일 8자리를 입력해주세요. ");
							int age = scanner.nextInt();
							scanner.nextLine();

							age /= 10000;

							// 20살 미만이면 구매 불가
							if (age > 2005) {
								System.out.println();
								System.out.println("20살 이상 성인만 해당 상품을 구매할 수 있습니다.");
								break;
							}

						}
						// 수량을 입력 받음
						System.out.println();
						System.out.printf("수량을 입력해주세요. ");
						int quantity = scanner.nextInt();
						scanner.nextLine();

						Transaction transaction = new Transaction(product, quantity);
						System.out.println();
						System.out.println("판매가 완료되었습니다.");
						System.out.println();
						printTotalSales();
					}
					break;
				case 3:
					// 로그아웃
					currentUser.logout();
					currentUser = null;
					System.out.println();
					System.out.println("성공적으로 로그아웃 되었습니다.");
					System.out.println(
							" ▬▬▬.◙.▬▬▬\r\n" + "═▂▄▄▓▄▄▂\r\n" + "◢◤ █▀▀████▄▄▄▄▄▄\r\n" + "█▄▂█ █▄███▀▀▀▀▀▀▀-╬\r\n"
									+ "◥█████◤\r\n" + "══╩══╩═\r\n" + "╬═╬\r\n" + "╬═╬\r\n" + "╬═╬\r\n" + "╬═╬\r\n"
									+ "╬═╬\r\n" + "╬═╬ ☻/\r\n" + "╬═╬/▌\r\n" + "╬═╬/\r\n" + "BYEEEEEEEEEEEEEEEEEE");
					System.out.println();
					System.out.println();
					break;
				case 4:
					// 사용자로부터 근무 시간을 입력 받음
					System.out.println();
					System.out.printf("오늘의 총 근무 시간(분)을 입력하세요. ");
					int totalMinutesWorked = scanner.nextInt();
					scanner.nextLine(); // Consume newline

					// 시급을 사용하여 일당 계산
					int totalWage = Paycheck.calculateDailyWage(wagePerMinute, totalMinutesWorked);

					// 결과 출력
					System.out.println();
					System.out.println("오늘의 일당: " + totalWage + " 원 입니다. 수고하셨습니다.");
					System.out.println();
					break;

				case 5:
					getMyMoneyBack();// 상품 환불
					break;

				case 6:
					addstuffs();// 상품 입고
					break;

				case 7:
					searchStuff();
					break;

				default:
					System.out.println("નાસ!! 다시 시도해주세요.");

				}
			}
		}
	}
}
