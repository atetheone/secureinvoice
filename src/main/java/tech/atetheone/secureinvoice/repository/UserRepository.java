package tech.atetheone.secureinvoice.repository;

import tech.atetheone.secureinvoice.domain.User;

import java.util.Collection;

public interface UserRepository<T extends User> {
  /* Basic CRUD operations */
  T create(T user);
  Collection<T> list(int page, int pageSize);
  T findById(Long id);
  T update(T data);
  T findByEmail(String email);
  Boolean deleteById(Long id);
}
