package pe.gob.munisantanita.talleres.global.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BaseConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("jwtInterceptor")
    private HandlerInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Afecta a todos los request
        registry.addInterceptor(interceptor);

        // Afecta a todos los request, menos al patters "/cerrado";
        //registry.addInterceptor(interceptor).excludePathPatterns("/cerrado");
    }
}
