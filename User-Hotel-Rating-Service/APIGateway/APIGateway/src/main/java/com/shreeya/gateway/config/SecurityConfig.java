package com.shreeya.gateway.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {




        httpSecurity
                .authorizeExchange((exchanges) -> exchanges
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults());


        return httpSecurity.build();
    }}
//     httpSecurity.authorizeExchange((exchanges) -> exchanges
//             .anyExchange().authenticated()).oauth2Client((oauth2Client) -> oauth2Client.clientRegistrationRepository()
//            .authorizedClientRepository()
//             .authorizedClientService()
//             .authorizationCodeGrant()).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt).jwt().jwtAuthenticationConverter();

//        @Bean
//        public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//
//            httpSecurity
//                    .authorizeExchange()
//                    .anyExchange()
//                    .authenticated()
//                    .and()
//                    .oauth2Client()s
//                    .and()
//                    .oauth2ResourceServer()
//                    .jwt();


//            return httpSecurity.build();
//
//
//        }
//
//     return httpSecurity.build();

// we need to include all this below but could not-

//httpSecurity.authorizeExchange().anyExchange().authenticated().and().oauth2ResourceServer().jwt();
//
//        return httpSecurity.build();
//        }