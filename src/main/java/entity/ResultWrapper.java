package entity;

/**
 * Created by JMBRUN on 01/12/2016.
 */
public class ResultWrapper {

    Integer[] maxSubArray;
    Integer maxPartialSum;

    public Integer[] getMaxSubArray() {
        return maxSubArray;
    }

    public void setMaxSubArray(Integer[] maxSubArray) {
        this.maxSubArray = maxSubArray;
    }

    public Integer getMaxPartialSum() {
        return maxPartialSum;
    }

    public void setMaxPartialSum(Integer maxPartialSum) {
        this.maxPartialSum = maxPartialSum;
    }
}
