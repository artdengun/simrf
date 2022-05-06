
package com.deni.gunawan.sistemmanajemenricheesefactory.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 *
 * @author denigunawan
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    private static final String SQL_LOGIN = "select u.username, up.password, u.aktif "
            + "from s_user u inner join s_user_password up on up.id_user = u.id "
            + "where u.username = ?";
    private static final String SQL_PERMISSION = "select u.username, p.nama " +
            "from s_user u inner join s_user_group ug on u.id = ug.id_user " +
            "inner join s_group g on g.id = ug.id_group " +
            "inner join s_group_permission gp on gp.id_group = g.id " +
            "inner join s_permission p on p.id = gp.id_permission " +
            "where u.username = ?";

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SQL_LOGIN)
                .authoritiesByUsernameQuery(SQL_PERMISSION)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/login","/logout","/"," ").permitAll()
                .antMatchers("/asset/index").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/asset/tambah").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/asset/edit").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/asset/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/asset/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")

                .antMatchers("/raw/index").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/raw/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/raw/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/raw/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/raw/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")

                .antMatchers("/frozen/index").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/frozen/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/frozen/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/frozen/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/frozen/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")

                .antMatchers("/retur/index").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/retur/tambah").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/retur/edit").hasAnyAuthority("MANAJER", "LEADER", "CREW", "SUPERUSER")
                .antMatchers("/retur/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/retur/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")

                .antMatchers("/transferplant/index").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/transferplant/tambah").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/transferplant/edit").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/transferplant/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")
                .antMatchers("/transferplant/export/excel").hasAnyAuthority("MANAJER", "LEADER", "SUPERUSER")

                .antMatchers("/users/index").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/users/tambah").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/users/edit").hasAnyAuthority("MANAJER", "SUPERUSER")
                .antMatchers("/users/export/excel").hasAnyAuthority("MANAJER","SUPERUSER")
                .antMatchers("/users/export/excel").hasAnyAuthority("MANAJER", "SUPERUSER")

                .anyRequest().authenticated()
                .and().headers().frameOptions().sameOrigin()
                .and().logout().permitAll()
                .and().oauth2Login().loginPage("/login").permitAll()
                .userInfoEndpoint()
                .and().defaultSuccessUrl("/index",true);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
