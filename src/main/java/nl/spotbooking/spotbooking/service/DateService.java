package nl.spotbooking.spotbooking.service;

import nl.spotbooking.spotbooking.model.Date;

import java.util.List;


public interface DateService {

    List<Date> getAllDates();

    Date getDate(long id);

    void save(Date date);

    void deleteById(long id);
}
