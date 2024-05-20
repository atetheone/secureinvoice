package tech.atetheone.secureinvoice.exception;

public class ApiException extends RuntimeException {
  public ApiException(String message) {
    super(message);
  }
}
