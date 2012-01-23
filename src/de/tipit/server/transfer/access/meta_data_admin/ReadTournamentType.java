package de.tipit.server.transfer.access.meta_data_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentTypeIdTO;
import de.tipit.server.transfer.data.TournamentTypeTO;

public class ReadTournamentType implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "tournType")
        private final TournamentTypeTO tournType;

        @Override
        public Object getValue() {
            return tournType;
        }

        public Result(@Element(name = "tournType") TournamentTypeTO tournType) {
            this.tournType = tournType;
        }

        public TournamentTypeTO getTournType() {
            return tournType;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentTypeIdTO tournTypeId;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.readTournamentType(context, sessionId, tournTypeId)));
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

    public TournamentTypeIdTO getTournTypeId() {
        return tournTypeId;
    }

    public void setTournTypeId(TournamentTypeIdTO tournTypeId) {
        this.tournTypeId = tournTypeId;
    }
}
