package com.example.biblio.Repository;

import com.example.biblio.Model.Emprunts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpruntRepository extends JpaRepository<Emprunts, Integer > {


}
