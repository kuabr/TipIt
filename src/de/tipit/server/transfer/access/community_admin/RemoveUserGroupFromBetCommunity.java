package de.tipit.server.transfer.access.community_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.CommunityAdmin;
import de.tipit.server.transfer.access.CommunityAdminTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.BetCommunityIdTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.UserGroupIdTO;

public class RemoveUserGroupFromBetCommunity implements CommunityAdminTask {

    public static class Result implements ResultData {

        @Element(required = false)
        Void none;

        @Override
        public Object getValue() {
            return none;
        }

        public Result(Void none) {
            this.none = none;
        }

        public Result() {
            this.none = null;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private BetCommunityIdTO betCommunityId;

    @Element(required = true)
    private UserGroupIdTO userGroupId;

    @Override
    public InvocationResult execute(CommunityAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.removeUserGroupFromBetCommunity(context, sessionId, betCommunityId, userGroupId)));
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

    public BetCommunityIdTO getBetCommunityId() {
        return betCommunityId;
    }

    public void setBetCommunityId(BetCommunityIdTO betCommunityId) {
        this.betCommunityId = betCommunityId;
    }

    public UserGroupIdTO getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(UserGroupIdTO userGroupId) {
        this.userGroupId = userGroupId;
    }
}
