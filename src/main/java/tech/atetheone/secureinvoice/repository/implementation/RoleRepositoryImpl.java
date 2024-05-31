package tech.atetheone.secureinvoice.repository.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import tech.atetheone.secureinvoice.domain.Role;
import tech.atetheone.secureinvoice.exception.ApiException;
import tech.atetheone.secureinvoice.repository.RoleRepository;
import tech.atetheone.secureinvoice.rowmapper.RoleRowMapper;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static tech.atetheone.secureinvoice.enumeration.RoleType.ROLE_USER;
import static tech.atetheone.secureinvoice.query.RoleQuery.INSERT_ROLE_TO_USER_QUERY;
import static tech.atetheone.secureinvoice.query.RoleQuery.SELECT_ROLE_BY_NAME_QUERY;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository {
  private final NamedParameterJdbcTemplate jdbc;
  @Override
  public Role create(Role user) {
    return null;
  }

  @Override
  public Collection list(int page, int pageSize) {
    return List.of();
  }

  @Override
  public Role findById(Long id) {
    return null;
  }

  @Override
  public void addRoleToUser(Long userId, String roleName) {
    log.info("Adding role {} to user {}", roleName, userId);

    try {
      // add role to user
      Role role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, Map.of("role_name", roleName), new RoleRowMapper());
      jdbc.update(INSERT_ROLE_TO_USER_QUERY, Map.of("user_id", userId, "role_id", role.getRoleId()));
    } catch (EmptyResultDataAccessException e) {
      log.error("Empty result error", e);
      throw new ApiException("No role found by name: " + ROLE_USER.name());
    } catch (Exception e) {
      log.error("Error occurred while saving user to database", e);
      throw new ApiException("Error occurred while saving user to database"); // don't be specific about the error
    }
  }

  @Override
  public Role getRoleByUserId(Long userId) {
    return null;
  }

  @Override
  public Role getRoleByEmail(String email) {
    return null;
  }

  @Override
  public void updateUserRole(Long userId, String roleName) {

  }
}
