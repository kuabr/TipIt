package de.tipit.server.transfer.access;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import de.tipit.server.transfer.data.ErrorTO;

@Root(name = "result")
public class InvocationResult {

    @Element(required = false)
    ErrorTO error;

    @Element(required = false)
    ResultData data;

    public InvocationResult() {
        this.error = null;
        this.data = null;
    }

    public InvocationResult(GeneralError error) {
        this.error = new ErrorTO();
        this.error.setType(error.getClass().getName());
        this.error.setDisplayMessage(error.getLocalizedMessage());
        this.data = null;
    }

    public InvocationResult(Throwable exc) {
        this.error = new ErrorTO();
        this.error.setType(exc.getClass().getName());
        this.error.setDisplayMessage("SYSTEM [" + exc.getMessage() + "]");
        this.data = null;
    }

    public InvocationResult(ResultData data) {
        this.error = null;
        this.data = data;
    }

    public ErrorTO getError() {
        return error;
    }

    public void setError(ErrorTO error) {
        this.error = error;
    }

    public ResultData getData() {
        return data;
    }

    public void setData(ResultData data) {
        this.data = data;
    }
}
