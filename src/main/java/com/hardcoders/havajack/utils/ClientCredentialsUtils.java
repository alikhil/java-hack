package com.hardcoders.havajack.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;

public class ClientCredentialsUtils {

    private static String[] getClientIdAndPassword(String token) {
        if(StringUtils.isNotEmpty(token)){
            token = token.replace("Basic ", "");
            String decodedAuthorizationHeader = new String(Base64.getDecoder().decode(token), Charset.forName("UTF-8"));
            return decodedAuthorizationHeader.split(":");
        }
        return new String[]{""};
    }

    private static User getClientUser(String token) {
        String[] clientData = getClientIdAndPassword(token);
        return new User(clientData[0], clientData[1], new ArrayList<SimpleGrantedAuthority>() {{
            add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        }});
    }

    public static UsernamePasswordAuthenticationToken getClientPrincipal(String token) {
        User user = getClientUser(token);
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
    }
}
