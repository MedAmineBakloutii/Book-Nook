package net.javaguides.bibliotheque.Model;


import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_book_nook")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "adress")
    private String adress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email",unique = true)
    @NotNull
    @Email(message = "please enter a valid email")
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(min = 4, max = 16, message = "Password should be between 4 and 16 chars")
    private String password;

    @JoinColumn(name = "role_name")
    private Role role;

	public Long getIdUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
