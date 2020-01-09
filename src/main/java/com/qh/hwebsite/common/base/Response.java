package com.qh.hwebsite.common.base;

import lombok.Data;

import java.io.Serializable;

/*
 * @BelongsProject: sun
 * @BelongsPackage: com.elshou.sun.base.http
 * @Author: zhangxd
 * @CreateTime: 2019-08-29 11:37
 * @Description: Custom http response
 */

@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -6888562506492796994L;
    private int status;
    private Object data;
    private Pagination pagination;
    private String message;

    public Response error(int status, String message) {
        this.setStatus(status);
        this.setMessage(message);
        return this;
    }

    public Response error(ErrorEnum e) {
        return error(e.getStatus(), e.getMessage());
    }

    public Response error(BaseException e) {
        return error(e.getStatus(), e.getMessage());
    }

    public Response error() {
        return error(ErrorEnum.ServerError);
    }

    public Response success() {
        this.status(ResponseStatus.SUCCESS);
        return this;
    }

    public Response success(Object data) {
        this.status(ResponseStatus.SUCCESS);
        this.setData(data);
        return this;
    }

    public Response data(Object data) {
        this.setData(data);
        return this;
    }

    public Response pagination(Long total) {
        Pagination pagination = new Pagination(1L, 10L, total);
        return pagination(pagination);
    }

    public Response pagination(Pagination pagination) {
        this.setPagination(pagination);
        return this;
    }

    public Response status(int status) {
        this.setStatus(status);
        return this;
    }


    public Response message(String message) {
        this.setMessage(message);
        return this;
    }

//    @Override
//    public Response put(String key, Object value) {
//        super.put(key, value);
//        return this;
//    }
}
