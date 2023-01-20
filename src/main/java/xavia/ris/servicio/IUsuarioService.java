package xavia.ris.servicio;

import xavia.ris.modelo.Usuario;
import java.util.List;

public interface IUsuarioService {
    
    public Usuario salvar(Usuario usuario);
    public Usuario findById(Long id);
    public Usuario findByName(String nombre);
    public List<Usuario> findAll();
    public void eliminar(Long id);
    
}
