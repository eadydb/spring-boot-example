package com.eadydb.boot.security;

import com.google.code.kaptcha.Constants;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author eadydb {dengbin1201@163.com}
 * @Date 17-5-5 下午2:47
 * <p>
 * @Description 验证拦截器, 对验证码进行验证
 **/
public class KaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String servletPath;

    public KaptchaAuthenticationFilter(String servletPath, String failureUrl) {
        super(servletPath);
        this.servletPath = servletPath;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if ("POST".equalsIgnoreCase(request.getMethod()) && servletPath.equalsIgnoreCase(request.getServletPath())) {
            String validateCode = request.getParameter("kaptcha");
            String realVailDateCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (validateCode != null && !validateCode.equalsIgnoreCase(realVailDateCode)) {
                unsuccessfulAuthentication(request, response, new InsufficientAuthenticationException("输入验证码不正确"));
                return;
            }
        }

        chain.doFilter(req, res);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
