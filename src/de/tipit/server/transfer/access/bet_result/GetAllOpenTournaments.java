package de.tipit.server.transfer.access.bet_result;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.BetResult;
import de.tipit.server.transfer.access.BetResultTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentDescrTO;

public class GetAllOpenTournaments implements BetResultTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "tournDescrList")
        private final List<TournamentDescrTO> tournDescrList;

        @Override
        public Object getValue() {
            return tournDescrList;
        }

        public Result(@ElementList(name = "tournDescrList") List<TournamentDescrTO> tournDescrList) {
            this.tournDescrList = tournDescrList;
        }

        public List<TournamentDescrTO> getTournDescrList() {
            return tournDescrList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Override
    public InvocationResult execute(BetResult delegate) {
        try {
            return new InvocationResult(new Result(delegate.getAllOpenTournaments(context, sessionId)));
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
}
