package service;


import entity.ResultWrapper;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Created by JMBRUN on 01/12/2016.
 * @version 0.1
 */
public class MaxSubArray {

    private static final Logger logger = Logger.getLogger(MaxSubArray.class);

    /**
     * compute and return the sub-array with the biggest sum
     */
    public Integer[]  computeMaxSubArray(Integer[] pInputArray) {

        Integer maxSum = Integer.MIN_VALUE; // pInputArray[0]

        Integer[] outputMaxSubArray = new Integer[pInputArray.length];

        for (int iStart = 0; iStart < pInputArray.length; iStart++) {
            for (int jEnd = iStart; jEnd < pInputArray.length; jEnd++) {
                if (jEnd>iStart) {
                    // Arrays.copyOfRange(oldArray, startIndex, endIndex)
                    // startIndex is the initial, inclusive.
                    // endIndex : final index of the range to be copied, exclusive.
                    Integer[] partialArray = Arrays.copyOfRange(pInputArray, iStart, jEnd+1);
                    Integer partialSum = Arrays.stream(partialArray).filter(p-> p!=null).mapToInt(Integer::intValue).sum();
                    if (partialSum > maxSum) {
                        maxSum = partialSum;
                        outputMaxSubArray = partialArray;
                    }
                }
            }
        }

        logger.debug("--------------------");
        logger.debug("Max final : "+maxSum);
        logger.debug("--------------------");

        return outputMaxSubArray;
    }


    /**
     * compute and return the wrapper containing the max and the sub-array
     */
    public ResultWrapper computeResult(Integer[] pInputArray) {

        Integer maxSum = Integer.MIN_VALUE;
        Integer[] outputMaxSubArray = new Integer[pInputArray.length];

        ResultWrapper resultClass = new ResultWrapper();

        for (int i = 0; i < pInputArray.length; i++) {
            for (int j = i; j < pInputArray.length; j++) {
                if (j>i) {
                    Integer[] partialArray = Arrays.copyOfRange(pInputArray, i, j+1);
                    Integer partialSum = Arrays.stream(partialArray).mapToInt(Integer::intValue).sum();
                    if (partialSum > maxSum) {
                        maxSum = partialSum;
                        outputMaxSubArray = partialArray;

                    }
                }
            }
        }

        resultClass.setMaxSubArray(outputMaxSubArray);
        resultClass.setMaxPartialSum(maxSum);

        return resultClass;
    }

}
