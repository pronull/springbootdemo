package com.github.config;

import com.github.entity.Role;
import com.github.entity.User;
import com.github.entity.UserRoleRelation;
import com.github.mapper.RoleMapper;
import com.github.mapper.UserMapper;
import com.github.mapper.UserRoleRelationMapper;
import com.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copyright (C), 2016-2017, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description :
 * @Author by weiwb
 * @date on 2017/8/1.
 */
@Component
public class SecurityUserDetailService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findUserByAccount(username);
        if(user == null){
            throw new UsernameNotFoundException("未找到对应的用户");
        }
        return new SecurityUserDetails(user);
    }


    /**
     * 用户名/权限校验
     */
    class SecurityUserDetails implements UserDetails{
        private User user;

        public SecurityUserDetails(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            List<UserRoleRelation> relations = userRoleRelationMapper.findByUserRecordId(this.user.getRecordId());
            relations.forEach(relation->{
                String  roleRecordId = relation.getRoleRecordId();
                Role role =  roleMapper.findByRecordId(roleRecordId);
                grantedAuthorityList.add(new SimpleGrantedAuthority(role.getCode()));
            });
            return grantedAuthorityList;
        }

        @Override
        public String getPassword() {
            return this.user.getUserPassword();
        }

        @Override
        public String getUsername() {
            return this.user.getUserAccount();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
