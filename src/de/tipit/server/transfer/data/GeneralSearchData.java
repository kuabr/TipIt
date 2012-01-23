package de.tipit.server.transfer.data;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "GeneralSearchData")
public class GeneralSearchData {

    @Attribute(required = false)
    Integer maxNrOfResults;

    @Element(required = false)
    String searchText;

    public Integer getMaxNrOfResults() {
        return maxNrOfResults;
    }

    public void setMaxNrOfResults(Integer maxNrOfResults) {
        this.maxNrOfResults = maxNrOfResults;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
