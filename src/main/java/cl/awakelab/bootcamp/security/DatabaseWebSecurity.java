package cl.awakelab.bootcamp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
  
  @Bean
  UserDetailsManager users(DataSource dataSource) {
    JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    users.setUsersByUsernameQuery("select username, password, estatus from Usuarios u where username=?");
    users.setAuthoritiesByUsernameQuery("select u.username, p.perfil from UsuarioPerfil up " + 
        "inner join Usuarios u on u.id = up.idUsuario " + 
        "inner join Perfiles p on p.id = up.idPerfil " + 
        "where u.username=?");
    
    return users;
  }
  

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.authorizeRequests()
        .antMatchers("/bootstrap/css/**","/bootstrap/js/**", "/images/**", "/css/**").permitAll()
        .antMatchers("/").permitAll()
        .anyRequest().authenticated()
        .and().formLogin().permitAll();
    
    return http.build();
    
    /* http.authorizeHttpRequests(requests -> requests
    .antMatchers("/bootstrap/css", "/img/**", "/css/**", "/js/**").permitAll()
    .antMatchers("/").permitAll()
    .anyRequest().authenticated()).formLogin(login -> login.permitAll());
    */
        
  }
}
