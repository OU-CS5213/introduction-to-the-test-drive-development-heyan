package com.heyan.testdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AWSTest {

    private static final int FILLER_VALUE = Integer.MIN_VALUE;
    private int[] original={1, 2, 3};
    AWS originalAWS;

    @BeforeEach
    void setUp() throws Exception {
        originalAWS = new AWS(this.original);
    }

    @Test
    void testGetValues() {
        int[] value_expected = {1, 2, 3};
        AWS aws = new AWS(value_expected);
        int[] actual = aws.getValues();
        assertEquals(actual[1], value_expected[1]);

    }

    @Test
    void testSetValues() {
        int[] value_expected = {1, 2, 3};
        int[] readytoset = {1, 2, 4};
        AWS aws = new AWS(value_expected);
        aws.setValues(readytoset);
        int[] actual = aws.getValues();
        assertEquals(4, actual[2]);
    }

    @Test
    void testToString() {
        int[] value_expected = {1, 2, 3};
        AWS aws = new AWS(value_expected);
        String test_output = aws.toString();
        assertEquals("AWS [values=[1, 2, 3]]", test_output);
    }

    @Test
    void testAWS() {
        int[] expected = {1, 2, 3};
        int[] x = {1, 2, 3};
        AWS aws = new AWS(x);
        x[1] = 100;

        int[] actual = aws.getValues();
        assertEquals(actual[0], expected[0]);
        assertEquals(actual[1], expected[1]);
    }

    @Test
    void testRemove() {
        int[] x = {1, 2, 3};
        AWS aws = new AWS(x);

        int value = aws.remove(-1);
        int expected = FILLER_VALUE;
        assertEquals(expected, value);

        value = aws.remove(x.length + 10);
        expected = FILLER_VALUE;
        assertEquals(expected, value);

        value = aws.remove(0);
        assertEquals(x[0], value);

        int[] r = aws.getValues();
        value = r[r.length - 1];
        assertEquals(expected, value);

        value = aws.remove(2);
        assertEquals(r[2], value);

        r = aws.getValues();
        value = r[r.length - 1];
        assertEquals(expected, value);

    }

    @Test
    void testFillAndExpand() {
        int position = 1;
        int numberOfTimes = 2;
        int[] org = originalAWS.getValues();
        int expectedValue = org[position];
        int first = org[0];

        int expected = originalAWS.getValues().length + numberOfTimes;
        originalAWS.fillAndExpand(position, numberOfTimes);
        int[] result = originalAWS.getValues();
        assertEquals(expected, result.length);

        int a = result[1];
        int b = result[2];
        int c = result[3];
        assertEquals(expectedValue, a);
        assertEquals(expectedValue, b);
        assertEquals(expectedValue, c);
        assertEquals(first, result[0]);



    }
    @Test
    void testFillAndExpandWithNegative() {
        int position = 1;
        int numberOfTimes = -2;

        int[] org = originalAWS.getValues();
        int expectedValue = org[position];
        int first = org[0];
        int expected = originalAWS.getValues().length - numberOfTimes;
        originalAWS.fillAndExpand(position, numberOfTimes);
        int[] result = originalAWS.getValues();
        assertEquals(expected, result.length);

        int a = result[1];
        int b = result[2];
        int c = result[3];
        assertEquals(expectedValue, a);
        assertEquals(expectedValue, b);
        assertEquals(expectedValue, c);

        assertEquals(first, result[0]);


    }
    @Test
    void testRemoveBiggerThan() {
        int[] value_expected = {1, 2, 3, 4, 5, 6, 7};
        AWS aws = new AWS(value_expected);
        aws.removeBiggerThan(4);
        String test_output = aws.toString();
        assertEquals("AWS [values=[1, 2, 3, 4, -2147483648, -2147483648, -2147483648]]", aws.toString());
    }
    @Test
    void testStepMultiplier() {
        int[] value_expected = {1, 15, 3, 45, 5, 6, 50};
        AWS aws = new AWS(value_expected);
        aws.stepMultiplier();
        assertEquals("AWS [values=[2, 60, 6, 4500, 10, 12, 5000]]", aws.toString());

    }

}
