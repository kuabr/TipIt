package de.tipit.server.transfer.access.bet_result;

import org.simpleframework.xml.Element;

import de.tipit.server.transfer.access.BetResult;
import de.tipit.server.transfer.access.BetResultTask;
import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.InvocationResult;
import de.tipit.server.transfer.access.ResultData;
import de.tipit.server.transfer.data.CommentDataTO;
import de.tipit.server.transfer.data.CommentIdTO;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.SessionIdTO;
import de.tipit.server.transfer.data.TournamentIdTO;

public class CreateOrUpdateCommentForWinnerTeam implements BetResultTask {

    public static class Result implements ResultData {

        @Element(required = true, name = "commentId")
        private final CommentIdTO commentId;

        @Override
        public Object getValue() {
            return commentId;
        }

        public Result(@Element(name = "commentId") CommentIdTO commentId) {
            this.commentId = commentId;
        }

        public CommentIdTO getCommentId() {
            return commentId;
        }
    }

    @Element(required = true)
    private ContextTO context;

    @Element(required = true)
    private SessionIdTO sessionId;

    @Element(required = true)
    private TournamentIdTO tournId;

    @Element(required = true)
    private CommentDataTO commentData;

    @Override
    public InvocationResult execute(BetResult delegate) {
        try {
            return new InvocationResult(new Result(delegate.createOrUpdateCommentForWinnerTeam(context, sessionId, tournId, commentData)));
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

    public TournamentIdTO getTournId() {
        return tournId;
    }

    public void setTournId(TournamentIdTO tournId) {
        this.tournId = tournId;
    }

    public CommentDataTO getCommentData() {
        return commentData;
    }

    public void setCommentData(CommentDataTO commentData) {
        this.commentData = commentData;
    }
}
