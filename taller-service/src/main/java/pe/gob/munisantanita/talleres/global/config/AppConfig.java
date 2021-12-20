package pe.gob.munisantanita.talleres.global.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "appconfig")
@Getter
@Setter
public class AppConfig {
    private Boolean debug;
}
