package de.tipit.client.transfer;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.ResultData;

public interface TransferHandler {

    ResultData doTransfer(final Object invocationObject, final String serviceName) throws GeneralError;
}
