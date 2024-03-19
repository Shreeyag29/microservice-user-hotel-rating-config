//package com.shreeya.user.config;
//
//@Configuration
//@EnableWebFluxSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig {
//
//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//
//        httpSecurity
//                .authorizeExchange()
//                .anyExchange()
//                .authenticated()
//                .and()
//                .oauth2Client()
//                .and()
//                .oauth2ResourceServer()
//                .jwt();
//
//
//        return httpSecurity.build();
//
//    }}
