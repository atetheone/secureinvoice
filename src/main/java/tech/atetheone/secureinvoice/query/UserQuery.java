package tech.atetheone.secureinvoice.query;

public class UserQuery {
  public final static String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email = :email";
  public final static String INSERT_USER_QUERY = "INSERT INTO users (first_name, last_name, password, email, address, phone, title, bio, enabled, non_locked, using_mfa, image_url, created_at) VALUES (:firstName, :lastName, :password, :email, :address, :phone, :title, :bio, :enabled, :nonLocked, :usingMfa, :imageUrl, :createdAt)";
}
