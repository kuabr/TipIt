package de.tipit.server.transfer.access.user_session;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.UserSession;
import de.tipit.server.transfer.access.UserSessionTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionTO;

public class DoLoginAsGuest implements UserSessionTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "session")
        private final SessionTO session;

        @Override
        public Object getValue() {
            return session;
        }

        public Result(@Element(name = "session") SessionTO session) {
            this.session = session;
        }

        public SessionTO getSession() {
            return session;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Override
    public InvocationResult execute(UserSession delegate) {
        try {
            return new InvocationResult(new Result(delegate.doLoginAsGuest(context)));
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
}
