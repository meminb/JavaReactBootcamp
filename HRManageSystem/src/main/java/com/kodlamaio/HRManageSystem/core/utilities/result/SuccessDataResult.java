package com.kodlamaio.HRManageSystem.core.utilities.result;

public class SuccessDataResult<T> extends DataResult {

    public SuccessDataResult(Object data, String message) {
        super(data, true,message);
    }

    public SuccessDataResult(T data){
        super(data,true);
    }

    public SuccessDataResult(String message) {
        super(null, true,message);

    }
    public SuccessDataResult() {
        super(null, true);

    }

}
