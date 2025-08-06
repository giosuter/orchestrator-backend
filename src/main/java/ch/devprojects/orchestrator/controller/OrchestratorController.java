package ch.devprojects.orchestrator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ch.devprojects.orchestrator.dto.PingResponse;

@RestController
public class OrchestratorController {

    private final String deployedAt;

    public OrchestratorController() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy - HH:mm:ss");
        this.deployedAt = LocalDateTime.now().format(formatter);
    }

    // 1. JSON endpoint for Angular etc.
    @CrossOrigin(origins = "*")  // Use a specific origin in prod!
    @GetMapping(value = "/api/ping", produces = "application/json")
    public PingResponse pingJson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy - HH:mm:ss");
        String calledAt = LocalDateTime.now().format(formatter);
        String message = "The code has been changed! Orchestrator API is running!";
        return new PingResponse(deployedAt, calledAt, message);
    }

    // 2. HTML endpoint for browser/manual
    @CrossOrigin(origins = "*")
    @GetMapping(value = "/api/pingHtml", produces = "text/html")
    public String pingHtml() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy - HH:mm:ss");
        String calledAt = LocalDateTime.now().format(formatter);
        return "<!DOCTYPE html>" +
                "<html><head><title>Orchestrator Ping</title></head><body>" +
                "<b>The code has been changed! Orchestrator API is running!</b><br><hr>" +
                "<ul>" +
                "<li><u>Deployed on</u>: " + deployedAt + "</li>" +
                "<li><u>Endpoint called at</u>: " + calledAt + "</li>" +
                "</ul>" +
                "</body></html>";
    }
}