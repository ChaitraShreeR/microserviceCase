package com.ibm.loginms;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.loginms.util.JwtUtil;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class LoginmsApplication extends WebSecurityConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(LoginmsApplication.class, args);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
 
        //Configuring Spring security access. For /login, /user, and /userinfo, we need authentication.
        //Logout is enabled.
        //Adding csrf token support to this configurer.
        http.authorizeRequests()
                .antMatchers("/login**", "/user","/userInfo").authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
 
    }
	
	@RequestMapping("/user")
    public Principal user(Principal principal) {
        //Principal holds the logged in user information.
        // Spring automatically populates this principal object after login.
        return principal;
    }
 
    @RequestMapping("/userInfo")
    public String userInfo(Principal principal){
        final OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        final Authentication authentication = oAuth2Authentication.getUserAuthentication();
        //Manually getting the details from the authentication, and returning them as String.
        return authentication.getDetails().toString();
    }
	
    
    @RequestMapping("/userToken")
    public String getUserToken(Principal principal) {
    	String tokenValue = null;
    	final Authentication authenticationObject = SecurityContextHolder.getContext().getAuthentication();
        final Object userDetailObject = authenticationObject.getDetails();
        System.out.println("Enter userToken .... == > " + userDetailObject);
        
            final OAuth2AuthenticationDetails userDetails = (OAuth2AuthenticationDetails) userDetailObject;
            tokenValue = userDetails.getTokenValue();
            System.out.println("User tokens == > "+tokenValue);
       
        
    	return tokenValue;
    }
    
    @RequestMapping("/getTxnToken")
    public String getTxnToken(Principal principal) {
    	String txnTokenValue = null;
    	txnTokenValue=	new JwtUtil().generateToken(principal.getName());
    	System.out.println(" txnTokenValue ==> " + txnTokenValue);
    	return txnTokenValue;
        
    	 
    }

}
