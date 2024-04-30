package ru.good.HW_7.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();

        if ("admin".equals(username)) {
            // Редирект для пользователя admin на /private
            response.sendRedirect("/private-data");
        } else if ("user".equals(username)) {
            // Редирект для пользователя user на /public
            response.sendRedirect("/public-data");
        } else {
            // Неизвестный пользователь, возможно, стоит отправить на главную страницу
            response.sendRedirect("/login");
        }
    }
}
