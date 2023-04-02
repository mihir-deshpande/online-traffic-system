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
        @Transactional
        public Incident save(Incident incident) {
            // Save incident to database and return incident
            if (incident.getIncidentId() == 0) {
                // If the incident has no ID, it's a new entity, so persist it
                entityManager.persist(incident);
            } else {
                // If the incident has an ID, find the existing entity first
                Incident existingIncident = entityManager.find(Incident.class, incident.getIncidentId());
                if (existingIncident != null) {
                    // If the existing entity is found, update it
                    entityManager.merge(incident);
                } else {
                    // If the existing entity is not found, persist the incident as a new entity
                    entityManager.persist(incident);
                }
            }
            return incident;
        }


        @Override
        @Transactional
        public List<Incident> getIncidentsByOfficerId(Officer officer) {
            String hql = "FROM Incident WHERE officer = :officer ORDER BY id DESC";
            TypedQuery<Incident> query = entityManager.createQuery(hql, Incident.class);
            query.setParameter("officer", officer);
            return query.getResultList();
        }

        @Override
        @Transactional
        public void deleteById(int id) {
            Incident incident = entityManager.find(Incident.class, id);
            entityManager.remove(incident);

        }

        @Override
        @Transactional
        public Incident getIncidentById(int id) {
            return entityManager.find(Incident.class, id);
        }

}
