package conviniproject.newtry;

import java.time.LocalDateTime;
/*
 * Product 클래스는 제품 정보를 저장하고 제공하는 역할을 합니다.
 * 제품의 이름, ID, 가격, 재고, 유통기한 등의 정보를 관리합니다.
 */
class Product {
    private String name; // 제품명
    private String id; // 제품 ID
    private double price; // 제품 가격
    private int stock; // 제품 재고
    private LocalDateTime expiryDate; // 제품 유통기한
    /*
     * Product 클래스의 생성자입니다.
     * @param name        제품명
     * @param id          제품 ID
     * @param price       제품 가격
     * @param stock       제품 재고
     * @param expiryDate  제품 유통기한
     */
	public Product(String name, String id, double price, int stock, LocalDateTime expiryDate) {
		this.name = name; // 제품명 초기화
        this.id = id; // 제품 ID 초기화
        this.price = price; // 제품 가격 초기화
        this.stock = stock; // 제품 재고 초기화
        this.expiryDate = expiryDate; // 제품 유통기한 초기화
	}
	// Getters and Setters
    /*
     * 제품명을 반환하는 메서드입니다.
     * @return 제품명
     */
    public String getName() {
        return name;
    }
    /*
     * 제품 ID를 반환하는 메서드입니다.
     * @return 제품 ID
     */
    public String getId() {
        return id;
    }
    /*
     * 제품 가격을 반환하는 메서드입니다.
     * @return 제품 가격
     */
    public double getPrice() {
        return price;
    }
    /*
     * 제품 재고를 반환하는 메서드입니다.
     * @return 제품 재고
     */
    public int getStock() {
        return stock;
    }
    /*
     * 제품 재고를 설정하는 메서드입니다.
     * @param stock 설정할 제품 재고
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /*
     * 제품 유통기한을 반환하는 메서드입니다.
     * @return 제품 유통기한
     */
    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }
    /*
     * 해당 제품이 제한 상품인지 확인하는 메서드입니다.
     * 담배나 소주가 포함된 이름인 경우 제한 상품으로 간주됩니다.
     * @return 제한 상품 여부 (true/false)
     */
    public boolean isRestricted() {
        return name.contains("담배") || name.contains("소주");
    }
}