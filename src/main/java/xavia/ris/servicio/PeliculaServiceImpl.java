/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavia.ris.servicio;

import xavia.ris.modelo.Pelicula;
import xavia.ris.repositorio.IPeliculaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maira
 */
@Service
public class PeliculaServiceImpl implements IPeliculaService {

    @Autowired
    private IPeliculaRepo repo;

    @Override
    public Pelicula salvar(Pelicula pelicula) {
        return repo.save(pelicula);
    }

    @Override
    public List<Pelicula> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Pelicula buscarPorId(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Pelicula> findByDuracionLessThan(int duracion) {
        return repo.findByDuracionLessThan(duracion);
    }

}
