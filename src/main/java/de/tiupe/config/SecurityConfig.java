package de.tiupe.config;

import de.tiupe.business.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository myUserRepo;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/news/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .csrf().ignoringAntMatchers("/restuser")
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    /*Hiermit wird ein AuthenticationBuilder */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .withUser("user")
//                .password("password").roles("USER").and()
//                .withUser("admin").password("password")
//                .roles("USER", "ADMIN");
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(new MyUserDetailsService(myUserRepo)).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    /** this is needed for method security later */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }
}
