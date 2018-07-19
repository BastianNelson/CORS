package cl.ripley.multicotizador.security;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CorsInterceptor extends HandlerInterceptorAdapter {
    
   

    public static final String REQUEST_ORIGIN_NAME = "Origin";

    public static final String CREDENTIALS_NAME = "Access-Control-Allow-Credentials";
    public static final String ORIGIN_NAME = "Access-Control-Allow-Origin";
    public static final String METHODS_NAME = "Access-Control-Allow-Methods";
    public static final String HEADERS_NAME = "Access-Control-Allow-Headers";
    public static final String MAX_AGE_NAME = "Access-Control-Max-Age";

    private final List<String> origins;
    
    public CorsInterceptor(String origins) {
        this.origins = Arrays.asList(origins.trim().split("( )*,( )*"));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       
        
        String origin = request.getHeader(REQUEST_ORIGIN_NAME);
        if (origins.contains(origin)) {
        	 response.setHeader(CREDENTIALS_NAME, "False");
             response.setHeader(METHODS_NAME, "GET, OPTIONS, POST, PUT, DELETE");
             response.setHeader(HEADERS_NAME, "Origin, X-Requested-With, Content-Type, Accept");
             response.setHeader(MAX_AGE_NAME, "60");
            response.setHeader(ORIGIN_NAME, origin);
            return true; // Proceed
        } else {
         
            // Include an origin to provide a clear browser error
           
            response.setStatus(403);
            return false; // No need to find handler
        }
    }

}

