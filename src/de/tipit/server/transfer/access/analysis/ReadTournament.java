package de.tipit.server.transfer.access.analysis;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.Analysis;
import de.tipit.server.transfer.access.AnalysisTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentIdTO;
import de.tipit.server.transfer.data.TournamentTO;

public class ReadTournament implements AnalysisTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "tournament")
        private final TournamentTO tournament;

        @Override
        public Object getValue() {
            return tournament;
        }

        public Result(@Element(name = "tournament") TournamentTO tournament) {
            this.tournament = tournament;
        }

        public TournamentTO getTournament() {
            return tournament;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentIdTO tournId;

    @Override
    public InvocationResult execute(Analysis delegate) {
        try {
            return new InvocationResult(new Result(delegate.readTournament(context, sessionId, tournId)));
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
