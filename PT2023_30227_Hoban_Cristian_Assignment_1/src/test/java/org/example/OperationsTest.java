package org.example;

import model.*;
import controller.*;


import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    Operations op = new Operations();
    CalculatorController c = new CalculatorController();
    static int cnt = 0;
    static int totalNumber = 0;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("New Test: ");
    }

    @org.junit.jupiter.api.AfterAll
    static void showMessage(){
        System.out.println(""+ cnt + " tests out of " + totalNumber + " have passed!");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Test ended");
    }

    @org.junit.jupiter.api.Test
    void addition() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = c.splitString("+2x^3-4x^1");
        p2 = c.splitString("+6x^3+4x^2");
        String res = "";
        res = op.addition(p1, p2).toString();
        if("+8x^3+4x^2-4x^1".equals(res))
            cnt++;
        assertEquals("+8x^3+4x^2-4x^1", res);


    }
    @org.junit.jupiter.api.Test
    void splitString() {
        totalNumber++;
        String p1 = "+2x^3-4x^1";
        Polynomial res = new Polynomial();
        res = c.splitString(p1);
        if(p1.equals(res.toString()))
            cnt++;
        assertEquals(p1, res.toString());


    }

    @org.junit.jupiter.api.Test
    void subtraction() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = c.splitString("+2x^3-4x^1");
        p2 = c.splitString("+6x^3+4x^2");
        String res = op.subtraction(p1, p2).toString();
        if("-4x^3-4x^2-4x^1".equals(res))
            cnt++;
        assertEquals("-4x^3-4x^2-4x^1", res);
    }

    @org.junit.jupiter.api.Test
    void derivation() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        p1 = c.splitString("+2x^3-4x^1");
        String res = op.derivation(p1).toString();
        if("+6x^2-4x^0".equals( res))
            cnt++;
        assertEquals("+6x^2-4x^0", res);
    }

    @org.junit.jupiter.api.Test
    void integration() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        p1 = c.splitString("+2x^3-4x^1");
        String res = "";
        res = op.integration(p1).toString();
        if("+0.50x^4-2x^2".equals(res))
            cnt++;
        assertEquals("+0.50x^4-2x^2", res);
    }
    @org.junit.jupiter.api.Test
    void integrationInvalid() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        p1 = c.splitString("+2x^3-4x^1");
        String res = "";
        res = op.integration(p1).toString();
        if("+0.50x^5-2x^2".equals(res))
            cnt++;
        assertEquals("+0.50x^5-2x^2", res);
    }

    @org.junit.jupiter.api.Test
    void multiplication() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = c.splitString("+4x^1-3x^0");
        p2 = c.splitString("+5x^2-2x^1-1x^0");
        assertEquals("+20x^3-23x^2+2x^1+3x^0", op.multiplication(p1, p2).toString());
        if("+20x^3-23x^2+2x^1+3x^0".equals( op.multiplication(p1, p2).toString()))
            cnt++;
    }
    @org.junit.jupiter.api.Test
    void multiplicationInvalid() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = c.splitString("+4x^1-3x^0");
        p2 = c.splitString("+5x^2-2x^1-1x^0");
        assertEquals("+28x^3-23x^2+2x^1+3x^0", op.multiplication(p1, p2).toString());
        if("+28x^3-23x^2+2x^1+3x^0".equals( op.multiplication(p1, p2).toString()))
            cnt++;
    }

    @org.junit.jupiter.api.Test
    void division() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = c.splitString("+1x^2+2x^1+1x^0");
        p2 = c.splitString("+1x^1+1x^0");
        Polynomial[] result =new Polynomial[2];
        result = op.division(p1, p2);
        String s = result[0].toString() + " " + result[1].toString();
        if("+1x^1+1x^0 0".equals(s))
            cnt++;
        assertEquals("+1x^1+1x^0 0", s);
    }

    @org.junit.jupiter.api.Test
    void zeroDividedBySth() {
        totalNumber++;
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        p1 = c.splitString("0");
        p2 = c.splitString("+1x^2+2x^1+1x^0");
        Polynomial[] result =new Polynomial[2];
        result = op.division(p1, p2);
        String s = result[0].toString() + " " + result[1].toString();
        if("0 0".equals(s))
            cnt++;
        assertEquals("0 0", s);
    }
}