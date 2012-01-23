package de.tipit.server.transfer.access.meta_data_admin;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentTypeDataArgumentTO;
import de.tipit.server.transfer.data.TournamentTypeIdTO;

public class CreateOrUpdateTournamentType implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "tournTypeId")
        private final TournamentTypeIdTO tournTypeId;

        @Override
        public Object getValue() {
            return tournTypeId;
        }

        public Result(@Element(name = "tournTypeId") TournamentTypeIdTO tournTypeId) {
            this.tournTypeId = tournTypeId;
        }

        public TournamentTypeIdTO getTournTypeId() {
            return tournTypeId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentTypeDataArgumentTO tournTypeData;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateTournamentType(context, sessionId, tournTypeData)));
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

    public TournamentTypeDataArgumentTO getTournTypeData() {
        return tournTypeData;
    }

    public void setTournTypeData(TournamentTypeDataArgumentTO tournTypeData) {
        this.tournTypeData = tournTypeData;
    }
}
