package com.zyj.hos.config.shiroConfig;

public enum LoginType {
    DOCTOR("Doctor"), USER("User"), ADMIN("Admin");

    private String type;

    private LoginType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}
