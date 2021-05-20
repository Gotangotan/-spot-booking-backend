package nl.spotbooking.spotbooking.service;

import nl.spotbooking.spotbooking.exception.RecordNotFoundException;
import nl.spotbooking.spotbooking.model.Desk;
import nl.spotbooking.spotbooking.repository.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskServiceImpl implements DeskService {

    @Autowired
    private DeskRepository deskRepository;

    @Override
    public List<Desk> getAllDesk() {
        return deskRepository.findAll();
    }

    @Override
    public Desk getDesk(long id) {
        if (deskRepository.existsById(id)) {
            return deskRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException("No desk found with this id"  + id);
        }
    }

    @Override
    public void save(Desk desk) {
        deskRepository.save(desk);
    }

    @Override
    public void deleteById(long id) {
        if (deskRepository.existsById(id)) {
            deskRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No desk found with this id"  + id);
        }
    }

    @Override
    public void updateDesk(long id, Desk desk) {
        if (!deskRepository.existsById(id)) throw new RecordNotFoundException();
        Desk existingDesk = deskRepository.findById(id).get();
        existingDesk.setAvailability(desk.getAvailability());
        existingDesk.setUsername(desk.getUsername());
        existingDesk.setEmail(desk.getEmail());
        deskRepository.save(existingDesk);
    }



}
