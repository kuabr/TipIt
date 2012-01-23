package de.tipit.server.transfer.access;

import java.util.List;

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

public interface CommunityAdmin {

    List<BetCommunityNameTO> findBetCommunities(ContextTO context, SessionIdTO sessionId, BetCommunitySearchDataTO betCommunitySearchData) throws GeneralError;

    List<BetCommunityNameTO> getBetCommunitiesForUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError;

    List<BetCommunityNameTO> getBetCommunitiesForUser(ContextTO context, SessionIdTO sessionId, UserIdTO userId) throws GeneralError;

    List<BetCommunityNameTO> getParticipatingBetCommunities(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<BetCommunityNameTO> getModeratingBetCommunities(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    Boolean isBetCommunityModerator(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError;

    List<UserGroupNameTO> findUserGroups(ContextTO context, SessionIdTO sessionId, UserGroupSearchDataTO userGroupSearchData) throws GeneralError;

    List<UserGroupNameTO> getUserGroupsForUser(ContextTO context, SessionIdTO sessionId, UserIdTO userId) throws GeneralError;

    List<UserGroupNameTO> getParticipatingUserGroups(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<UserGroupNameTO> getModeratingUserGroups(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    Boolean isUserGroupModerator(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError;

    List<RuleBookNameTO> getAllFinalRuleBooks(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    BetCommunityTO readBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError;

    UserGroupTO readUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError;

    RuleBookTO readRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId) throws GeneralError;

    BetCommunityIdTO createOrUpdateBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityDataArgumentTO betCommunityData) throws GeneralError;

    Void deleteBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId) throws GeneralError;

    Void addUserGroupToBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserGroupIdTO userGroupId) throws GeneralError;

    Void removeUserGroupFromBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserGroupIdTO userGroupId)
            throws GeneralError;

    Void addTournamentToBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId) throws GeneralError;

    Void removeTournamentFromBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, TournamentIdTO tournId)
            throws GeneralError;

    Void addModeratorToBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserIdTO modId) throws GeneralError;

    Void removeModeratorFromBetCommunity(ContextTO context, SessionIdTO sessionId, BetCommunityIdTO betCommunityId, UserIdTO modId) throws GeneralError;

    UserGroupIdTO createOrUpdateUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupDataTO userGroupData) throws GeneralError;

    Void deleteUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError;

    Void addUserToUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO userId) throws GeneralError;

    Void removeUserFromUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO userId) throws GeneralError;

    Void joinUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError;

    Void leaveUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId) throws GeneralError;

    Void addModeratorToUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO modId) throws GeneralError;

    Void removeModeratorFromUserGroup(ContextTO context, SessionIdTO sessionId, UserGroupIdTO userGroupId, UserIdTO modId) throws GeneralError;
}
