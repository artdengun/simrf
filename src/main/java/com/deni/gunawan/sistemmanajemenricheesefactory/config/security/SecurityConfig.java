
package com.deni.gunawan.sistemmanajemenricheesefactory.config.security;


import com.deni.gunawan.sistemmanajemenricheesefactory.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author denigunawan
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userService);
        dao.setPasswordEncoder(passwordEncoder());
        return dao;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/logout", "/", "/users/index", "/users/tambah", "/users/edit", "/index", "/role/index", "/role/tambah", "/role/edit").permitAll()
//                .antMatchers("/asset/index").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/asset/tambah").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/asset/edit").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/asset/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/asset/export/pdf").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/raw/index").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/raw/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/raw/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/raw/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/raw/export/pdf").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/frozen/index").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/frozen/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/frozen/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/frozen/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/frozen/export/pdf").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/retur/index").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/retur/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/retur/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
//                .antMatchers("/retur/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/retur/export/pdf").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/transferplant/index").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/transferplant/tambah").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/transferplant/edit").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/transferplant/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/transferplant/export/pdf").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
//                .antMatchers("/users/index").hasAnyAuthority("MANAJER", "SUPERUSER"
//                .antMatchers("/users/tambah").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/edit").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/export/excel").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/export/pdf").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/index").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/tambah").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/edit").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/export/excel").hasAnyAuthority("MANAJER", "SUPERUSER")
//                .antMatchers("/users/export/pdf").hasAnyAuthority("MANAJER", "SUPERUSER")
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index", true).permitAll();
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
