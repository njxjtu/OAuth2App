package authgroup.oauth2App.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;

@RestController
public class AuthenticationController {
	
	/**
	 * Endpoint to demonstrate successful authentication.
	 * The @AuthenticationPrincipal will be populated with the user details
	 * fetched from the CAS server's User Info endpoint.
	 *
	 * @param principal The authenticated OAuth2 user principal.
	 * @return A welcome message.
	 */
	@GetMapping("/")
	public String home(@AuthenticationPrincipal OAuth2User principal) {
		if (principal != null) {
			// CAS typically uses 'id' or a principal attribute for the username
			String name = principal.getAttribute("id");
			String welcomeMessage = String.format(
				"<h2>Welcome, %s!</h2>" +
				"<p>You are authenticated via local CAS OAuth2 Server.</p>" +
				"<p>Your Principal Attributes: %s</p>" +
				"<p><a href=\"/logout\">Logout</a></p>",
				name, principal.getAttributes()
			);
			return welcomeMessage;
		}
		return "<h1>OAuth2 Client Application</h1><p>Not authenticated. Please access a protected resource to start authentication.</p>";
	}

}
