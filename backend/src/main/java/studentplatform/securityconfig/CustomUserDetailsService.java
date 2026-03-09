package studentplatform.student_platform.securityconfig;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import studentplatform.student_platform.model.Student;
import studentplatform.student_platform.repo.repo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    repo repoin;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        Student s = repoin.findByName(username);

        if (s == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
                s.getName(),
                s.getPass(),
                Collections.emptyList()
        );
    }
}