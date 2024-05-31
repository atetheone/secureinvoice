package tech.atetheone.secureinvoice.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class UserDto {
  private Long userId;
  private String firstName;
  private String lastName;
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