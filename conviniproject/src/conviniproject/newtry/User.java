package conviniproject.newtry;
/*
 * 이 클래스는 사용자를 나타냅니다.
 * 사용자 정보와 관련된 다양한 기능을 제공합니다.
 */
class User {
    private String username; // 사용자 이름
    private String password; // 비밀번호
    private boolean isLoggedIn; // 로그인 상태
    private int age; // 나이
    private double balance; // 잔액

    /*
     * 사용자 이름, 나이, 잔액을 초기화하는 생성자.
     * @param name 사용자 이름
     * @param age 나이
     * @param balance 잔액
     */
    public User(String name, int age, double balance) {
        this.username = name;
        this.age = age;
        this.balance = balance;
    }

    /*
     * 사용자 이름과 비밀번호를 초기화하는 생성자.
     * 기본값으로 "dahee"와 "1997"을 설정합니다.
     * @param username 사용자 이름
     * @param password 비밀번호
     */
    public User(String username, String password) {
        this.username = "dahee";
        this.password = "1997";
        this.isLoggedIn = false;
    }

    /*
     * 사용자 이름을 반환하는 메서드.
     * @return 사용자 이름
     */
    public String getName() {
        return username;
    }

    /*
     * 나이를 반환하는 메서드.
     * @return 나이
     */
    public int getAge() {
        return age;
    }

    /*
     * 사용자가 미성년자인지 여부를 확인하는 메서드.
     * @return 미성년자 여부
     */
    public boolean isMinor() {
        return age < 20;
    }

    /*
     * 잔액을 반환하는 메서드.
     * @return 잔액
     */
    public double getBalance() {
        return balance;
    }

    /*
     * 구매를 시도하고 성공 여부를 반환하는 메서드.
     * @param amount 구매 금액
     * @return 구매 성공 여부
     */
    public boolean purchase(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    /*
     * 잔액을 추가하는 메서드.
     * @param amount 추가할 금액
     */
    public void addFunds(double amount) {
        balance += amount;
    }

    /*
     * 로그인 시도 및 성공 여부를 반환하는 메서드.
     * @param username 사용자 이름
     * @param password 비밀번호
     * @return 로그인 성공 여부
     */
    public boolean login(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    /*
     * 로그아웃하는 메서드.
     */
    public void logout() {
        this.isLoggedIn = false;
    }

    /*
     * 로그인 상태를 반환하는 메서드.
     * @return 로그인 상태
     */
    public boolean isLoggedIn() {
        return this.isLoggedIn;
    }

    /*
     * 사용자 이름을 반환하는 메서드. (중복된 메서드명, getName과 동일한 기능)
     * @return 사용자 이름
     */
    public String getUsername() {
        return username;
    }
}
