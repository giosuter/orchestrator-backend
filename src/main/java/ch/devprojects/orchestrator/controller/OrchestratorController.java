package ch.devprojects.orchestrator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestratorController {

    // Store the deployment timestamp when the bean is created
    private final String deployedAt;

    public OrchestratorController() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy - HH:mm:ss");
        this.deployedAt = LocalDateTime.now().format(formatter);
    }

    // Endpoint that returns HTML
    @GetMapping(value = "/api/ping", produces = "text/html")
    public String pingHtml() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy - HH:mm:ss");
        String calledAt = LocalDateTime.now().format(formatter);

        return "<!DOCTYPE html>" +
               "<html><head><title>Orchestrator Ping</title></head><body>" +
               "<b>The code has been changed! - Orchestrator API is running!</b><br><hr>" +
               "<ul>" +
               "<li><u>Deployed on</u>: " + deployedAt + "</li>" +
               "<li><u>Endpoint called at</u>: " + calledAt + "</li>" +
               "</ul>" +
               "</body></html>";
    }
}