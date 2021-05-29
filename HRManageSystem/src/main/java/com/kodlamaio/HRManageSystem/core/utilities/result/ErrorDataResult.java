package com.kodlamaio.HRManageSystem.core.utilities.result;

public class ErrorDataResult<T> extends DataResult {



    public ErrorDataResult(Object data, String message) {
        super(data, false,message);
    }

    public ErrorDataResult(T data){
        super(data,false);
    }

    public ErrorDataResult(String message) {
        super(null, false,message);

    }
    public ErrorDataResult() {
        super(null, false);

    }

}
