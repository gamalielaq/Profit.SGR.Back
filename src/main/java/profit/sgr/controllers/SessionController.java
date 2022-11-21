package profit.sgr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import profit.sgr.exception.models.ExceptionHandlig;
import profit.sgr.models.entity.Session;
import profit.sgr.services.interfaces.ISessionService;

@RestController
@RequestMapping(path = { "/", "/api/session" })
@Tag(name = "Session", description = "Endpoints para la gestion de sesiones")
public class SessionController extends ExceptionHandlig {

    @Autowired
    private ISessionService service;

    @PostMapping
    @ApiResponse (
        responseCode = "200",
        description = "OK",
        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Session.class))
    )
    private Session save(@RequestBody Session session) {
        return this.service.save(session);
    }
}
