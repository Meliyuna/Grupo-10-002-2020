package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("empleadoRepository")
	private IEmpleadoRepository empleadoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserService");
		Empleado e = empleadoRepository.findByNombre(username);
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		if(e.isTipoEmpleado()) {
			roles.add(new SimpleGrantedAuthority("ROLE_GERENTE"));
		}else {roles.add(new SimpleGrantedAuthority("ROLE_EMPLEADO"));}
		UserDetails ud = new User(e.getNombre(),e.getPassword(),roles);
		return ud;
	}

}
