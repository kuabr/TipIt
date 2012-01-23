package de.tipit.server.transfer.access;

import java.util.List;

import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.LoginParameterTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.SessionTO;
import de.tipit.server.transfer.data.UserAccountTO;
import de.tipit.server.transfer.data.UserContactTO;
import de.tipit.server.transfer.data.UserDataTO;
import de.tipit.server.transfer.data.UserIdTO;
import de.tipit.server.transfer.data.UserNameTO;
import de.tipit.server.transfer.data.UserSearchDataTO;
import de.tipit.server.transfer.data.UserTO;

public interface UserSession {

    SessionTO renewSession(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    SessionTO doLogin(ContextTO context, UserAccountTO userAccount, LoginParameterTO loginParameter) throws GeneralError;

    SessionTO doLoginAsGuest(ContextTO context) throws GeneralError;

    Void doLogout(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    UserIdTO createUser(ContextTO context, UserDataTO userData) throws GeneralError;

    Void updateUser(ContextTO context, SessionIdTO sessionId, UserDataTO userData) throws GeneralError;

    Void resetPassword(ContextTO context, UserContactTO userContact) throws GeneralError;

    List<UserNameTO> findUsers(ContextTO context, SessionIdTO sessionId, UserSearchDataTO userSearchData) throws GeneralError;

    Void setInactive(ContextTO context, SessionIdTO sessionId, Boolean isInactive) throws GeneralError;

    Void setDisabled(ContextTO context, SessionIdTO sessionId, UserIdTO userId, Boolean isDisabled) throws GeneralError;

    UserTO readOwnUser(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    UserTO readUser(ContextTO context, SessionIdTO sessionId, UserIdTO userId) throws GeneralError;
}
