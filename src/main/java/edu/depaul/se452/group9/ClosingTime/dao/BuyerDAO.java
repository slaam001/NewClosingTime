package edu.depaul.se452.group9.ClosingTime.dao;

import edu.depaul.se452.group9.ClosingTime.dao.interfaces.IBuyerRespository;
import edu.depaul.se452.group9.ClosingTime.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuyerDAO {

    @Autowired
    private IBuyerRespository repository;

    public Buyer createBuyer(Buyer buyer) { return repository.insert(buyer); }

    public List<Buyer> getBuyers() { return repository.findAll(); }

    public Buyer getBuyer(String id) { return repository.findById(id).orElse(null); }

    public void updateBuyer(String id, Buyer buyer) {
        repository.save(buyer);
    }

    public void deleteBuyer(String id) { repository.deleteById(id); }

}
