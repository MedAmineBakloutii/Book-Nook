package net.javaguides.bibliotheque.Controller;



import net.javaguides.bibliotheque.Model.Reservation;
import net.javaguides.bibliotheque.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ReservationController {

    @Autowired
    private net.javaguides.bibliotheque.service.LivreService livreservice;
    @Autowired
    private net.javaguides.bibliotheque.service.UserService userService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/allReservation")
    public String GetAllReservation(Model model){
        List <Reservation> allreservation = reservationService.getAllReservation();
        model.addAttribute("allListreservation" , allreservation);
        return "Reservation";
    }
    @PostMapping( "/saveReservation")
    public Reservation PostAllReservation(@RequestBody Reservation reservation){
        return this.reservationService.saveReservation(reservation);
    }
    @GetMapping("/oneReservation/{id}")
    public Reservation GetOneReservation(@PathVariable("id") int id){
        return this.reservationService.getOneReservationById( id);
    }
    @PutMapping("/update/{id}")
    public Reservation PostAllReservation(@RequestBody Reservation reservation ,@PathVariable ("id") int id){
        return this.reservationService.updateReservation(reservation , id);
    }

    @GetMapping(value = "/deletereservation/{id}")
    public String DeleteReservation(@PathVariable ("id") int id){

        this.reservationService.deleteReservation(id);
        return "redirect:/allReservation";


    }
    @GetMapping("/addreservation/{livre}/{user}")
    public String addEmprunt(@ModelAttribute("addreservation") Reservation addreservation, @PathVariable("livre") int livre ) {
       /* Livre exitlivre = livreservice.getOneLivreById(livre);
        User exituser = userService.getOneUserById(1);
        addreservation.setLivre(exitlivre);
        addreservation.setUser(exituser);*/

        reservationService.saveReservation(addreservation);
        return "redirect:/allReservation";
    }
}
