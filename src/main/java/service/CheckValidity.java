package service;

import util.AppException;
import util.MessageEnum;

/**
 * Created by JMBRUN on 01/12/2016.
 */
public class CheckValidity {

    /**
     * Check pre-condition on input
     */
    public void checkPreConditionOnInput(Integer[] pInputArray) {

        if (pInputArray == null) {
            // Manage problem with the input
            throw new AppException(MessageEnum.ERR_ARRAY_INPUT, pInputArray, null, null);
        } else if (2 > pInputArray.length) {
            // Manage problem with the input : the result should have at least 2 elements, so the input too
            throw new AppException(MessageEnum.ERR_ARRAY_SIZE, pInputArray, null, null);
        }

    }


    /**
     * Catch post-calculation problems
     */
    public void checkPostConditionOnOutput(Integer[] pInputArray, Integer[] pOutputResultArray) {
        if (pOutputResultArray == null) {
            // Pb in thecomputation
            throw new AppException(MessageEnum.ERR_COMPUTE, pInputArray, pOutputResultArray, null);
        } else if (2 > pOutputResultArray.length) {
            // No correct solution
            throw new AppException(MessageEnum.ERR_NO_SOLUTION, pInputArray, pOutputResultArray, null);
        }
    }

    /**
     * Catch post-calculation problems
     */
    public void checkPostConditionOnOutput(Integer[] pInputArray, Integer[] pOutputResultArray, Integer pMaxComputed) {
        if (pOutputResultArray == null) {
            // Pb in thecomputation
            throw new AppException(MessageEnum.ERR_COMPUTE, pInputArray, pOutputResultArray, pMaxComputed);
        } else if (2 > pOutputResultArray.length) {
            // No correct solution
            throw new AppException(MessageEnum.ERR_NO_SOLUTION, pInputArray, pOutputResultArray, pMaxComputed);
        }
    }
}
