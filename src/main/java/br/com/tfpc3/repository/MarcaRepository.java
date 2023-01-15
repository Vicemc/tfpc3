package br.com.tfpc3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tfpc3.domains.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer> {
    
}
