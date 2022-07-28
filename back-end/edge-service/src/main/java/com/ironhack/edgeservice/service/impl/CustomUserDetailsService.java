package com.ironhack.edgeservice.service.impl;

import com.ironhack.edgeservice.client.AmateurServiceClient;
import com.ironhack.edgeservice.controller.dto.Amateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AmateurServiceClient amateurServiceClient;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Optional<Amateur> optionalAmateur = amateurServiceClient.getAmateurByName(name);

        if(!optionalAmateur.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        return optionalAmateur.get();
    }

}
