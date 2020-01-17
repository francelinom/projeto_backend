package com.ufrn.eaj.demo.resources.exception;

import java.io.Serializable;

public class StandarError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String mesasge;
    private String path;

    public StandarError(){
        
    }

    public StandarError(Long timestamp, Integer status, String error, String mesasge, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.mesasge = mesasge;
        this.path = path;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMesasge() {
        return mesasge;
    }

    public void setMesasge(String mesasge) {
        this.mesasge = mesasge;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
