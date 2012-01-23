package de.tipit.server.transfer.access.user_session;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.UserSession;
import de.tipit.server.transfer.access.UserSessionTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserTO;

public class ReadOwnUser implements UserSessionTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "user")
        private final UserTO user;

        @Override
        public Object getValue() {
            return user;
        }

        public Result(@Element(name = "user") UserTO user) {
            this.user = user;
        }

        public UserTO getUser() {
            return user;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Override
    public InvocationResult execute(UserSession delegate) {
        try {
            return new InvocationResult(new Result(delegate.readOwnUser(context, sessionId)));
        } catch (GeneralError exc) {
            return new InvocationResult(exc);
        } catch (RuntimeException exc) {
            return new InvocationResult(exc);
        }
    }

    public ContextTO getContext() {
        return context;
    }

    public void setContext(ContextTO context) {
        this.context = context;
    }

    public SessionIdTO getSessionId() {
        return sessionId;
    }

    public void setSessionId(SessionIdTO sessionId) {
        this.sessionId = sessionId;
    }
}
