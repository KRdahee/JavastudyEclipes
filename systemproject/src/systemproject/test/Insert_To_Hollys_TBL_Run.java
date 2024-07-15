package systemproject.test;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert_To_Hollys_TBL_Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		final String connectionUrl = """
				jdbc:oracle:thin:@localhost:1521/orcl
				""";
		try {
			
		Class.forName("oracle.jdbc.OracleDriver");
		connection = DriverManager.getConnection(connectionUrl, "WEBMASTER", "webmaster");
		
		final String insert_sql = """
				INSERT INTO hollys(hollys_id, 매점이름, 매점지역, 매점주소, 매점전화번호)\s
				VALUES(?,?,?,?,?)
				""";
		
		final InputStream InputStream = new FileInputStream("./Hollys_table.csv"); //FileInput을 통해서 파일을 추가
		
		final Reader reader = new InputStreamReader(InputStream); //파일 읽기
		
		final BufferedReader bufferedReader = new BufferedReader(reader); //오라클에 파일을 던지기 위해서 필요함.
		
		int index = 0;
		
		PreparedStatement preparedstatement = null;
		
		while(true) {
			
		String hollys_str = bufferedReader.readLine(); //한줄을 통으로 읽어오기.
		
			if(hollys_str == null) break; // 다 읽었을 때
			
			String store_address = null;
			String store_name = null;
			String store_province_city = null;
			String store_phone_number = null;
			
			boolean isFound = false; //""를 찾았는지 체크
			
			int double_quotes = 0;
			
			for(char c : hollys_str.toCharArray()) {
				if(c == '"') {
					++double_quotes;
					if(double_quotes == 2) isFound = true;
				}
			} 
			//part1
			String [] patterns; //[0]번 [(),()] 1번째 [""] 2번째 [.()] 
			
			if(isFound) {
				final String[] patterns1 = hollys_str.split("\"");
				patterns = new String[patterns1.length]; //패턴 길이만큼 예)3
				for (int i = 0; i < patterns1.length; ++i) {
					patterns[i] = patterns1[i];
				}
			
				final String[] pattern1 = patterns[0].split(",");  //DB에서 가져올 때 나눌곳
			final String[] pattern2 = patterns[2].split(",");  //DB에서 가져올 때 나눌곳(확인 후)
			
			store_address = patterns1[1];
			store_name = pattern1[0];			//이름
			store_province_city = pattern1[1];	//지역
			store_phone_number = pattern2[1];
			
			preparedstatement = connection.prepareStatement(insert_sql);			
			preparedstatement.setInt(1, ++index);
			preparedstatement.setString(2, store_name);
			preparedstatement.setString(3, store_province_city);
			preparedstatement.setString(4, store_address);
			preparedstatement.setString(5, store_phone_number);
			
			final int row = preparedstatement.executeUpdate();
			
			System.out.println("저장된 index : " + row);
			
			} else { //part2
				
				String[] hollys_arr = hollys_str.split(","); //전화번호 없을땐 null or 없음
				
				if (hollys_arr.length == 4 ) {
					
					preparedstatement = connection.prepareStatement(insert_sql);			
					preparedstatement.setInt(1, ++index);
					preparedstatement.setString(2, hollys_arr[0]);
					preparedstatement.setString(3, hollys_arr[1]);
					preparedstatement.setString(4, hollys_arr[2]);
					preparedstatement.setString(5, hollys_arr[3]);
					
					final int row = preparedstatement.executeUpdate();
					
					System.out.println("저장된 index : " + row);
				} else {
					System.out.println("ERRORR"); //자바 or Oracle 에서는 300개 이상 출력 불가능.
				}
			}
		}
	
		preparedstatement.close();
		bufferedReader.close();
		reader.close();
		InputStream.close();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         try {
	             connection.close();
	          } catch (SQLException e) {
	             e.printStackTrace();
	          }
	       }
	    }
	 }