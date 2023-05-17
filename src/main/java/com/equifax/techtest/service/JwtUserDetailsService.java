package com.equifax.techtest.service;

import com.equifax.techtest.model.Usuario;
import com.equifax.techtest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public JwtUserDetailsService(UsuarioRepository iUsuarioRepository) {
        usuarioRepository = iUsuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.getById(username);
        if (usuario != null && usuario.getUsername().equals(username)) {
            // El password debe estar codificado usando el PasswordEncoder apropiado
            return new User(usuario.getUsername(), usuario.getEncryptedPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
    }
}
