package hu.a_k.akademia.webfejlesztes.springboot;

import hu.a_k.akademia.webfejlesztes.springboot.domain.message.AbstractMessage;
import hu.a_k.akademia.webfejlesztes.springboot.domain.message.ErrorMessage;
import hu.a_k.akademia.webfejlesztes.springboot.domain.message.SuccessMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("hu.a_k.akademia.webfejlesztes.springboot.service")
public class ApplicationConfiguration {

    @Bean("successMessage")
    public AbstractMessage successMessage() {
        return new SuccessMessage("It was success");
    }

    @Bean("errorMessage")
    public AbstractMessage errorMessage() {
        return new ErrorMessage("Huston, we have a problem!");
    }

}
