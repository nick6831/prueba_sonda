package nvelasquez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication

public class App {    
    /**
    *
    * @param application
    * @return
    */
    
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
       return application.sources(App.class);
   }
   
   /**
    *
    * @param args
    */
   public static void main(String[] args) {
       SpringApplication.run(App.class, args);
   }
}