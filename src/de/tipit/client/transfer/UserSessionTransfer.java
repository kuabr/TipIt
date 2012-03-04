package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.UserSession;
import de.tipit.server.transfer.access.UserSessionInvocation;
import de.tipit.server.transfer.access.user_session.CreateUser;
import de.tipit.server.transfer.access.user_session.DoLogin;
import de.tipit.server.transfer.access.user_session.DoLoginAsGuest;
import de.tipit.server.transfer.access.user_session.DoLogout;
import de.tipit.server.transfer.access.user_session.FindUsers;
import de.tipit.server.transfer.access.user_session.ReadOwnUser;
import de.tipit.server.transfer.access.user_session.ReadUser;
import de.tipit.server.transfer.access.user_session.RenewSession;
import de.tipit.server.transfer.access.user_session.ResetPassword;
import de.tipit.server.transfer.access.user_session.SetDisabled;
import de.tipit.server.transfer.access.user_session.SetInactive;
import de.tipit.server.transfer.access.user_session.UpdateUser;
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

public class UserSessionTransfer implements UserSession {

    private static final String serviceName = "UserSession";

    private final TransferHandler transferHandler;

    public UserSessionTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public SessionTO renewSession(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        RenewSession renewSession = new RenewSession();
        renewSession.setContext(context);
        renewSession.setSessionId(sessionId);
        RenewSession.Result resultData = (RenewSession.Result) transferHandler.doTransfer(new UserSessionInvocation(renewSession), serviceName);
        return resultData.getSession();
    }

    @Override
    public SessionTO doLogin(ContextTO context, UserAccountTO userAccount, LoginParameterTO loginParameter) throws GeneralError {
        DoLogin doLogin = new DoLogin();
        doLogin.setContext(context);
        doLogin.setUserAccount(userAccount);
        doLogin.setLoginParameter(loginParameter);
        DoLogin.Result resultData = (DoLogin.Result) transferHandler.doTransfer(new UserSessionInvocation(doLogin), serviceName);
        return resultData.getSession();
    }

    @Override
    public SessionTO doLoginAsGuest(ContextTO context) throws GeneralError {
        DoLoginAsGuest doLoginAsGuest = new DoLoginAsGuest();
        doLoginAsGuest.setContext(context);
        DoLoginAsGuest.Result resultData = (DoLoginAsGuest.Result) transferHandler.doTransfer(new UserSessionInvocation(doLoginAsGuest), serviceName);
        return resultData.getSession();
    }

    @Override
    public Void doLogout(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        DoLogout doLogout = new DoLogout();
        doLogout.setContext(context);
        doLogout.setSessionId(sessionId);
        transferHandler.doTransfer(new UserSessionInvocation(doLogout), serviceName);
        return null;
    }

    @Override
    public UserIdTO createUser(ContextTO context, UserDataTO userData) throws GeneralError {
        CreateUser createUser = new CreateUser();
        createUser.setContext(context);
        createUser.setUserData(userData);
        CreateUser.Result resultData = (CreateUser.Result) transferHandler.doTransfer(new UserSessionInvocation(createUser), serviceName);
        return resultData.getUserId();
    }

    @Override
    public Void updateUser(ContextTO context, SessionIdTO sessionId, UserDataTO userData) throws GeneralError {
        UpdateUser updateUser = new UpdateUser();
        updateUser.setContext(context);
        updateUser.setSessionId(sessionId);
        updateUser.setUserData(userData);
        transferHandler.doTransfer(new UserSessionInvocation(updateUser), serviceName);
        return null;
    }

    @Override
    public Void resetPassword(ContextTO context, UserContactTO userContact) throws GeneralError {
        ResetPassword resetPassword = new ResetPassword();
        resetPassword.setContext(context);
        resetPassword.setUserContact(userContact);
        transferHandler.doTransfer(new UserSessionInvocation(resetPassword), serviceName);
        return null;
    }

    @Override
    public List<UserNameTO> findUsers(ContextTO context, SessionIdTO sessionId, UserSearchDataTO userSearchData) throws GeneralError {
        FindUsers findUsers = new FindUsers();
        findUsers.setContext(context);
        findUsers.setSessionId(sessionId);
        findUsers.setUserSearchData(userSearchData);
        FindUsers.Result resultData = (FindUsers.Result) transferHandler.doTransfer(new UserSessionInvocation(findUsers), serviceName);
        return resultData.getUserNameList();
    }

    @Override
    public Void setInactive(ContextTO context, SessionIdTO sessionId, Boolean isInactive) throws GeneralError {
        SetInactive setInactive = new SetInactive();
        setInactive.setContext(context);
        setInactive.setSessionId(sessionId);
        setInactive.setIsInactive(isInactive);
        transferHandler.doTransfer(new UserSessionInvocation(setInactive), serviceName);
        return null;
    }

    @Override
    public Void setDisabled(ContextTO context, SessionIdTO sessionId, UserIdTO userId, Boolean isDisabled) throws GeneralError {
        SetDisabled setDisabled = new SetDisabled();
        setDisabled.setContext(context);
        setDisabled.setSessionId(sessionId);
        setDisabled.setUserId(userId);
        setDisabled.setIsDisabled(isDisabled);
        transferHandler.doTransfer(new UserSessionInvocation(setDisabled), serviceName);
        return null;
    }

    @Override
    public UserTO readOwnUser(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        ReadOwnUser readOwnUser = new ReadOwnUser();
        readOwnUser.setContext(context);
        readOwnUser.setSessionId(sessionId);
        ReadOwnUser.Result resultData = (ReadOwnUser.Result) transferHandler.doTransfer(new UserSessionInvocation(readOwnUser), serviceName);
        return resultData.getUser();
    }

    @Override
    public UserTO readUser(ContextTO context, SessionIdTO sessionId, UserIdTO userId) throws GeneralError {
        ReadUser readUser = new ReadUser();
        readUser.setContext(context);
        readUser.setSessionId(sessionId);
        readUser.setUserId(userId);
        ReadUser.Result resultData = (ReadUser.Result) transferHandler.doTransfer(new UserSessionInvocation(readUser), serviceName);
        return resultData.getUser();
    }
}
