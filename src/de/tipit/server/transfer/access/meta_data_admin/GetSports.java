package de.tipit.server.transfer.access.meta_data_admin;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.MetaDataAdmin;
import de.tipit.server.transfer.access.MetaDataAdminTask;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.SportNameTO;

public class GetSports implements MetaDataAdminTask {

    public static class Result implements ResultData {

        @ElementList(required = true, name = "sportNameList")
        private final List<SportNameTO> sportNameList;

        @Override
        public Object getValue() {
            return sportNameList;
        }

        public Result(@ElementList(name = "sportNameList") List<SportNameTO> sportNameList) {
            this.sportNameList = sportNameList;
        }

        public List<SportNameTO> getSportNameList() {
            return sportNameList;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Override
    public InvocationResult execute(MetaDataAdmin delegate) {
        try {
            return new InvocationResult(new Result(delegate.getSports(context, sessionId)));
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
}
