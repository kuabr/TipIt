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
import de.tipit.server.transfer.data.TeamNameTO;
import de.tipit.server.transfer.data.TournamentIdTO;

public class GetTeamsForTournament implements TournamentAdminTask {

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
    private TournamentIdTO tournId;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.getTeamsForTournament(context, sessionId, tournId)));
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

    public TournamentIdTO getTournId() {
        return tournId;
    }

    public void setTournId(TournamentIdTO tournId) {
        this.tournId = tournId;
    }
}
