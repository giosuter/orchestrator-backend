package ch.devprojects.orchestrator.dto;

public class PingResponse {
    private String deployedAt;
    private String calledAt;
    private String message;

    public PingResponse(String deployedAt, String calledAt, String message) {
        this.deployedAt = deployedAt;
        this.calledAt = calledAt;
        this.message = message;
    }

    // Getters (required for JSON serialization)
    public String getDeployedAt() { return deployedAt; }
    public String getCalledAt() { return calledAt; }
    public String getMessage() { return message; }
}