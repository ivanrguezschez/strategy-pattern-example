package com.irs.strategypatternexample;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ValidatorTest extends TestCase {

    @Rule
    public TestName testName = new TestName();

    // Hace de metodo setUp
    @Before
    public void beforeTest() {
        System.out.println("beforeTest->" + testName.getMethodName());
    }

    // Hace de metodo tearDown
    @After
    public void afterTest() {
        System.out.println("afterTest->" + testName.getMethodName());
    }

    @Test
    public void testIsAllLowerCaseStrategy() {
        Validator v = new Validator(new IsAllLowerCase());
        assertTrue(v.validate("bbbb"));
        assertFalse(v.validate("BBBB"));
    }

    @Test
    public void testIsAllUpperCaseStrategy() {
        Validator v = new Validator(new IsAllUpperCase());
        assertTrue(v.validate("BBBB"));
        assertFalse(v.validate("bbbb"));
    }

    @Test
    public void testIsNumericStrategy() {
        Validator v = new Validator(new IsNumeric());
        assertFalse(v.validate("aaaa"));
        assertTrue(v.validate("1234"));
        assertTrue(v.validate("0000"));
        assertFalse(v.validate("12.45"));
        assertTrue(v.validate(String.valueOf(new Integer(1))));
    }

    @Test
    public void testIsNumericAndLengthStrategy() {
        Validator v = new Validator(new IsNumericAndLength(5));
        assertTrue(v.validate("28045"));
        assertFalse(v.validate("1234"));
        assertFalse(v.validate("0000"));
        assertFalse(v.validate("12.45"));
        assertTrue(v.validate("00000"));
    }
}
