package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

//        Flyway flyway = new Flyway();
//        flyway.setDataSource("jdbc:h2:file:./src/main/resources/db/SpringBootTestDB", "sa", "");
//        flyway.migrate();

        SpringApplication.run(Main.class, args);
    }
}
