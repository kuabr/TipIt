package de.tipit.server.transfer.access.meta_data_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TeamDataTO;
import de.tipit.server.transfer.data.TeamIdTO;

public class CreateOrUpdateTeam implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "teamId")
        private final TeamIdTO teamId;

        @Override
        public Object getValue() {
            return teamId;
        }

        public Result(@Element(name = "teamId") TeamIdTO teamId) {
            this.teamId = teamId;
        }

        public TeamIdTO getTeamId() {
            return teamId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TeamDataTO teamData;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateTeam(context, sessionId, teamData)));
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

    public TeamDataTO getTeamData() {
        return teamData;
    }

    public void setTeamData(TeamDataTO teamData) {
        this.teamData = teamData;
    }
}
