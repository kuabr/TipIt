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
import de.tipit.server.transfer.data.SportTO;

public class ReadSport implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "sport")
        private final SportTO sport;

        @Override
        public Object getValue() {
            return sport;
        }

        public Result(@Element(name = "sport") SportTO sport) {
            this.sport = sport;
        }

        public SportTO getSport() {
            return sport;
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
            return new InvocationResult(new Result(delegate.readSport(context, sessionId, sportId)));
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
