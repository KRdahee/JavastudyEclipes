package conviniproject.newtry;

import java.time.LocalDateTime;
/*
 * 이 클래스는 거래 내역을 나타냅니다.
 * 각 거래는 상품, 수량, 거래 시간을 포함합니다.
 * 또한 총 매출을 관리합니다.
 */
class Transaction {
    private Product product; // 거래된 상품
    private int quantity; // 거래된 수량
    private LocalDateTime transactionTime; // 거래 시간

    private static int totalSalesYesterday = 390500; // 어제의 총 매출 (초기값: 390500)
    private static int totalSalesToday = 0; // 오늘의 총 매출

    /*
     * Transaction 생성자.
     * 거래된 상품과 수량을 설정하고 재고와 매출을 업데이트합니다.
     * @param product 거래된 상품
     * @param quantity 거래된 수량
     */
    public Transaction(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.transactionTime = LocalDateTime.now();
        updateStock(); // 거래 후 재고 업데이트
        updateSales(); // 거래 후 매출 업데이트
    }

    /*
     * 거래된 수량만큼 재고를 감소시키는 메서드.
     */
    private void updateStock() {
        int currentStock = product.getStock(); // 현재 재고 수량
        product.setStock(currentStock - quantity); // 재고 수량 감소
    }

    /*
     * 거래된 금액을 오늘의 총 매출에 더하는 메서드.
     */
    private void updateSales() {
        totalSalesToday += product.getPrice() * quantity; // 오늘의 총 매출 업데이트
    }

    /*
     * 거래의 총 가격을 반환하는 메서드.
     * @return 거래의 총 가격
     */
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    /*
     * 어제의 총 매출을 반환하는 정적 메서드.
     * @return 어제의 총 매출
     */
    public static int getTotalSalesYesterday() {
        return totalSalesYesterday;
    }

    /*
     * 오늘의 총 매출을 반환하는 정적 메서드.
     * @return 오늘의 총 매출
     */
    public static int getTotalSalesToday() {
        return totalSalesToday;
    }

    /*
     * Transaction 클래스 초기화 시 어제의 총 매출을 설정합니다.
     */
    static {
        totalSalesYesterday = Transaction.getTotalSalesYesterday();
    }
}
