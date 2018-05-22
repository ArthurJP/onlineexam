package com.jp.onlineexam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/16/2018
 */
@Configuration
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

//        CSRF Cross-site Request Forgery
        http.csrf().csrfTokenRepository( new CookieCsrfTokenRepository() ).requireCsrfProtectionMatcher(
                request -> request.getMethod().equals( "POST" ) && request.getRequestURI().startsWith( "login" )
        );

//        CSP Content Security Policy  开发完成后开启
//        http.headers().contentSecurityPolicy( "script-src http://localhost:8080/" );

//        X-Frame-Options header iframe的加载控制
//        相同域名允许
        http.headers().frameOptions().sameOrigin();

//        指定白名单可以访问
//        http.headers().addHeaderWriter( new XFrameOptionsHeaderWriter( new AllowFromStrategy() {
////            @Override
////            public String getAllowFromValue(HttpServletRequest request) {
////                return "url example:www.baidu.com";
////            }
////        } ) )

//        XSS header
        http.headers().xssProtection().block( true );

        http.authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers( "/login" ).permitAll()
                .antMatchers( "/sys/**" ).hasAnyRole( "ADMIN" )
//                全部验证
//                .anyRequest().fullyAuthenticated()
//                .anyRequest().authenticated()
            .and()
                .formLogin().usernameParameter( "name" )
                .passwordParameter( "pwd" )
                .loginPage( "/login" )
                .loginProcessingUrl( "/loginAction" )
                .defaultSuccessUrl( "/sys/index" )
                .failureUrl( "/login?error" )
                .permitAll()
            .and()
                .logout().logoutUrl( "/logoutAction" ).logoutSuccessUrl( "/login" ).permitAll()
            .and()
                .exceptionHandling().accessDeniedHandler( accessDeniedHandler );

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser( "jp" ).password( "1234" ).roles( "ADMIN" )
                .and().withUser( "刘德华" ).password( "123456" ).roles( "USER" );

//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .withDefaultSchema()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers( "/login_files", "/bootstrap/**", "/dist/**", "/pages/**", "/plugins/**" );
    }
}
