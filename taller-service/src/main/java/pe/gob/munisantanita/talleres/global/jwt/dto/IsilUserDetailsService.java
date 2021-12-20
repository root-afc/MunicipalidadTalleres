package pe.gob.munisantanita.talleres.global.jwt.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IsilUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();
            List<String> roleList = new ArrayList<>();
            for (Role role : users.getRoles()) {
                roleList.add(role.getRoleName());
            }
            return User.builder()
                    .username(users.getUsername())
                    .password("{noop}" + users.getPassword())
                    .roles(roleList.toArray(new String[0]))
                    .build();
        } else {
            throw new UsernameNotFoundException("user not found.");
        }
    }
}
