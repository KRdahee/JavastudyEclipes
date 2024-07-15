package systemproject.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_Book_Run {

   public static void main(String[] args) {
      Connection connect = null;
      final String connectionURL = """
            jdbc:oracle:thin:@192.168.0.2:1521/xe
            """;

      try {
         Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 클래스 이름 수정
         connect = DriverManager.getConnection(connectionURL, "madang", "madang");
         System.out.println("연결 성공");
         final String insert_sql = """
               INSERT INTO book(bookid, bookname, publisher, price)\s
               VALUES(?, ?, ?, ?)
                  """;
         final PreparedStatement preparedStatement = connect.prepareStatement(insert_sql);
         preparedStatement.setInt(1, 2);
         preparedStatement.setString(2, "축구 하는 코기");
         preparedStatement.setString(3, "웰시코기출판사");
         preparedStatement.setInt(4, 30000);
         final int row = preparedStatement.executeUpdate();
         System.out.println("저장된 행" + row);

      } catch (ClassNotFoundException e) {
//         e.printStackTrace();
         System.out.printf("%s\r\n", e.getMessage());
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         if (connect != null) { // 널 체크 추가
            try {
               connect.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }
}