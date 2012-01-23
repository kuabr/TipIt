package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "BetCommunityDataArgument")
public class BetCommunityDataArgumentTO extends BetCommunityDataBaseTO {

    @Element(required = false)
    private RuleBookIdTO ruleBookId;

    public RuleBookIdTO getRuleBookId() {
        return ruleBookId;
    }

    public void setRuleBookId(RuleBookIdTO ruleBookId) {
        this.ruleBookId = ruleBookId;
    }
}
