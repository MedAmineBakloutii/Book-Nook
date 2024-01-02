package net.javaguides.bibliotheque.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;


@Data
@Entity
@Getter
@Setter
@AllArgsConstructor

@RequiredArgsConstructor
@Table(name = "Emprunts")


public class Emprunts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @Column(nullable = false, name= "date_debut")
    private LocalDate date_debut;

    @NotNull
    @Column(nullable = false, name= "date_fin")
    private LocalDate date_fin;

    @ManyToOne
    @JoinColumn(name = "livre_id_livre")
    @JsonIgnore
    private  Livre livre;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    @JsonIgnore
    private  User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
    
    


}
