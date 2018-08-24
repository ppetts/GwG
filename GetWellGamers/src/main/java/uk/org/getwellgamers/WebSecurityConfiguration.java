package uk.org.getwellgamers;

import java.util.Map.Entry;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import uk.org.getwellgamers.person.Person;
import uk.org.getwellgamers.staff.StaffRepository;
import uk.org.getwellgamers.staff.StaffService;

@EnableOAuth2Sso
@Configuration
@Order(1)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf()
		.disable()
		.antMatcher("/**")
		.authorizeRequests()
		.antMatchers("/", "/index.html", "/static/")
		.permitAll()
		.anyRequest()
		.authenticated();
	} 

	@Bean
	public PrincipalExtractor principalExtractor(StaffService staffService) {
		return map -> {
			String principalId = (String) map.get("id");

			for (Entry<String, Object> entry : map.entrySet())
			{
				System.out.println(entry.getKey() + "/" + entry.getValue());
			}

			System.out.println("principalId=" + principalId);
			//  System.out.println("email=" + email);

			Person user = staffService.getStaff("002");
		//	Person user = staffService.getStaffbyPrincipalId(principalId).get(0);

			System.out.println(user.toString());

			if (user == null) {
				
				System.out.println("No user found");
				
				
				//                LOGGER.info("No user found, generating profile for {}", principalId);
				//                user = new User();
				//                user.setPrincipalId(principalId);
				//                user.setCreated(LocalDateTime.now());
				//                user.setEmail((String) map.get("email"));
				//                user.setFullName((String) map.get("name"));
				//                user.setPhoto((String) map.get("picture"));
				//                user.setLoginType(UserLoginType.GOOGLE);
				//                user.setLastLogin(LocalDateTime.now());
			} else {
				user.addRole(Person.ROLE.AUTH_GOOGLE);
				// user.setLastLogin(LocalDateTime.now());
			}

			//            userRepository.save(user);
			return user;
		};
	}

	/*	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser("jduser").password("jdu@123").authorities("ROLE_USER")
			.and()
			.withUser("jdadmin").password("jda@123").authorities("ROLE_USER","ROLE_ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/homePage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
			.antMatchers("/userPage").access("hasRole('ROLE_USER')")
			.antMatchers("/adminPage").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginPage("/loginPage")
				.defaultSuccessUrl("/homePage")
				.failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password")				
			.and()
				.logout().logoutSuccessUrl("/loginPage?logout"); 

	}*/



}