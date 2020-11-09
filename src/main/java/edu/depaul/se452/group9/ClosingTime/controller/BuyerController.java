package edu.depaul.se452.group9.ClosingTime.controller;

import edu.depaul.se452.group9.ClosingTime.dao.BuyerDAO;
import edu.depaul.se452.group9.ClosingTime.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuyerController {

    @Autowired
    private BuyerDAO buyerDAO;

    @GetMapping("/buyers/signup") // render signup page for buyer
    public String newBuyer(Model model) {
        model.addAttribute("buyer", new Buyer());
        return "buyer/newbuyer";
    }

    @PostMapping("/buyers/signup") // signup new buyer
    public String createBuyer(@ModelAttribute Buyer buyer) {
        buyerDAO.createBuyer(buyer);
        return "redirect:/buyers";
    }

    @GetMapping("/buyers") // show all buyers
    public String getBuyers(Model model) {
        model.addAttribute("buyers", buyerDAO.getBuyers());
        return "buyer/buyers";
    }

    @GetMapping("/buyers/{id}") // show single buyer
    public String getBuyer(@PathVariable("id") String id, Model model) {
        model.addAttribute("buyer", buyerDAO.getBuyer(id));
        return "buyer/buyer";
    }

    @GetMapping("/buyers/edit/{id}") // render edit page for buyer
    public String editBuyer(@PathVariable("id") String id, Model model) {
        model.addAttribute("buyer", buyerDAO.getBuyer(id));
        return "buyer/editbuyer";
    }

    @PutMapping() // edit buyer
    public void updateBuyer(@RequestBody Buyer buyer) { buyerDAO.updateBuyer(buyer); }

    @DeleteMapping("/buyers/delete/{id}") // delete buyer
    public String deleteBuyer(@PathVariable("id") String id) {
        buyerDAO.deleteBuyer(id);
        return "redirect:/buyers";
    }

}
