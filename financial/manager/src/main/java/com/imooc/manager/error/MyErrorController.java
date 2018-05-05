package com.imooc.manager.error;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 自定义错误处理控制器
 *
 * @author xiaozefeng
 * @date 2018/5/4 下午11:08
 */
public class MyErrorController extends BasicErrorController {
    public MyErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorProperties, errorViewResolvers);
    }

    /**
     * {
     *     "timestamp": "2018-05-04 23:08:53",
     *     "status": 500,
     *     "error": "Internal Server Error",
     *     "exception": "java.lang.IllegalArgumentException",
     *     "message": "编号不能为空",
     *     "path": "/manager/product"
     * }
     */

    @Override
    protected Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {

        Map<String, Object> errorAttributes = super.getErrorAttributes(request, includeStackTrace);
        // 移除不必要的属性
        errorAttributes.remove("timestamp");
        errorAttributes.remove("status");
        errorAttributes.remove("error");
        errorAttributes.remove("exception");
        errorAttributes.remove("error");
        errorAttributes.remove("path");

        return errorAttributes;
    }
}
