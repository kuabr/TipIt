package de.tipit.server.transfer.access;

import java.util.List;

import de.tipit.server.transfer.data.BetCommunityIdTO;
import de.tipit.server.transfer.data.BetCommunityNameTO;
import de.tipit.server.transfer.data.BetCommunitySearchDataTO;
import de.tipit.server.transfer.data.BetCommunityTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.GameDataResultTO;
import de.tipit.server.transfer.data.GameWithPointsTO;
import de.tipit.server.transfer.data.MatchDayIdTO;
import de.tipit.server.transfer.data.PeriodTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentDescrTO;
import de.tipit.server.transfer.data.TournamentIdTO;
import de.tipit.server.transfer.data.TournamentRoundIdTO;
import de.tipit.server.transfer.data.TournamentSearchDataTO;
import de.tipit.server.transfer.data.TournamentTO;
import de.tipit.server.transfer.data.UserGroupPointsTO;
import de.tipit.server.transfer.data.UserPointsTO;

public interface Analysis {

    List<BetCommunityNameTO> findBetCommunities(ContextTO context, SessionIdTO sessionId, BetCommunitySearchDataTO betCommunitySearchData) throws GeneralError;

    List<BetCommunityNameTO> getParticipatingBetCommunities(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    BetCommunityTO readBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError;

    List<TournamentDescrTO> findTournaments(ContextTO context, SessionIdTO sessionId, TournamentSearchDataTO tournSearchData) throws GeneralError;

    TournamentTO readTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameDataResultTO> getGamesForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameWithPointsTO> getGamesWithPointsByTournament(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId,
            Boolean onlyGamesWithResult) throws GeneralError;

    List<GameWithPointsTO> getGamesWithPointsByPeriod(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, PeriodTO period,
            Boolean onlyGamesWithResult) throws GeneralError;

    List<UserPointsTO> getTournamentRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId,
            Boolean onlyUsersWithBet) throws GeneralError;

    List<UserGroupPointsTO> getTournamentRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId)
            throws GeneralError;

    List<UserPointsTO> getTournamentRoundRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            TournamentRoundIdTO tournRoundId, Boolean onlyUsersWithBet) throws GeneralError;

    List<UserGroupPointsTO> getTournamentRoundRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            TournamentRoundIdTO tournRoundId) throws GeneralError;

    List<UserPointsTO> getMatchDayRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, MatchDayIdTO matchDayId,
            Boolean onlyUsersWithBet) throws GeneralError;

    List<UserGroupPointsTO> getMatchDayRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, MatchDayIdTO matchDayId)
            throws GeneralError;

    List<UserPointsTO> getAllTimeRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, Boolean onlyUsersWithBet)
            throws GeneralError;

    List<UserGroupPointsTO> getAllTimeRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError;
}
