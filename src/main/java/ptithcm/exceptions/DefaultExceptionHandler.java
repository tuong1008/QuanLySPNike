package ptithcm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DefaultExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = PageNotFoundException.class)
    public String handle404(Exception e, Model model) {
        System.out.println("Page not found");
        model.addAttribute("message", e.getMessage());
        return "error/404";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String defaultHandler(Exception e) {
        System.out.println("Page not found");
        return "error/500";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnauthorizedException.class)
    public String handle401(Exception e, Model model) {
        System.out.println("Unauthorized");
        model.addAttribute("message", e.getMessage());
        return "error/401";
    }

}
