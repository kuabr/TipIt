package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "BetCommunityDataResult")
public class BetCommunityDataResultTO extends BetCommunityDataBaseTO {

    @Element(required = false)
    private RuleBookNameTO ruleBookName;

    public RuleBookNameTO getRuleBookName() {
        return ruleBookName;
    }

    public void setRuleBookName(RuleBookNameTO ruleBookName) {
        this.ruleBookName = ruleBookName;
    }
}
