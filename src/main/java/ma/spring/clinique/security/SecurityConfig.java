package ma.spring.clinique.security;


import lombok.AllArgsConstructor;
import ma.spring.clinique.security.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class SecurityConfig {

    private PasswordEncoder passwordEncoder;
    private UserDetailServiceImpl userDetailService;



    //@Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }



    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder.encode("1234")).roles("USER").build(),
                User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("USER","ADMIN").build()
        );


    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll();
        http.rememberMe();
        http.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();

        //http.authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER");
        //http.authorizeHttpRequests().requestMatchers("/admin/**").hasRole("ADMIN");
        http.exceptionHandling().accessDeniedPage("/notAuthorized");

        http.authorizeHttpRequests().anyRequest().authenticated();
        http.userDetailsService(userDetailService);
        return http.build();
    }


}
