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
import de.tipit.server.transfer.data.TournamentTypeIdTO;

public class GetTeamsForTournamentTypes implements MetaDataAdminTask {

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

    @ElementList(required = true)
    private List<TournamentTypeIdTO> tournTypeIdList;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.getTeamsForTournamentTypes(context, sessionId, tournTypeIdList)));
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

    public List<TournamentTypeIdTO> getTournTypeIdList() {
        return tournTypeIdList;
    }

    public void setTournTypeIdList(List<TournamentTypeIdTO> tournTypeIdList) {
        this.tournTypeIdList = tournTypeIdList;
    }
}
