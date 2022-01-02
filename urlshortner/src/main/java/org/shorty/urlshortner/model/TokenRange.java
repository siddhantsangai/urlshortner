package org.shorty.urlshortner.model;

public class TokenRange {
    private long lowerBound;
    private long upperBound;
    private long currentPointer;

    public TokenRange(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.currentPointer = lowerBound;
    }

    public long getLowerBound() {
        return lowerBound;
    }

    public long getUpperBound() {
        return upperBound;
    }

    public long getCurrentPointer() { return currentPointer; }

    public void setCurrentPointer(long id) { this.currentPointer=id; }

}
