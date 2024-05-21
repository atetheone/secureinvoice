package tech.atetheone.secureinvoice.repository;

import tech.atetheone.secureinvoice.domain.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role> {
  void addRoleToUser(Long userId, String roleName);
  T create(T user);
  Collection<T> list(int page, int pageSize);
  T findById(Long id);
}
