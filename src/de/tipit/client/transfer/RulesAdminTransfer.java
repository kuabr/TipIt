package de.tipit.client.transfer;

import java.util.List;

import de.tipit.server.transfer.access.GeneralError;
import de.tipit.server.transfer.access.RulesAdmin;
import de.tipit.server.transfer.access.RulesAdminInvocation;
import de.tipit.server.transfer.access.rules_admin.CalculatePointsForNewRuleBook;
import de.tipit.server.transfer.access.rules_admin.CalculatePointsForStoredRuleBook;
import de.tipit.server.transfer.access.rules_admin.CreateOrUpdateRuleBook;
import de.tipit.server.transfer.access.rules_admin.DeleteRuleBook;
import de.tipit.server.transfer.access.rules_admin.FindRuleBooks;
import de.tipit.server.transfer.access.rules_admin.GetNotFinalRuleBooks;
import de.tipit.server.transfer.access.rules_admin.GetOwnRuleBooks;
import de.tipit.server.transfer.access.rules_admin.ReadRuleBook;
import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookDataTO;
import de.tipit.server.transfer.data.RuleBookIdTO;
import de.tipit.server.transfer.data.RuleBookNameTO;
import de.tipit.server.transfer.data.RuleBookSearchDataTO;
import de.tipit.server.transfer.data.RuleBookTO;
import de.tipit.server.transfer.data.SessionIdTO;

public class RulesAdminTransfer implements RulesAdmin {

    private static final String serviceName = "RulesAdmin";

    private final TransferHandler transferHandler;

    public RulesAdminTransfer(final TransferHandler transferHandler) {
        this.transferHandler = transferHandler;
    }

    @Override
    public List<RuleBookNameTO> findRuleBooks(ContextTO context, SessionIdTO sessionId, RuleBookSearchDataTO ruleBookSearchData) throws GeneralError {
        FindRuleBooks findRuleBooks = new FindRuleBooks();
        findRuleBooks.setContext(context);
        findRuleBooks.setSessionId(sessionId);
        findRuleBooks.setRuleBookSearchData(ruleBookSearchData);
        FindRuleBooks.Result resultData = (FindRuleBooks.Result) transferHandler.doTransfer(new RulesAdminInvocation(findRuleBooks), serviceName);
        return resultData.getRuleBookNameList();
    }

    @Override
    public List<RuleBookNameTO> getNotFinalRuleBooks(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetNotFinalRuleBooks getNotFinalRuleBooks = new GetNotFinalRuleBooks();
        getNotFinalRuleBooks.setContext(context);
        getNotFinalRuleBooks.setSessionId(sessionId);
        GetNotFinalRuleBooks.Result resultData = (GetNotFinalRuleBooks.Result) transferHandler.doTransfer(new RulesAdminInvocation(getNotFinalRuleBooks),
                serviceName);
        return resultData.getRuleBookNameList();
    }

    @Override
    public List<RuleBookNameTO> getOwnRuleBooks(ContextTO context, SessionIdTO sessionId) throws GeneralError {
        GetOwnRuleBooks getOwnRuleBooks = new GetOwnRuleBooks();
        getOwnRuleBooks.setContext(context);
        getOwnRuleBooks.setSessionId(sessionId);
        GetOwnRuleBooks.Result resultData = (GetOwnRuleBooks.Result) transferHandler.doTransfer(new RulesAdminInvocation(getOwnRuleBooks), serviceName);
        return resultData.getRuleBookNameList();
    }

    @Override
    public RuleBookTO readRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId) throws GeneralError {
        ReadRuleBook readRuleBook = new ReadRuleBook();
        readRuleBook.setContext(context);
        readRuleBook.setSessionId(sessionId);
        readRuleBook.setRuleBookId(ruleBookId);
        ReadRuleBook.Result resultData = (ReadRuleBook.Result) transferHandler.doTransfer(new RulesAdminInvocation(readRuleBook), serviceName);
        return resultData.getRuleBook();
    }

    @Override
    public Integer calculatePointsForStoredRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId, Integer homeResult, Integer awayResult,
            Integer averageHomeResultBet, Integer averageAwayResultBet, Integer homeResultBet, Integer awayResultBet) throws GeneralError {
        CalculatePointsForStoredRuleBook calculatePointsForStoredRuleBook = new CalculatePointsForStoredRuleBook();
        calculatePointsForStoredRuleBook.setContext(context);
        calculatePointsForStoredRuleBook.setSessionId(sessionId);
        calculatePointsForStoredRuleBook.setRuleBookId(ruleBookId);
        calculatePointsForStoredRuleBook.setHomeResult(homeResult);
        calculatePointsForStoredRuleBook.setAwayResult(awayResult);
        calculatePointsForStoredRuleBook.setAverageHomeResultBet(averageHomeResultBet);
        calculatePointsForStoredRuleBook.setAverageAwayResultBet(averageAwayResultBet);
        calculatePointsForStoredRuleBook.setHomeResultBet(homeResultBet);
        calculatePointsForStoredRuleBook.setAwayResultBet(awayResultBet);
        CalculatePointsForStoredRuleBook.Result resultData = (CalculatePointsForStoredRuleBook.Result) transferHandler.doTransfer(new RulesAdminInvocation(
                calculatePointsForStoredRuleBook), serviceName);
        return resultData.getPoints();
    }

    @Override
    public Integer calculatePointsForNewRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookDataTO ruleBookData, Integer homeResult, Integer awayResult,
            Integer averageHomeResultBet, Integer averageAwayResultBet, Integer homeResultBet, Integer awayResultBet) throws GeneralError {
        CalculatePointsForNewRuleBook calculatePointsForNewRuleBook = new CalculatePointsForNewRuleBook();
        calculatePointsForNewRuleBook.setContext(context);
        calculatePointsForNewRuleBook.setSessionId(sessionId);
        calculatePointsForNewRuleBook.setRuleBookData(ruleBookData);
        calculatePointsForNewRuleBook.setHomeResult(homeResult);
        calculatePointsForNewRuleBook.setAwayResult(awayResult);
        calculatePointsForNewRuleBook.setAverageHomeResultBet(averageHomeResultBet);
        calculatePointsForNewRuleBook.setAverageAwayResultBet(averageAwayResultBet);
        calculatePointsForNewRuleBook.setHomeResultBet(homeResultBet);
        calculatePointsForNewRuleBook.setAwayResultBet(awayResultBet);
        CalculatePointsForNewRuleBook.Result resultData = (CalculatePointsForNewRuleBook.Result) transferHandler.doTransfer(new RulesAdminInvocation(
                calculatePointsForNewRuleBook), serviceName);
        return resultData.getPoints();
    }

    @Override
    public RuleBookIdTO createOrUpdateRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookDataTO ruleBookData) throws GeneralError {
        CreateOrUpdateRuleBook createOrUpdateRuleBook = new CreateOrUpdateRuleBook();
        createOrUpdateRuleBook.setContext(context);
        createOrUpdateRuleBook.setSessionId(sessionId);
        createOrUpdateRuleBook.setRuleBookData(ruleBookData);
        CreateOrUpdateRuleBook.Result resultData = (CreateOrUpdateRuleBook.Result) transferHandler.doTransfer(new RulesAdminInvocation(createOrUpdateRuleBook),
                serviceName);
        return resultData.getRuleBookId();
    }

    @Override
    public Void deleteRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId) throws GeneralError {
        DeleteRuleBook deleteRuleBook = new DeleteRuleBook();
        deleteRuleBook.setContext(context);
        deleteRuleBook.setSessionId(sessionId);
        deleteRuleBook.setRuleBookId(ruleBookId);
        transferHandler.doTransfer(new RulesAdminInvocation(deleteRuleBook), serviceName);
        return null;
    }
}
