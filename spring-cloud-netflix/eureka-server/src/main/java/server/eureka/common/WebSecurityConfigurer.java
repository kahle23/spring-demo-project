package server.eureka.common;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * In newer versions of spring cloud,
 *      when eureka enables security authentication,
 *      CSRF is enabled by default,
 *      causing eureka clients to register times incorrectly.
 * Error information: "TransportException: Cannot execute request on any known server".
 * @author Kahle
 */
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }

}
