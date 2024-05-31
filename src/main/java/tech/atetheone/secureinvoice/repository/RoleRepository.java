package tech.atetheone.secureinvoice.repository;

import tech.atetheone.secureinvoice.domain.Role;

import java.util.Collection;

public interface RoleRepository<T extends Role> {
  T create(T user);
  Collection<T> list(int page, int pageSize);
  T findById(Long id);

  void addRoleToUser(Long userId, String roleName);
  Role getRoleByUserId(Long userId);
  Role getRoleByEmail(String email);
  void updateUserRole(Long userId, String roleName);
}
