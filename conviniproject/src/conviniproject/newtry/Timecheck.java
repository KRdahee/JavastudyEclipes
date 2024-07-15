package conviniproject.newtry;

import java.time.LocalDateTime;   
import java.time.format.DateTimeFormatter;
/*
 * Timecheck 클래스는 시간 관련 기능을 제공합니다.
 * 사용자의 로그인 시간을 기록하고 출력하는 기능을 포함합니다. 
 */

public class Timecheck {

    public static LocalDateTime timecheck = LocalDateTime.now(); 
    // 현재 시간을 저장하는 변수
    
    /*
     * 사용자의 로그인 시간을 설정하고 출력하는 메서드입니다.
     * 시작 로그인 시간을 출력합니다.
     */
    public void setLoginTime() {
        LocalDateTime time = LocalDateTime.now(); // 현재 시간을 가져옴
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss"); 
        // 출력 형식 지정

        System.out.printf("현재 시간: " + time.format(dtf)); // 현재 시간 출력
    }
}
