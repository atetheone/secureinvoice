package tech.atetheone.secureinvoice.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@JsonInclude(NON_DEFAULT)
public class User {
  private Long userId;
  @NotEmpty(message = "First name is required")
  private String firstName;
  @NotEmpty(message = "Last name is required")
  private String lastName;
  @NotEmpty(message = "Password is required")
  private String password;
  @NotEmpty(message = "Email is required")
  @Email(message = "Invalid email")
  private String email;
  private String address;
  private String phone;
  private String title;
  private String bio;
  private boolean enabled;
  private boolean nonLocked;
  private boolean usingMfa;
  private String imageUrl;
  private LocalDateTime createdAt;
}