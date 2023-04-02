package com.humber.md.daos;

import com.humber.md.models.Incident;
import com.humber.md.models.Officer;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IncidentDao {

    public Incident save(Incident incident);

    public List<Incident> getIncidentsByOfficerId(Officer officer);

}
