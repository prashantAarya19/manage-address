package com.manageaddress;

public class ApiResponse {
    Boolean success;
    String message;
    Object data;

    private ApiResponse(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ApiResponse successResponse(Object object) {
        return new ApiResponse(true, "", object);
    }


    public static ApiResponse failResponse(Object object) {
        return new ApiResponse(false, "", object);
    }
}
