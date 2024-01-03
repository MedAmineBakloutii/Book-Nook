package com.example.biblio.Model;

import jakarta.persistence.Entity;


public enum Role {
    ADMIN("Admin"),
    MEMBRE("Membre"),
    BIBLIOTEQUERE("Bibliotequere");

    private  String roleName;

    Role(String roleName) {
        // Ensure that only the specified role names are allowed
        if (!roleName.equals("Admin") && !roleName.equals("Membre") && !roleName.equals("Bibliotequere")) {
            throw new IllegalArgumentException("Invalid role name: " + roleName);
        }
        this.roleName = roleName;
    }
    public String getRoleName() {
        return roleName;
    }

}
