package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "TeamSearchData")
public class TeamSearchDataTO extends GeneralSearchData {

    @Element(required = false)
    private Boolean searchInAbbreviations;

    @Element(required = false)
    private Boolean searchInNames;

    public Boolean getSearchInAbbreviations() {
        return searchInAbbreviations;
    }

    public void setSearchInAbbreviations(Boolean searchInAbbreviations) {
        this.searchInAbbreviations = searchInAbbreviations;
    }

    public Boolean getSearchInNames() {
        return searchInNames;
    }

    public void setSearchInNames(Boolean searchInNames) {
        this.searchInNames = searchInNames;
    }
}
