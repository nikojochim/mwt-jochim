package de.stuttgart.hft.domain;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table(name="bookings")
@Data
@NoArgsConstructor
public class HotelBuchung {
    @Id
    private int id;
    private String name;
    private int roomNumber;
    private LocalDate startDate;
    private LocalDate endDate;


}
