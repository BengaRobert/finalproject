package ro.sda.java30.finalproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ro.sda.java30.finalproject.service.UserDetailsSecurityService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private UserDetailsSecurityService userDetailsSecurityService;

    public SecurityConfiguration(UserDetailsSecurityService userDetailsSecurityService) {
        this.userDetailsSecurityService = userDetailsSecurityService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/customer").permitAll()
                .antMatchers("/customer/delete/**").hasRole("ADMIN")
                .antMatchers("/customer/list/**").hasRole("ADMIN")
                .antMatchers("/customer/**").permitAll()
                .antMatchers("/specialization/**").hasRole("ADMIN")
                .antMatchers("/instructor/**").hasRole("ADMIN")
                .antMatchers("/product/**").hasRole("ADMIN")
                .antMatchers("/equipment/**").hasRole("ADMIN")
                .antMatchers("/languages/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.GET,"/api/cars").hasAnyRole("ADMIN","CARS")
//                .antMatchers(HttpMethod.POST,"/api/cars").authenticated()
//                .antMatchers("/api/users/**").hasAuthority("ROLE_USER_ADMIN") //test
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .logout()
                .and()
                .csrf().ignoringAntMatchers("/api/**", "/h2-console/**")
                .and()
                .headers().frameOptions().disable();
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsSecurityService).passwordEncoder( new BCryptPasswordEncoder());
    }
//    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .withUser("admin").roles("ADMIN","CARS").password("{noop}Secret_123")
//                .and()
//                .withUser("admin2").authorities("ROLE_USER_ADMIN").password("{noop}Secret_123")
//                .and()
//                .withUser("admin3").roles("CARS").password("{noop}Secret_123")
//                ;
//    }
}