package com.walle.girl.utils;

import com.walle.girl.entity.Result;
import com.walle.girl.enums.ResultEnum;

/**
 * Created by 张向吉
 * 2017/9/22.
 * good good study!
 */
public class ResultUtil {
    /**
     * 成功带参数
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功不带参数
     * @return
     */
    public static Result success(){
       return success(null);
    }

    /**
     * 失败
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
    /**
     * 失败
     * @param resultEnum
     * @return
     */
    public static Result error2(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

}
