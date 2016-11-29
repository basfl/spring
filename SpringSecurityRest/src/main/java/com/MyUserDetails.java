package com;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails  implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pass;
	String user;
	boolean accountNotExpired;
	boolean accountNotLocked;
	boolean credentialsNotExpired;
	boolean enable;
	Collection<? extends GrantedAuthority> authorities;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
	//	return auth.getPass();
		System.out.println("what*****"+this.pass);
		return this.pass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
	//	return auth.getUser();
		System.out.println("what*****"+this.user);
		return this.user;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNotExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNotLocked;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setAccountNotExpired(boolean accountNotExpired) {
		this.accountNotExpired = accountNotExpired;
	}

	public void setAccountNotLocked(boolean accountNotLocked) {
		this.accountNotLocked = accountNotLocked;
	}

	public void setCredentialsNotExpired(boolean credentialsNotExpired) {
		this.credentialsNotExpired = credentialsNotExpired;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNotExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;
	}

}