package org.example.View;

import org.example.Logic.Operations;
import org.example.Model.Polynomial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final Calculator theView;
    private final Operations o;
    public Controller(){
        theView = new Calculator();
        o = new Operations();

        theView.getBadd().addActionListener(new ButtonAdd());
        theView.getBsub().addActionListener(new ButtonSub());
        theView.getBmul().addActionListener(new ButtonMul());
        theView.getBdiv().addActionListener(new ButtonDiv());
        theView.getBmod().addActionListener(new ButtonMod());
        theView.getBder().addActionListener(new ButtonDer());
        theView.getBint().addActionListener(new ButtonInt());

    }

    private class ButtonAdd implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp();
                Polynomial rez = o.pAdd();
                theView.setRez(rez.toString());
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }

    private class ButtonSub implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp();
                Polynomial rez = o.pSub();
                theView.setRez(rez.toString());
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }

    private class ButtonMul implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp();
                Polynomial rez = o.pMul();
                theView.setRez(rez.toString());
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }

    private class ButtonDiv implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp();
                Polynomial rez = o.pDiv(true);
                theView.setRez(rez.toString());
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }
    private class ButtonMod implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp();
                Polynomial rez = o.pDiv(false);
                theView.setRez(rez.toString());
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }
    private class ButtonDer implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp1Pol();
                Polynomial rez = o.pDer();
                theView.setRez(rez.toString());
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }

    private class ButtonInt implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                initOp1Pol();
                Polynomial rez = o.pInt();
                theView.setRez(rez.toString() + "+C");
            }
            catch (Exception ex){
                theView.getInvalidIn().setVisible(true);
            }
        }
    }

    private void initOp() throws Exception{
            Polynomial p1 = new Polynomial(theView.getPol1().getText());
            Polynomial p2 = new Polynomial(theView.getPol2().getText());
            o.setP(p1,p2);
            theView.getInvalidIn().setVisible(false);
    }
    private void initOp1Pol() throws Exception{
        Polynomial p1 = new Polynomial(theView.getPol1().getText());
        o.setP1(p1);
        theView.getInvalidIn().setVisible(false);
    }
}

