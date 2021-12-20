package pe.gob.munisantanita.talleres.global.jwt.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.munisantanita.talleres.global.jwt.dto.security.JWTUtil;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IsilUserDetailsService isilUserDetailsService;

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    UserRepository userRepository;
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest authenticationRequest) {

        try {
            List<Role> role = null;
            Integer id = null;
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            UserDetails userDetails = isilUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            Optional<Users> optionalUser = userRepository.findByUsername(authenticationRequest.getUsername());
            if (optionalUser.isPresent()) {
                Users users = optionalUser.get();
                id = users.getUserId();
                role = users.getRoles();
            }
            AuthenticationResponse obj = new AuthenticationResponse();
            obj.setJwt(jwt);
            obj.setRole(role);
            obj.setId(id);
            return new ResponseEntity(obj, HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
