package com.mg.compose.config;

import com.mg.common.action.MgApiException;
import com.mg.common.pojo.ResultItem;
import com.mg.common.util.ResultItemUtil;
import com.mg.compose.pojo.bo.UserBo;
import com.mg.compose.pojo.dto.InUserDto;
import com.mg.compose.pojo.dto.OutUserDto;
import com.mg.compose.service.feign.UserFeign;
import com.mg.compose.service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
//@EnableWebSecurity
@Component
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            log.info("登录用户校验："+username);
            UserBo bo =  repository.getByName(username);
            if(bo==null)return null;
            UserDetails userDetails = new User(bo.getUserName(),
                    passwordEncoder.encode(bo.getUserPassword()),
                    true,true,true,true,
                    AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN1,ADMIN2"));

            return userDetails;
        } catch (MgApiException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
