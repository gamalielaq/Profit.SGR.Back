package profit.sgr.anotattions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import profit.sgr.response.HttpResponse;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses( value = {
        @ApiResponse(responseCode = "400", description = "Solicitud Invalida", content = @Content(schema = @Schema(implementation = HttpResponse.class))),
        @ApiResponse(responseCode = "401", description = "No Authorizado Token Invalido", content = @Content(schema = @Schema(implementation = HttpResponse.class))),
        @ApiResponse(responseCode = "404", description = "Recurso No encontrado",content = @Content(schema = @Schema(implementation = HttpResponse.class))),
        @ApiResponse(responseCode = "403", description = "Recurso Prohibido, No Tiene Permisos", content = @Content(schema = @Schema(implementation = HttpResponse.class))),
        @ApiResponse(responseCode = "500", description = "Error en El Servidor", content = @Content (schema = @Schema(implementation = HttpResponse.class)))
    })
public @interface ApiResponsesException {
    
}
