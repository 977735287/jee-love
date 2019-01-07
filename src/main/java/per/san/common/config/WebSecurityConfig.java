//package per.san.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//
///**
// * description:
// *
// * @author shencai.huang@hand-china.com
// * @date 12/29/2018 17:14
// * lastUpdateBy: shencai.huang@hand-china.com
// * lastUpdateDate: 12/29/2018
// */
//@Configuration
//@EnableAuthorizationServer  //  注解开启验证服务器
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/public/**", "/login", "/register", "/find", "/swagger-ui.html",
//                        "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui",
//                        "/configuration/security", "/v1/sys/user/**")
//                .permitAll()         // 设置所有人都可以访问登录页面
//                .anyRequest()               // 任何请求,登录后可以访问
//                .authenticated()
//                .and()
//                .csrf().disable();          // 关闭csrf防护
//    }
//
//}
