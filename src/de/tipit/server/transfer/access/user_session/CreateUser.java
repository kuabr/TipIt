package de.tipit.server.transfer.access.user_session;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.UserSession;
import de.tipit.server.transfer.access.UserSessionTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.UserDataTO;
import de.tipit.server.transfer.data.UserIdTO;

public class CreateUser implements UserSessionTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "userId")
        private final UserIdTO userId;

        @Override
        public Object getValue() {
            return userId;
        }

        public Result(@Element(name = "userId") UserIdTO userId) {
            this.userId = userId;
        }

        public UserIdTO getUserId() {
            return userId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private UserDataTO userData;

    @Override
    public InvocationResult execute(UserSession delegate) {
        try {
            return new InvocationResult(new Result(delegate.createUser(context, userData)));
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

    public UserDataTO getUserData() {
        return userData;
    }

    public void setUserData(UserDataTO userData) {
        this.userData = userData;
    }
}
