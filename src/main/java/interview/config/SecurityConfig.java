package interview.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/home" , "/login", "/register", "/saveUser", "/css/**").permitAll()

                    .requestMatchers("/admin/**").hasRole("ADMIN")

                    .requestMatchers("/hr/**").hasRole("HR")

                    .requestMatchers("/candidate/**").hasRole("CANDIDATE")

                    .anyRequest().authenticated())

            .formLogin(form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .successHandler(loginSuccessHandler)
                    .permitAll())

            .exceptionHandling(exception -> exception
                    .accessDeniedPage("/access-denied"))

            .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout")
                    .permitAll());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
