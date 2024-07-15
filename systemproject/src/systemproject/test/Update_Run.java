package systemproject.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update_Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String update_sql = """
				UPDATE customer SET name=?, address=?, phone=?\s WHERE custid=? """;
		Connection connect = null;

		final String connectionURL = """
						jdbc:oracle:thin:@192.168.0.2:1521/xe

				""";

		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버 클래스 이름 수정
			connect = DriverManager.getConnection(connectionURL, "madang", "madang");

			final PreparedStatement preparedStatement = connect.prepareStatement(update_sql);

			preparedStatement.setString(1, "손흥민");
			preparedStatement.setString(2, "대한민국 강원도");
			preparedStatement.setString(3, "010-4568-7895");
			preparedStatement.setInt(4, 5);

			final int row = preparedStatement.executeUpdate();
			System.out.println("수정된 데이터 갯수" + row);
			preparedStatement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
