package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.BetResult;
import de.tipit.server.transfer.access.BetResultInvocation;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.bet_result.CreateOrUpdateCommentForGameBet;
import de.tipit.server.transfer.access.bet_result.CreateOrUpdateCommentForGameResult;
import de.tipit.server.transfer.access.bet_result.CreateOrUpdateCommentForWinnerBet;
import de.tipit.server.transfer.access.bet_result.CreateOrUpdateCommentForWinnerTeam;
import de.tipit.server.transfer.access.bet_result.DelGameResult;
import de.tipit.server.transfer.access.bet_result.DelWinnerTeam;
import de.tipit.server.transfer.access.bet_result.GetAllOpenTournaments;
import de.tipit.server.transfer.access.bet_result.GetGamesWithForgottenBetForPeriod;
import de.tipit.server.transfer.access.bet_result.GetGamesWithForgottenBetForTournament;
import de.tipit.server.transfer.access.bet_result.GetGamesWithMissingBetForPeriod;
import de.tipit.server.transfer.access.bet_result.GetGamesWithMissingBetForTournament;
import de.tipit.server.transfer.access.bet_result.GetGamesWithMissingResultForPeriod;
import de.tipit.server.transfer.access.bet_result.GetGamesWithMissingResultForTournament;
import de.tipit.server.transfer.access.bet_result.GetGamesWithMissingTeamsForTournament;
import de.tipit.server.transfer.access.bet_result.GetGamesWithPopulatedBetForPeriod;
import de.tipit.server.transfer.access.bet_result.GetGamesWithPopulatedBetForTournament;
import de.tipit.server.transfer.access.bet_result.GetGamesWithPopulatedResultForPeriod;
import de.tipit.server.transfer.access.bet_result.GetGamesWithPopulatedResultForTournament;
import de.tipit.server.transfer.access.bet_result.GetOpenParticipatingTournaments;
import de.tipit.server.transfer.access.bet_result.GetTeamsForTournament;
import de.tipit.server.transfer.access.bet_result.GetWinnerBetsForTournament;
import de.tipit.server.transfer.access.bet_result.HasMissingWinnerBetForTournament;
import de.tipit.server.transfer.access.bet_result.ReadTournament;
import de.tipit.server.transfer.access.bet_result.RemoveCommentForGameBet;
import de.tipit.server.transfer.access.bet_result.RemoveCommentForGameResult;
import de.tipit.server.transfer.access.bet_result.RemoveCommentForWinnerBet;
import de.tipit.server.transfer.access.bet_result.RemoveCommentForWinnerTeam;
import de.tipit.server.transfer.access.bet_result.SetGameBet;
import de.tipit.server.transfer.access.bet_result.SetGameResult;
import de.tipit.server.transfer.access.bet_result.SetWinnerBet;
import de.tipit.server.transfer.access.bet_result.SetWinnerTeam;
import de.tipit.server.transfer.access.bet_result.UpdateGame;
import de.tipit.server.transfer.data.CommentDataTO;
import de.tipit.server.transfer.data.CommentIdTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameBetDataWithoutGameTO;
import de.tipit.server.transfer.data.GameBetIdTO;
import de.tipit.server.transfer.data.GameDataArgumentTO;
import de.tipit.server.transfer.data.GameDataResultTO;
import de.tipit.server.transfer.data.GameIdTO;
import de.tipit.server.transfer.data.GameResultDataTO;
import de.tipit.server.transfer.data.GameTO;
import de.tipit.server.transfer.data.PeriodTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TeamIdTO;
import de.tipit.server.transfer.data.TeamNameTO;
import de.tipit.server.transfer.data.TournamentDescrTO;
import de.tipit.server.transfer.data.TournamentIdTO;
import de.tipit.server.transfer.data.TournamentTO;
import de.tipit.server.transfer.data.WinnerBetDataArgumentTO;
import de.tipit.server.transfer.data.WinnerBetIdTO;
import de.tipit.server.transfer.data.WinnerBetTO;

public class BetResultTransfer implements BetResult {

    private static final String serviceName = "BetResult";

    private final TransferHandler transferHandler;

    public BetResultTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public List<TournamentDescrTO> getOpenParticipatingTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetOpenParticipatingTournaments getOpenParticipatingTournaments = new GetOpenParticipatingTournaments();
        getOpenParticipatingTournaments.setContext(context);
        getOpenParticipatingTournaments.setSessionId(sessionId);
        GetOpenParticipatingTournaments.Result resultData = (GetOpenParticipatingTournaments.Result) transferHandler.doTransfer(new BetResultInvocation(
                getOpenParticipatingTournaments), serviceName);
        return resultData.getTournDescrList();
    }

    @Override
    public List<TournamentDescrTO> getAllOpenTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetAllOpenTournaments getAllOpenTournaments = new GetAllOpenTournaments();
        getAllOpenTournaments.setContext(context);
        getAllOpenTournaments.setSessionId(sessionId);
        GetAllOpenTournaments.Result resultData = (GetAllOpenTournaments.Result) transferHandler.doTransfer(new BetResultInvocation(getAllOpenTournaments),
                serviceName);
        return resultData.getTournDescrList();
    }

    @Override
    public TournamentTO readTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        ReadTournament readTournament = new ReadTournament();
        readTournament.setContext(context);
        readTournament.setSessionId(sessionId);
        readTournament.setTournId(tournId);
        ReadTournament.Result resultData = (ReadTournament.Result) transferHandler.doTransfer(new BetResultInvocation(readTournament), serviceName);
        return resultData.getTournament();
    }

    @Override
    public Boolean hasMissingWinnerBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        HasMissingWinnerBetForTournament hasMissingWinnerBetForTournament = new HasMissingWinnerBetForTournament();
        hasMissingWinnerBetForTournament.setContext(context);
        hasMissingWinnerBetForTournament.setSessionId(sessionId);
        hasMissingWinnerBetForTournament.setTournId(tournId);
        HasMissingWinnerBetForTournament.Result resultData = (HasMissingWinnerBetForTournament.Result) transferHandler.doTransfer(new BetResultInvocation(
                hasMissingWinnerBetForTournament), serviceName);
        return resultData.getHasMissWBet();
    }

    @Override
    public List<WinnerBetTO> getWinnerBetsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetWinnerBetsForTournament getWinnerBetsForTournament = new GetWinnerBetsForTournament();
        getWinnerBetsForTournament.setContext(context);
        getWinnerBetsForTournament.setSessionId(sessionId);
        getWinnerBetsForTournament.setTournId(tournId);
        GetWinnerBetsForTournament.Result resultData = (GetWinnerBetsForTournament.Result) transferHandler.doTransfer(new BetResultInvocation(
                getWinnerBetsForTournament), serviceName);
        return resultData.getWinnerBetList();
    }

    @Override
    public List<TeamNameTO> getTeamsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetTeamsForTournament getTeamsForTournament = new GetTeamsForTournament();
        getTeamsForTournament.setContext(context);
        getTeamsForTournament.setSessionId(sessionId);
        getTeamsForTournament.setTournId(tournId);
        GetTeamsForTournament.Result resultData = (GetTeamsForTournament.Result) transferHandler.doTransfer(new BetResultInvocation(getTeamsForTournament),
                serviceName);
        return resultData.getTeamNameList();
    }

    @Override
    public List<GameDataResultTO> getGamesWithMissingBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesWithMissingBetForTournament getGamesWithMissingBetForTournament = new GetGamesWithMissingBetForTournament();
        getGamesWithMissingBetForTournament.setContext(context);
        getGamesWithMissingBetForTournament.setSessionId(sessionId);
        getGamesWithMissingBetForTournament.setTournId(tournId);
        GetGamesWithMissingBetForTournament.Result resultData = (GetGamesWithMissingBetForTournament.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithMissingBetForTournament), serviceName);
        return resultData.getGameDataResultList();
    }

    @Override
    public List<GameTO> getGamesWithPopulatedBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesWithPopulatedBetForTournament getGamesWithPopulatedBetForTournament = new GetGamesWithPopulatedBetForTournament();
        getGamesWithPopulatedBetForTournament.setContext(context);
        getGamesWithPopulatedBetForTournament.setSessionId(sessionId);
        getGamesWithPopulatedBetForTournament.setTournId(tournId);
        GetGamesWithPopulatedBetForTournament.Result resultData = (GetGamesWithPopulatedBetForTournament.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithPopulatedBetForTournament), serviceName);
        return resultData.getGameList();
    }

    @Override
    public List<GameTO> getGamesWithForgottenBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesWithForgottenBetForTournament getGamesWithForgottenBetForTournament = new GetGamesWithForgottenBetForTournament();
        getGamesWithForgottenBetForTournament.setContext(context);
        getGamesWithForgottenBetForTournament.setSessionId(sessionId);
        getGamesWithForgottenBetForTournament.setTournId(tournId);
        GetGamesWithForgottenBetForTournament.Result resultData = (GetGamesWithForgottenBetForTournament.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithForgottenBetForTournament), serviceName);
        return resultData.getGameList();
    }

    @Override
    public List<GameDataResultTO> getGamesWithMissingResultForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesWithMissingResultForTournament getGamesWithMissingResultForTournament = new GetGamesWithMissingResultForTournament();
        getGamesWithMissingResultForTournament.setContext(context);
        getGamesWithMissingResultForTournament.setSessionId(sessionId);
        getGamesWithMissingResultForTournament.setTournId(tournId);
        GetGamesWithMissingResultForTournament.Result resultData = (GetGamesWithMissingResultForTournament.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithMissingResultForTournament), serviceName);
        return resultData.getGameDataResultList();
    }

    @Override
    public List<GameTO> getGamesWithPopulatedResultForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesWithPopulatedResultForTournament getGamesWithPopulatedResultForTournament = new GetGamesWithPopulatedResultForTournament();
        getGamesWithPopulatedResultForTournament.setContext(context);
        getGamesWithPopulatedResultForTournament.setSessionId(sessionId);
        getGamesWithPopulatedResultForTournament.setTournId(tournId);
        GetGamesWithPopulatedResultForTournament.Result resultData = (GetGamesWithPopulatedResultForTournament.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithPopulatedResultForTournament), serviceName);
        return resultData.getGameList();
    }

    @Override
    public List<GameDataResultTO> getGamesWithMissingBetForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError {
        GetGamesWithMissingBetForPeriod getGamesWithMissingBetForPeriod = new GetGamesWithMissingBetForPeriod();
        getGamesWithMissingBetForPeriod.setContext(context);
        getGamesWithMissingBetForPeriod.setSessionId(sessionId);
        getGamesWithMissingBetForPeriod.setPeriod(period);
        GetGamesWithMissingBetForPeriod.Result resultData = (GetGamesWithMissingBetForPeriod.Result) transferHandler.doTransfer(new BetResultInvocation(
                getGamesWithMissingBetForPeriod), serviceName);
        return resultData.getGameDataResultList();
    }

    @Override
    public List<GameTO> getGamesWithPopulatedBetForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError {
        GetGamesWithPopulatedBetForPeriod getGamesWithPopulatedBetForPeriod = new GetGamesWithPopulatedBetForPeriod();
        getGamesWithPopulatedBetForPeriod.setContext(context);
        getGamesWithPopulatedBetForPeriod.setSessionId(sessionId);
        getGamesWithPopulatedBetForPeriod.setPeriod(period);
        GetGamesWithPopulatedBetForPeriod.Result resultData = (GetGamesWithPopulatedBetForPeriod.Result) transferHandler.doTransfer(new BetResultInvocation(
                getGamesWithPopulatedBetForPeriod), serviceName);
        return resultData.getGameList();
    }

    @Override
    public List<GameTO> getGamesWithForgottenBetForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError {
        GetGamesWithForgottenBetForPeriod getGamesWithForgottenBetForPeriod = new GetGamesWithForgottenBetForPeriod();
        getGamesWithForgottenBetForPeriod.setContext(context);
        getGamesWithForgottenBetForPeriod.setSessionId(sessionId);
        getGamesWithForgottenBetForPeriod.setPeriod(period);
        GetGamesWithForgottenBetForPeriod.Result resultData = (GetGamesWithForgottenBetForPeriod.Result) transferHandler.doTransfer(new BetResultInvocation(
                getGamesWithForgottenBetForPeriod), serviceName);
        return resultData.getGameList();
    }

    @Override
    public List<GameDataResultTO> getGamesWithMissingResultForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError {
        GetGamesWithMissingResultForPeriod getGamesWithMissingResultForPeriod = new GetGamesWithMissingResultForPeriod();
        getGamesWithMissingResultForPeriod.setContext(context);
        getGamesWithMissingResultForPeriod.setSessionId(sessionId);
        getGamesWithMissingResultForPeriod.setPeriod(period);
        GetGamesWithMissingResultForPeriod.Result resultData = (GetGamesWithMissingResultForPeriod.Result) transferHandler.doTransfer(new BetResultInvocation(
                getGamesWithMissingResultForPeriod), serviceName);
        return resultData.getGameDataResultList();
    }

    @Override
    public List<GameTO> getGamesWithPopulatedResultForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError {
        GetGamesWithPopulatedResultForPeriod getGamesWithPopulatedResultForPeriod = new GetGamesWithPopulatedResultForPeriod();
        getGamesWithPopulatedResultForPeriod.setContext(context);
        getGamesWithPopulatedResultForPeriod.setSessionId(sessionId);
        getGamesWithPopulatedResultForPeriod.setPeriod(period);
        GetGamesWithPopulatedResultForPeriod.Result resultData = (GetGamesWithPopulatedResultForPeriod.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithPopulatedResultForPeriod), serviceName);
        return resultData.getGameList();
    }

    @Override
    public Void setWinnerBet(ContextTO context, SessionIdTO sessionId, WinnerBetDataArgumentTO winnerBetData) throws GeneralError {
        SetWinnerBet setWinnerBet = new SetWinnerBet();
        setWinnerBet.setContext(context);
        setWinnerBet.setSessionId(sessionId);
        setWinnerBet.setWinnerBetData(winnerBetData);
        transferHandler.doTransfer(new BetResultInvocation(setWinnerBet), serviceName);
        return null;
    }

    @Override
    public Void setGameBet(ContextTO context, SessionIdTO sessionId, GameBetDataWithoutGameTO gameBetData, GameIdTO gameId) throws GeneralError {
        SetGameBet setGameBet = new SetGameBet();
        setGameBet.setContext(context);
        setGameBet.setSessionId(sessionId);
        setGameBet.setGameBetData(gameBetData);
        setGameBet.setGameId(gameId);
        transferHandler.doTransfer(new BetResultInvocation(setGameBet), serviceName);
        return null;
    }

    @Override
    public Void setWinnerTeam(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, TeamIdTO winnerTeamId) throws GeneralError {
        SetWinnerTeam setWinnerTeam = new SetWinnerTeam();
        setWinnerTeam.setContext(context);
        setWinnerTeam.setSessionId(sessionId);
        setWinnerTeam.setTournId(tournId);
        setWinnerTeam.setWinnerTeamId(winnerTeamId);
        transferHandler.doTransfer(new BetResultInvocation(setWinnerTeam), serviceName);
        return null;
    }

    @Override
    public Void delWinnerTeam(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        DelWinnerTeam delWinnerTeam = new DelWinnerTeam();
        delWinnerTeam.setContext(context);
        delWinnerTeam.setSessionId(sessionId);
        delWinnerTeam.setTournId(tournId);
        transferHandler.doTransfer(new BetResultInvocation(delWinnerTeam), serviceName);
        return null;
    }

    @Override
    public Void setGameResult(ContextTO context, SessionIdTO sessionId, GameResultDataTO gameResultData) throws GeneralError {
        SetGameResult setGameResult = new SetGameResult();
        setGameResult.setContext(context);
        setGameResult.setSessionId(sessionId);
        setGameResult.setGameResultData(gameResultData);
        transferHandler.doTransfer(new BetResultInvocation(setGameResult), serviceName);
        return null;
    }

    @Override
    public Void delGameResult(ContextTO context, SessionIdTO sessionId, GameIdTO gameId) throws GeneralError {
        DelGameResult delGameResult = new DelGameResult();
        delGameResult.setContext(context);
        delGameResult.setSessionId(sessionId);
        delGameResult.setGameId(gameId);
        transferHandler.doTransfer(new BetResultInvocation(delGameResult), serviceName);
        return null;
    }

    @Override
    public CommentIdTO createOrUpdateCommentForWinnerBet(ContextTO context, SessionIdTO sessionId, WinnerBetIdTO winnerBetId, CommentDataTO commentData)
            throws GeneralError {
        CreateOrUpdateCommentForWinnerBet createOrUpdateCommentForWinnerBet = new CreateOrUpdateCommentForWinnerBet();
        createOrUpdateCommentForWinnerBet.setContext(context);
        createOrUpdateCommentForWinnerBet.setSessionId(sessionId);
        createOrUpdateCommentForWinnerBet.setWinnerBetId(winnerBetId);
        createOrUpdateCommentForWinnerBet.setCommentData(commentData);
        CreateOrUpdateCommentForWinnerBet.Result resultData = (CreateOrUpdateCommentForWinnerBet.Result) transferHandler.doTransfer(new BetResultInvocation(
                createOrUpdateCommentForWinnerBet), serviceName);
        return resultData.getCommentId();
    }

    @Override
    public CommentIdTO createOrUpdateCommentForWinnerTeam(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, CommentDataTO commentData)
            throws GeneralError {
        CreateOrUpdateCommentForWinnerTeam createOrUpdateCommentForWinnerTeam = new CreateOrUpdateCommentForWinnerTeam();
        createOrUpdateCommentForWinnerTeam.setContext(context);
        createOrUpdateCommentForWinnerTeam.setSessionId(sessionId);
        createOrUpdateCommentForWinnerTeam.setTournId(tournId);
        createOrUpdateCommentForWinnerTeam.setCommentData(commentData);
        CreateOrUpdateCommentForWinnerTeam.Result resultData = (CreateOrUpdateCommentForWinnerTeam.Result) transferHandler.doTransfer(new BetResultInvocation(
                createOrUpdateCommentForWinnerTeam), serviceName);
        return resultData.getCommentId();
    }

    @Override
    public CommentIdTO createOrUpdateCommentForGameBet(ContextTO context, SessionIdTO sessionId, GameBetIdTO gameBetId, CommentDataTO commentData)
            throws GeneralError {
        CreateOrUpdateCommentForGameBet createOrUpdateCommentForGameBet = new CreateOrUpdateCommentForGameBet();
        createOrUpdateCommentForGameBet.setContext(context);
        createOrUpdateCommentForGameBet.setSessionId(sessionId);
        createOrUpdateCommentForGameBet.setGameBetId(gameBetId);
        createOrUpdateCommentForGameBet.setCommentData(commentData);
        CreateOrUpdateCommentForGameBet.Result resultData = (CreateOrUpdateCommentForGameBet.Result) transferHandler.doTransfer(new BetResultInvocation(
                createOrUpdateCommentForGameBet), serviceName);
        return resultData.getCommentId();
    }

    @Override
    public CommentIdTO createOrUpdateCommentForGameResult(ContextTO context, SessionIdTO sessionId, GameIdTO gameId, CommentDataTO commentData)
            throws GeneralError {
        CreateOrUpdateCommentForGameResult createOrUpdateCommentForGameResult = new CreateOrUpdateCommentForGameResult();
        createOrUpdateCommentForGameResult.setContext(context);
        createOrUpdateCommentForGameResult.setSessionId(sessionId);
        createOrUpdateCommentForGameResult.setGameId(gameId);
        createOrUpdateCommentForGameResult.setCommentData(commentData);
        CreateOrUpdateCommentForGameResult.Result resultData = (CreateOrUpdateCommentForGameResult.Result) transferHandler.doTransfer(new BetResultInvocation(
                createOrUpdateCommentForGameResult), serviceName);
        return resultData.getCommentId();
    }

    @Override
    public Void removeCommentForWinnerBet(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError {
        RemoveCommentForWinnerBet removeCommentForWinnerBet = new RemoveCommentForWinnerBet();
        removeCommentForWinnerBet.setContext(context);
        removeCommentForWinnerBet.setSessionId(sessionId);
        removeCommentForWinnerBet.setCommentId(commentId);
        transferHandler.doTransfer(new BetResultInvocation(removeCommentForWinnerBet), serviceName);
        return null;
    }

    @Override
    public Void removeCommentForWinnerTeam(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError {
        RemoveCommentForWinnerTeam removeCommentForWinnerTeam = new RemoveCommentForWinnerTeam();
        removeCommentForWinnerTeam.setContext(context);
        removeCommentForWinnerTeam.setSessionId(sessionId);
        removeCommentForWinnerTeam.setCommentId(commentId);
        transferHandler.doTransfer(new BetResultInvocation(removeCommentForWinnerTeam), serviceName);
        return null;
    }

    @Override
    public Void removeCommentForGameBet(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError {
        RemoveCommentForGameBet removeCommentForGameBet = new RemoveCommentForGameBet();
        removeCommentForGameBet.setContext(context);
        removeCommentForGameBet.setSessionId(sessionId);
        removeCommentForGameBet.setCommentId(commentId);
        transferHandler.doTransfer(new BetResultInvocation(removeCommentForGameBet), serviceName);
        return null;
    }

    @Override
    public Void removeCommentForGameResult(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError {
        RemoveCommentForGameResult removeCommentForGameResult = new RemoveCommentForGameResult();
        removeCommentForGameResult.setContext(context);
        removeCommentForGameResult.setSessionId(sessionId);
        removeCommentForGameResult.setCommentId(commentId);
        transferHandler.doTransfer(new BetResultInvocation(removeCommentForGameResult), serviceName);
        return null;
    }

    @Override
    public List<GameDataResultTO> getGamesWithMissingTeamsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesWithMissingTeamsForTournament getGamesWithMissingTeamsForTournament = new GetGamesWithMissingTeamsForTournament();
        getGamesWithMissingTeamsForTournament.setContext(context);
        getGamesWithMissingTeamsForTournament.setSessionId(sessionId);
        getGamesWithMissingTeamsForTournament.setTournId(tournId);
        GetGamesWithMissingTeamsForTournament.Result resultData = (GetGamesWithMissingTeamsForTournament.Result) transferHandler.doTransfer(
                new BetResultInvocation(getGamesWithMissingTeamsForTournament), serviceName);
        return resultData.getGameDataResultList();
    }

    @Override
    public Void updateGame(ContextTO context, SessionIdTO sessionId, GameDataArgumentTO gameData) throws GeneralError {
        UpdateGame updateGame = new UpdateGame();
        updateGame.setContext(context);
        updateGame.setSessionId(sessionId);
        updateGame.setGameData(gameData);
        transferHandler.doTransfer(new BetResultInvocation(updateGame), serviceName);
        return null;
    }
}
