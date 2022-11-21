package profit.sgr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import profit.sgr.anotattions.ApiResponsesException;
import profit.sgr.exception.models.ExceptionHandlig;
import profit.sgr.models.entity.Divisa;
import profit.sgr.services.interfaces.IDivisaService;


@RestController()
@RequestMapping(path = { "/", "/api" })
@Tag(name = "Divisas", description = "Endpoints para la gestion de Divisas")
public class DivisaController extends ExceptionHandlig {
    
    @Autowired 
    private IDivisaService divisaService;

    @GetMapping("/divisa/listar")
    @Operation(summary = "Listar Todas la divisas", description = "", tags = { "contacto" })
    @ApiResponse (
        responseCode = "200",
        description = "OK",
        content = @Content (mediaType = "application/json", schema = @Schema(implementation = Divisa.class))
        )
    @ApiResponsesException()
    private List<Divisa> getAllDivisas() {  
        return this.divisaService.findAll();
    }

    @PostMapping("/divisa")
    private String save() {  
        return "Probando un String";
    }
}
