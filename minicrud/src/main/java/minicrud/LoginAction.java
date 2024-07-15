package minicrud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
//아직 안쓰는거임
@WebServlet("/LoginAction") // URL 뒷쪽에 붙는 이름이다. 이 쿼리를 입력하지 않으면 주소와 프로그램과 연결해주지 못한다.
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// id, pwd, checkbox 정보 받아오기
		String id = request.getParameter("id"); // id 넘어온다.
		String pwd = request.getParameter("pwd"); // pwd 넘어온다.
		String checkbox = request.getParameter("checkbox");// 체크박스의 체크여부 넘어온다.
		String recentURI = request.getParameter("from");// login에서 보낸 from으로 로그인 요청한 URI 받기
		HttpSession session = request.getSession(); // 세션 생성
		String sessionID = session.getId();// 세션 아이디 받아오기

		response.setCharacterEncoding("UTF-8"); // 한글도 입력 가능하게 하기
		PrintWriter out = response.getWriter();

		Cookie cookie = new Cookie("userId", id);// 쿠키 생성

		if (checkbox == null) {
			cookie.setMaxAge(0);// 체크박스 체크 해제되었을 때 쿠키 유효시간 0으로 해서 브라우저에서 삭제하게 한다.
			response.addCookie(cookie);
		}
		// id , pwd 에 null 체크 반드시 하기
		if ((id != null) && (pwd != null)) {
			if (id.equals("asdf") && pwd.equals("1234")) { // 로그인 성공시
				// id 와 pwd가 일치하는 경우 index.jsp로 이동 경로설정 주의!! context 값 / 으로해놓았다.
				if (checkbox != null) { // 체크박스 체크여부에 따라 쿠키 저장 확인
					response.addCookie(cookie); // 체크박스 체크 되었을 때 쿠키 저장
				}
				session.setAttribute("LoginID", id);// 세션에 로그인 아이디를 속성으로 넣기
				session.setMaxInactiveInterval(60*10);//세션의 수명을 10분으로 설정
				response.sendRedirect(recentURI); // 로그인 하기전 페이지로 보내기
			} else { // 로그인 실패시
				response.sendRedirect("/login.jsp?from="+recentURI);// 로그인 실패시 바로 login 화면으로 돌아가게하기
				// 어디서 보냈는지 기억해야하므로 recentURI추가해줘야한다.
			}
		}

	}
}