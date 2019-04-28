package io.xtests.mock.response;


/**
 * @author patrick
 */
public class GenericMockResponse {
    private String status = "success";
    private static final String ERROR_STATUS = "error";
    private String code = "0000";
    private String message = "处理成功";
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String getErrorStatus() {
        return ERROR_STATUS;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
