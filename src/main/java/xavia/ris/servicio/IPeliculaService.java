/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xavia.ris.servicio;

import xavia.ris.modelo.Pelicula;
import java.util.List;

/**
 *
 * @author maira
 */
public interface IPeliculaService {
    public Pelicula salvar(Pelicula pelicula);
    public List<Pelicula> listar();
    public void eliminarPorId(Long id);
    public Pelicula buscarPorId(Long id);
    
    public List<Pelicula> findByDuracionLessThan(int duracion);
}
