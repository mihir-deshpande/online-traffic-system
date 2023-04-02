package com.humber.md.daos;

import com.humber.md.models.Officer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class OfficerDaoImpl implements OfficerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Officer> findAll() {
        TypedQuery<Officer> query = entityManager.createQuery("from Officer", Officer.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Officer save(Officer officer) {
        entityManager.persist(officer);
        return officer;
    }

    // Get and officer my username
    @Override
    public Officer getOfficerByUsername(String username) {
        TypedQuery<Officer> query = entityManager.createQuery("from Officer where username = :username", Officer.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

}
