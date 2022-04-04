package pro.sky.employeeBook.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIsInArrayException extends RuntimeException{

    public EmployeeIsInArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
