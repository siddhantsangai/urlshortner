package org.shorty.urlshortner.generator;

import org.shorty.urlshortner.model.ShortURLEntity;
import org.shorty.urlshortner.model.TokenRange;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class UIDGenerator {
    private final TokenGenerator tokenGenerator;
    private TokenRange tokenRange;

    public UIDGenerator(TokenGenerator tokenGenerator) {
        this.tokenGenerator = tokenGenerator;
        this.tokenRange=tokenGenerator.getTokenBound();
    }

    final static Character[] dictionary={'R','S','T','U', 'a','b','h','i','j','k','l','c'
            ,'d','e','f','g', 'm','n','o','p', 'H','I','J','K','L','4'
            ,'5','G','M','N','O','P','q','r','s','t','u','v','w','x','y'
            ,'z', '6','7','8','9','A','B','C','D','E','F', '0','1','2'
            ,'3', 'Q','V','W','X','Y','Z'};

    final static Map<Character, Integer> revDictionary=new HashMap<>();

    static {
        IntStream.range(0,62).forEach(i -> revDictionary.put(dictionary[i],i));
    }

    public ShortURLEntity generate(){
        long id;
        if(tokenRange.getCurrentPointer() < tokenRange.getUpperBound()) {
            id=tokenRange.getCurrentPointer();
            tokenRange.setCurrentPointer(id+1);
        }
        else{
            id=tokenRange.getCurrentPointer();
            tokenRange=tokenGenerator.getTokenBound();
        }
        long tempid=id;
        StringBuilder sb=new StringBuilder();
        while(tempid>0){
            long div=tempid/62;
            int rem=(int) tempid%62;
            sb.append(dictionary[rem]);
            tempid=div;
        }
        return new ShortURLEntity(sb.toString(),id);
    }

    public long reverse(String uid){
        int len=uid.length();
        long dbId=0;
        for(int i=0; i<len; i++){
            char a=uid.charAt(i);
            double multiple=Math.pow(62,i);
            int pos=revDictionary.get(a);
            dbId= (long) (dbId+(multiple*pos));
        }
        return dbId;
    }
}
