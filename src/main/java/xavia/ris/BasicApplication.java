package xavia.ris;

import xavia.ris.modelo.Usuario;
import xavia.ris.servicio.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BasicApplication implements CommandLineRunner{

//    @Autowired
//    private IUsuarioService usuarioService;
    
    
    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//       usuarioService.salvar(new Usuario("lolo", passwordEncoder().encode("lolo"), "ADMIN", true));
//       usuarioService.salvar(new Usuario("lala", passwordEncoder().encode("lala"), "TECNICO", true));
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
