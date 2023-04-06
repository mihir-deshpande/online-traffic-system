/**
 * @author  Mihir
 * @description This class is used to handle all the database operations related to the Officer table.
 */
package com.humber.md.daos;

import com.humber.md.models.Officer;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
