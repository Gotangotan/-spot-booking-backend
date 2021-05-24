package nl.spotbooking.spotbooking.model;

//POJO - Plain Old Java Object

import javax.persistence.*;
import java.util.List;

@Entity
public class Date {

    // attributen die overeenkomen met de columns in PostgreSQL/SpotBooking/Table/Columns

    @OneToMany(mappedBy = "date")
    List<Desk> dates;
    //PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String Date;


    //getters and setters

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

}
