/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author brend
 */




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Autowired
   UserDetailsService userDetailsService;

   
   @Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {			 
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}	
//     @Bean("authenticationManager")
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//            return super.authenticationManagerBean();
//    }
   
//       @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) 
//      throws Exception {
//        auth.inMemoryAuthentication().withUser("bren")
//          .password(passwordEncoder().encode("pass")).roles("USER").and()
//                .withUser("admin")
//          .password(passwordEncoder().encode("pass1")).roles("ADMIN", "USER");
//    }

//    @Autowired
//    private DataSource dataSource;
 
//@Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth)
//  throws Exception {
//    auth.jdbcAuthentication()
//      .dataSource(dataSource)
//            .usersByUsernameQuery("select username,password,enabled "
//                + "from Users "
//                + "where username = ?")
//            .authoritiesByUsernameQuery("select username,authority "
//                + "from authorities "
//                + "where email = ?");;
//     
//    }
// @Override
//    protected void configure(HttpSecurity http) throws Exception {
//       
//    http .csrf().disable()
//      .authorizeRequests()
//      .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .defaultSuccessUrl("/agent/homepage",true);
//    
//  
//}
       @Override
  protected void configure(HttpSecurity http) throws Exception {
    
  	http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().antMatchers("**/*processReg**").permitAll()
                        .antMatchers("*/agent*/**").hasAnyRole("ADMIN","USER")
                        .antMatchers( "/*admin*/**").access("hasRole('ADMIN')").and()
  			.formLogin()//.loginPage("/login.jsp")
                        .loginProcessingUrl("/processlogin")
                        //.failureUrl("/login.jsp?error=true")
                        .and()
                        .rememberMe().key("uniqueAndSecret")
                        .and()
                        .logout()
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/index.jsp");
       
  } 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    
    
    
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//          .csrf().disable()
//          .authorizeRequests()
//          .antMatchers("/agent/**").hasRole("ADMIN")
//          .antMatchers("/anonymous*").anonymous()
//          .antMatchers("/login*").permitAll()
//          .anyRequest().authenticated()
//          .and()
//          .formLogin()
//          .loginPage("/login.jsp")
//          .loginProcessingUrl("/perform_login")
//          .defaultSuccessUrl("/homepage.html", true)
//          //.failureUrl("/login.html?error=true")
//          //.failureHandler(authenticationFailureHandler())
//          .and()
//          .logout()
//          .logoutUrl("/perform_logout")
//          .deleteCookies("JSESSIONID");
//         // .logoutSuccessHandler(logoutSuccessHandler());
//    }
//     
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    
//    
    
//@Autowired
//  public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//  	 auth.inMemoryAuthentication().withUser("alanr").password("pass")
//                                                  .roles("USER", "ADMIN").and()
//                                            .withUser("brendanw").password("pass")
//                                                  .roles("USER");
//  }

//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//      System.out.println("HERE in Configure");
//  	http.authorizeRequests().antMatchers("/login").permitAll()
//  			.antMatchers("/", "/*agent*/**").access("hasRole('USER')").and()
//  			.formLogin()
//                        .loginPage("/login")
//                        .permitAll().and().logout().permitAll();
//       
//  } 
//  
//  @Override
//protected void configure(HttpSecurity http) throws Exception {
//    http.formLogin()
//      .loginPage("/login.jsp")
//      .loginProcessingUrl("/perform_login")
//      .defaultSuccessUrl("/homepage.html",true)
//      .failureUrl("/login.html?error=true");
//}
}

