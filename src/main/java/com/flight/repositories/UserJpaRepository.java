package com.flight.repositories;

import com.flight.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findUsers(String firstName, String lastName, String email) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(User.class);
        var user = criteriaQuery.from(User.class);
        var predicates = new ArrayList<Predicate>();
        if (firstName != null) {
            predicates.add(criteriaBuilder.equal(user.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(criteriaBuilder.equal(user.get("lastName"), lastName));
        }
        if (email != null) {
            predicates.add(criteriaBuilder.equal(user.get("email"), email));
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }


}
