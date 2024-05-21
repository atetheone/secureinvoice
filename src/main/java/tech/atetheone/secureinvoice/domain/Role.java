package tech.atetheone.secureinvoice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@JsonInclude(NON_DEFAULT)
public class Role {
  private Long roleId;
  @NotEmpty(message = "Name is required")
  private String name;
  @NotEmpty(message = "Permission is required")
  private String permission;
}