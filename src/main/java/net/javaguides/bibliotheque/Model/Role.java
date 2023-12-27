package net.javaguides.bibliotheque.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
