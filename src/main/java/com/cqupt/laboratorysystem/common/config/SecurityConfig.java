package com.cqupt.laboratorysystem.common.config;

import com.cqupt.laboratorysystem.common.filter.CaptchaFilter;
import com.cqupt.laboratorysystem.common.handler.LoginFailureHandler;
import com.cqupt.laboratorysystem.common.handler.LoginSuccessHandler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @create 2023/5/3 16:28
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    private final LoginSuccessHandler loginSuccessHandler;

    private final LoginFailureHandler loginFailureHandler;

    private final CaptchaFilter captchaFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //用来忽略URL地址，被忽略的URL不会被Security拦截，一般项目中的静态文件需要忽略。
        web.ignoring().antMatchers("/js/**","/css/**","/images/**","/layui/**","/lib/**","/api/**","/webjars/**","/error/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
             //csrf防护
             .csrf().disable()
             .headers()
             .frameOptions().disable()
             .and()

             //设置url权限
             .authorizeRequests()
                    .antMatchers("/configuration/ui","/swagger-ui.html",
                        "/swagger-resources/**","/v2/api-docs",
                        "/actuator/**","/captcha","/index","/emp/**","/welcome","/main","/custom-authenticate"
                    ).permitAll()
                    .anyRequest().authenticated()
                    .and()

             //登录
//             .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)
             .formLogin()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/custom-authenticate").permitAll()
                    .failureHandler(loginFailureHandler)
                    .successHandler(loginSuccessHandler)
                    .successForwardUrl("/main").permitAll()
//                    .defaultSuccessUrl("/main",true).permitAll()
                    .and()

             //退出登录
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/loginPage")
            .permitAll();
//            .cors();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
    }

}
