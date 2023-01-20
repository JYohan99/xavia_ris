package xavia.ris.seguridad;

import xavia.ris.modelo.Usuario;
import xavia.ris.repositorio.IUsuarioRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepo repo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repo.findByUserName(userName);
        List<GrantedAuthority> authoritys = new ArrayList<>();
        authoritys.add(new SimpleGrantedAuthority(usuario.get().getRol()));
        return new User(usuario.get().getUserName(), usuario.get().getPassword(), authoritys);
    }

}
