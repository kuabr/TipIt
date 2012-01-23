package de.tipit.server.transfer.access;

import java.util.List;

import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.SportDataTO;
import de.tipit.server.transfer.data.SportIdTO;
import de.tipit.server.transfer.data.SportNameTO;
import de.tipit.server.transfer.data.SportTO;
import de.tipit.server.transfer.data.TeamDataTO;
import de.tipit.server.transfer.data.TeamIdTO;
import de.tipit.server.transfer.data.TeamNameTO;
import de.tipit.server.transfer.data.TeamSearchDataTO;
import de.tipit.server.transfer.data.TeamTO;
import de.tipit.server.transfer.data.TournamentTypeDataArgumentTO;
import de.tipit.server.transfer.data.TournamentTypeIdTO;
import de.tipit.server.transfer.data.TournamentTypeNameTO;
import de.tipit.server.transfer.data.TournamentTypeSearchDataTO;
import de.tipit.server.transfer.data.TournamentTypeTO;

public interface MetaDataAdmin {

    List<SportNameTO> getSports(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<TournamentTypeNameTO> findTournamentTypes(ContextTO context, SessionIdTO sessionId, TournamentTypeSearchDataTO tournTypeSearchData)
            throws GeneralError;

    List<TeamNameTO> findTeams(ContextTO context, SessionIdTO sessionId, TeamSearchDataTO teamSearchData) throws GeneralError;

    List<TournamentTypeNameTO> getTournamentTypesForTeams(ContextTO context, SessionIdTO sessionId, List<TeamIdTO> teamIdList) throws GeneralError;

    List<TeamNameTO> getTeamsForTournamentTypes(ContextTO context, SessionIdTO sessionId, List<TournamentTypeIdTO> tournTypeIdList) throws GeneralError;

    SportTO readSport(ContextTO context, SessionIdTO sessionId, SportIdTO sportId) throws GeneralError;

    TournamentTypeTO readTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId) throws GeneralError;

    TeamTO readTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId) throws GeneralError;

    SportIdTO createOrUpdateSport(ContextTO context, SessionIdTO sessionId, SportDataTO sportData) throws GeneralError;

    Void deleteSport(ContextTO context, SessionIdTO sessionId, SportIdTO sportId) throws GeneralError;

    TournamentTypeIdTO createOrUpdateTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeDataArgumentTO tournTypeData) throws GeneralError;

    Void deleteTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId) throws GeneralError;

    TeamIdTO createOrUpdateTeam(ContextTO context, SessionIdTO sessionId, TeamDataTO teamData) throws GeneralError;

    Void deleteTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId) throws GeneralError;

    Void addAllowedTournamentTypesToTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId, List<TournamentTypeIdTO> tournTypeIdList)
            throws GeneralError;

    Void removeAllowedTournamentTypesFromTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId, List<TournamentTypeIdTO> tournTypeIdList)
            throws GeneralError;

    Void addAllowedTeamsToTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId, List<TeamIdTO> teamIdList)
            throws GeneralError;

    Void removeAllowedTeamsFromTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId, List<TeamIdTO> teamIdList)
            throws GeneralError;
}
