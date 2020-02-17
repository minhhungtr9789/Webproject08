package vn.nlu.fit.filters;

import vn.nlu.fit.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminAuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("enter to admin filter");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpRequestResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        User user = (User) session.getAttribute("user");

        // Nếu người dùng chưa đăng nhập,
        // Redirect (chuyển hướng) tới trang đăng nhập.
        if (user == null) {
            // Lưu trữ trang hiện tại để redirect đến sau khi đăng nhập thành công.
            return;
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) {
    }
}
