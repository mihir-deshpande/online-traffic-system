package com.humber.md.daos;

import com.humber.md.models.Route;

import java.util.List;

public interface RouteDao {
    List<Route> findAll();

    Route getRouteById(int routeId);

}
