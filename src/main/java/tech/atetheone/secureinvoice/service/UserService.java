package tech.atetheone.secureinvoice.service;

import tech.atetheone.secureinvoice.domain.User;
import tech.atetheone.secureinvoice.dto.UserDto;

public interface UserService {
  UserDto createUser(User user);
}
