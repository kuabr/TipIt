package de.tipit.server.transfer.access.meta_data_admin;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TeamNameTO;
import de.tipit.server.transfer.data.TeamSearchDataTO;

public class FindTeams implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "teamNameList")
        private final List<TeamNameTO> teamNameList;

        @Override
        public Object getValue() {
            return teamNameList;
        }

        public Result(@ElementList(name = "teamNameList") List<TeamNameTO> teamNameList) {
            this.teamNameList = teamNameList;
        }

        public List<TeamNameTO> getTeamNameList() {
            return teamNameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TeamSearchDataTO teamSearchData;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.findTeams(context, sessionId, teamSearchData)));
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

    public TeamSearchDataTO getTeamSearchData() {
        return teamSearchData;
    }

    public void setTeamSearchData(TeamSearchDataTO teamSearchData) {
        this.teamSearchData = teamSearchData;
    }
}
