/**
 * Controller to handel all the routes related to Officer
 * @author  Mihir
 */
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

    // Inject OfficerDao
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
        // Get officer by username
        Officer officerByUsername = officerDao.getOfficerByUsername(officer.getUsername());
        if(officerByUsername != null) {
            if(officerByUsername.getPassword().equals(officer.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedinOfficer", officerByUsername);
                return "redirect:/incident/incidents"; // Redirect to incidents
            }
        }
        return "redirect:/officer/signin"; // Redirect to signin if officer not found
    }


    // Logout officer
    @GetMapping("/officer/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("loggedinOfficer");
        return "redirect:/";
    }

}
