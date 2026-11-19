package in.ashokit.handler;

import in.ashokit.dto.ErrorResponse;
import in.ashokit.exception.FoodOrderNotFoundException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleExeption(FoodOrderNotFoundException ex, HttpServletRequest request)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setLocalDateTime(LocalDateTime.now());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setStatus(400);
        errorResponse.setPath(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
