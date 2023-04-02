package com.humber.md.controllers;


import com.humber.md.daos.IncidentDao;
import com.humber.md.daos.RouteDao;
import com.humber.md.daos.VehicleDao;
import com.humber.md.models.Incident;
import com.humber.md.models.Officer;
import com.humber.md.models.Route;
import com.humber.md.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IncidentController {

    @Autowired
    private IncidentDao incidentDao;

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private RouteDao routeDao;


    // Display all incidents for particular officer
    @GetMapping("/incident/incidents")
    public String displayIncidents(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();

        if(session.getAttribute("loggedinOfficer") != null) {
            Officer loggedInOfficer = (Officer) session.getAttribute("loggedinOfficer");
            List<Incident> incidents = incidentDao.getIncidentsByOfficerId(loggedInOfficer);
            model.addAttribute("incidents", incidents);
            return "incident/incidents";
        }

        return "redirect:/";
    }

    @GetMapping("/incident/create")
    public String createIncident(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(session.getAttribute("loggedinOfficer") != null) {
            // Get all vehicles and routes
            List<Vehicle> vehicles = vehicleDao.findAll();
            List<Route> routes = routeDao.findAll();

            model.addAttribute("vehicles", vehicles);
            model.addAttribute("routes", routes);

            return "incident/create";
        }
        return "redirect:/";
    }

    @PostMapping("/incident/create")
    public String handleCreateIncident(Incident incident, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(session.getAttribute("loggedinOfficer") != null) {
            Officer loggedInOfficer = (Officer) session.getAttribute("loggedinOfficer");


            // Get form fields
            int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
            int routeId = Integer.parseInt(request.getParameter("routeId"));
            String description = request.getParameter("description");
            String incidentDate = request.getParameter("date");
            String incidentId = request.getParameter("incidentId");


            // Get vehicle and route by id
            Vehicle vehicle = vehicleDao.getVehicleById(vehicleId);
            Route route = routeDao.getRouteById(routeId);

            Incident newIncident = (incidentId != null) ? incidentDao.getIncidentById(Integer.parseInt(incidentId)) : new Incident();

            newIncident.setVehicle(vehicle);
            newIncident.setRoute(route);
            newIncident.setDescription(description);
            newIncident.setIncidentDate(incidentDate);
            newIncident.setOfficer(loggedInOfficer);
            if(incidentId != null){
                newIncident.setIncidentId(Integer.parseInt(incidentId));
            }

            incidentDao.save(newIncident);

            return "redirect:/incident/incidents";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/incident/delete/{id}", method = RequestMethod.GET)
    public String deleteIncident(@PathVariable("id") int id, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(session.getAttribute("loggedinOfficer") != null) {
            incidentDao.deleteById(id);
            return "redirect:/incident/incidents";
        }
        return "redirect:/";
    }


    @GetMapping("/incident/edit/{id}")
    public String editIncident(@PathVariable("id") int id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if(session.getAttribute("loggedinOfficer") != null) {
            // Get all vehicles and routes
            List<Vehicle> vehicles = vehicleDao.findAll();
            List<Route> routes = routeDao.findAll();

            model.addAttribute("vehicles", vehicles);
            model.addAttribute("routes", routes);

            Incident incident = incidentDao.getIncidentById(id);
            model.addAttribute("incident", incident);

            return "incident/edit";
        }
        return "redirect:/";
    }


}
