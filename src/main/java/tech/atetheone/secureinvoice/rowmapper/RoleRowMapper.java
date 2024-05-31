package tech.atetheone.secureinvoice.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import tech.atetheone.secureinvoice.domain.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {
  @Override
  public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Role.builder()
          .roleId(rs.getLong("role_id"))
          .name(rs.getString("name"))
          .permission(rs.getString("permission"))
          .build();
  }
}
