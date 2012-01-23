package de.tipit.server.transfer.access;

import java.util.List;

import de.tipit.server.transfer.data.ContextTO;
import de.tipit.server.transfer.data.RuleBookDataTO;
import de.tipit.server.transfer.data.RuleBookIdTO;
import de.tipit.server.transfer.data.RuleBookNameTO;
import de.tipit.server.transfer.data.RuleBookSearchDataTO;
import de.tipit.server.transfer.data.RuleBookTO;
import de.tipit.server.transfer.data.SessionIdTO;

public interface RulesAdmin {

    List<RuleBookNameTO> findRuleBooks(ContextTO context, SessionIdTO sessionId, RuleBookSearchDataTO ruleBookSearchData) throws GeneralError;

    List<RuleBookNameTO> getNotFinalRuleBooks(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    List<RuleBookNameTO> getOwnRuleBooks(ContextTO context, SessionIdTO sessionId) throws GeneralError;

    RuleBookTO readRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId) throws GeneralError;

    Integer calculatePointsForStoredRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId, Integer homeResult, Integer awayResult,
            Integer averageHomeResultBet, Integer averageAwayResultBet, Integer homeResultBet, Integer awayResultBet) throws GeneralError;

    Integer calculatePointsForNewRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookDataTO ruleBookData, Integer homeResult, Integer awayResult,
            Integer averageHomeResultBet, Integer averageAwayResultBet, Integer homeResultBet, Integer awayResultBet) throws GeneralError;

    RuleBookIdTO createOrUpdateRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookDataTO ruleBookData) throws GeneralError;

    Void deleteRuleBook(ContextTO context, SessionIdTO sessionId, RuleBookIdTO ruleBookId) throws GeneralError;
}
