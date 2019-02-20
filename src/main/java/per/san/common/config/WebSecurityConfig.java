package per.san.common.config;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import per.san.common.security.service.CustomUserDetailsService;
import per.san.sys.domain.SysPermission;
import per.san.sys.mapper.SysPermissionMapper;

import java.util.List;

/**
 * description:
 *
 * @author shencai.huang@hand-china.com
 * @date 12/29/2018 17:14
 * lastUpdateBy: shencai.huang@hand-china.com
 * lastUpdateDate: 12/29/2018
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //启用方法级的权限认证
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    @Bean
    UserDetailsService customUserService() { //注册UserDetailsService 的bean
        return new CustomUserDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //user Details Service验证

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<SysPermission> permissionList = sysPermissionMapper.selectAllPublicPermission();
        List<String> urls = Lists.newArrayList("/public/**", "/login", "/register", "/find", "/swagger-ui.html",
                "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui",
                "/configuration/security");
        permissionList.forEach(item -> urls.add(item.getPath()));
        String[] antMatchers = new String[urls.size()];
        for (int i = 0; i < antMatchers.length; i++) {
            antMatchers[i] = urls.get(i);
        }
        http.authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers(antMatchers)
                .permitAll()         // 设置所有人都可以访问
//                .anyRequest()               // 任何请求,登录后可以访问
//                .permitAll()
                .and()
                // 设置登陆页
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/user/login")
                // 设置登陆成功页
                .defaultSuccessUrl("/").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();          // 关闭csrf防护
    }

}
