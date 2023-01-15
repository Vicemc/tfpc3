package br.com.tfpc3.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.tfpc3.domains.Carro;
import br.com.tfpc3.services.CarroService;



@RestController
@RequestMapping("/api/v1/carro")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")

public class CarroResources {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<Carro>> findAll() {
        List<Carro> carros = carroService.findAll();
        if (carros == null || carros.isEmpty()) {
            return new ResponseEntity<List<Carro>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Carro>>(carros,HttpStatus.OK);
    }

    @GetMapping(path =  {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return carroService.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping
    public Carro save(@RequestBody Carro carro) {
        return carroService.save(carro);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity<Carro> update(@PathVariable("id") Integer id,
    @RequestBody Carro carro) {
        return carroService.findById(id)
            .map(record -> {
            record.setAnoFabricacao(carro.getAnoFabricacao());
            record.setAnoModelo(carro.getAnoModelo());
            record.setCor(carro.getCor());
            record.setMarca(carro.getMarca());
            record.setPlaca(carro.getPlaca());
            Carro updated = carroService.save(record);
            return ResponseEntity.ok().body(updated);
            }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
        public ResponseEntity<?> delete(@PathVariable Integer id) {
        return carroService.findById(id)
        .map(record -> {
        carroService.deleteById(id);
        return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
