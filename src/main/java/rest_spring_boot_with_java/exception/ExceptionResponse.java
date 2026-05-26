package rest_spring_boot_with_java.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
