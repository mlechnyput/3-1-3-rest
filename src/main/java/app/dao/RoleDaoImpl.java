package app.dao;

import app.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class RoleDaoImpl {

    @PersistenceContext
    EntityManager em;

    public Role findByRole(String role) {
        TypedQuery<Role> query = em.createQuery("from Role r where r.role = :x", Role.class);
        query.setParameter("x", role);
        return query.getSingleResult();
    }
}
