package ro.sda.java30.finalproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
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
                    .csrf().ignoringAntMatchers("/api/**","/h2-console/**")
                .and()
                        .headers().frameOptions().disable();
    }

    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("admin").roles("ADMIN","CARS").password("{noop}Secret_123")
                .and()
                .withUser("admin2").authorities("ROLE_USER_ADMIN").password("{noop}Secret_123")
                .and()
                .withUser("admin3").roles("CARS").password("{noop}Secret_123")
                ;
    }
}