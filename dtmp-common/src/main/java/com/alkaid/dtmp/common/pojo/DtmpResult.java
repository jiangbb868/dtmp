package com.alkaid.dtmp.common.pojo;

import com.alkaid.dtmp.common.base.BaseResult;

import java.io.Serializable;

/**
 * 返回结果对象
 */
public class DtmpResult implements BaseResult, Serializable {

    /**
     * 返回状态
     */
    private Integer status;

    /**
     * 返回结果消息
     */
    private String message;

    /**
     * 返回结果数据
     */
    private Object data;

    public DtmpResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
