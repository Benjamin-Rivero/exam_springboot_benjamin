package fr.benjamin.exam_springboot_benjamin.service;

import fr.benjamin.exam_springboot_benjamin.configuration.PasswordEncoderConfig;
import fr.benjamin.exam_springboot_benjamin.dto.UserPostDTO;
import fr.benjamin.exam_springboot_benjamin.dto.UserPutDTO;
import fr.benjamin.exam_springboot_benjamin.entity.Brand;
import fr.benjamin.exam_springboot_benjamin.entity.User;
import fr.benjamin.exam_springboot_benjamin.exception.NotFoundEntityException;
import fr.benjamin.exam_springboot_benjamin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoderConfig encoder;

    public User findById(Long id){
        return this.userRepository.findById(id)
                .orElseThrow(()->new NotFoundEntityException("User","id",id));
    }

    public User create(UserPostDTO userPostDTO){
        User user = new User();
        user.setEmail(userPostDTO.getEmail());
        user.setPassword(encoder.passwordEncoder().encode(userPostDTO.getPassword()));
        return this.userRepository.saveAndFlush(user);
    }

    public User update(UserPutDTO userPutDTO, Long id) {
        User user = findById(id);
        user.setPassword(encoder.passwordEncoder().encode(userPutDTO.getPassword()));
        return this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = this.userRepository.findByEmail(username);
        optionalUser.orElseThrow(() -> new NotFoundEntityException("User","username",username));
        User user = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                userGrantedAuthority(user.getRoles())
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(role);
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }
}