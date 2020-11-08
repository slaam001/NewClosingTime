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

    @PostMapping
    public Buyer createBuyer(@RequestBody Buyer buyer) { return buyerDAO.createBuyer(buyer); }

    @GetMapping("/buyers")
    public String getBuyers(Model model) {
        model.addAttribute("buyers", buyerDAO.getBuyers());
        return "buyers";
    }

    @GetMapping("/buyers/{id}")
    public String getBuyer(@PathVariable("id") String id, Model model) {
        model.addAttribute("buyer", buyerDAO.getBuyer(id));
        return "buyer";
    }

    @PutMapping("/buyers/edit/{id}")
    public void updateBuyer(@PathVariable("id") String id, @RequestBody Buyer buyer) {
        buyerDAO.updateBuyer(id, buyer);
    }

    @DeleteMapping("/buyers/delete/{id}")
    public void deleteBuyer(@PathVariable("id") String id) { buyerDAO.deleteBuyer(id); }

}
