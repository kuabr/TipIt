package de.tipit.server.transfer.access;

public interface UserSessionTask {
    InvocationResult execute(UserSession delegate);
}
