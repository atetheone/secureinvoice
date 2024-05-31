package tech.atetheone.secureinvoice.query;

public class RoleQuery {
  public final static String INSERT_ROLE_TO_USER_QUERY = "INSERT INTO user_roles (user_id, role_id) VALUES (:user_id, :role_id)";
  public final static String SELECT_ROLE_BY_NAME_QUERY = "SELECT * FROM roles WHERE role_name = :role_name";
}

