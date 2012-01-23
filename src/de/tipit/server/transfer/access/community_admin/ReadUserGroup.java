package de.tipit.server.transfer.access.community_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.CommunityAdmin;
import de.tipit.server.transfer.access.CommunityAdminTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserGroupIdTO;
import de.tipit.server.transfer.data.UserGroupTO;

public class ReadUserGroup implements CommunityAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "userGroup")
        private final UserGroupTO userGroup;

        @Override
        public Object getValue() {
            return userGroup;
        }

        public Result(@Element(name = "userGroup") UserGroupTO userGroup) {
            this.userGroup = userGroup;
        }

        public UserGroupTO getUserGroup() {
            return userGroup;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private UserGroupIdTO userGroupId;

    @Override
    public InvocationResult execute(CommunityAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.readUserGroup(context, sessionId, userGroupId)));
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

    public UserGroupIdTO getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(UserGroupIdTO userGroupId) {
        this.userGroupId = userGroupId;
    }
}
