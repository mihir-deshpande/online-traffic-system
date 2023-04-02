package com.humber.md.controllers;


import com.humber.md.daos.IncidentDao;
import com.humber.md.models.Incident;
import com.humber.md.models.Officer;
import com.humber.md.models.Route;
import com.humber.md.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IncidentController {

    @Autowired
    private IncidentDao incidentDao;


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



}
