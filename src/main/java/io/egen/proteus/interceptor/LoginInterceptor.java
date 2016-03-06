package io.egen.proteus.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import io.egen.proteus.exception.LoginRequiredException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
			
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
			
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
						
		final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new LoginRequiredException();
        }

        final String token = authHeader.substring(7);

        final Claims claims = Jwts.parser().setSigningKey("secretkey")
		    .parseClaimsJws(token).getBody();
        System.out.println(claims.getExpiration());
		request.setAttribute("claims", claims);
		return true;
	}
}
