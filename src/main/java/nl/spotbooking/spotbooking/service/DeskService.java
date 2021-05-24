package nl.spotbooking.spotbooking.service;

import nl.spotbooking.spotbooking.model.Desk;

import java.util.List;


public interface DeskService {

    List<Desk> getAllDesk();

    Desk getDesk(long id);

    void save(Desk desk);

    void deleteById(long id);

    void updateDesk(long id, Desk desk);
}
