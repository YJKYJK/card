package com.ytzl.itrip;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        BigDecimal to=new BigDecimal(1213.00);
        System.out.println(to.multiply(BigDecimal.valueOf(3)));
    }
}
