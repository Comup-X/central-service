package com.comup.auth._base;

import com.comup.auth.entity.SysUser;
import com.comup.auth.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String lowCaseUsername = username.toLowerCase();
        Optional<SysUser> realUser = sysUserRepository.findOneWithRolesByUsername(lowCaseUsername);

        return realUser.map(user -> {
            Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("用户" + lowCaseUsername + "不存在!"));
    }
}