package com.chinanx.springboot.auth;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {
    private List<AuthUser> users;
    
    public List<AuthUser> getUsers() {
        return users;
    }

    public void setUsers(List<AuthUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "AuthProperties [users=" + users + "]";
    }
    
    public static class AuthUser {
        String openId;
        String name;
        String role;
        List<String> permission;
        
        public String getOpenId() {
            return openId;
        }
        public void setOpenId(String openId) {
            this.openId = openId;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
        public List<String> getPermission() {
            return permission;
        }
        public void setPermission(List<String> permission) {
            this.permission = permission;
        }
        
        @Override
        public String toString() {
            return "User [openId=" + openId + ", name=" + name + ", role=" + role + ", permission=" + permission + "]";
        }
    }
}
