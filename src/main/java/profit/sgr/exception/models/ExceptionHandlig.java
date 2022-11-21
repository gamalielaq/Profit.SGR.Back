package profit.sgr.exception.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import io.swagger.v3.oas.annotations.Hidden;
import profit.sgr.response.HttpResponse;


@RestControllerAdvice
public class ExceptionHandlig implements ErrorController {

	Logger log = LoggerFactory.getLogger(this.getClass());
    
	private static final String INTERNAL_SERVER_ERROR_MSG = "Ha ocurrido un error mientras se proceco su soliciud";
    private static final String ERROR_PATH = "/error";

	@Hidden
    @RequestMapping(ERROR_PATH)
	public ResponseEntity<HttpResponse> notFound404() {
		return this.createHttpResponse(HttpStatus.NOT_FOUND, "La URL que busca no se encuetra en nuestra base");
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<HttpResponse> internalServerErrorException(Exception exception,  WebRequest request) {
		log.error("Error en: " + request.getDescription(false), exception);
		HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		HttpResponse httpResponse = new HttpResponse( httpStatus.value(), httpStatus, getReason(exception) , INTERNAL_SERVER_ERROR_MSG );
		return new ResponseEntity<>(httpResponse, httpStatus);
	}

	private String getReason(Exception exception) {
		String  message = exception.getMessage();
		return (message == null)? exception.toString() : message;
	}

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message ) {
		return new ResponseEntity<>(
			new HttpResponse(
				httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message.toUpperCase()
            ),
			httpStatus
        );
	}
}
