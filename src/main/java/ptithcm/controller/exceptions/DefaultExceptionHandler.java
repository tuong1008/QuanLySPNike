package ptithcm.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ptithcm.exceptions.PageNotFoundException;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = PageNotFoundException.class)
    public String handle404(Exception e) {
        System.out.println("Page not found");
        return "error/404";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String defaultHandler(Exception e) {
        System.out.println("Page not found");
        return "error/500";
    }

}
