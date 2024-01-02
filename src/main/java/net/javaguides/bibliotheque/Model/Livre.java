package net.javaguides.bibliotheque.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

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
 
	@Column(name = "nb_exemplaires")
    private Long nbExemplaires;

	 @Column(name = "disponibilite")
	 private boolean disponibilite;
	
	
	
	
	

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

	
	
	
	
	public Long getNbExemplaires() {
		return nbExemplaires;
	}

	public void setNbExemplaires(Long nbExemplaires) {
		this.nbExemplaires = nbExemplaires;
	}

	public boolean isDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}





	@OneToMany(mappedBy ="livre",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

	private List<Reservation> reservation;

	@OneToMany(mappedBy ="livre",cascade = CascadeType.ALL,fetch = FetchType.LAZY)

	private List<Emprunts> emprunt;





}
