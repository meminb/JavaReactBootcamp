package com.kodlamaio.HRManageSystem.core.utilities.result;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success){
        this.success=success;
    }

    public Result(boolean success,String message){
        this(success);
        this.message=message;
    }
    public boolean isSucces() {
        return success;
    }

    public String getMessage() {
        return message;
    }

}
