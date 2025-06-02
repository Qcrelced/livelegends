package livelegends.livelegendsbackend.core.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

//
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/support/**").hasRole("SUPPORT")
                        .anyRequest().permitAll()
                ).httpBasic(withDefaults())
                .formLogin(withDefaults())
                .build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //Utilisateur de la base
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder)
                //Login / mdp
                .usersByUsernameQuery("select name, password, true as enabled from user where name = ?")
                //Role
                .authoritiesByUsernameQuery("select name, concat('ROLE_', user_role) from user where name = ?");
    }
}
