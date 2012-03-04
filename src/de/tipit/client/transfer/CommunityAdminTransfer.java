package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.CommunityAdmin;
import de.tipit.server.transfer.access.CommunityAdminInvocation;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.community_admin.AddModeratorToBetCommunity;
import de.tipit.server.transfer.access.community_admin.AddModeratorToUserGroup;
import de.tipit.server.transfer.access.community_admin.AddTournamentToBetCommunity;
import de.tipit.server.transfer.access.community_admin.AddUserGroupToBetCommunity;
import de.tipit.server.transfer.access.community_admin.AddUserToUserGroup;
import de.tipit.server.transfer.access.community_admin.CreateOrUpdateBetCommunity;
import de.tipit.server.transfer.access.community_admin.CreateOrUpdateUserGroup;
import de.tipit.server.transfer.access.community_admin.DeleteBetCommunity;
import de.tipit.server.transfer.access.community_admin.DeleteUserGroup;
import de.tipit.server.transfer.access.community_admin.FindBetCommunities;
import de.tipit.server.transfer.access.community_admin.FindUserGroups;
import de.tipit.server.transfer.access.community_admin.GetAllFinalRuleBooks;
import de.tipit.server.transfer.access.community_admin.GetBetCommunitiesForUser;
import de.tipit.server.transfer.access.community_admin.GetBetCommunitiesForUserGroup;
import de.tipit.server.transfer.access.community_admin.GetModeratingBetCommunities;
import de.tipit.server.transfer.access.community_admin.GetModeratingUserGroups;
import de.tipit.server.transfer.access.community_admin.GetParticipatingBetCommunities;
import de.tipit.server.transfer.access.community_admin.GetParticipatingUserGroups;
import de.tipit.server.transfer.access.community_admin.GetUserGroupsForUser;
import de.tipit.server.transfer.access.community_admin.IsBetCommunityModerator;
import de.tipit.server.transfer.access.community_admin.IsUserGroupModerator;
import de.tipit.server.transfer.access.community_admin.JoinUserGroup;
import de.tipit.server.transfer.access.community_admin.LeaveUserGroup;
import de.tipit.server.transfer.access.community_admin.ReadBetCommunity;
import de.tipit.server.transfer.access.community_admin.ReadRuleBook;
import de.tipit.server.transfer.access.community_admin.ReadUserGroup;
import de.tipit.server.transfer.access.community_admin.RemoveModeratorFromBetCommunity;
import de.tipit.server.transfer.access.community_admin.RemoveModeratorFromUserGroup;
import de.tipit.server.transfer.access.community_admin.RemoveTournamentFromBetCommunity;
import de.tipit.server.transfer.access.community_admin.RemoveUserFromUserGroup;
import de.tipit.server.transfer.access.community_admin.RemoveUserGroupFromBetCommunity;
import de.tipit.server.transfer.data.BetCommunityDataArgumentTO;
import de.tipit.server.transfer.data.BetCommunityIdTO;
import de.tipit.server.transfer.data.BetCommunityNameTO;
import de.tipit.server.transfer.data.BetCommunitySearchDataTO;
import de.tipit.server.transfer.data.BetCommunityTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookIdTO;
import de.tipit.server.transfer.data.RuleBookNameTO;
import de.tipit.server.transfer.data.RuleBookTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentIdTO;
import de.tipit.server.transfer.data.UserGroupDataTO;
import de.tipit.server.transfer.data.UserGroupIdTO;
import de.tipit.server.transfer.data.UserGroupNameTO;
import de.tipit.server.transfer.data.UserGroupSearchDataTO;
import de.tipit.server.transfer.data.UserGroupTO;
import de.tipit.server.transfer.data.UserIdTO;

public class CommunityAdminTransfer implements CommunityAdmin {

    private static final String serviceName = "CommunityAdmin";

    private final TransferHandler transferHandler;

    public CommunityAdminTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public List<BetCommunityNameTO> findBetCommunities(ContextTO context, SessionIdTO sessionId, BetCommunitySearchDataTO betCommunitySearchData)
            throws GeneralError {
        FindBetCommunities findBetCommunities = new FindBetCommunities();
        findBetCommunities.setContext(context);
        findBetCommunities.setSessionId(sessionId);
        findBetCommunities.setBetCommunitySearchData(betCommunitySearchData);
        FindBetCommunities.Result resultData = (FindBetCommunities.Result) transferHandler.doTransfer(new CommunityAdminInvocation(findBetCommunities),
                serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public List<BetCommunityNameTO> getBetCommunitiesForUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError {
        GetBetCommunitiesForUserGroup getBetCommunitiesForUserGroup = new GetBetCommunitiesForUserGroup();
        getBetCommunitiesForUserGroup.setContext(context);
        getBetCommunitiesForUserGroup.setSessionId(sessionId);
        getBetCommunitiesForUserGroup.setUserGroupId(userGroupId);
        GetBetCommunitiesForUserGroup.Result resultData = (GetBetCommunitiesForUserGroup.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                getBetCommunitiesForUserGroup), serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public List<BetCommunityNameTO> getBetCommunitiesForUser(ContextTO context, SessionIdTO sessionId, UserIdTO userId) throws GeneralError {
        GetBetCommunitiesForUser getBetCommunitiesForUser = new GetBetCommunitiesForUser();
        getBetCommunitiesForUser.setContext(context);
        getBetCommunitiesForUser.setSessionId(sessionId);
        getBetCommunitiesForUser.setUserId(userId);
        GetBetCommunitiesForUser.Result resultData = (GetBetCommunitiesForUser.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                getBetCommunitiesForUser), serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public List<BetCommunityNameTO> getParticipatingBetCommunities(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetParticipatingBetCommunities getParticipatingBetCommunities = new GetParticipatingBetCommunities();
        getParticipatingBetCommunities.setContext(context);
        getParticipatingBetCommunities.setSessionId(sessionId);
        GetParticipatingBetCommunities.Result resultData = (GetParticipatingBetCommunities.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                getParticipatingBetCommunities), serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public List<BetCommunityNameTO> getModeratingBetCommunities(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetModeratingBetCommunities getModeratingBetCommunities = new GetModeratingBetCommunities();
        getModeratingBetCommunities.setContext(context);
        getModeratingBetCommunities.setSessionId(sessionId);
        GetModeratingBetCommunities.Result resultData = (GetModeratingBetCommunities.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                getModeratingBetCommunities), serviceName);
        return resultData.getBetCommunityNameList();
    }

    @Override
    public Boolean isBetCommunityModerator(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError {
        IsBetCommunityModerator isBetCommunityModerator = new IsBetCommunityModerator();
        isBetCommunityModerator.setContext(context);
        isBetCommunityModerator.setSessionId(sessionId);
        isBetCommunityModerator.setBetCommunityId(betCommunityId);
        IsBetCommunityModerator.Result resultData = (IsBetCommunityModerator.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                isBetCommunityModerator), serviceName);
        return resultData.getIsBetComMod();
    }

    @Override
    public List<UserGroupNameTO> findUserGroups(ContextTO context, SessionIdTO sessionId, UserGroupSearchDataTO userGroupSearchData) throws GeneralError {
        FindUserGroups findUserGroups = new FindUserGroups();
        findUserGroups.setContext(context);
        findUserGroups.setSessionId(sessionId);
        findUserGroups.setUserGroupSearchData(userGroupSearchData);
        FindUserGroups.Result resultData = (FindUserGroups.Result) transferHandler.doTransfer(new CommunityAdminInvocation(findUserGroups), serviceName);
        return resultData.getUserGroupNameList();
    }

    @Override
    public List<UserGroupNameTO> getUserGroupsForUser(ContextTO context, SessionIdTO sessionId, UserIdTO userId) throws GeneralError {
        GetUserGroupsForUser getUserGroupsForUser = new GetUserGroupsForUser();
        getUserGroupsForUser.setContext(context);
        getUserGroupsForUser.setSessionId(sessionId);
        getUserGroupsForUser.setUserId(userId);
        GetUserGroupsForUser.Result resultData = (GetUserGroupsForUser.Result) transferHandler.doTransfer(new CommunityAdminInvocation(getUserGroupsForUser),
                serviceName);
        return resultData.getUserGroupNameList();
    }

    @Override
    public List<UserGroupNameTO> getParticipatingUserGroups(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetParticipatingUserGroups getParticipatingUserGroups = new GetParticipatingUserGroups();
        getParticipatingUserGroups.setContext(context);
        getParticipatingUserGroups.setSessionId(sessionId);
        GetParticipatingUserGroups.Result resultData = (GetParticipatingUserGroups.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                getParticipatingUserGroups), serviceName);
        return resultData.getUserGroupNameList();
    }

    @Override
    public List<UserGroupNameTO> getModeratingUserGroups(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetModeratingUserGroups getModeratingUserGroups = new GetModeratingUserGroups();
        getModeratingUserGroups.setContext(context);
        getModeratingUserGroups.setSessionId(sessionId);
        GetModeratingUserGroups.Result resultData = (GetModeratingUserGroups.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                getModeratingUserGroups), serviceName);
        return resultData.getUserGroupNameList();
    }

    @Override
    public Boolean isUserGroupModerator(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError {
        IsUserGroupModerator isUserGroupModerator = new IsUserGroupModerator();
        isUserGroupModerator.setContext(context);
        isUserGroupModerator.setSessionId(sessionId);
        isUserGroupModerator.setUserGroupId(userGroupId);
        IsUserGroupModerator.Result resultData = (IsUserGroupModerator.Result) transferHandler.doTransfer(new CommunityAdminInvocation(isUserGroupModerator),
                serviceName);
        return resultData.getIsUsrGrpMod();
    }

    @Override
    public List<RuleBookNameTO> getAllFinalRuleBooks(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetAllFinalRuleBooks getAllFinalRuleBooks = new GetAllFinalRuleBooks();
        getAllFinalRuleBooks.setContext(context);
        getAllFinalRuleBooks.setSessionId(sessionId);
        GetAllFinalRuleBooks.Result resultData = (GetAllFinalRuleBooks.Result) transferHandler.doTransfer(new CommunityAdminInvocation(getAllFinalRuleBooks),
                serviceName);
        return resultData.getRuleBookNameList();
    }

    @Override
    public BetCommunityTO readBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError {
        ReadBetCommunity readBetCommunity = new ReadBetCommunity();
        readBetCommunity.setContext(context);
        readBetCommunity.setSessionId(sessionId);
        readBetCommunity.setBetCommunityId(betCommunityId);
        ReadBetCommunity.Result resultData = (ReadBetCommunity.Result) transferHandler.doTransfer(new CommunityAdminInvocation(readBetCommunity), serviceName);
        return resultData.getBetCommunity();
    }

    @Override
    public UserGroupTO readUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError {
        ReadUserGroup readUserGroup = new ReadUserGroup();
        readUserGroup.setContext(context);
        readUserGroup.setSessionId(sessionId);
        readUserGroup.setUserGroupId(userGroupId);
        ReadUserGroup.Result resultData = (ReadUserGroup.Result) transferHandler.doTransfer(new CommunityAdminInvocation(readUserGroup), serviceName);
        return resultData.getUserGroup();
    }

    @Override
    public RuleBookTO readRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId) throws GeneralError {
        ReadRuleBook readRuleBook = new ReadRuleBook();
        readRuleBook.setContext(context);
        readRuleBook.setSessionId(sessionId);
        readRuleBook.setRuleBookId(ruleBookId);
        ReadRuleBook.Result resultData = (ReadRuleBook.Result) transferHandler.doTransfer(new CommunityAdminInvocation(readRuleBook), serviceName);
        return resultData.getRuleBook();
    }

    @Override
    public BetCommunityIdTO createOrUpdateBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityDataArgumentTO betCommunityData)
            throws GeneralError {
        CreateOrUpdateBetCommunity createOrUpdateBetCommunity = new CreateOrUpdateBetCommunity();
        createOrUpdateBetCommunity.setContext(context);
        createOrUpdateBetCommunity.setSessionId(sessionId);
        createOrUpdateBetCommunity.setBetCommunityData(betCommunityData);
        CreateOrUpdateBetCommunity.Result resultData = (CreateOrUpdateBetCommunity.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                createOrUpdateBetCommunity), serviceName);
        return resultData.getBetCommunityId();
    }

    @Override
    public Void deleteBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError {
        DeleteBetCommunity deleteBetCommunity = new DeleteBetCommunity();
        deleteBetCommunity.setContext(context);
        deleteBetCommunity.setSessionId(sessionId);
        deleteBetCommunity.setBetCommunityId(betCommunityId);
        transferHandler.doTransfer(new CommunityAdminInvocation(deleteBetCommunity), serviceName);
        return null;
    }

    @Override
    public Void addUserGroupToBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserGroupIdTO userGroupId)
            throws GeneralError {
        AddUserGroupToBetCommunity addUserGroupToBetCommunity = new AddUserGroupToBetCommunity();
        addUserGroupToBetCommunity.setContext(context);
        addUserGroupToBetCommunity.setSessionId(sessionId);
        addUserGroupToBetCommunity.setBetCommunityId(betCommunityId);
        transferHandler.doTransfer(new CommunityAdminInvocation(addUserGroupToBetCommunity), serviceName);
        return null;
    }

    @Override
    public Void removeUserGroupFromBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserGroupIdTO userGroupId)
            throws GeneralError {
        RemoveUserGroupFromBetCommunity removeUserGroupFromBetCommunity = new RemoveUserGroupFromBetCommunity();
        removeUserGroupFromBetCommunity.setContext(context);
        removeUserGroupFromBetCommunity.setSessionId(sessionId);
        removeUserGroupFromBetCommunity.setBetCommunityId(betCommunityId);
        removeUserGroupFromBetCommunity.setUserGroupId(userGroupId);
        transferHandler.doTransfer(new CommunityAdminInvocation(removeUserGroupFromBetCommunity), serviceName);
        return null;
    }

    @Override
    public Void addTournamentToBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId)
            throws GeneralError {
        AddTournamentToBetCommunity addTournamentToBetCommunity = new AddTournamentToBetCommunity();
        addTournamentToBetCommunity.setContext(context);
        addTournamentToBetCommunity.setSessionId(sessionId);
        addTournamentToBetCommunity.setBetCommunityId(betCommunityId);
        addTournamentToBetCommunity.setTournId(tournId);
        transferHandler.doTransfer(new CommunityAdminInvocation(addTournamentToBetCommunity), serviceName);
        return null;
    }

    @Override
    public Void removeTournamentFromBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId)
            throws GeneralError {
        RemoveTournamentFromBetCommunity removeTournamentFromBetCommunity = new RemoveTournamentFromBetCommunity();
        removeTournamentFromBetCommunity.setContext(context);
        removeTournamentFromBetCommunity.setSessionId(sessionId);
        removeTournamentFromBetCommunity.setBetCommunityId(betCommunityId);
        removeTournamentFromBetCommunity.setTournId(tournId);
        transferHandler.doTransfer(new CommunityAdminInvocation(removeTournamentFromBetCommunity), serviceName);
        return null;
    }

    @Override
    public Void addModeratorToBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserIdTO modId) throws GeneralError {
        AddModeratorToBetCommunity addModeratorToBetCommunity = new AddModeratorToBetCommunity();
        addModeratorToBetCommunity.setContext(context);
        addModeratorToBetCommunity.setSessionId(sessionId);
        addModeratorToBetCommunity.setBetCommunityId(betCommunityId);
        addModeratorToBetCommunity.setModId(modId);
        transferHandler.doTransfer(new CommunityAdminInvocation(addModeratorToBetCommunity), serviceName);
        return null;
    }

    @Override
    public Void removeModeratorFromBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserIdTO modId) throws GeneralError {
        RemoveModeratorFromBetCommunity removeModeratorFromBetCommunity = new RemoveModeratorFromBetCommunity();
        removeModeratorFromBetCommunity.setContext(context);
        removeModeratorFromBetCommunity.setSessionId(sessionId);
        removeModeratorFromBetCommunity.setBetCommunityId(betCommunityId);
        removeModeratorFromBetCommunity.setModId(modId);
        transferHandler.doTransfer(new CommunityAdminInvocation(removeModeratorFromBetCommunity), serviceName);
        return null;
    }

    @Override
    public UserGroupIdTO createOrUpdateUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupDataTO userGroupData) throws GeneralError {
        CreateOrUpdateUserGroup createOrUpdateUserGroup = new CreateOrUpdateUserGroup();
        createOrUpdateUserGroup.setContext(context);
        createOrUpdateUserGroup.setSessionId(sessionId);
        createOrUpdateUserGroup.setUserGroupData(userGroupData);
        CreateOrUpdateUserGroup.Result resultData = (CreateOrUpdateUserGroup.Result) transferHandler.doTransfer(new CommunityAdminInvocation(
                createOrUpdateUserGroup), serviceName);
        return resultData.getUserGroupId();
    }

    @Override
    public Void deleteUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError {
        DeleteUserGroup deleteUserGroup = new DeleteUserGroup();
        deleteUserGroup.setContext(context);
        deleteUserGroup.setSessionId(sessionId);
        deleteUserGroup.setUserGroupId(userGroupId);
        transferHandler.doTransfer(new CommunityAdminInvocation(deleteUserGroup), serviceName);
        return null;
    }

    @Override
    public Void addUserToUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO userId) throws GeneralError {
        AddUserToUserGroup addUserToUserGroup = new AddUserToUserGroup();
        addUserToUserGroup.setContext(context);
        addUserToUserGroup.setSessionId(sessionId);
        addUserToUserGroup.setUserGroupId(userGroupId);
        addUserToUserGroup.setUserId(userId);
        transferHandler.doTransfer(new CommunityAdminInvocation(addUserToUserGroup), serviceName);
        return null;
    }

    @Override
    public Void removeUserFromUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO userId) throws GeneralError {
        RemoveUserFromUserGroup removeUserFromUserGroup = new RemoveUserFromUserGroup();
        removeUserFromUserGroup.setContext(context);
        removeUserFromUserGroup.setSessionId(sessionId);
        removeUserFromUserGroup.setUserGroupId(userGroupId);
        removeUserFromUserGroup.setUserId(userId);
        transferHandler.doTransfer(new CommunityAdminInvocation(removeUserFromUserGroup), serviceName);
        return null;
    }

    @Override
    public Void joinUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError {
        JoinUserGroup joinUserGroup = new JoinUserGroup();
        joinUserGroup.setContext(context);
        joinUserGroup.setSessionId(sessionId);
        joinUserGroup.setUserGroupId(userGroupId);
        transferHandler.doTransfer(new CommunityAdminInvocation(joinUserGroup), serviceName);
        return null;
    }

    @Override
    public Void leaveUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError {
        LeaveUserGroup leaveUserGroup = new LeaveUserGroup();
        leaveUserGroup.setContext(context);
        leaveUserGroup.setSessionId(sessionId);
        leaveUserGroup.setUserGroupId(userGroupId);
        transferHandler.doTransfer(new CommunityAdminInvocation(leaveUserGroup), serviceName);
        return null;
    }

    @Override
    public Void addModeratorToUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO modId) throws GeneralError {
        AddModeratorToUserGroup addModeratorToUserGroup = new AddModeratorToUserGroup();
        addModeratorToUserGroup.setContext(context);
        addModeratorToUserGroup.setSessionId(sessionId);
        addModeratorToUserGroup.setUserGroupId(userGroupId);
        addModeratorToUserGroup.setModId(modId);
        transferHandler.doTransfer(new CommunityAdminInvocation(addModeratorToUserGroup), serviceName);
        return null;
    }

    @Override
    public Void removeModeratorFromUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO modId) throws GeneralError {
        RemoveModeratorFromUserGroup removeModeratorFromUserGroup = new RemoveModeratorFromUserGroup();
        removeModeratorFromUserGroup.setContext(context);
        removeModeratorFromUserGroup.setSessionId(sessionId);
        removeModeratorFromUserGroup.setUserGroupId(userGroupId);
        removeModeratorFromUserGroup.setModId(modId);
        transferHandler.doTransfer(new CommunityAdminInvocation(removeModeratorFromUserGroup), serviceName);
        return null;
    }
}
