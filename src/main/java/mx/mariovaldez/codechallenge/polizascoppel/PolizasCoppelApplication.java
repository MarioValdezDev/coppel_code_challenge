package mx.mariovaldez.codechallenge.polizascoppel;

import mx.mariovaldez.codechallenge.polizascoppel.controller.DemoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@RestController
public class PolizasCoppelApplication {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public static void main(String[] args) {
        SpringApplication.run(PolizasCoppelApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World JEJEJ") String name) {
        String sql = "INSERT INTO EMPLEADO VALUES("+"'1234'"+",'MARIO'"+",'VALDEZ'"+",'VENDEDOR')";
        int rows = jdbcTemplate.update(sql);
        return rows >0 ? "EXITO" : "NOT CONNECTED";
    }

}
