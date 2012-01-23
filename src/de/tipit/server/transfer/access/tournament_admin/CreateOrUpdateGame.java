package de.tipit.server.transfer.access.tournament_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminTask;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameDataArgumentTO;
import de.tipit.server.transfer.data.GameIdTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class CreateOrUpdateGame implements TournamentAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "gameId")
        private final GameIdTO gameId;

        @Override
        public Object getValue() {
            return gameId;
        }

        public Result(@Element(name = "gameId") GameIdTO gameId) {
            this.gameId = gameId;
        }

        public GameIdTO getGameId() {
            return gameId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private GameDataArgumentTO gameData;

    @Override
    public InvocationResult execute(TournamentAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateGame(context, sessionId, gameData)));
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

    public GameDataArgumentTO getGameData() {
        return gameData;
    }

    public void setGameData(GameDataArgumentTO gameData) {
        this.gameData = gameData;
    }
}
