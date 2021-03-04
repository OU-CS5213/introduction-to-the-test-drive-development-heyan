
package com.heyan.testdd;
import java.util.Arrays;


public class AWS {
    private static final int FILLER_VALUE = Integer.MIN_VALUE;
    private int[] values;

    public int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    public void setValues(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }
    public void removeBiggerThan(int threshold)
    {
        for(int i = 0; i < values.length; ++i)
        {
            if(values[i] > threshold)
            {
                values[i] = FILLER_VALUE;
            }
        }
    }
    public void stepMultiplier()
    {
        for(int i = 0; i < values.length; ++i)
        {
            if(values[i] < 100 && values[i] > 20)
            {
                values[i] = values[i] * 100;
            }
            else if(values[i] < 20 && values[i] > 10)
            {
                values[i] = values[i] * 4;
            }
            else if(values[i] < 10)
            {
                values[i] = values[i] * 2;
            }
        }
    }
    @Override
    public String toString() {
        return "AWS [values=" + Arrays.toString(values) + "]";
    }

    public AWS(int[] values) {
        super();
        setValues(values);
    }

    public int remove(int i) {

        int value = FILLER_VALUE;
        if (i >= 0 && i < values.length) {
            value = values[i];
            for(int index = i; index < values.length - 1; ++index) {
                values[index] = values[index+1];
            }
            values[values.length-1] = FILLER_VALUE;
        }
        return value;
    }

    public void fillAndExpand(int position, int nt) {
        int numberOfTimes = Math.abs(nt);
        int[] newArray = new int[values.length + numberOfTimes];
        for(int i = 0; i <=position; ++i) {
            newArray[i] = values[i];
        }
        for(int i = position; i<=numberOfTimes + position; ++i) {
            newArray[i] = newArray[position];
        }
        // Make examples, so it is easier to visualize your methods
        //   p 1 2
        // a b c
        // a b b b c

        int x = numberOfTimes;
        for(int i = position+1; i <values.length; ++i ) {
            newArray[i+x] = values[i];
        }
        values = newArray;
    }

}
