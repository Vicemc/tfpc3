package br.com.tfpc3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tfpc3.domains.Marca;
import br.com.tfpc3.repository.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public Marca save(Marca Marca) {
        return marcaRepository.save(Marca);
    }

    public List<Marca> findAll() {
        return (List<Marca>) marcaRepository.findAll();
    }
    
    public Optional<Marca> findById(Integer id) {
        return marcaRepository.findById(id);
    }

    public Marca update(Marca Marca) {
        return marcaRepository.save(Marca);
    }

    public void deleteById(Integer id) {
        marcaRepository.deleteById(id);
    }
}
