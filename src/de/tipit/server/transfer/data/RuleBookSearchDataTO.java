package de.tipit.server.transfer.data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "RuleBookSearchData")
public class RuleBookSearchDataTO extends GeneralSearchData {

    public static class RuleBookPoints {

        @Element(required = false)
        private Integer pointsToAddForCorrectHomeResult;

        @Element(required = false)
        private Integer pointsToAddForCorrectAwayResult;

        @Element(required = false)
        private Integer pointsToAddForCorrectHomeResultInCaseOfCorrectTrend;

        @Element(required = false)
        private Integer pointsToAddForCorrectAwayResultInCaseOfCorrectTrend;

        @Element(required = false)
        private Integer pointsToAddForCorrectResult;

        @Element(required = false)
        private Integer pointsToAddForCorrectDifference;

        @Element(required = false)
        private Integer pointsToAddForCorrectTrend;

        @Element(required = false)
        private Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult;

        @Element(required = false)
        private Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult;

        @Element(required = false)
        private Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference;

        @Element(required = false)
        private Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend;

        @Element(required = false)
        private Integer roundMultiplierForFirstRound;

        @Element(required = false)
        private Integer roundMultiplierAdderPerRound;

        @Element(required = false)
        private Integer roundMultiplierMultiplierPerRound;

        @Element(required = false)
        private Integer pointsPerUserToDistribute;

        @Element(required = false)
        private Integer pointsForCorrectWinnerBet;

        @Element(required = false)
        private Integer pointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers;

        @Element(required = false)
        private Integer pointsForCorrectWinnerBetPer100PointsFromGameBets;

        public Integer getPointsToAddForCorrectHomeResult() {
            return pointsToAddForCorrectHomeResult;
        }

        public void setPointsToAddForCorrectHomeResult(Integer pointsToAddForCorrectHomeResult) {
            this.pointsToAddForCorrectHomeResult = pointsToAddForCorrectHomeResult;
        }

        public Integer getPointsToAddForCorrectAwayResult() {
            return pointsToAddForCorrectAwayResult;
        }

        public void setPointsToAddForCorrectAwayResult(Integer pointsToAddForCorrectAwayResult) {
            this.pointsToAddForCorrectAwayResult = pointsToAddForCorrectAwayResult;
        }

        public Integer getPointsToAddForCorrectHomeResultInCaseOfCorrectTrend() {
            return pointsToAddForCorrectHomeResultInCaseOfCorrectTrend;
        }

        public void setPointsToAddForCorrectHomeResultInCaseOfCorrectTrend(Integer pointsToAddForCorrectHomeResultInCaseOfCorrectTrend) {
            this.pointsToAddForCorrectHomeResultInCaseOfCorrectTrend = pointsToAddForCorrectHomeResultInCaseOfCorrectTrend;
        }

        public Integer getPointsToAddForCorrectAwayResultInCaseOfCorrectTrend() {
            return pointsToAddForCorrectAwayResultInCaseOfCorrectTrend;
        }

        public void setPointsToAddForCorrectAwayResultInCaseOfCorrectTrend(Integer pointsToAddForCorrectAwayResultInCaseOfCorrectTrend) {
            this.pointsToAddForCorrectAwayResultInCaseOfCorrectTrend = pointsToAddForCorrectAwayResultInCaseOfCorrectTrend;
        }

        public Integer getPointsToAddForCorrectResult() {
            return pointsToAddForCorrectResult;
        }

        public void setPointsToAddForCorrectResult(Integer pointsToAddForCorrectResult) {
            this.pointsToAddForCorrectResult = pointsToAddForCorrectResult;
        }

        public Integer getPointsToAddForCorrectDifference() {
            return pointsToAddForCorrectDifference;
        }

        public void setPointsToAddForCorrectDifference(Integer pointsToAddForCorrectDifference) {
            this.pointsToAddForCorrectDifference = pointsToAddForCorrectDifference;
        }

        public Integer getPointsToAddForCorrectTrend() {
            return pointsToAddForCorrectTrend;
        }

        public void setPointsToAddForCorrectTrend(Integer pointsToAddForCorrectTrend) {
            this.pointsToAddForCorrectTrend = pointsToAddForCorrectTrend;
        }

        public Integer getPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult() {
            return pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult;
        }

        public void setPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult(Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult) {
            this.pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult = pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectHomeResult;
        }

        public Integer getPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult() {
            return pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult;
        }

        public void setPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult(Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult) {
            this.pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult = pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectAwayResult;
        }

        public Integer getPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference() {
            return pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference;
        }

        public void setPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference(Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference) {
            this.pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference = pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectDifference;
        }

        public Integer getPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend() {
            return pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend;
        }

        public void setPointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend(Integer pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend) {
            this.pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend = pointsToMultiplyWithAbsDiffBetweenAverageAndCorrectTrend;
        }

        public Integer getRoundMultiplierForFirstRound() {
            return roundMultiplierForFirstRound;
        }

        public void setRoundMultiplierForFirstRound(Integer roundMultiplierForFirstRound) {
            this.roundMultiplierForFirstRound = roundMultiplierForFirstRound;
        }

        public Integer getRoundMultiplierAdderPerRound() {
            return roundMultiplierAdderPerRound;
        }

        public void setRoundMultiplierAdderPerRound(Integer roundMultiplierAdderPerRound) {
            this.roundMultiplierAdderPerRound = roundMultiplierAdderPerRound;
        }

        public Integer getRoundMultiplierMultiplierPerRound() {
            return roundMultiplierMultiplierPerRound;
        }

        public void setRoundMultiplierMultiplierPerRound(Integer roundMultiplierMultiplierPerRound) {
            this.roundMultiplierMultiplierPerRound = roundMultiplierMultiplierPerRound;
        }

        public Integer getPointsPerUserToDistribute() {
            return pointsPerUserToDistribute;
        }

        public void setPointsPerUserToDistribute(Integer pointsPerUserToDistribute) {
            this.pointsPerUserToDistribute = pointsPerUserToDistribute;
        }

        public Integer getPointsForCorrectWinnerBet() {
            return pointsForCorrectWinnerBet;
        }

        public void setPointsForCorrectWinnerBet(Integer pointsForCorrectWinnerBet) {
            this.pointsForCorrectWinnerBet = pointsForCorrectWinnerBet;
        }

        public Integer getPointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers() {
            return pointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers;
        }

        public void setPointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers(Integer pointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers) {
            this.pointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers = pointsForCorrectWinnerBetPer100GamesConsideringRoundMultipliers;
        }

        public Integer getPointsForCorrectWinnerBetPer100PointsFromGameBets() {
            return pointsForCorrectWinnerBetPer100PointsFromGameBets;
        }

        public void setPointsForCorrectWinnerBetPer100PointsFromGameBets(Integer pointsForCorrectWinnerBetPer100PointsFromGameBets) {
            this.pointsForCorrectWinnerBetPer100PointsFromGameBets = pointsForCorrectWinnerBetPer100PointsFromGameBets;
        }
    }

    @Element(required = false)
    private RuleBookPoints minPoints;

    @Element(required = false)
    private RuleBookPoints maxPoints;

    public RuleBookPoints getMinPoints() {
        return minPoints;
    }

    public void setMinPoints(RuleBookPoints minPoints) {
        this.minPoints = minPoints;
    }

    public RuleBookPoints getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(RuleBookPoints maxPoints) {
        this.maxPoints = maxPoints;
    }
}
