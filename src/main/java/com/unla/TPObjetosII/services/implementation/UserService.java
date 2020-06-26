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
import com.unla.TPObjetosII.entities.Usuario;
import com.unla.TPObjetosII.repositories.IEmpleadoRepository;
import com.unla.TPObjetosII.repositories.IUsuarioRepository;

@Service("userService")
public class UserService implements UserDetailsService{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserService");
		Usuario u = usuarioRepository.findByUsername(username);
		if(u==null) throw new UsernameNotFoundException("Usuario o Password incorrectos/s");
		System.out.print("Encontrado usuario!!!");
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		if(u.getEmpleado().isTipoEmpleado()) {
			roles.add(new SimpleGrantedAuthority("ROLE_GERENTE"));
		}else {roles.add(new SimpleGrantedAuthority("ROLE_EMPLEADO"));}
		UserDetails ud = new User(u.getEmpleado().getNombre(),u.getPassword(),roles);
		return ud;
	}

}
