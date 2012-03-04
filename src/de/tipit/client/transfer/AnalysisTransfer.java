package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.Analysis;
import de.tipit.server.transfer.access.AnalysisInvocation;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.analysis.FindBetCommunities;
import de.tipit.server.transfer.access.analysis.FindTournaments;
import de.tipit.server.transfer.access.analysis.GetAllTimeRankingByUser;
import de.tipit.server.transfer.access.analysis.GetAllTimeRankingByUserGroup;
import de.tipit.server.transfer.access.analysis.GetGamesForTournament;
import de.tipit.server.transfer.access.analysis.GetGamesWithPointsByPeriod;
import de.tipit.server.transfer.access.analysis.GetGamesWithPointsByTournament;
import de.tipit.server.transfer.access.analysis.GetMatchDayRankingByUser;
import de.tipit.server.transfer.access.analysis.GetMatchDayRankingByUserGroup;
import de.tipit.server.transfer.access.analysis.GetParticipatingBetCommunities;
import de.tipit.server.transfer.access.analysis.GetTournamentRankingByUser;
import de.tipit.server.transfer.access.analysis.GetTournamentRankingByUserGroup;
import de.tipit.server.transfer.access.analysis.GetTournamentRoundRankingByUser;
import de.tipit.server.transfer.access.analysis.GetTournamentRoundRankingByUserGroup;
import de.tipit.server.transfer.access.analysis.ReadBetCommunity;
import de.tipit.server.transfer.access.analysis.ReadTournament;
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

public class AnalysisTransfer implements Analysis {

    private static final String serviceName = "Analysis";

    private final TransferHandler transferHandler;

    public AnalysisTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public List<BetCommunityNameTO> findBetCommunities(ContextTO context, SessionIdTO sessionId, BetCommunitySearchDataTO betCommunitySearchData)
            throws GeneralError {
        FindBetCommunities findBetCommunities = new FindBetCommunities();
        findBetCommunities.setContext(context);
        findBetCommunities.setSessionId(sessionId);
        findBetCommunities.setBetCommunitySearchData(betCommunitySearchData);
        FindBetCommunities.Result resultData = (FindBetCommunities.Result) transferHandler.doTransfer(new AnalysisInvocation(findBetCommunities), serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public List<BetCommunityNameTO> getParticipatingBetCommunities(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetParticipatingBetCommunities getParticipatingBetCommunities = new GetParticipatingBetCommunities();
        getParticipatingBetCommunities.setContext(context);
        getParticipatingBetCommunities.setSessionId(sessionId);
        GetParticipatingBetCommunities.Result resultData = (GetParticipatingBetCommunities.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getParticipatingBetCommunities), serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public BetCommunityTO readBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError {
        ReadBetCommunity readBetCommunity = new ReadBetCommunity();
        readBetCommunity.setContext(context);
        readBetCommunity.setSessionId(sessionId);
        readBetCommunity.setBetCommunityId(betCommunityId);
        ReadBetCommunity.Result resultData = (ReadBetCommunity.Result) transferHandler.doTransfer(new AnalysisInvocation(readBetCommunity), serviceName);
        return resultData.getBetCommunity();
    }

    @Override
    public List<TournamentDescrTO> findTournaments(ContextTO context, SessionIdTO sessionId, TournamentSearchDataTO tournSearchData) throws GeneralError {
        FindTournaments findTournaments = new FindTournaments();
        findTournaments.setContext(context);
        findTournaments.setSessionId(sessionId);
        findTournaments.setTournSearchData(tournSearchData);
        FindTournaments.Result resultData = (FindTournaments.Result) transferHandler.doTransfer(new AnalysisInvocation(findTournaments), serviceName);
        return resultData.getTournDescrList();
    }

    @Override
    public TournamentTO readTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        ReadTournament readTournament = new ReadTournament();
        readTournament.setContext(context);
        readTournament.setSessionId(sessionId);
        readTournament.setTournId(tournId);
        ReadTournament.Result resultData = (ReadTournament.Result) transferHandler.doTransfer(new AnalysisInvocation(readTournament), serviceName);
        return resultData.getTournament();
    }

    @Override
    public List<GameDataResultTO> getGamesForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError {
        GetGamesForTournament getGamesForTournament = new GetGamesForTournament();
        getGamesForTournament.setContext(context);
        getGamesForTournament.setSessionId(sessionId);
        getGamesForTournament.setTournId(tournId);
        GetGamesForTournament.Result resultData = (GetGamesForTournament.Result) transferHandler.doTransfer(new AnalysisInvocation(getGamesForTournament),
                serviceName);
        return resultData.getGameDataResultList();
    }

    @Override
    public List<GameWithPointsTO> getGamesWithPointsByTournament(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            TournamentIdTO tournId, Boolean onlyGamesWithResult) throws GeneralError {
        GetGamesWithPointsByTournament getGamesWithPointsByTournament = new GetGamesWithPointsByTournament();
        getGamesWithPointsByTournament.setContext(context);
        getGamesWithPointsByTournament.setSessionId(sessionId);
        getGamesWithPointsByTournament.setBetCommunityId(betCommunityId);
        getGamesWithPointsByTournament.setTournId(tournId);
        getGamesWithPointsByTournament.setOnlyGamesWithResult(onlyGamesWithResult);
        GetGamesWithPointsByTournament.Result resultData = (GetGamesWithPointsByTournament.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getGamesWithPointsByTournament), serviceName);
        return resultData.getGameWithPointsList();
    }

    @Override
    public List<GameWithPointsTO> getGamesWithPointsByPeriod(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, PeriodTO period,
            Boolean onlyGamesWithResult) throws GeneralError {
        GetGamesWithPointsByPeriod getGamesWithPointsByPeriod = new GetGamesWithPointsByPeriod();
        getGamesWithPointsByPeriod.setContext(context);
        getGamesWithPointsByPeriod.setSessionId(sessionId);
        getGamesWithPointsByPeriod.setBetCommunityId(betCommunityId);
        getGamesWithPointsByPeriod.setPeriod(period);
        getGamesWithPointsByPeriod.setOnlyGamesWithResult(onlyGamesWithResult);
        GetGamesWithPointsByPeriod.Result resultData = (GetGamesWithPointsByPeriod.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getGamesWithPointsByPeriod), serviceName);
        return resultData.getGameWithPointsList();
    }

    @Override
    public List<UserPointsTO> getTournamentRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId,
            Boolean onlyUsersWithBet) throws GeneralError {
        GetTournamentRankingByUser getTournamentRankingByUser = new GetTournamentRankingByUser();
        getTournamentRankingByUser.setContext(context);
        getTournamentRankingByUser.setSessionId(sessionId);
        getTournamentRankingByUser.setBetCommunityId(betCommunityId);
        getTournamentRankingByUser.setTournId(tournId);
        getTournamentRankingByUser.setOnlyUsersWithBet(onlyUsersWithBet);
        GetTournamentRankingByUser.Result resultData = (GetTournamentRankingByUser.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getTournamentRankingByUser), serviceName);
        return resultData.getUserPointsList();
    }

    @Override
    public List<UserGroupPointsTO> getTournamentRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            TournamentIdTO tournId) throws GeneralError {
        GetTournamentRankingByUserGroup getTournamentRankingByUserGroup = new GetTournamentRankingByUserGroup();
        getTournamentRankingByUserGroup.setContext(context);
        getTournamentRankingByUserGroup.setSessionId(sessionId);
        getTournamentRankingByUserGroup.setBetCommunityId(betCommunityId);
        getTournamentRankingByUserGroup.setTournId(tournId);
        GetTournamentRankingByUserGroup.Result resultData = (GetTournamentRankingByUserGroup.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getTournamentRankingByUserGroup), serviceName);
        return resultData.getUserGroupPointsList();
    }

    @Override
    public List<UserPointsTO> getTournamentRoundRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            TournamentRoundIdTO tournRoundId, Boolean onlyUsersWithBet) throws GeneralError {
        GetTournamentRoundRankingByUser getTournamentRoundRankingByUser = new GetTournamentRoundRankingByUser();
        getTournamentRoundRankingByUser.setContext(context);
        getTournamentRoundRankingByUser.setSessionId(sessionId);
        getTournamentRoundRankingByUser.setBetCommunityId(betCommunityId);
        getTournamentRoundRankingByUser.setTournRoundId(tournRoundId);
        getTournamentRoundRankingByUser.setOnlyUsersWithBet(onlyUsersWithBet);
        GetTournamentRoundRankingByUser.Result resultData = (GetTournamentRoundRankingByUser.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getTournamentRoundRankingByUser), serviceName);
        return resultData.getUserPointsList();
    }

    @Override
    public List<UserGroupPointsTO> getTournamentRoundRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            TournamentRoundIdTO tournRoundId) throws GeneralError {
        GetTournamentRoundRankingByUserGroup getTournamentRoundRankingByUserGroup = new GetTournamentRoundRankingByUserGroup();
        getTournamentRoundRankingByUserGroup.setContext(context);
        getTournamentRoundRankingByUserGroup.setSessionId(sessionId);
        getTournamentRoundRankingByUserGroup.setBetCommunityId(betCommunityId);
        getTournamentRoundRankingByUserGroup.setTournRoundId(tournRoundId);
        GetTournamentRoundRankingByUserGroup.Result resultData = (GetTournamentRoundRankingByUserGroup.Result) transferHandler.doTransfer(
                new AnalysisInvocation(getTournamentRoundRankingByUserGroup), serviceName);
        return resultData.getUserGroupPointsList();
    }

    @Override
    public List<UserPointsTO> getMatchDayRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, MatchDayIdTO matchDayId,
            Boolean onlyUsersWithBet) throws GeneralError {
        GetMatchDayRankingByUser getMatchDayRankingByUser = new GetMatchDayRankingByUser();
        getMatchDayRankingByUser.setContext(context);
        getMatchDayRankingByUser.setSessionId(sessionId);
        getMatchDayRankingByUser.setBetCommunityId(betCommunityId);
        getMatchDayRankingByUser.setMatchDayId(matchDayId);
        getMatchDayRankingByUser.setOnlyUsersWithBet(onlyUsersWithBet);
        GetMatchDayRankingByUser.Result resultData = (GetMatchDayRankingByUser.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getMatchDayRankingByUser), serviceName);
        return resultData.getUserPointsList();
    }

    @Override
    public List<UserGroupPointsTO> getMatchDayRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId,
            MatchDayIdTO matchDayId) throws GeneralError {
        GetMatchDayRankingByUserGroup getMatchDayRankingByUserGroup = new GetMatchDayRankingByUserGroup();
        getMatchDayRankingByUserGroup.setContext(context);
        getMatchDayRankingByUserGroup.setSessionId(sessionId);
        getMatchDayRankingByUserGroup.setBetCommunityId(betCommunityId);
        getMatchDayRankingByUserGroup.setMatchDayId(matchDayId);
        GetMatchDayRankingByUserGroup.Result resultData = (GetMatchDayRankingByUserGroup.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getMatchDayRankingByUserGroup), serviceName);
        return resultData.getUserGroupPointsList();
    }

    @Override
    public List<UserPointsTO> getAllTimeRankingByUser(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, Boolean onlyUsersWithBet)
            throws GeneralError {
        GetAllTimeRankingByUser getAllTimeRankingByUser = new GetAllTimeRankingByUser();
        getAllTimeRankingByUser.setContext(context);
        getAllTimeRankingByUser.setSessionId(sessionId);
        getAllTimeRankingByUser.setBetCommunityId(betCommunityId);
        getAllTimeRankingByUser.setOnlyUsersWithBet(onlyUsersWithBet);
        GetAllTimeRankingByUser.Result resultData = (GetAllTimeRankingByUser.Result) transferHandler.doTransfer(
                new AnalysisInvocation(getAllTimeRankingByUser), serviceName);
        return resultData.getUserPointsList();
    }

    @Override
    public List<UserGroupPointsTO> getAllTimeRankingByUserGroup(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError {
        GetAllTimeRankingByUserGroup getAllTimeRankingByUserGroup = new GetAllTimeRankingByUserGroup();
        getAllTimeRankingByUserGroup.setContext(context);
        getAllTimeRankingByUserGroup.setSessionId(sessionId);
        getAllTimeRankingByUserGroup.setBetCommunityId(betCommunityId);
        GetAllTimeRankingByUserGroup.Result resultData = (GetAllTimeRankingByUserGroup.Result) transferHandler.doTransfer(new AnalysisInvocation(
                getAllTimeRankingByUserGroup), serviceName);
        return resultData.getUserGroupPointsList();
    }
}
