package daumnews.secondproject;

import java.io.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert_To_Daum_Run {

    public static void main(String[] args) {
        Connection connection = null;
        final String connectionUrl = "jdbc:oracle:thin:@localhost:1521/orcl";

        try {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Establish connection
            connection = DriverManager.getConnection(connectionUrl, "daumnews", "daumnews");

            // SQL statement for insertion
            final String insert_sql = "INSERT INTO daumnews(제목, 출처, 시간) VALUES(?, ?, ?)";

            // Prepare to read CSV file
            final String csvFile = "C:\\Codes\\Python\\news_articles.csv";
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));

            // Prepare the PreparedStatement for insertion
            final PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split CSV line by comma
                String[] data = line.split(",");

                // Assuming CSV format is: 제목,출처,시간
                String 제목 = data[0].trim();  // Assuming 제목 is the first column
                String 출처 = data[1].trim();  // Assuming 출처 is the second column
                String 시간 = data[2].trim();  // Assuming 시간 is the third column

                // Check if the 제목 already exists in the table
                PreparedStatement checkStatement = connection.prepareStatement("SELECT COUNT(*) FROM daumnews WHERE 제목 = ?");
                checkStatement.setString(1, 제목);
                ResultSet resultSet = checkStatement.executeQuery();
                
                resultSet.next();
                int count = resultSet.getInt(1);
                
                checkStatement.close();
                
                if (count == 0) {
                    // Set parameters for PreparedStatement
                    preparedStatement.setString(1, 제목);
                    preparedStatement.setString(2, 출처);
                    preparedStatement.setString(3, 시간);

                    // Execute the insert statement
                    int row = preparedStatement.executeUpdate();
                    System.out.println("저장된 행: " + row);
                } else {
                    System.out.println("제목이 이미 존재하여 삽입되지 않았습니다: " + 제목);
                }
            }

            // Close resources
            bufferedReader.close();
            preparedStatement.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
