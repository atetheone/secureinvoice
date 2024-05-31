package tech.atetheone.secureinvoice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.atetheone.secureinvoice.domain.HttpResponse;
import tech.atetheone.secureinvoice.domain.User;
import tech.atetheone.secureinvoice.dto.UserDto;
import tech.atetheone.secureinvoice.service.UserService;

import java.net.URI;
import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<HttpResponse> saveUser(@RequestBody @Valid User user) {
    UserDto userDto = userService.createUser(user);
    return ResponseEntity.created(null).body(
            HttpResponse.builder()
                    .timestamp(now().toString())
                    .data(Map.of("user", userDto))
                    .message("User created successfully")
                    .httpStatus("CREATED")
                    .httpStatusCode(HttpStatus.CREATED.value())
                    .build()
    );
  }

  private URI getUri() {
    String path = "/api/v1/user/get/<userId>";
    return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path(path).toUriString());
  }
}
