package de.tipit.server.transfer.access.meta_data_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.SportIdTO;

public class DeleteSport implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @Element(required = false)
        Void none;

        @Override
        public Object getValue() {
            return none;
        }

        public Result(Void none) {
            this.none = none;
        }

        public Result() {
            this.none = null;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private SportIdTO sportId;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.deleteSport(context, sessionId, sportId)));
        } catch (GeneralError exc) {
            return new InvocationResult(exc);
        } catch (RuntimeException exc) {
            return new InvocationResult(exc);
        }
    }

    public ContextTO getContext() {
        return context;
    }

    public void setContext(ContextTO context) {
        this.context = context;
    }

    public SessionIdTO getSessionId() {
        return sessionId;
    }

    public void setSessionId(SessionIdTO sessionId) {
        this.sessionId = sessionId;
    }

    public SportIdTO getSportId() {
        return sportId;
    }

    public void setSportId(SportIdTO sportId) {
        this.sportId = sportId;
    }
}
