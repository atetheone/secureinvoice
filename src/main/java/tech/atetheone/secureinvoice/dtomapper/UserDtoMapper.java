package tech.atetheone.secureinvoice.dtomapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tech.atetheone.secureinvoice.domain.User;
import tech.atetheone.secureinvoice.dto.UserDto;

@Component
public class UserDtoMapper {
  public static UserDto fromUser(User user) {
    UserDto userDto = new UserDto();
    BeanUtils.copyProperties(user, userDto);

    return userDto;
  }

  public static User toUser(UserDto userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);

    return user;
  }
}
