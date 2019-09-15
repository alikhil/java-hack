//package com.hardcoders.havajack.config;
//
//import com.hardcoders.havajack.utils.TimeUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
//
//    @Value("${application.clientId}")
//    private String clientId;
//    @Value("${application.secret}")
//    private String secret;
//
//    private final AuthenticationManager authenticationManager;
//    private final DataSource dataSource;
//    private final PasswordEncoder encoder;
//
//    @Autowired
//    public AuthorizationConfig(@Qualifier("authenticationManagerBean")
//                        AuthenticationManager authenticationManager,
//                        @Qualifier("dataSource") DataSource dataSource,
//                        PasswordEncoder encoder) {
//        this.authenticationManager = authenticationManager;
//        this.dataSource = dataSource;
//        this.encoder = encoder;
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.checkTokenAccess("isAuthenticated()");
//        super.configure(security);
//    }
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//
//    @Bean
//    public AuthorizationCodeServices authorizationCodeServices() {
//        return new JdbcAuthorizationCodeServices(dataSource);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer configurer) {
//        configurer.authenticationManager(authenticationManager)
//                .authorizationCodeServices(authorizationCodeServices())
//                .tokenStore(tokenStore());
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient(clientId)
//                .secret(encoder.encode(secret))
//                .authorities("ROLE_CLIENT")
//                .accessTokenValiditySeconds(TimeUtils.MONTH_SECONDS)
//                .scopes("read", "write")
//                .authorizedGrantTypes("password", "refresh_token")
//                .resourceIds("resource");
//    }
//}
