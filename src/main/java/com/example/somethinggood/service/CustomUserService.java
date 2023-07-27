package com.example.somethinggood.service;

import com.example.somethinggood.config.GoogleUserInfo;
import com.example.somethinggood.domain.User;
import com.example.somethinggood.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService extends OidcUserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
            return processOidcUser(userRequest, oidcUser);

    }


    private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {

        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());
        Optional<User> userOptional = userRepo.findById(googleUserInfo.getId());
        if (userOptional.isEmpty()) {
            userRepo.save(convertedUser(oidcUser));
        }
        return oidcUser;
    }

    public User convertedUser(OidcUser oidcUser) {
        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());
        User user = new User();
        user.setId(googleUserInfo.getId());
        user.setEmail(googleUserInfo.getEmail());
        user.setUsername(googleUserInfo.getName());
        user.setPic(googleUserInfo.getPicture());

        return user;

    }
}
