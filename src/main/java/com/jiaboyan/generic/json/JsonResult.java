package com.jiaboyan.generic.json;

/**
 * Created by jiaboyan on 2017/3/27.
 */
public class JsonResult {

    private boolean flag;

    private String msg;

    private Object data;

    public JsonResult() {
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
