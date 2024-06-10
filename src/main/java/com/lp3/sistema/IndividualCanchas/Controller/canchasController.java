package com.lp3.sistema.IndividualCanchas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lp3.sistema.IndividualCanchas.model.CanchasFutbol;
import com.lp3.sistema.IndividualCanchas.Services.CanchasServices;

@RestController
@RequestMapping("/cancha")
public class canchasController {

    @Autowired
    private CanchasServices canchasServices;

    @PostMapping("/nuevacancha")
    public void nuevaCancha(@RequestBody CanchasFutbol cancha) {
        canchasServices.registrarCancha(cancha);
    }

    @GetMapping("/vercanchas")
    public List<CanchasFutbol> getCanchas() {
        return canchasServices.getCanchasFutbol();
    }

    @GetMapping("/vercancha/{idCanchaFutbol}")
    public CanchasFutbol getCanchaById(@PathVariable int idCanchaFutbol) {
        return canchasServices.getCanchaById(idCanchaFutbol);
    }

    @PutMapping("/actualizarcancha/{idCanchaFutbol}")
    public void actualizarCancha(@PathVariable int idCanchaFutbol, @RequestBody CanchasFutbol cancha) {
        canchasServices.actualizarCancha(idCanchaFutbol, cancha);
    }

    @DeleteMapping("/eliminarcancha/{idCanchaFutbol}")
    public void eliminarCancha(@PathVariable int idCanchaFutbol) {
        canchasServices.eliminarCancha(idCanchaFutbol);
    }
}
