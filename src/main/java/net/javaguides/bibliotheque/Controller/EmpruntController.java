package net.javaguides.bibliotheque.Controller;


import net.javaguides.bibliotheque.Model.Emprunts;
import net.javaguides.bibliotheque.Service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller


public class EmpruntController {

    @Autowired
    private EmpruntService empruntService;
    @Autowired
    private net.javaguides.bibliotheque.Service.LivreService livreservice;
    @Autowired
    private net.javaguides.bibliotheque.Service.UserService userService;

    @GetMapping("/oneEmprunts/{id}")
    public Emprunts GetOneEmprunts(@PathVariable("id") int id){
        return this.empruntService.getOneEmpruntsById( id);

    }

    @GetMapping("/listeLivre")
    public String listeLivre(Model model) {
        //List <Livre> allLivre = livreservice.getAlllivre();
        //model.addAttribute("allListLivre" , allLivre);
        return "listeLivre";
    }

    @GetMapping("/emprunt")
    public String emprunt(Model model) {
        List <Emprunts> allEmprunt = empruntService.getAllEmprunt();
        model.addAttribute("allListEmprunt" , allEmprunt);
        return "emprunt";
    }

    @GetMapping("/formEmprunt/{livre}/{user}")
    public String showforum(Model model , @PathVariable("livre") int livreId, @PathVariable("user") int userId) {
        model.addAttribute("livre", livreId);
        System.out.println(livreId);
        System.out.println(userId);
        model.addAttribute("user", userId);
        model.addAttribute("addemprunt", new Emprunts());
        return "create";
    }

    @PostMapping("/addEmprunt/{livre}/{user}")
    public String addEmprunt(@ModelAttribute("addemprunt") Emprunts addemprunt, @PathVariable("livre") int livre ) {
       /* Livre exitlivre = livreservice.getOneLivreById(livre);
        User exituser = userService.getOneUserById(1);
        addemprunt.setLivre(exitlivre);
        addemprunt.setUser(exituser);*/

        empruntService.saveEmprunts(addemprunt);
        return "redirect:/emprunt";
    }

    @GetMapping("/updateEmprunt/{id}")
    public String showPageUpdate(@PathVariable("id") int empruntid,Model model) {
        Emprunts existeemprunt = empruntService.getOneEmpruntsById(empruntid);
        model.addAttribute("updemprunt", existeemprunt);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("updemprunt") Emprunts updemprunt ,@PathVariable ("id") int id) {
        Emprunts empruntupdated = empruntService.getOneEmpruntsById(id);

        if (empruntupdated.getDate_debut() != null) {
            updemprunt.setDate_debut(empruntupdated.getDate_debut());
        }
        if (empruntupdated.getUser() != null) {
            updemprunt.setUser(empruntupdated.getUser());
        }
        if (empruntupdated.getLivre() != null) {
            updemprunt.setLivre(empruntupdated.getLivre());
        }
        this.empruntService.updateEmprunts(updemprunt, id);
        return "redirect:/emprunt";
    }
    @GetMapping(value = "/deleteEmprunts/{id}")
    public String DeleteEmprunts(@PathVariable ("id") int id){

            this.empruntService.deleteEmprunts(id);
            return "redirect:/emprunt";


    }

}
