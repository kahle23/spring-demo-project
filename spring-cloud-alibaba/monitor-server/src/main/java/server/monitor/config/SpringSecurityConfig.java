package server.monitor.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * The spring security configuration.
 * @author Kahle
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private final String contextPath;

    public SpringSecurityConfig(AdminServerProperties adminServerProperties) {

        this.contextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 如果登录成功之后带有 redirectTo 参数，则重定向到 redirectTo 参数对应的 URL 中
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        // 默认重定向到 /wallboard 页面
        successHandler.setDefaultTargetUrl(contextPath + "/wallboard");
        // Spring Security 配置
        http.authorizeRequests()
                // 1. 配置 静态资源、登录页、instances 和 actuator 可以公开访问
                .antMatchers(contextPath + "/assets/**").permitAll()
                .antMatchers(contextPath + "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                // 2. 配置登录和登出路径
                .formLogin().loginPage(contextPath + "/login").successHandler(successHandler).and()
                .logout().logoutUrl(contextPath + "/logout").and()
                // 3. 开启http basic支持，admin-client注册时需要使用
                .httpBasic().and()
                .csrf()
                // 4. 开启基于 cookie 的 csrf 保护
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                // 5. 忽略这些路径的 csrf 保护以便 admin-client 注册
                .ignoringAntMatchers(
                        contextPath + "/instances",
                        contextPath + "/actuator/**"
                )
        ;
    }

}
