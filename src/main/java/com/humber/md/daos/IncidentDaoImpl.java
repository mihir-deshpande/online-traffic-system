package com.humber.md.daos;

import com.humber.md.models.Incident;
import com.humber.md.models.Officer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IncidentDaoImpl implements IncidentDao{

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public Incident save(Incident incident) {
            // Save incident to database and return incident
            entityManager.persist(incident);
            return incident;
        }

        @Override
        @Transactional
        // Get all incidents by officer
        public List<Incident> getIncidentsByOfficerId(Officer officer) {
            String hql = "FROM Incident WHERE officer = :officer ORDER BY id DESC";
            TypedQuery<Incident> query = entityManager.createQuery(hql, Incident.class);
            query.setParameter("officer", officer);
            return query.getResultList();
        }
}
