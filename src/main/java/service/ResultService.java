package service;

/**
 * Created by JMBRUN on 01/12/2016.
 */
public class ResultService {

    private InitInputArray initInputArray = new InitInputArray();
    private CheckValidity checkValidity = new CheckValidity();
    private MaxSubArray maxSubArray = new MaxSubArray();

    public Integer[] compute() throws Exception {

        // Initialization
        Integer[] inputArray = initInputArray.initArray();

        // Check the input
        checkValidity.checkPreConditionOnInput(inputArray);

        // Compute the result
        Integer[] resultMaxSubArray = maxSubArray.computeMaxSubArray(inputArray);

        // Check the output
        checkValidity.checkPostConditionOnOutput(inputArray, resultMaxSubArray);

        return resultMaxSubArray;
    }

    public Integer[] compute(Integer[] pInputArray) {

        // Check the input
        checkValidity.checkPreConditionOnInput(pInputArray);

        // Compute the result
        Integer[] resultMaxSubArray = maxSubArray.computeMaxSubArray(pInputArray);

        // Check the output
        checkValidity.checkPostConditionOnOutput(pInputArray, resultMaxSubArray);

        return resultMaxSubArray;
    }
}
