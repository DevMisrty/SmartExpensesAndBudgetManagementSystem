package com.spring.smartexpensesandbudgetmanagementsystem.security;

import com.spring.smartexpensesandbudgetmanagementsystem.model.Users;
import com.spring.smartexpensesandbudgetmanagementsystem.service.UsersService;
import com.spring.smartexpensesandbudgetmanagementsystem.utility.JwtUtility;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private UsersService usersService;
    private JwtUtility jwtUtility;

    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {
        String token;
        String username;

        String authToken = request.getHeader("Authorization");
        if(authToken== null || !authToken.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        token = authToken.substring(7);
        if(jwtUtility.isValidToken(token)){
            username = jwtUtility.getUsernamefromToken(token);
            Users users = usersService.findByUsername(username).orElseThrow();
            SecurityContextHolder.getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            List.of(new SimpleGrantedAuthority("ROLE_" + users.getRole()))
                    ));
        }
        filterChain.doFilter(request,response);
    }
}
