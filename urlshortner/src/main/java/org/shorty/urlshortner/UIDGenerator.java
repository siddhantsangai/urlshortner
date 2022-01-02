package org.shorty.urlshortner;

public class UIDGenerator {

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(10));
        System.out.println(generate(61));
        System.out.println(generate(62));
        System.out.println(generate(63));
        System.out.println(generate(130));
        System.out.println(generate(10000));
    }

    public static String generate(long id){

        char[] dictionary={'R','S','T','U', 'a','b','h','i','j','k','l','c'
                ,'d','e','f','g', 'm','n','o','p', 'H','I','J','K','L','4'
                ,'5','G','M','N','O','P','q','r','s','t','u','v','w','x','y'
                ,'z', '6','7','8','9','A','B','C','D','E','F', '0','1','2'
                ,'3', 'Q','V','W','X','Y','Z'};

        StringBuilder sb=new StringBuilder();
        while(id>0){
            long div=id/62;
            int rem=(int) id%62;
            sb.append(dictionary[rem]);
            id=div;
        }
        return sb.toString();
    }

}
