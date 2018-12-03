package com.wesleyreisz.algorithms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals( 123 , StringUtil.atoi("abc") );
        assertEquals( 419 , StringUtil.atoi("DaI") );
    }
}
