package com.equifax.techtest.service;

import com.equifax.techtest.model.Usuario;
import com.equifax.techtest.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JwtUserDetailsServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void loadUserByUsername() {
        MockitoAnnotations.openMocks(this); // Inicializar los mocks anotados

        JwtUserDetailsService jwtUserDetailsService = new JwtUserDetailsService(usuarioRepository);

        // Crear un usuario ficticio
        Usuario user = new Usuario();
        user.setUsername("usuario");
        user.setEncryptedPassword(passwordEncoder.encode("contraseña"));

        // Configurar el comportamiento simulado de UsuarioRepository
        when(usuarioRepository.getById("usuario")).thenReturn(user);


        // Crear el repositorio y llamar al método bajo prueba
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername("usuario");

        // Verificar el resultado
        assertEquals(user.getUsername(), userDetails.getUsername());
        assertEquals(user.getEncryptedPassword(), userDetails.getPassword());
    }
}
