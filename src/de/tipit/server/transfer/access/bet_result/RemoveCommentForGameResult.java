package de.tipit.server.transfer.access.bet_result;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.BetResult;
import de.tipit.server.transfer.access.BetResultTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.CommentIdTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class RemoveCommentForGameResult implements BetResultTask {

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
    private CommentIdTO commentId;

    @Override
    public InvocationResult execute(BetResult delegate) {
        try {
            return new InvocationResult(new Result(delegate.removeCommentForGameResult(context, sessionId, commentId)));
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

    public CommentIdTO getCommentId() {
        return commentId;
    }

    public void setCommentId(CommentIdTO commentId) {
        this.commentId = commentId;
    }
}
