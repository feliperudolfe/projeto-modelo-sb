package br.com.feliperudolfe.service.implementacao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.feliperudolfe.service.SecurityService;

public class SecurityServiceImpl implements SecurityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public String findLoggedInUsername() {
		String retorno = null;
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			retorno = ((UserDetails) userDetails).getUsername();
		}// if
		return retorno;
	}// findLoggedInUsername()

	@Override
	public void autologin(String username, String password) {

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			LOGGER.debug(String.format("Auto login %s successfully!", username));
		}// if

	}// autologin()

}