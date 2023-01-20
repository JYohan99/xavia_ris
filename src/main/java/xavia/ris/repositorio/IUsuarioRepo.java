
package xavia.ris.repositorio;

import xavia.ris.modelo.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByUserName(String nombre);
}
