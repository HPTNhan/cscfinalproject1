package com.csc.fresher.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csc.fresher.dao.UserDao;
import com.csc.fresher.domain.UserRole;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.csc.fresher.domain.SystemAccount user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getUserRoles());
 
		return buildUserForAuthentication(user, authorities);		
	}
	
	private User buildUserForAuthentication(com.csc.fresher.domain.SystemAccount user, 
			List<GrantedAuthority> authorities) {
			return new User(user.getUsername(), user.getPassword(), 
				user.isEnabled(), true, true, true, authorities);
		}
	
	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {
		 
		List<GrantedAuthority> setAuths = new ArrayList<GrantedAuthority>();
 
		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		} 		
 
		return setAuths;
	}
}
