package tech.atetheone.secureinvoice.query;

public class UserQuery {
  public final static String INSERT_USER_QUERY = "INSERT INTO users (first_name, last_name, password, email) VALUES (:first_name, :last_name, :password, :email)";
  public final static String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email = :email";
  public final static String INSERT_ACCOUNT_VERIFICATION_QUERY = "INSERT INTO account_verifications (user_id, url) VALUES (:user_id, :url)";
}
