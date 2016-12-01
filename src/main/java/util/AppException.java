package util;

/**
 * Created by JMBRUN on 01/12/2016.
 */
public class AppException extends RuntimeException{

    private final MessageEnum messageEnum;
    private final Integer[] inputArray;
    private final Integer[] outputSubArray;
    private final Integer maxComputed;


    public AppException() {
        super();
        this.messageEnum = MessageEnum.ERR_UNKNOW;
        this.inputArray = null;
        this.outputSubArray = null;
        this.maxComputed = null;
    }

    public MessageEnum getMessageEnum() {
        return messageEnum;
    }

    public Integer[] getInputArray() {
        return inputArray;
    }

    public Integer[] getOutputSubArray() {
        return outputSubArray;
    }

    public Integer getMaxComputed() {
        return maxComputed;
    }

    public AppException(MessageEnum pMessageEnum, Integer[] pInputArray, Integer[] pOutputSubArray, Integer pMaxComputed) {
        super();
        this.messageEnum = pMessageEnum;
        this.inputArray = null;
        this.outputSubArray = null;
        this.maxComputed = null;

        System.out.println("Erreur : "+pMessageEnum.getLabel());
    }
}

