package com.walle.girl.exception;

import com.walle.girl.enums.ResultEnum;

/**
 * Created by 张向吉
 * 2017/9/22.10:22
 * good good study!
 *
 * RuntimeException 继承 Exception
 * 而且Spring 框架支队抛出的RuntimeException进行职务回滚
 */
public class MyException extends RuntimeException {
    private int code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code =resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
