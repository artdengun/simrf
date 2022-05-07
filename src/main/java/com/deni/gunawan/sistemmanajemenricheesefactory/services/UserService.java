package com.deni.gunawan.sistemmanajemenricheesefactory.services;


import com.deni.gunawan.sistemmanajemenricheesefactory.entity.UserPrincipal;
import com.deni.gunawan.sistemmanajemenricheesefactory.entity.Users;
import com.deni.gunawan.sistemmanajemenricheesefactory.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


        @Autowired
        private UsersRepo userRepository;

        @Override
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                Users user = userRepository.findByNama(s);
                if(user != null)
                        return new UserPrincipal(user);
        else return new UserPrincipal(new Users());
    }
}
