package ro.sda.java30.finalproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.model.ApplicationRole;
import ro.sda.java30.finalproject.model.CustomerDto;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsSecurityService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

//    public UserDetailsSecurityService(CustomerService customerService) {
//        this.customerService = customerService;
//    }



    //implementarea noastra pe care io dam Springului (cand vrea sa faca logarea , o face pe baza datelor bagate de noi
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       CustomerDto customerDto = customerService.findByEmail(email);
        if (customerDto == null) {
            throw new UsernameNotFoundException(email);
        }

        Set<GrantedAuthority> roles = new HashSet<>();
        //TODO define roles for our application
//        roles.add(new SimpleGrantedAuthority(user.getRole().getName()));
        roles.add(new SimpleGrantedAuthority(customerDto.getApplicationRole() !=null ?customerDto.getApplicationRole().name(): ApplicationRole.ROLE_USER.name()));
        return new org.springframework.security.core.userdetails
                .User(customerDto.getEmail(), customerDto.getPassword(), roles);
    }


}