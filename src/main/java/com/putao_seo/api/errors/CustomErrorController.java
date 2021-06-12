package com.putao_seo.api.errors;

//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////server.error.whitelabel.enabled=false
//
//@RestController
//public class CustomErrorController implements ErrorController {
//
//    private static final String PATH = "/error";
//
//    @RequestMapping(value = PATH)
//    public Errors error(HttpServletResponse response) {
//    	if(response.getStatus() == 404)
//    		return Errors.endPointNotFound();
//    	else if (response.getStatus() == 400)
//    		return Errors.cannotAddBookException();
//    	return Errors.bookNotFound();
//    }
//
//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }
//
//}



//// 不要用这个Errors,直接输出 {"code":"1", "error_code": response.getStatus()}  ??