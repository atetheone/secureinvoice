package tech.atetheone.secureinvoice.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.atetheone.secureinvoice.domain.User;
import tech.atetheone.secureinvoice.dto.UserDto;
import tech.atetheone.secureinvoice.dtomapper.UserDtoMapper;
import tech.atetheone.secureinvoice.repository.UserRepository;
import tech.atetheone.secureinvoice.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private  final UserRepository userRepository;
  @Override
  public UserDto createUser(User user) {
    return UserDtoMapper.fromUser(userRepository.create(user));
  }
}
