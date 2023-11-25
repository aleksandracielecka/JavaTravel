package com.example.javatravel.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.javatravel.entity.UserEntity;
import com.example.javatravel.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepo;

//    @Override
//    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
//        UserEntity user = userRepo.findByEmail(userEmail);
//        if(user==null){
//            new UsernameNotFoundException("User not exists by Username");
//        }
//        Set<GrantedAuthority> authorities = user.getRoles().stream()
//                .map((role) -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());
//        return new User(userEmail,user.getPassword(),authorities);
//    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        UserEntity user = findByEmail(userEmail);

        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        return new User(userEmail, user.getPassword(), authorities);
    }
    private UserEntity findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("Couldn't find user by email"));
    }
}
