package com.nun.lib_base.dto;

/**
 * Created by lenovo on 2017/7/25.
 */

public class AppResponse {
    private boolean success;
    private String message;
    private String data;

    public AppResponse() {
    }

    public AppResponse(boolean success, String message, String data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public static AppResponse getNetworkErrorResponse() {
        AppResponse response = new AppResponse();
        response.setSuccess(false);
        response.setMessage("从服务器加载数据失败!");
        return response;
    }

    /**
     * 操作成功返回
     * @return
     */
    public static   AppResponse getOperationSuccessResponse(){
        AppResponse response = new AppResponse();
        response.setSuccess(true);
        response.setMessage("操作成功!");
        return response;
    }
    /**
     * 操作成功返回
     * @return
     */
    public static   AppResponse getOperationErrorResponse(String message){
        AppResponse response = new AppResponse();
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }


}
