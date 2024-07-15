package minicrud;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/admin_users.jsp")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        // 여기서 관리자 권한을 확인하는 로직을 구현
        // 세션에서 관리자 권한을 확인
        HttpSession session = req.getSession(false); // 세션이 없으면 새로 생성하지 않음
        boolean isAdmin = session != null && session.getAttribute("isAdmin") != null && (boolean) session.getAttribute("isAdmin"); /* 여기에 관리자 권한을 확인하는 로직을 구현 */;
        
        if (isAdmin) {
            chain.doFilter(request, response); // 다음 필터 또는 서블릿으로 전달
        } else {
            res.sendRedirect("login.jsp"); // 관리자가 아닌 경우 로그인 페이지로 리다이렉트
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // 필요한 경우 초기화 코드 추가
    }

    @Override
    public void destroy() {
        // 필요한 경우 리소스 해제 코드 추가
    }
}
