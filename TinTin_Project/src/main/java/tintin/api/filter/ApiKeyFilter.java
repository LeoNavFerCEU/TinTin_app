package tintin.api.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@SecurityRequirement(name = "Authorization")
public class ApiKeyFilter extends OncePerRequestFilter{
	
	@Value("${api.key}")
	private String apiKey;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		String requestApiKey = request.getHeader("API-KEY");
		if(apiKey.equals(requestApiKey)) {
			filterChain.doFilter(request, response);
		}else {
			response.setStatus(HttpStatus.FORBIDDEN.value());
			response.getWriter().write("FORBIDDEN TO DO ANY OPERATIONS");
		}
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		String path = request.getRequestURI();
		return (path.startsWith("/swagger") || path.startsWith("/docs"));
	}

}
