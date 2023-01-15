package br.com.tfpc3.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tfpc3.domains.Veiculo;
import br.com.tfpc3.repository.VeiculoRepository;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll() {
        return (List<Veiculo>) veiculoRepository.findAll();
    }
    
    public Optional<Veiculo> findById(Integer id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo update(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void deleteById(Integer id) {
        veiculoRepository.deleteById(id);
    }
}