package de.tipit.server.transfer.access.community_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.CommunityAdmin;
import de.tipit.server.transfer.access.CommunityAdminTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserGroupDataTO;
import de.tipit.server.transfer.data.UserGroupIdTO;

public class CreateOrUpdateUserGroup implements CommunityAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "userGroupId")
        private final UserGroupIdTO userGroupId;

        @Override
        public Object getValue() {
            return userGroupId;
        }

        public Result(@Element(name = "userGroupId") UserGroupIdTO userGroupId) {
            this.userGroupId = userGroupId;
        }

        public UserGroupIdTO getUserGroupId() {
            return userGroupId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private UserGroupDataTO userGroupData;

    @Override
    public InvocationResult execute(CommunityAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateUserGroup(context, sessionId, userGroupData)));
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

    public UserGroupDataTO getUserGroupData() {
        return userGroupData;
    }

    public void setUserGroupData(UserGroupDataTO userGroupData) {
        this.userGroupData = userGroupData;
    }
}
