package de.tipit.server.transfer.access.bet_result;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.BetResult;
import de.tipit.server.transfer.access.BetResultTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentIdTO;

public class HasMissingWinnerBetForTournament implements BetResultTask {

    public static class Result implements ResultData {

        @Attribute(required = true, name = "hasMissWBet")
        private final Boolean hasMissWBet;

        @Override
        public Object getValue() {
            return hasMissWBet;
        }

        public Result(@Attribute(name = "hasMissWBet") Boolean hasMissWBet) {
            this.hasMissWBet = hasMissWBet;
        }

        public Boolean getHasMissWBet() {
            return hasMissWBet;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentIdTO tournId;

    @Override
    public InvocationResult execute(BetResult delegate) {
        try {
            return new InvocationResult(new Result(delegate.hasMissingWinnerBetForTournament(context, sessionId, tournId)));
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
