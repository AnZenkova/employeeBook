package pro.sky.employeeBook.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEmployeeException extends RuntimeException{
    public NotFoundEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
