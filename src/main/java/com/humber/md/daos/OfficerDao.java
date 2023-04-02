package com.humber.md.daos;

import java.util.List;
import com.humber.md.models.Officer;


public interface OfficerDao {
    List<Officer> findAll();
    Officer save(Officer officer);
}
