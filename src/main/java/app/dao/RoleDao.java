package app.dao;

import app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDao extends JpaRepository<Role, Long> {
    @Query("SELECT r from Role r Where r.role = :role")
    public Role findByRole(@Param("role") String role);
}
