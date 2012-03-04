package de.tipit.server.transfer.access;

import de.tipit.server.transfer.data.ContextTO;

public class GeneralError extends Exception {

    private static final long serialVersionUID = 5637147660763900442L;

    private static String calcMessage(ContextTO context, String messageDE, String messageEN) {
        if (context != null) {
            if (context.getLanguage() == ContextTO.Language.DE) {
                return messageDE;
            }

            if (context.getLanguage() == ContextTO.Language.EN) {
                return messageEN;
            }
        }

        return "";
    }

    public GeneralError(ContextTO context, String messageDE, String messageEN) {
        super(calcMessage(context, messageDE, messageEN));
    }

    public GeneralError(String message) {
        super(message);
    }

    @Override
    public String getLocalizedMessage() {
        return super.getMessage(); // localized message is already set ;-)
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
