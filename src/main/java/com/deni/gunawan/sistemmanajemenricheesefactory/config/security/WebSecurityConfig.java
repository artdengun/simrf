
package com.deni.gunawan.sistemmanajemenricheesefactory.config.security;


import com.deni.gunawan.sistemmanajemenricheesefactory.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author denigunawan
 */

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login", "/logout", "/register").permitAll()
//                .antMatchers("/").permitAll()
//                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index", true).permitAll()
//                .and().logout().logoutSuccessUrl("/login").permitAll();
//    }
//
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers("/static/**")
//                .antMatchers("/image/**")
//                .antMatchers("/css/**")
//                .antMatchers("/fonts/**")
//                .antMatchers("/frontend/**")
//                .antMatchers("/js/**")
//                .antMatchers("/vendor/**");
//    }
//}


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/logout", "/", "/index").permitAll()
                .antMatchers("/asset/index").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/asset/tambah").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/asset/edit").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/raw/index").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/raw/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/raw/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/frozen/index").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/frozen/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/frozen/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/retur/index").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/retur/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/retur/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW")
                .antMatchers("/transferplant/index").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/transferplant/tambah").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/transferplant/edit").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/users/index").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/users/tambah").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/users/edit").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/userrole/index").hasAnyAuthority("SUPERUSER")
                .antMatchers("/userrole/tambah").hasAnyAuthority("SUPERUSER")
                .antMatchers("/userrole/edit").hasAnyAuthority("SUPERUSER")
                .antMatchers("/role/index").hasAnyAuthority("SUPERUSER")
                .antMatchers("/role/tambah").hasAnyAuthority("SUPERUSER")
                .antMatchers("/role/edit").hasAnyAuthority("SUPERUSER")
                // REPORTING
                .antMatchers("/users/export/excel").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/users/export/pdf").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/transferplant/export/excel").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/transferplant/export/pdf").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/retur/export/excel").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/retur/export/pdf").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/frozen/export/excel").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/frozen/export/pdf").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/raw/export/excel").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/raw/export/pdf").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/asset/export/excel").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/asset/export/pdf").hasAnyAuthority("MANAJER", "LEADER")
                .antMatchers("/userrole/export/excel").hasAnyAuthority("SUPERUSER")
                .antMatchers("/userrole/export/pdf").hasAnyAuthority("SUPERUSER")
                .antMatchers("/role/export/pdf").hasAnyAuthority("SUPERUSER")
                .antMatchers("/role/export/pdf").hasAnyAuthority("SUPERUSER")

                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/index", true).permitAll();
    }

        @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/**")
                .antMatchers("/image/**")
                .antMatchers("/css/**")
                .antMatchers("/fonts/**")
                .antMatchers("/frontend/**")
                .antMatchers("/js/**")
                .antMatchers("/vendor/**");
    }
}