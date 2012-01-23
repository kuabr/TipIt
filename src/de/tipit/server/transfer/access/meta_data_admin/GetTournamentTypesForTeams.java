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
import de.tipit.server.transfer.data.TeamIdTO;
import de.tipit.server.transfer.data.TournamentTypeNameTO;

public class GetTournamentTypesForTeams implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "tournTypeNameList")
        private final List<TournamentTypeNameTO> tournTypeNameList;

        @Override
        public Object getValue() {
            return tournTypeNameList;
        }

        public Result(@ElementList(name = "tournTypeNameList") List<TournamentTypeNameTO> tournTypeNameList) {
            this.tournTypeNameList = tournTypeNameList;
        }

        public List<TournamentTypeNameTO> getTournTypeNameList() {
            return tournTypeNameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @ElementList(required = true)
    private List<TeamIdTO> teamIdList;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.getTournamentTypesForTeams(context, sessionId, teamIdList)));
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

    public List<TeamIdTO> getTeamIdList() {
        return teamIdList;
    }

    public void setTeamIdList(List<TeamIdTO> teamIdList) {
        this.teamIdList = teamIdList;
    }
}
