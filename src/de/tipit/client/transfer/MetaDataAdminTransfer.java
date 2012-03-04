package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminInvocation;
import de.tipit.server.transfer.access.meta_data_admin.AddAllowedTeamsToTournamentType;
import de.tipit.server.transfer.access.meta_data_admin.AddAllowedTournamentTypesToTeam;
import de.tipit.server.transfer.access.meta_data_admin.CreateOrUpdateSport;
import de.tipit.server.transfer.access.meta_data_admin.CreateOrUpdateTeam;
import de.tipit.server.transfer.access.meta_data_admin.CreateOrUpdateTournamentType;
import de.tipit.server.transfer.access.meta_data_admin.DeleteSport;
import de.tipit.server.transfer.access.meta_data_admin.DeleteTeam;
import de.tipit.server.transfer.access.meta_data_admin.DeleteTournamentType;
import de.tipit.server.transfer.access.meta_data_admin.FindTeams;
import de.tipit.server.transfer.access.meta_data_admin.FindTournamentTypes;
import de.tipit.server.transfer.access.meta_data_admin.GetSports;
import de.tipit.server.transfer.access.meta_data_admin.GetTeamsForTournamentTypes;
import de.tipit.server.transfer.access.meta_data_admin.GetTournamentTypesForTeams;
import de.tipit.server.transfer.access.meta_data_admin.ReadSport;
import de.tipit.server.transfer.access.meta_data_admin.ReadTeam;
import de.tipit.server.transfer.access.meta_data_admin.ReadTournamentType;
import de.tipit.server.transfer.access.meta_data_admin.RemoveAllowedTeamsFromTournamentType;
import de.tipit.server.transfer.access.meta_data_admin.RemoveAllowedTournamentTypesFromTeam;
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

public class MetaDataAdminTransfer implements MetaDataAdmin {

    private static final String serviceName = "MetaDataAdmin";

    private final TransferHandler transferHandler;

    public MetaDataAdminTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public List<SportNameTO> getSports(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetSports getSports = new GetSports();
        getSports.setContext(context);
        getSports.setSessionId(sessionId);
        GetSports.Result resultData = (GetSports.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(getSports), serviceName);
        return resultData.getSportNameList();
    }

    @Override
    public List<TournamentTypeNameTO> findTournamentTypes(ContextTO context, SessionIdTO sessionId, TournamentTypeSearchDataTO tournTypeSearchData)
            throws GeneralError {
        FindTournamentTypes findTournamentTypes = new FindTournamentTypes();
        findTournamentTypes.setContext(context);
        findTournamentTypes.setSessionId(sessionId);
        findTournamentTypes.setTournTypeSearchData(tournTypeSearchData);
        FindTournamentTypes.Result resultData = (FindTournamentTypes.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(findTournamentTypes),
                serviceName);
        return resultData.getTournTypeNameList();
    }

    @Override
    public List<TeamNameTO> findTeams(ContextTO context, SessionIdTO sessionId, TeamSearchDataTO teamSearchData) throws GeneralError {
        FindTeams findTeams = new FindTeams();
        findTeams.setContext(context);
        findTeams.setSessionId(sessionId);
        findTeams.setTeamSearchData(teamSearchData);
        FindTeams.Result resultData = (FindTeams.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(findTeams), serviceName);
        return resultData.getTeamNameList();
    }

    @Override
    public List<TournamentTypeNameTO> getTournamentTypesForTeams(ContextTO context, SessionIdTO sessionId, List<TeamIdTO> teamIdList) throws GeneralError {
        GetTournamentTypesForTeams getTournamentTypesForTeams = new GetTournamentTypesForTeams();
        getTournamentTypesForTeams.setContext(context);
        getTournamentTypesForTeams.setSessionId(sessionId);
        getTournamentTypesForTeams.setTeamIdList(teamIdList);
        GetTournamentTypesForTeams.Result resultData = (GetTournamentTypesForTeams.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(
                getTournamentTypesForTeams), serviceName);
        return resultData.getTournTypeNameList();
    }

    @Override
    public List<TeamNameTO> getTeamsForTournamentTypes(ContextTO context, SessionIdTO sessionId, List<TournamentTypeIdTO> tournTypeIdList) throws GeneralError {
        GetTeamsForTournamentTypes getTeamsForTournamentTypes = new GetTeamsForTournamentTypes();
        getTeamsForTournamentTypes.setContext(context);
        getTeamsForTournamentTypes.setSessionId(sessionId);
        getTeamsForTournamentTypes.setTournTypeIdList(tournTypeIdList);
        GetTeamsForTournamentTypes.Result resultData = (GetTeamsForTournamentTypes.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(
                getTeamsForTournamentTypes), serviceName);
        return resultData.getTeamNameList();
    }

    @Override
    public SportTO readSport(ContextTO context, SessionIdTO sessionId, SportIdTO sportId) throws GeneralError {
        ReadSport readSport = new ReadSport();
        readSport.setContext(context);
        readSport.setSessionId(sessionId);
        readSport.setSportId(sportId);
        ReadSport.Result resultData = (ReadSport.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(readSport), serviceName);
        return resultData.getSport();
    }

    @Override
    public TournamentTypeTO readTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId) throws GeneralError {
        ReadTournamentType readTournamentType = new ReadTournamentType();
        readTournamentType.setContext(context);
        readTournamentType.setSessionId(sessionId);
        readTournamentType.setTournTypeId(tournTypeId);
        ReadTournamentType.Result resultData = (ReadTournamentType.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(readTournamentType),
                serviceName);
        return resultData.getTournType();
    }

    @Override
    public TeamTO readTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId) throws GeneralError {
        ReadTeam readTeam = new ReadTeam();
        readTeam.setContext(context);
        readTeam.setSessionId(sessionId);
        readTeam.setTeamId(teamId);
        ReadTeam.Result resultData = (ReadTeam.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(readTeam), serviceName);
        return resultData.getTeam();
    }

    @Override
    public SportIdTO createOrUpdateSport(ContextTO context, SessionIdTO sessionId, SportDataTO sportData) throws GeneralError {
        CreateOrUpdateSport createOrUpdateSport = new CreateOrUpdateSport();
        createOrUpdateSport.setContext(context);
        createOrUpdateSport.setSessionId(sessionId);
        createOrUpdateSport.setSportData(sportData);
        CreateOrUpdateSport.Result resultData = (CreateOrUpdateSport.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(createOrUpdateSport),
                serviceName);
        return resultData.getSportId();
    }

    @Override
    public Void deleteSport(ContextTO context, SessionIdTO sessionId, SportIdTO sportId) throws GeneralError {
        DeleteSport deleteSport = new DeleteSport();
        deleteSport.setContext(context);
        deleteSport.setSessionId(sessionId);
        deleteSport.setSportId(sportId);
        transferHandler.doTransfer(new MetaDataAdminInvocation(deleteSport), serviceName);
        return null;
    }

    @Override
    public TournamentTypeIdTO createOrUpdateTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeDataArgumentTO tournTypeData)
            throws GeneralError {
        CreateOrUpdateTournamentType createOrUpdateTournamentType = new CreateOrUpdateTournamentType();
        createOrUpdateTournamentType.setContext(context);
        createOrUpdateTournamentType.setSessionId(sessionId);
        createOrUpdateTournamentType.setTournTypeData(tournTypeData);
        CreateOrUpdateTournamentType.Result resultData = (CreateOrUpdateTournamentType.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(
                createOrUpdateTournamentType), serviceName);
        return resultData.getTournTypeId();
    }

    @Override
    public Void deleteTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId) throws GeneralError {
        DeleteTournamentType deleteTournamentType = new DeleteTournamentType();
        deleteTournamentType.setContext(context);
        deleteTournamentType.setSessionId(sessionId);
        deleteTournamentType.setTournTypeId(tournTypeId);
        transferHandler.doTransfer(new MetaDataAdminInvocation(deleteTournamentType), serviceName);
        return null;
    }

    @Override
    public TeamIdTO createOrUpdateTeam(ContextTO context, SessionIdTO sessionId, TeamDataTO teamData) throws GeneralError {
        CreateOrUpdateTeam createOrUpdateTeam = new CreateOrUpdateTeam();
        createOrUpdateTeam.setContext(context);
        createOrUpdateTeam.setSessionId(sessionId);
        createOrUpdateTeam.setTeamData(teamData);
        CreateOrUpdateTeam.Result resultData = (CreateOrUpdateTeam.Result) transferHandler.doTransfer(new MetaDataAdminInvocation(createOrUpdateTeam),
                serviceName);
        return resultData.getTeamId();
    }

    @Override
    public Void deleteTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId) throws GeneralError {
        DeleteTeam deleteTeam = new DeleteTeam();
        deleteTeam.setContext(context);
        deleteTeam.setSessionId(sessionId);
        deleteTeam.setTeamId(teamId);
        transferHandler.doTransfer(new MetaDataAdminInvocation(deleteTeam), serviceName);
        return null;
    }

    @Override
    public Void addAllowedTournamentTypesToTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId, List<TournamentTypeIdTO> tournTypeIdList)
            throws GeneralError {
        AddAllowedTournamentTypesToTeam addAllowedTournamentTypesToTeam = new AddAllowedTournamentTypesToTeam();
        addAllowedTournamentTypesToTeam.setContext(context);
        addAllowedTournamentTypesToTeam.setSessionId(sessionId);
        addAllowedTournamentTypesToTeam.setTeamId(teamId);
        addAllowedTournamentTypesToTeam.setTournTypeIdList(tournTypeIdList);
        transferHandler.doTransfer(new MetaDataAdminInvocation(addAllowedTournamentTypesToTeam), serviceName);
        return null;
    }

    @Override
    public Void removeAllowedTournamentTypesFromTeam(ContextTO context, SessionIdTO sessionId, TeamIdTO teamId, List<TournamentTypeIdTO> tournTypeIdList)
            throws GeneralError {
        RemoveAllowedTournamentTypesFromTeam removeAllowedTournamentTypesFromTeam = new RemoveAllowedTournamentTypesFromTeam();
        removeAllowedTournamentTypesFromTeam.setContext(context);
        removeAllowedTournamentTypesFromTeam.setSessionId(sessionId);
        removeAllowedTournamentTypesFromTeam.setTeamId(teamId);
        removeAllowedTournamentTypesFromTeam.setTournTypeIdList(tournTypeIdList);
        transferHandler.doTransfer(new MetaDataAdminInvocation(removeAllowedTournamentTypesFromTeam), serviceName);
        return null;
    }

    @Override
    public Void addAllowedTeamsToTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId, List<TeamIdTO> teamIdList)
            throws GeneralError {
        AddAllowedTeamsToTournamentType addAllowedTeamsToTournamentType = new AddAllowedTeamsToTournamentType();
        addAllowedTeamsToTournamentType.setContext(context);
        addAllowedTeamsToTournamentType.setSessionId(sessionId);
        addAllowedTeamsToTournamentType.setTournTypeId(tournTypeId);
        addAllowedTeamsToTournamentType.setTeamIdList(teamIdList);
        transferHandler.doTransfer(new MetaDataAdminInvocation(addAllowedTeamsToTournamentType), serviceName);
        return null;
    }

    @Override
    public Void removeAllowedTeamsFromTournamentType(ContextTO context, SessionIdTO sessionId, TournamentTypeIdTO tournTypeId, List<TeamIdTO> teamIdList)
            throws GeneralError {
        RemoveAllowedTeamsFromTournamentType removeAllowedTeamsFromTournamentType = new RemoveAllowedTeamsFromTournamentType();
        removeAllowedTeamsFromTournamentType.setContext(context);
        removeAllowedTeamsFromTournamentType.setSessionId(sessionId);
        removeAllowedTeamsFromTournamentType.setTournTypeId(tournTypeId);
        removeAllowedTeamsFromTournamentType.setTeamIdList(teamIdList);
        transferHandler.doTransfer(new MetaDataAdminInvocation(removeAllowedTeamsFromTournamentType), serviceName);
        return null;
    }
}
