package de.tipit.server.transfer.access;

import java.util.List;

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

public interface TournamentAdmin {

    List<SportNameTO> getSports(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<TournamentDescrTO> findTournaments(ContextTO context, SessionIdTO sessionId, TournamentSearchDataTO tournSearchData) throws GeneralError;

    List<TournamentDescrTO> getModeratedTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<TournamentDescrTO> getOwnTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<TeamNameTO> getTeamsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    TournamentTO readTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<UserNameTO> findUsers(ContextTO context, SessionIdTO sessionId, UserSearchDataTO userSearchData) throws GeneralError;

    TournamentIdTO createOrUpdateTournament(ContextTO context, SessionIdTO sessionId, TournamentDataArgumentTO tournData) throws GeneralError;

    Void deleteTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    Boolean isTournamentModerator(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    Void addModeratorToTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, UserIdTO modId) throws GeneralError;

    Void removeModeratorFromTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, UserIdTO modId) throws GeneralError;

    TournamentRoundIdTO createOrUpdateTournamentRound(ContextTO context, SessionIdTO sessionId, TournamentRoundDataArgumentTO tournRoundData)
            throws GeneralError;

    Void deleteTournamentRound(ContextTO context, SessionIdTO sessionId, TournamentRoundIdTO tournRoundId) throws GeneralError;

    MatchDayIdTO createOrUpdateMatchDay(ContextTO context, SessionIdTO sessionId, MatchDayDataArgumentTO matchDayData) throws GeneralError;

    Void deleteMatchDay(ContextTO context, SessionIdTO sessionId, MatchDayIdTO matchDayId) throws GeneralError;

    GameIdTO createOrUpdateGame(ContextTO context, SessionIdTO sessionId, GameDataArgumentTO gameData) throws GeneralError;

    Void deleteGame(ContextTO context, SessionIdTO sessionId, GameIdTO gameId) throws GeneralError;
}
