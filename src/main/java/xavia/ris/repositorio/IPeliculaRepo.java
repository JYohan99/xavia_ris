/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavia.ris.repositorio;

import xavia.ris.modelo.Pelicula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mapa
 */
@Repository
public interface IPeliculaRepo extends JpaRepository<Pelicula, Long>{
    public List<Pelicula> findByDuracionLessThan(int duracion);
}
