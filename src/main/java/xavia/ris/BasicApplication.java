package xavia.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import xavia.ris.modelo.Usuario;
import xavia.ris.servicio.IUsuarioService;

@SpringBootApplication
public class BasicApplication implements CommandLineRunner {

    /*@Autowired
    private IUsuarioService usuarioService;*/

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*usuarioService.registrarUsuario(new Usuario("lolo", passwordEncoder().encode("lolo"), "Administrador", "asd@asd.com"));
        usuarioService.registrarUsuario(new Usuario("lala", passwordEncoder().encode("lala"), "Especialista", "addsd@asd.com"));*/
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
