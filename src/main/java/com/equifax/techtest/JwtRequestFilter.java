package com.equifax.techtest;

import com.equifax.techtest.model.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtRequestFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public JwtRequestFilter(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // Extraer el token JWT del encabezado de Autorización
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            try {
                // Verificar y validar el token JWT
                username = jwtUtil.extractUsername(jwt);
            } catch (ExpiredJwtException e) {
                // Manejar caso de token expirado
                // Aquí puedes realizar alguna acción, como enviar una respuesta de error o actualizar el estado del usuario en la base de datos
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Autenticar al usuario basado en el token JWT
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, null);
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authenticationToken));
        }

        chain.doFilter(request, response);
    }
}

