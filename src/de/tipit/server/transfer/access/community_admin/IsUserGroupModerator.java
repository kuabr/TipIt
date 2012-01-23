package de.tipit.server.transfer.access.community_admin;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.CommunityAdmin;
import de.tipit.server.transfer.access.CommunityAdminTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserGroupIdTO;

public class IsUserGroupModerator implements CommunityAdminTask {

    public static class Result implements ResultData {

        @Attribute(required = true, name = "isUsrGrpMod")
        private final Boolean isUsrGrpMod;

        @Override
        public Object getValue() {
            return isUsrGrpMod;
        }

        public Result(@Attribute(name = "isUsrGrpMod") Boolean isUsrGrpMod) {
            this.isUsrGrpMod = isUsrGrpMod;
        }

        public Boolean getIsUsrGrpMod() {
            return isUsrGrpMod;
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
            return new InvocationResult(new Result(delegate.isUserGroupModerator(context, sessionId, userGroupId)));
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
