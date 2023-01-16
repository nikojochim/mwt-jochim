package de.stuttgart.hft.controller;

import de.stuttgart.hft.domain.HotelBuchung;
import de.stuttgart.hft.infrastructure.repository.HotelBuchungRepository;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController

@RequestMapping(path = "/bockings", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HotelBuchungController {

    HotelBuchungRepository repository;


    @GetMapping
    public final ResponseEntity<Collection<HotelBuchung>> getBookings(){

        return ResponseEntity.ok(repository.findAll());
    }

    @SneakyThrows
    @GetMapping("{id}")
    public final ResponseEntity<HotelBuchung> getBookingByID(@PathVariable int id){
        return ResponseEntity.ok(repository.findById(id).orElseThrow(() -> new Exception()));
    }

    @PostMapping
    public final ResponseEntity<HotelBuchung> createBooking(@RequestBody HotelBuchung bocking){
        final HotelBuchung save = repository.save(bocking);
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @PutMapping()
    public final ResponseEntity<HotelBuchung> updateById(@RequestBody HotelBuchung buchung) {
        final Optional<HotelBuchung> byId = repository.findById(buchung.getId());
        if(byId.isPresent()){
            final HotelBuchung hotelBuchung = byId.get();
            hotelBuchung.setName(buchung.getName());
            hotelBuchung.setStartDate(buchung.getStartDate());
            hotelBuchung.setEndDate(buchung.getEndDate());
            hotelBuchung.setRoomNumber(buchung.getRoomNumber());
            return ResponseEntity.ok(repository.save(hotelBuchung));
        }
        return  ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        repository.deleteById(id);

    }


}
