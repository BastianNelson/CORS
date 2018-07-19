package cl.ripley.multicotizador.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	 @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(new CorsInterceptor("http://localhost:9084,http://localhost:9083"));
	        
	    }
}