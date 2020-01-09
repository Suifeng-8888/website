package com.qh.hwebsite.common.base;

/*
 * @Author: zhangxd
 * @Version: v1.0
 * @CreateTime: 2019-08-31 10:21
 * @Package: com.elshou.sun.base.http
 * @Description: ResponseError
 */

public enum ErrorEnum {

    /*
     * 服务器内部错误
     */
    ServerError(50000, "InternalServerError"),
    DBError(50010, "DBError"),
    DBOperateError(50011, "DBOperateError"),
    AddressNil(50020, "AddressNil"),
    CacheError(50030, "CacheError"),
    IOError(50040, "IOError"),
    IOFileError(50041, "IOFileError"),

    SecModuleError(50000, "SecModuleError"),
    SecModuleBaseError(50000, "SecModuleBaseError"),
    SecAuthorityError(50000, "SecAuthorityError"),
    SecDigitError(50000, "SecDigitError"),


    /*
     * 用户请求错误
     */
    BadRequest(40000, "BadRequest"),
    ValidateFail(40001, "ValidateFail"),
    FieldKeyError(40003, "FieldKeyError"),
    PreStepError(40004, "PreStepError"),
    StatusNotMatch(40005, "StatusNotMatch"),
    PromoteCheckError(40006, "PromoteCheckError"),
    SendSmsError(40007, "SendSmsError"),
    RoleError(40008, "RoleError"),
    PhoneNotMatch(40009, "PhoneNotMatch"),

    AuthError(40100, "Unauthorithed"),
    AccessForbidden(40300, "AccessForbidden"),
    SpoofingAttack(40301, "SpoofingAttack"),
    NotFound(40400, "NotFound"),

    /*
     * 用户操作错误
     */
    StatusForbidden(20010, "StatusForbidden"),

    LoginError(20020, "LoginError"),
    PasswordError(20021, "PasswordError"),
    ImgCaptchaError(20022, "ImgCaptchaError"),
    PhoneCaptchaError(20023, "PhoneCaptchaError"),

    DBNotFound(20030, "DBNotFound"),
    DBNotFoundUser(20031, "DBNotFoundUser"),
    DBNotFoundGoods(20032, "DBNotFoundGoods"),
    DBNotFoundOrder(20033, "DBNotFoundOrder"),

    FormatError(20040, "FormateError"),
    FileFormatError(20041, "FileFormateError"),
    ExcelFormatError(20042, "ExcelFormateError"),

    NotifyError(20050, "NotifyError"),

    /*
     * 外部API或依赖错误
     */
    APIError(20100, "APIError"),
    AppIdError(20101, "AppIdError"),
    PaymentAPIError(20102, "PaymentAPIError"),
    PayTpError(20103, "PayTpError"),

    WxAPIError(20110, "WxAPIError"),
    WxAPITotalError(20111, "WxAPIErrorTotal"),
    WxNotifyAPIError(20112, "WxNotifyAPIError"),

    AliAPIError(20120, "AliAPIError"),
    AliAPITotalError(20121, "AliAPIErrorTotal"),
    AliNotifyAPIError(20122, "AliNotifyAPIError"),

    SMSAPIError(20130, "SMSAPIError"),
    CDNAPIError(20140, "CDNAPIError"),
    ;
    private int status;
    private String message;

    ErrorEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResponseError{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
