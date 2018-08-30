package uk.org.getwellgamers;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import uk.org.getwellgamers.person.Person;
import uk.org.getwellgamers.staff.Staff;
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
			String forename = (String) map.get("given_name");
			String surname = (String) map.get("family_name");

			//Debug - printout every entry in the oAuth response
			for (Entry<String, Object> entry : map.entrySet())
			{
				System.out.println(entry.getKey() + "/" + entry.getValue());
			}
	
			Person user = null;
			user = staffService.getStaff(staffService, principalId, forename, surname);

			return user;
		};
	}


	@Component
	public class GooggleAuthoritiesExtractor implements AuthoritiesExtractor {
		@Autowired
		public StaffService staffService;
		@Override
		public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {
			String principalId = (String) map.get("id");
			String forename = (String) map.get("given_name");
			String surname = (String) map.get("family_name");

			Staff user = staffService.getStaff(staffService, principalId, forename, surname); 
			if (user == null) {
				return Collections.<GrantedAuthority> emptyList();
			}
			System.out.println(user.getRoles());
			return AuthorityUtils.createAuthorityList(user.getRoles().stream().toArray(size -> new String[size]));
		}
	}

}