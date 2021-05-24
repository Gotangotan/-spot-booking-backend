package nl.spotbooking.spotbooking.service;

import nl.spotbooking.spotbooking.exception.RecordNotFoundException;
import nl.spotbooking.spotbooking.model.Date;
import nl.spotbooking.spotbooking.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateServiceImpl implements DateService {

    @Autowired
    private DateRepository dateRepository;

    @Override
    public List<Date> getAllDates() {
        return dateRepository.findAll();
    }

    @Override
    public Date getDate(long id) {
        if (dateRepository.existsById(id)) {
            return dateRepository.findById(id).orElse(null);
        } else {
            throw new RecordNotFoundException("No date found with this id" + id);
        }
    }

    @Override
    public void save(Date date) {
        dateRepository.save(date);
    }

    @Override
    public void deleteById(long id) {
        if (dateRepository.existsById(id)) {
            dateRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No date found with this id" + id);
        }
    }

}
