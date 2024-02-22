package org.example.Model;

import java.util.Collections;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private final TreeMap<Integer, Double> terms = new TreeMap<>(Collections.reverseOrder());

    public TreeMap<Integer, Double> getTerms() {
        return terms;
    }
    public Polynomial(){}
    public Polynomial(String s) throws Exception{
        if(!Pattern.matches("(([+-]?)([0-9]*?)(x\\^)([0-9]*))*", s))
            throw new Exception();
        Pattern p = Pattern.compile("([+-]?)([0-9]*?)(x\\^)([0-9]*)");
        Matcher m = p.matcher(s);
        while(m.find()){
            int e;
            double c;
            if(m.group(2).equals(""))
                c=1;
            else
                c = Integer.parseInt(m.group(2));
            if(m.group(1).equals("-"))
                c = -c;
            e = Integer.parseInt(m.group(4));
            this.terms.put(e,c);
        }
    }
    public int degree(){
        if(terms.isEmpty())
            return -1;
        return terms.firstKey();
    }
    public String toString(){
        if(this.terms.isEmpty())
            return "0";
        StringBuilder s = new StringBuilder();
        this.terms.forEach((e,c) -> {
            if(c>0)
                s.append("+");
            if(c!=1) {
                if (c != -1) {
                    if(c == Math.rint(c))
                        s.append(String.format("%.0f",c));
                    else
                        s.append(String.format("%.2f",c));
                    s.append("x^").append(e);
                }
                else
                    s.append("-x^").append(e);
            }
            else
                s.append("x^").append(e);
        });
        if(s.charAt(0)=='+')
            s.delete(0,1);
        return s.toString();
    }
}
