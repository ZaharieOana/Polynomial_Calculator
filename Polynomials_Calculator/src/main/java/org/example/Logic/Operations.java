package org.example.Logic;

import org.example.Model.Polynomial;

public class Operations {
    private Polynomial p1;
    private Polynomial p2;

    public void setP1(Polynomial p1) {this.p1 = p1;}

    public void setP(Polynomial p1, Polynomial p2) {this.p1 = p1; this.p2 = p2;}

    public Polynomial pAdd(){
        Polynomial rez = new Polynomial();
        p1.getTerms().forEach((e,c) -> {
            if(p2.getTerms().containsKey(e)) {
                double x = c+p2.getTerms().get(e);
                if(x != 0)
                    rez.getTerms().put(e, x);
            }
            else
                rez.getTerms().put(e, c);
        });
        p2.getTerms().forEach((e,c) -> {
            if(!p1.getTerms().containsKey(e))
                rez.getTerms().put(e, c);
        });
        return rez;
    }
    public Polynomial pSub(){
        Polynomial rez = new Polynomial();
        p1.getTerms().forEach((e,c) -> {
            if(p2.getTerms().containsKey(e)){
                double x = c-p2.getTerms().get(e);
                if(x!=0)
                    rez.getTerms().put(e, x);
            }
            else
                rez.getTerms().put(e, c);
        });
        p2.getTerms().forEach((e,c) -> {
            if(!p1.getTerms().containsKey(e))
                rez.getTerms().put(e, -c);
        });
        return rez;
    }
    public Polynomial pMul(){
        Polynomial rez = new Polynomial();
        p1.getTerms().forEach((e1,c1) -> p2.getTerms().forEach((e2, c2)-> {
            if(rez.getTerms().containsKey(e1+e2)) {
                double x = rez.getTerms().get(e1+e2) + c1 * c2;
                if(x==0)
                    rez.getTerms().remove(e1+e2);
                else
                    rez.getTerms().compute(e1 + e2, (k, v) -> x);
            }
            else
                rez.getTerms().put(e1+e2, c1*c2);
        }));
        return rez;
    }
    public Polynomial pDiv(boolean ok){
        Polynomial div = new Polynomial();
        Polynomial q = new Polynomial();
        Operations o = new Operations();
        while(p1.degree()>=p2.degree()){
            q.getTerms().clear();
            q.getTerms().put(p1.degree()-p2.degree(), p1.getTerms().firstEntry().getValue()/ p2.getTerms().firstEntry().getValue());
            div.getTerms().put(q.getTerms().firstKey(),q.getTerms().firstEntry().getValue());
            o.setP(p2,q);
            Polynomial mod = o.pMul();
            o.setP(p1,mod);
            p1=o.pSub();
        }

        if(ok)
            return div;
        else
            return p1;
    }
    public Polynomial pDer(){
        Polynomial rez = new Polynomial();
        p1.getTerms().forEach((e,c) -> {
            if(e!=0)
                rez.getTerms().put(e-1, c*e);
        });
        return rez;
    }
    public Polynomial pInt(){
        Polynomial rez = new Polynomial();
        p1.getTerms().forEach((e,c) -> rez.getTerms().put(e+1, c/(e+1)));
        return rez;
    }
}
