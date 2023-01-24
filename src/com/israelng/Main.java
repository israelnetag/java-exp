package com.israelng;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Thing extends Some{

}
class Some implements Comparable<Some>{
    @Override
    public int compareTo(Some o) {
        return 0;
    }
}


class sClass<T> {}
public class Main {
    public static boolean mysteryFunction(int n) { String str = new String(new char[n]); return !str.matches(".?|(..+?)\\1+"); }
    static void foo(sClass<? super A> arg) {}
    static List<String> getHtmlTags (String text){
        List<String> list = new ArrayList<>();
        //String tag = "<\\w++ (\\w++=(?:[^ "]++|"[^"]++")) ( \\1)*>";
        String oopen = "(<[^<>]*>+?)([^<>]*)(</[^<>]*>)?+";
        //String close = ""
        Pattern open = Pattern.compile(oopen);
        //Pattern close = Pattern.compile(close);
        Matcher m = open.matcher(text);
        while(m.find()){
            if (m.group(3) != ""){
                String content = " content=\""+text.substring(m.start(2),m.end(2))+"\"";
                String tag = text.substring(m.start(),m.end(1)-1)+content+">";
                list.add(tag);
            }
            else {
                list.add(m.group(0));
            }

        }
        return list;
    }
    static class MalformedTagException extends RuntimeException{

    }
    static String getLink(String tag) throws MalformedTagException{
        String tagRegex = "<(\\w++) (\\w++=(?:[^ <>\"]++|\"[^<>\"]*+\"))( \\w++=(?:[^ <>\"]++|\"[^<>\"]*+\"))*>([^<>]*)(</\\1>)?+";
        Pattern tagPattern = Pattern.compile(tagRegex);
        if(!tagPattern.matcher(tag).matches())
        {
            throw new MalformedTagException();
        }
        Pattern property = Pattern.compile("href=(([^ <>\"]++)|\"([^<>\"]++)\")");
        Matcher m = property.matcher(tag);
        if(!m.find()){
            return null;}
        //System.out.println(m.group(2));

        if (m.group(2)!=null){
            return m.group(2);
        }
        return m.group(1);


    }
    static class LinkReader extends BufferedReader{
        Pattern p = Pattern.compile("https::/google.com");
        List<String> tagBuffer;
        int index = 0;

        public LinkReader(Reader in) {
            super(in);
        }

        public String readLink() throws Exception{
            Matcher m = null;
            String link = "";
            while (m == null || !m.matches()){
                if (tagBuffer == null){
                    String line = readLine();
                    if (line == null) return null;
                    tagBuffer = getHtmlTags(line);
                }
                link = getLink(tagBuffer.get(index));
                while(link==null){
                    index ++;
                    if (tagBuffer.size() == index){
                        String line = readLine();
                        if (line == null) return null;
                        tagBuffer = getHtmlTags(line);
                        index =0;}
                    link = getLink(tagBuffer.get(index));
                }
              //  System.out.println(link);
                m = p.matcher(link);
                index ++;

            }
            return link;

        }
    }
    public static void main(String[] args) {
        String text = "<a a=a b=\"b b b\">Hello World!</a><bbb><ggg href=https::/google.com><kj k=kk></k>";
        String tag = "<ggg href=\"https::/google.com\">";
    LinkReader reader = new LinkReader(new StringReader(text));
        try {
            System.out.println(reader.readLink());
        } catch (Exception e) {
            e.printStackTrace();
        }





    }


}
 class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;
    public int myMember;

}



/** important things to remember for the exam in oop and java
 * how to implement an iterator:
 * 1. create a class that implements the iterator interface
 * 2. create a constructor that takes a list as a parameter
 * 3. create a private list variable
 * 4. create a private int variable
 * 5. create a hasNext method that returns a boolean
 * 6. create a next method that returns an object
 * 7. create a remove method that returns nothing
 */

/**
 * a shakespearian play
 * hamlet: a tragedy by william shakespear about a prince who seeks revenge for his father's death
 * act 1 scene 1:
 * king claudius: the king of denmark
 * queen gertrude: the queen of denmark
 * hamlet: the prince of denmark
 * polonius: the lord chamberlain
 * horatio: hamlet's friend
 * marcellus: a soldier
 * bernardo: a soldier
 * francisco: a soldier
 * reynaldo: a courtier
 * osric: a courtier
 * guildenstern: a courtier
 *
 *  act 1 scene 2:
 *  king claudius: the king of denmark
 *
 */
 /**  how to use generics in java:
  * 1. create a class that takes a generic type
  * 2. create a constructor that takes a generic type as a parameter
  * 3. create a private generic type variable
  * 4. create a method that takes a generic type as a parameter
  * 5. create a method that returns a generic type
  * 6. create a method that takes a generic type as a parameter and returns a generic type
  * 7. create a method that takes a generic type as a parameter and returns a generic type
  * 8. create a method that takes a generic type as a parameter and returns a generic type
  * code example:
  * public class MyClass<T> {
  *    private T myVariable;
  *    public MyClass(T myVariable){
  *    this.myVariable = myVariable;
  *    }
  *
 *
 *
 */