package de.tipit.server.transfer.access;

import java.util.List;

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

public interface BetResult {

    List<TournamentDescrTO> getOpenParticipatingTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<TournamentDescrTO> getAllOpenTournaments(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    TournamentTO readTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    Boolean hasMissingWinnerBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<WinnerBetTO> getWinnerBetsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<TeamNameTO> getTeamsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameDataResultTO> getGamesWithMissingBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameTO> getGamesWithPopulatedBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameTO> getGamesWithForgottenBetForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameDataResultTO> getGamesWithMissingResultForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameTO> getGamesWithPopulatedResultForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    List<GameDataResultTO> getGamesWithMissingBetForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError;

    List<GameTO> getGamesWithPopulatedBetForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError;

    List<GameTO> getGamesWithForgottenBetForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError;

    List<GameDataResultTO> getGamesWithMissingResultForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError;

    List<GameTO> getGamesWithPopulatedResultForPeriod(ContextTO context, SessionIdTO sessionId, PeriodTO period) throws GeneralError;

    Void setWinnerBet(ContextTO context, SessionIdTO sessionId, WinnerBetDataArgumentTO winnerBetData) throws GeneralError;

    Void setGameBet(ContextTO context, SessionIdTO sessionId, GameBetDataWithoutGameTO gameBetData, GameIdTO gameId) throws GeneralError;

    Void setWinnerTeam(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, TeamIdTO winnerTeamId) throws GeneralError;

    Void delWinnerTeam(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    Void setGameResult(ContextTO context, SessionIdTO sessionId, GameResultDataTO gameResultData) throws GeneralError;

    Void delGameResult(ContextTO context, SessionIdTO sessionId, GameIdTO gameId) throws GeneralError;

    CommentIdTO createOrUpdateCommentForWinnerBet(ContextTO context, SessionIdTO sessionId, WinnerBetIdTO winnerBetId, CommentDataTO commentData)
            throws GeneralError;

    CommentIdTO createOrUpdateCommentForWinnerTeam(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId, CommentDataTO commentData)
            throws GeneralError;

    CommentIdTO createOrUpdateCommentForGameBet(ContextTO context, SessionIdTO sessionId, GameBetIdTO gameBetId, CommentDataTO commentData) throws GeneralError;

    CommentIdTO createOrUpdateCommentForGameResult(ContextTO context, SessionIdTO sessionId, GameIdTO gameId, CommentDataTO commentData) throws GeneralError;

    Void removeCommentForWinnerBet(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError;

    Void removeCommentForWinnerTeam(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError;

    Void removeCommentForGameBet(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError;

    Void removeCommentForGameResult(ContextTO context, SessionIdTO sessionId, CommentIdTO commentId) throws GeneralError;

    List<GameDataResultTO> getGamesWithMissingTeamsForTournament(ContextTO context, SessionIdTO sessionId, TournamentIdTO tournId) throws GeneralError;

    Void updateGame(ContextTO context, SessionIdTO sessionId, GameDataArgumentTO gameData) throws GeneralError;
}
