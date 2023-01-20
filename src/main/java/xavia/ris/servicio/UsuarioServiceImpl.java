package xavia.ris.servicio;

import xavia.ris.modelo.Usuario;
import xavia.ris.repositorio.IUsuarioRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepo repo;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Usuario salvar(Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return repo.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Usuario findByName(String nombre) {
        return repo.findByUserName(nombre).orElse(null);
    }

}
