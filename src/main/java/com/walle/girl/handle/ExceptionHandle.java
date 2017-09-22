package com.walle.girl.handle;

import com.walle.girl.entity.Result;
import com.walle.girl.enums.ResultEnum;
import com.walle.girl.exception.MyException;
import com.walle.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;


/**
 * Created by 张向吉
 * 2017/9/22.
 * good good study!
 * <p>
 * 在spring 3.2中，新增了@ControllerAdvice 注解，可以用于定义@ExceptionHandler、@InitBinder、@ModelAttribute，并应用到所有@RequestMapping中。
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 全局异常捕捉处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if(e instanceof MyException){
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(), myException.getMessage());
        }
        logger.error("[系统异常]{}",e);
        return ResultUtil.error2(ResultEnum.UNKONW_ERROR);
    }




    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     * @ModelAttribute：在Model上设置的值，对于所有被 @RequestMapping 注解的方法中，都可以通过 ModelMap 获取，
     * public String home(ModelMap modelMap) {
     * System.out.println(modelMap.get("author"));
     * }
     * public String home(@ModelAttribute("author") String author) {
     * System.out.println(author);
     * }
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "walle");
    }

}
