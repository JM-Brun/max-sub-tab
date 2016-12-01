package service;

import entity.ResultWrapper;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import util.AppException;
import util.MessageEnum;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by JMBRUN on 01/12/2016.
 */
public class TestMaxSubArray extends TestCase {

    private MaxSubArray maxSubArray = new MaxSubArray();
    private ResultService resultService = new ResultService();

    /**
     *
     */
    @Test
    public void testMaxSubArray() {

        Integer[] arrayTestInput1 = {1, -2, 4, 9, -6, 8};
        Integer[] arrayExpected1 = {4, 9, -6, 8};
        Assert.assertArrayEquals( arrayExpected1, maxSubArray.computeMaxSubArray(arrayTestInput1) );

        Integer[] arrayTestInput2 = {1, 10, -5, 7, -1};
        Integer[] arrayExpected2 = {1, 10, -5, 7};
        Assert.assertArrayEquals( arrayExpected2, maxSubArray.computeMaxSubArray(arrayTestInput2));

        Integer[] arrayTestInput3 = {1, -10, -5, -8, -2};
        Integer[] arrayExpected3 = {1, -10};
        Assert.assertArrayEquals( arrayExpected3, maxSubArray.computeMaxSubArray(arrayTestInput3));

        Integer[] arrayTestInput4 = {-5, -10};
        Integer[] arrayExpected4 = {-5, -10};
        Assert.assertArrayEquals( arrayExpected4, maxSubArray.computeMaxSubArray(arrayTestInput4));
    }

    /**
     *
     */
    @Test
    public void testOnlyOnePositiveNumberArray() {

        Integer[] arrayTestInput1 = {-1, -1, 1, -1, -1};
        Integer[] arrayExpected1 = {-1, 1};
        Assert.assertArrayEquals( arrayExpected1, maxSubArray.computeMaxSubArray(arrayTestInput1));

        Integer[] arrayTestInput2 = {1, -1, -1, -1, -1};
        Integer[] arrayExpected2 = {1, -1};
        Assert.assertArrayEquals( arrayExpected2, maxSubArray.computeMaxSubArray(arrayTestInput2));

    }

    /**
     *
     */
    @Test
    public void testOnlyNegativesNumberArray() {

        Integer[] arrayTestInput1 = {-1, -2, -5, -6, -3, -4 };
        Integer[] arrayExpected1 = {-1, -2};
        Assert.assertArrayEquals( arrayExpected1, maxSubArray.computeMaxSubArray(arrayTestInput1));

    }

    /**
     *
     */
    @Test
    public void testArrayWithNullValuesSouldThrowAppException() {

        Integer[] arrayTestInput1 = {-1,null, -5, -6, -3, };
        maxSubArray.computeMaxSubArray(arrayTestInput1);

    }

    /**
     *
     */
    @Test(expected= AppException.class)
    public void testNullArrayThrowMessage() throws Exception {
        try {
            resultService.compute(null);
            fail("Should throw exception");
        } catch(AppException appExp){
            assert(MessageEnum.ERR_ARRAY_INPUT.equals(appExp.getMessageEnum()));
        }
    }

    /**
     *
     */
    @Test
    public void testOneElementArrayThrowMessage() throws Exception {

        Integer[] arrayTestInputOneElement = {-1,};
        try {
            resultService.compute(arrayTestInputOneElement);
            fail("Should throw exception");
        } catch(AppException appExp){
            assert(MessageEnum.ERR_ARRAY_SIZE.equals(appExp.getMessageEnum()));
        }
    }


    /**
     * Attention test non reproductible
     */
    @Test
    public void testRandomArrays() throws Exception {

        Random rand = new Random();
        Integer size = Math.min(1 + Math.abs(rand.nextInt(50)),10);
        Integer[] randomArray = new Integer[size];
        for (int i=0;i<randomArray.length; i++)     {
            randomArray[i] = rand.nextInt(1000);
        }
        assertThat(randomArray).isNotNull();

        ResultWrapper resultTestWrapper = maxSubArray.computeResult(randomArray);
        assertThat(resultTestWrapper.getMaxPartialSum()).isNotNull();

        Integer sizePartialArray = resultTestWrapper.getMaxSubArray().length;
        assertTrue(sizePartialArray >= 2 );

        // Encadrement des valeurs
        assertTrue(resultTestWrapper.getMaxPartialSum() <= Arrays.stream(randomArray).mapToInt(Math::abs).sum());
        assertTrue(resultTestWrapper.getMaxPartialSum() >= Arrays.stream(randomArray).mapToInt(Integer::intValue).min().getAsInt()*sizePartialArray);

    }

}
