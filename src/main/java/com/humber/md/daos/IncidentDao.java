package com.humber.md.daos;

import com.humber.md.models.Incident;
import com.humber.md.models.Officer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IncidentDao {

    Incident save(Incident incident);

    List<Incident> getIncidentsByOfficerId(Officer officer);

    void deleteById(int id);

    Incident getIncidentById(int id);

}
