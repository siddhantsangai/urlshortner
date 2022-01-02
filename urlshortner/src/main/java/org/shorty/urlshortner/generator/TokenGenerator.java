package org.shorty.urlshortner.generator;

import org.shorty.urlshortner.model.TokenRange;

public class TokenGenerator {
    private long currentCounter;
    private long offset;

    public void setCurrentCounter(long currentCounter) {
        this.currentCounter = currentCounter;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public synchronized TokenRange getTokenBound(){
        TokenRange current=new TokenRange(currentCounter, currentCounter+offset);
        currentCounter=currentCounter+offset+1;
        return current;
    }
}
