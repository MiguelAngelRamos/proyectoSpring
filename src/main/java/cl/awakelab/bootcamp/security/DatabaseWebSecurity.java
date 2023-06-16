package cl.awakelab.bootcamp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
  @Bean
  UserDetailsManager users(DataSource dataSource) {
    
    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    return users;
  }
}
