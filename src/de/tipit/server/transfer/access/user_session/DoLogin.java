package de.tipit.server.transfer.access.user_session;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.UserSession;
import de.tipit.server.transfer.access.UserSessionTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.LoginParameterTO;
import de.tipit.server.transfer.data.SessionTO;
import de.tipit.server.transfer.data.UserAccountTO;

public class DoLogin implements UserSessionTask {

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

    @Element(required = true)
    private UserAccountTO userAccount;

    @Element(required = true)
    private LoginParameterTO loginParameter;

    @Override
    public InvocationResult execute(UserSession delegate) {
        try {
            return new InvocationResult(new Result(delegate.doLogin(context, userAccount, loginParameter)));
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

    public UserAccountTO getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccountTO userAccount) {
        this.userAccount = userAccount;
    }

    public LoginParameterTO getLoginParameter() {
        return loginParameter;
    }

    public void setLoginParameter(LoginParameterTO loginParameter) {
        this.loginParameter = loginParameter;
    }
}
