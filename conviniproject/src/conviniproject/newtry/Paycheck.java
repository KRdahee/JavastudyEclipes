package conviniproject.newtry;

import java.util.Scanner;

/*
 * 이 클래스는 일당 계산 시스템을 나타냅니다.
 * 총 근무 시간과 분당 임금을 기반으로 일당을 계산합니다.
 */
public class Paycheck {
    // 분당 임금을 나타내는 상수
    private static final int WAGE_PER_MINUTE = 9800; // 분당 9800원

    // 총 근무 시간을 저장하는 필드
    private int totalMinutesWorked;

    /*
     * 총 근무 시간을 0으로 초기화하는 생성자.
     */
    public Paycheck() {
        this.totalMinutesWorked = 0;
    }

    /*
     * 근무 시간을 추가하는 메서드.
     * @param minutes 추가할 근무 시간(분)
     */
    public void addWorkTime(int minutes) {
        totalMinutesWorked += minutes;
    }

    /*
     * 총 근무 시간을 기반으로 일당을 계산하는 메서드. 
     * @return 일당
     */
    public int calculateDailyWage() {
        return totalMinutesWorked * WAGE_PER_MINUTE;
    }

    /*
     * 총 근무 시간을 반환하는 메서드.
     * @return 총 근무 시간(분)
     */
    public int getTotalMinutesWorked() {
        return totalMinutesWorked;
    }

    /*
     * 주어진 분당 임금과 총 근무 시간을 기반으로 일당을 계산하는 정적 메서드.
     * @param wagePerMinute 분당 임금
     * @param totalMinutesWorked 총 근무 시간(분)
     * @return 계산된 일당
     */
    public static int calculateDailyWage(int wagePerMinute, int totalMinutesWorked) {
        return wagePerMinute * totalMinutesWorked;
    }
}
