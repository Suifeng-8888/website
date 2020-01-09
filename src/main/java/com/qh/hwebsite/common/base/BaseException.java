package com.qh.hwebsite.common.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: zhangxd
 * @Version: v1.0
 * @CreateTime: 2019-09-10 11:12
 * @Package: com.elshou.sun.base.http
 * @Description: BaseException
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends Exception {
    private static final long serialVersionUID = 9079972344123939007L;
    /**
     * 异常码
     */
    private Integer status;

    public BaseException(ErrorEnum error){
        super(error.getMessage());
        this.status=error.getStatus();
    }

    public BaseException(Exception error) {
        super(error);
        this.status = 500;
    }

    public BaseException(Integer code, String message){
        super(message);
        this.status=code;
    }
}
