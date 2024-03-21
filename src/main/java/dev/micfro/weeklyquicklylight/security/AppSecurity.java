package dev.micfro.weeklyquicklylight.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Controller
public class AppSecurity {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery("select username, password, enabled from user where username=?");

        userDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        return userDetailsManager;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(config -> config
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/**").hasRole("ADMIN")
                        .anyRequest().authenticated())

                .formLogin(form -> form

                        .loginPage("/login")

                        .loginProcessingUrl("/authenticate")

                        .permitAll())


                .logout(logout -> logout

                        .permitAll());

        return http.build();
    }
}
