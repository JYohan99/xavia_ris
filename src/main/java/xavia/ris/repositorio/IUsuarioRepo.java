
package xavia.ris.repositorio;

import xavia.ris.modelo.Usuario;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Long> {

    @Query(
        "SELECT u FROM Usuario u WHERE u.userName LIKE %?1%" +
        "OR u.correo LIKE %?1%" +
        "OR u.rol LIKE %?1%"
      )
      public List<Usuario> findAll(String palBuscarUsuario);
      
    public Optional<Usuario> findByUserName(String nombre);
}
