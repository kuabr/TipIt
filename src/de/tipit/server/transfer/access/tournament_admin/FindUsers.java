package de.tipit.server.transfer.access.tournament_admin;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserNameTO;
import de.tipit.server.transfer.data.UserSearchDataTO;

public class FindUsers implements TournamentAdminTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "userNameList")
        private final List<UserNameTO> userNameList;

        @Override
        public Object getValue() {
            return userNameList;
        }

        public Result(@ElementList(name = "userNameList") List<UserNameTO> userNameList) {
            this.userNameList = userNameList;
        }

        public List<UserNameTO> getUserNameList() {
            return userNameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private UserSearchDataTO userSearchData;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.findUsers(context, sessionId, userSearchData)));
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

    public UserSearchDataTO getUserSearchData() {
        return userSearchData;
    }

    public void setUserSearchData(UserSearchDataTO userSearchData) {
        this.userSearchData = userSearchData;
    }
}
