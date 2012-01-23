package de.tipit.server.transfer.access.meta_data_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.SportDataTO;
import de.tipit.server.transfer.data.SportIdTO;

public class CreateOrUpdateSport implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "sportId")
        private final SportIdTO sportId;

        @Override
        public Object getValue() {
            return sportId;
        }

        public Result(@Element(name = "sportId") SportIdTO sportId) {
            this.sportId = sportId;
        }

        public SportIdTO getSportId() {
            return sportId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private SportDataTO sportData;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateSport(context, sessionId, sportData)));
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

    public SportDataTO getSportData() {
        return sportData;
    }

    public void setSportData(SportDataTO sportData) {
        this.sportData = sportData;
    }
}
