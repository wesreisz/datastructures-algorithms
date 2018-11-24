package com.wesleyreisz.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws FileUtil.NoValuePresentException
    {
        Assert.assertTrue(FileUtil.isPalidrome("madam"));
        Assert.assertTrue(FileUtil.isPalidrome("nurses run"));
        Assert.assertFalse(FileUtil.isPalidrome("nurses"));
        Assert.assertFalse(FileUtil.isPalidrome("wes"));
    }

    @Test(expected = FileUtil.NoValuePresentException.class)
    public void shouldThrowException() throws FileUtil.NoValuePresentException{
        Assert.assertFalse(FileUtil.isPalidrome(null));
    }
}
