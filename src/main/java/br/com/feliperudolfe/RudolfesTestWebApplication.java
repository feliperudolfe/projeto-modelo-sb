package br.com.feliperudolfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"br.com.feliperudolfe"})
public class RudolfesTestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RudolfesTestWebApplication.class, args);
	}

	@GetMapping("/login")
    public String login(){
        return "login";
    }

}