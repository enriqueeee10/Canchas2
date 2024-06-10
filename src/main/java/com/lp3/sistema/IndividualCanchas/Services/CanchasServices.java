package com.lp3.sistema.IndividualCanchas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp3.sistema.IndividualCanchas.model.CanchasFutbol;
import com.lp3.sistema.IndividualCanchas.repository.CanchasRepository;

@Service
public class CanchasServices {

    @Autowired
    private CanchasRepository canchaRepo;

    public void registrarCancha(CanchasFutbol cancha) {
        canchaRepo.save(cancha);
    }

    public List<CanchasFutbol> getCanchasFutbol() {
        return canchaRepo.findAll();
    }

    public CanchasFutbol getCanchaById(int idCanchaFutbol) {
        return canchaRepo.findById(idCanchaFutbol)
                .orElseThrow(() -> new RuntimeException("Cancha no encontrada"));
    }

    public void actualizarCancha(int idCanchaFutbol, CanchasFutbol cancha) {
        CanchasFutbol canchaExistente = getCanchaById(idCanchaFutbol);
        canchaExistente.setCodigo(cancha.getCodigo());
        canchaExistente.setNombre(cancha.getNombre());
        canchaExistente.setDireccion(cancha.getDireccion());
        canchaExistente.setPrecio(cancha.getPrecio());
        canchaRepo.save(canchaExistente);
    }

    public void eliminarCancha(int idCanchaFutbol) {
        CanchasFutbol canchaExistente = getCanchaById(idCanchaFutbol);
        canchaRepo.delete(canchaExistente);
    }
}
