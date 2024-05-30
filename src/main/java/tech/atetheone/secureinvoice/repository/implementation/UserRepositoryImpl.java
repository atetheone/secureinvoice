package tech.atetheone.secureinvoice.repository.implementation;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import tech.atetheone.secureinvoice.domain.Role;
import tech.atetheone.secureinvoice.domain.User;
import tech.atetheone.secureinvoice.exception.ApiException;
import tech.atetheone.secureinvoice.repository.UserRepository;
import tech.atetheone.secureinvoice.repository.RoleRepository;


import java.util.Collection;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static tech.atetheone.secureinvoice.enumeration.RoleType.ROLE_USER;
import static tech.atetheone.secureinvoice.query.UserQuery.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
  private final NamedParameterJdbcTemplate jdbc;
  private final RoleRepository<Role> roleRepository = null;
  private final BCryptPasswordEncoder passwordEncoder = null;



  @Override
  public User create(User user) {
    // check if user email is unique
    if (findByEmail(user.getEmail().trim().toLowerCase()) != null) {
      log.error("User with email {} already exists", user.getEmail());
      throw new ApiException("User with email " + user.getEmail() + " already exists");
    }
    // save user to database
    try {
      KeyHolder keyHolder = new GeneratedKeyHolder(); // to get the generated user id
      SqlParameterSource params =  getSqlParameterSource(user);
      jdbc.update(INSERT_USER_QUERY, params, keyHolder);
      user.setUserId(requireNonNull(keyHolder.getKey()).longValue());
      // add user role
      roleRepository.addRoleToUser(user.getUserId(), ROLE_USER.name());

      // send verification url
      // save url in verification table
      // send email to user with verification url
      // return user

    } catch (Exception e) {

    }

    return null;
  }

  private SqlParameterSource getSqlParameterSource(User user) {
   return new MapSqlParameterSource()
            .addValue("firstName", user.getFirstName())
            .addValue("lastName", user.getLastName())
           .addValue("email", user.getEmail())
            .addValue("password", passwordEncoder.encode(user.getPassword()));

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
    MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue("email", email);

    RowMapper<User> rowMapper = (rs, rowNum) -> {
      User user = new User();
      user.setUserId(rs.getLong("user_id"));
      user.setFirstName(rs.getString("first_name"));
      user.setLastName(rs.getString("last_name"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      user.setAddress(rs.getString("address"));
      user.setPhone(rs.getString("phone"));
      user.setTitle(rs.getString("title"));
      user.setBio(rs.getString("bio"));
      user.setEnabled(rs.getBoolean("enabled"));
      user.setNonLocked(rs.getBoolean("non_locked"));
      user.setUsingMfa(rs.getBoolean("using_mfa"));
      user.setImageUrl(rs.getString("image_url"));
      user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
      return user;
    };

    List<User> users = jdbc.query(FIND_BY_EMAIL_QUERY, params, rowMapper);

    return users.isEmpty() ? null : users.get(0);
  }

  @Override
  public Boolean deleteById(Long id) {
    return null;
  }
}
