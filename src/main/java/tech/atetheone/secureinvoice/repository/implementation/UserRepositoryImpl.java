package tech.atetheone.secureinvoice.repository.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import tech.atetheone.secureinvoice.domain.User;
import tech.atetheone.secureinvoice.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl<T extends User> implements UserRepository<User> {
  private final NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public User create(User user) {
    // check if user email is unique
    // save user to database
    // add role to user
    // send verification url
    // save url in verification table
    // send email to user with verification url
    // return user
    return null;
  }

  @Override
  public Collection<User> list(int page, int pageSize) {
    return List.of();
  }

  @Override
  public User findById(Long id) {
    return null;
  }

  @Override
  public User update(User data) {
    return null;
  }

  @Override
  public User findByEmail(String email) {
    String sql = "SELECT * FROM users WHERE email = :email";
    return null;
  }

  @Override
  public Boolean deleteById(Long id) {
    return null;
  }
}
