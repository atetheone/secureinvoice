package tech.atetheone.secureinvoice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(NON_DEFAULT)
public class HttpResponse {
  protected String timestamp;
  protected int httpStatusCode;
  protected String httpStatus;
  protected String reason;
  protected String message;
  protected String developerMessage;
  protected Map<?, ?> data;
}
