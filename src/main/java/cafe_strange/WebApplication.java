package cafe_strange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class WebApplication {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html");
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            ErrorPage error503Page = new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/503.html");

            container.addErrorPages(error400Page, error401Page, error404Page, error500Page, error503Page);
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);

    }

}
