/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su90.springbootouath2;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author superman90
 */

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SocialApplication extends WebSecurityConfigurerAdapter {
	
	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/login**", "/webjars/**").permitAll().anyRequest()
				.authenticated();
	}

	public static void main(String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}

}