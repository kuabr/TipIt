package de.tipit.helper;

public class IntentData {

    private static IntentData INSTANCE = new IntentData();

    public static IntentData getInstance() {
        return IntentData.INSTANCE;
    }

    private Object lastData;

    private IntentData() {
        this.lastData = null;
    }

    public synchronized void setNextData(Object data) {
        assert this.lastData == null;
        this.lastData = data;
    }

    public synchronized Object getLastData() {
        Object result = this.lastData;
        this.lastData = null;
        return result;
    }
}
