package com.toec.utils;

import lombok.Data;

@Data
public class ResultInfo {
    private Boolean success;
    private Object data;
    private String failReason;

    public ResultInfo() {
    }

    public ResultInfo(Boolean success) {
        this.success = success;
    }

    public ResultInfo(Boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ResultInfo(Boolean success, Object data, String failReason) {
        this.success = success;
        this.data = data;
        this.failReason = failReason;
    }
}
