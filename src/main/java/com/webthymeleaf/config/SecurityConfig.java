package com.webthymeleaf.config;


import com.webthymeleaf.serviceimpl.UserSerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserSerImpl userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService( userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/dang-ky").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasAnyAuthority("Admin","Manager")
                .antMatchers("/nguoi-dung/edit/*").hasAuthority("Admin")
                .and()
                .formLogin()
                .loginProcessingUrl("/j_spring_security_check") //
                .loginPage("/login")
                .defaultSuccessUrl("/trang-chu") //????ng nh???p xong s??? v??o ????y
                .usernameParameter("username")
                .passwordParameter("password")
                     .permitAll()
                     .and()
                     .logout()
                     .invalidateHttpSession(true)
                     .clearAuthentication(true)
                     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                     .logoutSuccessUrl("/login?logout")
                     .permitAll()
                .and()
                   .exceptionHandling().accessDeniedPage("/403");

    }


}
