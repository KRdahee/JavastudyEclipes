package conviniproject.newtry;

import java.time.format.DateTimeFormatter;  
import java.util.HashMap;
import java.util.Map;
/*
 * Inventory 클래스는 재고 관리를 위한 기능을 제공합니다.
 * 제품을 추가, 제거하고, 재고를 확인하는 기능을 포함합니다.
 */

class Inventory {
	private Map<String, Product> products;// 재고를 저장하는 맵
    //Inventory 클래스의 생성자입니다. 초기에 빈 맵을 생성하여 제품을 저장합니다.
	
	public Inventory() {
		products = new HashMap<>();// 초기화
	} //제품을 재고에 추가하는 메서드입니다. @param product 추가할 제품 객체

	public void addProduct(Product product) {
		products.put(product.getId(), product);// 제품 추가
	} //제품을 재고에서 제거하는 메서드입니다. @param productId 제거할 제품의 ID
	
	public void removeProduct(String productId) {
		products.remove(productId);// 제품 제거
	} //제품 ID를 기반으로 재고에서 제품을 가져오는 메서드입니다. @param productId 가져올 제품의 ID. @return 해당 ID에 해당하는 제품 객체

	public Product getProduct(String productId) {
		return products.get(productId); // 제품 가져오기
	} //전체 제품 목록을 반환하는 메서드입니다. @return 모든 제품의 맵
	public Map<String, Product> getProducts() {
		return products; // 모든 제품 반환
	}
	public void checkInventory() { //현재 재고를 출력하는 메서드입니다.

		DateTimeFormatter check = DateTimeFormatter.ofPattern("yyyy.MM.dd");// 날짜 형식 지정

		System.out.println("                   < 현재 재고 입니다. >");
		System.out.println();
		for (Product product : products.values()) {// 모든 제품에 대해 반복
			System.out.print("	" + "물품: " + product.getName() + ", 수량: " + product.getStock());
			System.out.println(", 유통기한: " + product.getExpiryDate().format(check));// 유통기한 포맷팅하여 출력
			System.out.println();

		}
	}
}
