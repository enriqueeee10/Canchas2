package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lp3.sistema.IndividualCanchas.Request.CanchasRequest;
import com.lp3.sistema.IndividualCanchas.model.CanchasFutbol;
import com.lp3.sistema.IndividualCanchas.repository.CanchasRepository;

@RestController
@RequestMapping("/cancha")
public class canchasController {

    @Autowired
    private CanchasRepository canchaRepo;

    @PostMapping("/nuevacancha")
    public void nuevaCancha(@RequestBody CanchasRequest cancha) {
        CanchasFutbol nuevaCancha = new CanchasFutbol();
        nuevaCancha.setIdcanchafutbol(cancha.getIdcanchafutbol());
        nuevaCancha.setCodigo(cancha.getCodigo());
        nuevaCancha.setNombre(cancha.getNombre());
        nuevaCancha.setDireccion(cancha.getDireccion());
        nuevaCancha.setPrecio(cancha.getPrecio());
        canchaRepo.save(nuevaCancha);
    }

    @GetMapping("/vercanchas")
    public List<CanchasFutbol> getCanchas() {
        return canchaRepo.findAll();
    }

    @GetMapping("/vercancha/{idcanchafutbol}")
    public CanchasFutbol getCanchaid(@PathVariable int idcanchafutbol) {
        return canchaRepo.findById(idcanchafutbol)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada"));
    }

    @PutMapping("/actualizarcancha/{idcanchafutbol}")
    public void actualizarCancha(@PathVariable int idcanchafutbol, @RequestBody CanchasRequest cancha) {
        Optional<CanchasFutbol> optionalCancha = canchaRepo.findById(idcanchafutbol);
        if (optionalCancha.isPresent()) {
            CanchasFutbol canchaExistente = optionalCancha.get();
            canchaExistente.setCodigo(cancha.getCodigo());
            canchaExistente.setNombre(cancha.getNombre());
            canchaExistente.setDireccion(cancha.getDireccion());
            canchaExistente.setPrecio(cancha.getPrecio());
            canchaRepo.save(canchaExistente);
        } else {
            // Manejar el caso en que la cancha no exista
            throw new RuntimeException("Cancha no encontrada");
        }
    }

    @DeleteMapping("/eliminarcancha/{idcanchafutbol}")
    public void eliminarCancha(@PathVariable Integer idcanchafutbol) {
        Optional<CanchasFutbol> canchaOptional = canchaRepo.findById(idcanchafutbol);
        if (canchaOptional.isPresent()) {
            canchaRepo.deleteById(idcanchafutbol);
        } else {
            // Manejar el caso en que la cancha no exista
            throw new RuntimeException("Cancha no encontrada");
        }
    }
}
