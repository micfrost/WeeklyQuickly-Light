package dev.micfro.weeklyquicklylight.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import java.io.IOException;

public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Here you can write custom logic to be executed after successful authentication
        // For example, redirecting to a specific URL:
        setDefaultTargetUrl("/login-success");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}