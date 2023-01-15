package br.com.tfpc3.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tfpc3.domains.Carro;
import br.com.tfpc3.repository.CarroRepository;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    
    public Carro save(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> findAll() {
        return (List<Carro>) carroRepository.findAll();
    }
    
    public Optional<Carro> findById(Integer id) {
        return carroRepository.findById(id);
    }

    public Carro update(Carro carro) {
        return carroRepository.save(carro);
    }

    public void deleteById(Integer id) {
        carroRepository.deleteById(id);
    }
}