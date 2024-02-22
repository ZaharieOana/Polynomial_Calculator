package Tests;

import org.example.Logic.Operations;
import org.example.Model.Polynomial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTests {
    //good
    @Test
    void testAdd1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            Polynomial p2 = new Polynomial("x^2-x^0");
            o.setP(p1,p2);
            assertEquals("x^3-x^2+6x^1-6x^0", o.pAdd().toString());
        }
        catch (Exception ignored) {}
    }
    @Test
    void testSub1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            Polynomial p2 = new Polynomial("x^2-x^0");
            o.setP(p1,p2);
            assertEquals("x^3-3x^2+6x^1-4x^0", o.pSub().toString());
        }
        catch (Exception ignored) {}
    }
    @Test
    void testMul1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            Polynomial p2 = new Polynomial("x^2-x^0");
            o.setP(p1,p2);
            assertEquals("x^5-2x^4+5x^3-3x^2-6x^1+5x^0", o.pMul().toString());
        }
        catch (Exception ignored) {}
    }
    @Test
    void testDiv1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            Polynomial p2 = new Polynomial("x^2-x^0");
            o.setP(p1,p2);
            assertEquals("x^1-2x^0", o.pDiv(true).toString());
        }
        catch (Exception ignored) {}
    }
    @Test
    void testMod1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            Polynomial p2 = new Polynomial("x^2-x^0");
            o.setP(p1,p2);
            assertEquals("7x^1-7x^0", o.pDiv(false).toString());
        }
        catch (Exception ignored) {}
    }
    @Test
    void testDer1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            o.setP1(p1);
            assertEquals("3x^2-4x^1+6x^0", o.pDer().toString());
        }
        catch (Exception ignored) {}
    }
    @Test
    void testInt1(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("x^3-2x^2+6x^1-5x^0");
            o.setP1(p1);
            assertEquals("0.25x^4-0.67x^3+3x^2-5x^1", o.pInt().toString());
        }
        catch (Exception ignored) {}
    }

    //fail
    @Test
    void testAdd2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            Polynomial p2 = new Polynomial("x^4+2x^2-x^1");
            o.setP(p1,p2);
            assertEquals("x^3+x^2-x^1-6x^0", o.pAdd().toString()); //actual x^4+x^2-x^1-4x^0
        }
        catch (Exception ignored) {}
    }
    @Test
    void testSub2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            Polynomial p2 = new Polynomial("x^4+2x^2-x^1");
            o.setP(p1,p2);
            assertEquals("-x^5-3x^2-4x^0", o.pSub().toString()); //actual -x^4-3x^2+x^1-4x^0
        }
        catch (Exception ignored) {}
    }
    @Test
    void testMul2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            Polynomial p2 = new Polynomial("x^4+2x^2-x^1");
            o.setP(p1,p2);
            assertEquals("3x^5-x^4-3x^3-6x^1", o.pMul().toString()); //actual -x^6-6x^4+x^3-8x^2+4x^1
        }
        catch (Exception ignored) {}
    }
    @Test
    void testDiv2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            Polynomial p2 = new Polynomial("x^4+2x^2-x^1");
            o.setP(p1,p2);
            assertEquals("x^0", o.pDiv(true).toString()); //actual 0
        }
        catch (Exception ignored) {}
    }
    @Test
    void testMod2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            Polynomial p2 = new Polynomial("x^4+2x^2-x^1");
            o.setP(p1,p2);
            assertEquals("-2x^2+x^0", o.pDiv(false).toString()); //actual -x^2-4x^0
        }
        catch (Exception ignored) {}
    }
    @Test
    void testDer2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            o.setP1(p1);
            assertEquals("4x^1", o.pDer().toString()); //actual -2x^1
        }
        catch (Exception ignored) {}
    }
    @Test
    void testInt2(){
        Operations o = new Operations();
        try {
            Polynomial p1 = new Polynomial("-x^2-4x^0");
            o.setP1(p1);assertEquals("0.22x^3-4x^21", o.pInt().toString()); //actual -0.33x^3-4x^1

        }
        catch (Exception ignored) {}
    }
}
