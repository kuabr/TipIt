package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.TournamentAdmin;
import de.tipit.server.transfer.access.TournamentAdminInvocation;
import de.tipit.server.transfer.access.tournament_admin.AddModeratorToTournament;
import de.tipit.server.transfer.access.tournament_admin.CreateOrUpdateGame;
import de.tipit.server.transfer.access.tournament_admin.CreateOrUpdateMatchDay;
import de.tipit.server.transfer.access.tournament_admin.CreateOrUpdateTournament;
import de.tipit.server.transfer.access.tournament_admin.CreateOrUpdateTournamentRound;
import de.tipit.server.transfer.access.tournament_admin.DeleteGame;
import de.tipit.server.transfer.access.tournament_admin.DeleteMatchDay;
import de.tipit.server.transfer.access.tournament_admin.DeleteTournament;
import de.tipit.server.transfer.access.tournament_admin.DeleteTournamentRound;
import de.tipit.server.transfer.access.tournament_admin.FindTournaments;
import de.tipit.server.transfer.access.tournament_admin.FindUsers;
import de.tipit.server.transfer.access.tournament_admin.GetModeratedTournaments;
import de.tipit.server.transfer.access.tournament_admin.GetOwnTournaments;
import de.tipit.server.transfer.access.tournament_admin.GetSports;
import de.tipit.server.transfer.access.tournament_admin.GetTeamsForTournament;
import de.tipit.server.transfer.access.tournament_admin.IsTournamentModerator;
import de.tipit.server.transfer.access.tournament_admin.ReadTournament;
import de.tipit.server.transfer.access.tournament_admin.RemoveModeratorFromTournament;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameDataArgumentTO;
import de.tipit.server.transfer.data.GameIdTO;
import de.tipit.server.transfer.data.MatchDayDataArgumentTO;
import de.tipit.server.transfer.data.MatchDayIdTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.SportNameTO;
import de.tipit.server.transfer.data.TeamNameTO;
import de.tipit.server.transfer.data.TournamentDataArgumentTO;
import de.tipit.server.transfer.data.TournamentDescrTO;
import de.tipit.server.transfer.data.TournamentIdTO;
import de.tipit.server.transfer.data.TournamentRoundDataArgumentTO;
import de.tipit.server.transfer.data.TournamentRoundIdTO;
import de.tipit.server.transfer.data.TournamentSearchDataTO;
import de.tipit.server.transfer.data.TournamentTO;
import de.tipit.server.transfer.data.UserIdTO;
import de.tipit.server.transfer.data.UserNameTO;
import de.tipit.server.transfer.data.UserSearchDataTO;

public class TournamentAdminTransfer implements TournamentAdmin {

    private static final String serviceName = "TournamentAdmin";

    private final TransferHandler transferHandler;

    public TournamentAdminTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public List<SportNameTO> getSports(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetSports getSports = new GetSports();
        getSports.setContext(context);
        getSports.setSessionId(sessionId);
        GetSports.Result resultData = (GetSports.Result) transferHandler.doTransfer(new TournamentAdminInvocation(getSports), serviceName);
        return resultData.getSportNameList();
    }

    @Override
    public List<TournamentDescrTO> findTournaments(ContextTO context, SessionIdTO sessionId, TournamentSearchDataTO tournSearchData) throws GeneralError {
        FindTournaments findTournaments = new FindTournaments();
        findTournaments.setContext(context);
        findTournaments.setSessionId(sessionId);
        findTournaments.setTournSearchData(tournSearchData);
        FindTournaments.Result resultData = (FindTournaments.Result) transferHandler.doTransfer(new TournamentAdminInvocation(findTournaments), serviceName);
        return resultData.getTournDescrList();
    }

    @Override
    public List<TournamentDescrTO> getModeratedTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetModeratedTournaments getModeratedTournaments = new GetModeratedTournaments();
        getModeratedTournaments.setContext(context);
        getModeratedTournaments.setSessionId(sessionId);
        GetModeratedTournaments.Result resultData = (GetModeratedTournaments.Result) transferHandler.doTransfer(new TournamentAdminInvocation(
                getModeratedTournaments), serviceName);
        return resultData.getTournDescrList();
    }

    @Override
    public List<TournamentDescrTO> getOwnTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetOwnTournaments getOwnTournaments = new GetOwnTournaments();
        getOwnTournaments.setContext(context);
        getOwnTournaments.setSessionId(sessionId);
        GetOwnTournaments.Result resultData = (GetOwnTournaments.Result) transferHandler.doTransfer(new TournamentAdminInvocation(getOwnTournaments),
                serviceName);
        return resultData.getTournDescrList();
    }

    @Override
    public List<TeamNameTO> getTeamsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetTeamsForTournament getTeamsForTournament = new GetTeamsForTournament();
        getTeamsForTournament.setContext(context);
        getTeamsForTournament.setSessionId(sessionId);
        getTeamsForTournament.setTournId(tournId);
        GetTeamsForTournament.Result resultData = (GetTeamsForTournament.Result) transferHandler.doTransfer(
                new TournamentAdminInvocation(getTeamsForTournament), serviceName);
        return resultData.getTeamNameList();
    }

    @Override
    public TournamentTO readTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        ReadTournament readTournament = new ReadTournament();
        readTournament.setContext(context);
        readTournament.setSessionId(sessionId);
        readTournament.setTournId(tournId);
        ReadTournament.Result resultData = (ReadTournament.Result) transferHandler.doTransfer(new TournamentAdminInvocation(readTournament), serviceName);
        return resultData.getTournament();
    }

    @Override
    public List<UserNameTO> findUsers(ContextTO context, SessionIdTO sessionId, UserSearchDataTO userSearchData) throws GeneralError {
        FindUsers findUsers = new FindUsers();
        findUsers.setContext(context);
        findUsers.setSessionId(sessionId);
        findUsers.setUserSearchData(userSearchData);
        FindUsers.Result resultData = (FindUsers.Result) transferHandler.doTransfer(new TournamentAdminInvocation(findUsers), serviceName);
        return resultData.getUserNameList();
    }

    @Override
    public TournamentIdTO createOrUpdateTournament(ContextTO context, SessionIdTO sessionId, TournamentDataArgumentTO tournData) throws GeneralError {
        CreateOrUpdateTournament createOrUpdateTournament = new CreateOrUpdateTournament();
        createOrUpdateTournament.setContext(context);
        createOrUpdateTournament.setSessionId(sessionId);
        createOrUpdateTournament.setTournData(tournData);
        CreateOrUpdateTournament.Result resultData = (CreateOrUpdateTournament.Result) transferHandler.doTransfer(new TournamentAdminInvocation(
                createOrUpdateTournament), serviceName);
        return resultData.getTournId();
    }

    @Override
    public Void deleteTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        DeleteTournament deleteTournament = new DeleteTournament();
        deleteTournament.setContext(context);
        deleteTournament.setSessionId(sessionId);
        deleteTournament.setTournId(tournId);
        transferHandler.doTransfer(new TournamentAdminInvocation(deleteTournament), serviceName);
        return null;
    }

    @Override
    public Boolean isTournamentModerator(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        IsTournamentModerator isTournamentModerator = new IsTournamentModerator();
        isTournamentModerator.setContext(context);
        isTournamentModerator.setSessionId(sessionId);
        isTournamentModerator.setTournId(tournId);
        IsTournamentModerator.Result resultData = (IsTournamentModerator.Result) transferHandler.doTransfer(
                new TournamentAdminInvocation(isTournamentModerator), serviceName);
        return resultData.getIsTournMod();
    }

    @Override
    public Void addModeratorToTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, UserIdTO modId) throws GeneralError {
        AddModeratorToTournament addModeratorToTournament = new AddModeratorToTournament();
        addModeratorToTournament.setContext(context);
        addModeratorToTournament.setSessionId(sessionId);
        addModeratorToTournament.setTournId(tournId);
        addModeratorToTournament.setModId(modId);
        transferHandler.doTransfer(new TournamentAdminInvocation(addModeratorToTournament), serviceName);
        return null;
    }

    @Override
    public Void removeModeratorFromTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, UserIdTO modId) throws GeneralError {
        RemoveModeratorFromTournament removeModeratorFromTournament = new RemoveModeratorFromTournament();
        removeModeratorFromTournament.setContext(context);
        removeModeratorFromTournament.setSessionId(sessionId);
        removeModeratorFromTournament.setTournId(tournId);
        removeModeratorFromTournament.setModId(modId);
        transferHandler.doTransfer(new TournamentAdminInvocation(removeModeratorFromTournament), serviceName);
        return null;
    }

    @Override
    public TournamentRoundIdTO createOrUpdateTournamentRound(ContextTO context, SessionIdTO sessionId, TournamentRoundDataArgumentTO tournRoundData)
            throws GeneralError {
        CreateOrUpdateTournamentRound createOrUpdateTournamentRound = new CreateOrUpdateTournamentRound();
        createOrUpdateTournamentRound.setContext(context);
        createOrUpdateTournamentRound.setSessionId(sessionId);
        createOrUpdateTournamentRound.setTournRoundData(tournRoundData);
        CreateOrUpdateTournamentRound.Result resultData = (CreateOrUpdateTournamentRound.Result) transferHandler.doTransfer(new TournamentAdminInvocation(
                createOrUpdateTournamentRound), serviceName);
        return resultData.getTournRoundId();
    }

    @Override
    public Void deleteTournamentRound(ContextTO context, SessionIdTO sessionId, TournamentRoundIdTO tournRoundId) throws GeneralError {
        DeleteTournamentRound deleteTournamentRound = new DeleteTournamentRound();
        deleteTournamentRound.setContext(context);
        deleteTournamentRound.setSessionId(sessionId);
        deleteTournamentRound.setTournRoundId(tournRoundId);
        transferHandler.doTransfer(new TournamentAdminInvocation(deleteTournamentRound), serviceName);
        return null;
    }

    @Override
    public MatchDayIdTO createOrUpdateMatchDay(ContextTO context, SessionIdTO sessionId, MatchDayDataArgumentTO matchDayData) throws GeneralError {
        CreateOrUpdateMatchDay createOrUpdateMatchDay = new CreateOrUpdateMatchDay();
        createOrUpdateMatchDay.setContext(context);
        createOrUpdateMatchDay.setSessionId(sessionId);
        createOrUpdateMatchDay.setMatchDayData(matchDayData);
        CreateOrUpdateMatchDay.Result resultData = (CreateOrUpdateMatchDay.Result) transferHandler.doTransfer(new TournamentAdminInvocation(
                createOrUpdateMatchDay), serviceName);
        return resultData.getMatchDayId();
    }

    @Override
    public Void deleteMatchDay(ContextTO context, SessionIdTO sessionId, MatchDayIdTO matchDayId) throws GeneralError {
        DeleteMatchDay deleteMatchDay = new DeleteMatchDay();
        deleteMatchDay.setContext(context);
        deleteMatchDay.setSessionId(sessionId);
        deleteMatchDay.setMatchDayId(matchDayId);
        transferHandler.doTransfer(new TournamentAdminInvocation(deleteMatchDay), serviceName);
        return null;
    }

    @Override
    public GameIdTO createOrUpdateGame(ContextTO context, SessionIdTO sessionId, GameDataArgumentTO gameData) throws GeneralError {
        CreateOrUpdateGame createOrUpdateGame = new CreateOrUpdateGame();
        createOrUpdateGame.setContext(context);
        createOrUpdateGame.setSessionId(sessionId);
        createOrUpdateGame.setGameData(gameData);
        CreateOrUpdateGame.Result resultData = (CreateOrUpdateGame.Result) transferHandler.doTransfer(new TournamentAdminInvocation(createOrUpdateGame),
                serviceName);
        return resultData.getGameId();
    }

    @Override
    public Void deleteGame(ContextTO context, SessionIdTO sessionId, GameIdTO gameId) throws GeneralError {
        DeleteGame deleteGame = new DeleteGame();
        deleteGame.setContext(context);
        deleteGame.setSessionId(sessionId);
        deleteGame.setGameId(gameId);
        transferHandler.doTransfer(new TournamentAdminInvocation(deleteGame), serviceName);
        return null;
    }
}
