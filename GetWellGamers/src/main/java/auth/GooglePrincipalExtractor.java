/*package auth;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class GooglePrincipalExtractor implements PrincipalExtractor {
  @Autowired
  private UserDetailsService userDetailsService;
  @Override
  public Object extractPrincipal(Map<String, Object> map) {
    String id = (String) map.get("id");
    // Check if we've already registered this uer
    CurrentUser user = userDetailsService(id); 
    if (user == null) {
      // If we haven't registered this user yet, create a new one
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      // This Details object exposes a token that allows us to interact with Facebook on this user's behalf
      String token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
      user = new CurrentUser();
      // Use the spring-social-facebook classes to request the user data we need
      Facebook fbApi = new FacebookTemplate(token);
      org.springframework.social.facebook.api.User fbUser = fbApi.fetchObject("me", org.springframework.social.facebook.api.User.class, "first_name", "last_name", "email");
      user.setFirstName(fbUser.getFirstName());
      user.setLastName(fbUser.getLastName());
      user.setEmail(fbUser.getEmail());
      // Set the default Roles for users registered via Facebook
      user.setRoles(Sets.newHashSet(Role.ROLE_USER, Role.ROLE_USER_FACEBOOK));
      user = userService.create(user);
    }
    return user;
  }
@Override
public Object extractPrincipal(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	return null;
}
}*/