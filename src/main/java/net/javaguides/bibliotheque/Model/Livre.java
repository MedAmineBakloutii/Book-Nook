package net.javaguides.bibliotheque.Model;

import lombok.Data;
import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Data
@Entity
@Table(name = "livres")

public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livre")
	private Long id;
	
	@Column(name = "titre", nullable = false)
	private String titre;
	
	@Column(name = "auteur")
	private String auteur;

	@Temporal(TemporalType.DATE)
	@Column(name = "datePublication")
	
	private Date datePublication;
	@Column(name = "isbn")
	private String isbn;
 
	@Column (name="copiesDisponibles")
	private Long copiesDisponibles;
	
	
	
	
	

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getCopiesDisponibles() {
		return copiesDisponibles;
	}

	public void setCopiesDisponibles(Long copiesDisponibles) {
		this.copiesDisponibles = copiesDisponibles;
	}

	

	
}
