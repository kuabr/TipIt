package de.tipit.helper;

import de.tipit.client.transfer.AnalysisTransfer;
import de.tipit.client.transfer.BetResultTransfer;
import de.tipit.client.transfer.CommunityAdminTransfer;
import de.tipit.client.transfer.HttpTransferHandler;
import de.tipit.client.transfer.MetaDataAdminTransfer;
import de.tipit.client.transfer.RulesAdminTransfer;
import de.tipit.client.transfer.TournamentAdminTransfer;
import de.tipit.client.transfer.TransferHandler;
import de.tipit.client.transfer.UserSessionTransfer;

public class Transfer {

    private static final String DEFAULT_HTTP_ADDRESS = "localhost";

    private static final int DEFAULT_PORT = 8080;

    private static Transfer INSTANCE = null;

    private final AnalysisTransfer analysisTransfer;

    private final BetResultTransfer betResultTransfer;

    private final CommunityAdminTransfer communityAdminTransfer;

    private final MetaDataAdminTransfer metaDataAdminTransfer;

    private final RulesAdminTransfer rulesAdminTransfer;

    private final TournamentAdminTransfer tournamentAdminTransfer;

    private final UserSessionTransfer userSessionTransfer;

    public static synchronized void setInstance(String httpAddress, int port) {
        Transfer.INSTANCE = new Transfer(httpAddress, port);
    }

    public static synchronized Transfer getInstance() {
        if (Transfer.INSTANCE != null) {
            return Transfer.INSTANCE;
        } else {
            return new Transfer(DEFAULT_HTTP_ADDRESS, DEFAULT_PORT);
        }
    }

    private Transfer(String httpAddress, int port) {
        TransferHandler transferHandler = new HttpTransferHandler(httpAddress, port);

        analysisTransfer = new AnalysisTransfer(transferHandler);
        betResultTransfer = new BetResultTransfer(transferHandler);
        communityAdminTransfer = new CommunityAdminTransfer(transferHandler);
        metaDataAdminTransfer = new MetaDataAdminTransfer(transferHandler);
        rulesAdminTransfer = new RulesAdminTransfer(transferHandler);
        tournamentAdminTransfer = new TournamentAdminTransfer(transferHandler);
        userSessionTransfer = new UserSessionTransfer(transferHandler);
    }

    public AnalysisTransfer getAnalysisTransfer() {
        return analysisTransfer;
    }

    public BetResultTransfer getBetResultTransfer() {
        return betResultTransfer;
    }

    public CommunityAdminTransfer getCommunityAdminTransfer() {
        return communityAdminTransfer;
    }

    public MetaDataAdminTransfer getMetaDataAdminTransfer() {
        return metaDataAdminTransfer;
    }

    public RulesAdminTransfer getRulesAdminTransfer() {
        return rulesAdminTransfer;
    }

    public TournamentAdminTransfer getTournamentAdminTransfer() {
        return tournamentAdminTransfer;
    }

    public UserSessionTransfer getUserSessionTransfer() {
        return userSessionTransfer;
    }
}
