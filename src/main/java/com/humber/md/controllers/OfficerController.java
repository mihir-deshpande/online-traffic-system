package com.humber.md.controllers;

import com.humber.md.daos.OfficerDao;
import com.humber.md.models.Incident;
import com.humber.md.models.Officer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class OfficerController {

    @Autowired
    private OfficerDao officerDao;


    // Routes to signup Officer
    @GetMapping("/officer/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("officer", new Officer());
        return "officer/signup";
    }

    @PostMapping("/officer/signup")
    public String handleSignupForm(Officer officer) {
        officerDao.save(officer);
        return "redirect:/officer/signin";
    }

    // Routes to SignIn Officer
    @GetMapping("/officer/signin")
    public String showSignIpForm(Model model) {
        model.addAttribute("officer", new Officer());
        return "officer/signin";
    }


    @PostMapping("/officer/signin")
    public String handleSignInForm(Officer officer, HttpServletRequest request, Model model) {

        // Get all officers
        List<Officer> officers = officerDao.findAll();
        Officer loggedInOfficer = new Officer();

        // Check if officer exists
        for (Officer o : officers) {
            if (o.getUsername().equals(officer.getUsername()) && o.getPassword().equals(officer.getPassword())) {
                loggedInOfficer = o;
                HttpSession session = request.getSession();
                session.setAttribute("loggedinOfficer", loggedInOfficer);
                return "redirect:/incident/incidents";
            }
        }
        // If officer does not exist
        return "redirect:/officer/signin";
    }

    // Logout officer
    @GetMapping("/officer/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("loggedinOfficer");
        return "redirect:/";
    }

}
