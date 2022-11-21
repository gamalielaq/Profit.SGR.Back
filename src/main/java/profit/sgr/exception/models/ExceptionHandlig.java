package profit.sgr.exception.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.swagger.v3.oas.annotations.Hidden;
import profit.sgr.response.HttpResponse;


@RestControllerAdvice
public class ExceptionHandlig implements ErrorController {

	Logger log = LoggerFactory.getLogger(this.getClass());
    
    private static final String ERROR_PATH = "/error";

	@Hidden
    @RequestMapping(ERROR_PATH)
	public ResponseEntity<HttpResponse> notFound404() {
		log.info("Entraste en este error no encontrado");
		return this.createHttpResponse(HttpStatus.NOT_FOUND, "La URL que busca no se encuetra en nuestra base");
	}

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
		return new ResponseEntity<>(
				new HttpResponse(
						httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase()
                ),
				httpStatus
            );
	}
}
