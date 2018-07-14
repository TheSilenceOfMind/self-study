package org.practice.spitter.web;


import org.practice.spitter.Spitter;
import org.practice.spitter.data.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    public SpitterController() {
    }

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new SpitterForm());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm,
            Errors errors,
            RedirectAttributes model) throws IOException {

        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        MultipartFile profilePicture = spitterForm.getProfilePicture();

        saveSelectedPicture(spitter, profilePicture);

        model.addAttribute("username", spitter.getUsername());
        model.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{username}";
    }

    /**
     * If picture exists ({@code profilePicture.getSize() > 0}) than save in specified directory on the server.
     *
     * @param spitter        needed to create subfolder for user's files(images)
     * @param profilePicture file(image) needed to save
     * @throws IOException if problem with IO-calls exists
     */
    private void saveSelectedPicture(Spitter spitter, MultipartFile profilePicture) throws IOException {
        if (profilePicture.getSize() > 0) {
            String profileAvatarsDir = "D:\\OneDrive - ITMO UNIVERSITY\\JavaPractice\\site_data\\profile_avatars" +
                    "\\" + spitter.getUsername();
            Path path = Paths.get(profileAvatarsDir);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            profilePicture.transferTo(new File(profileAvatarsDir + "\\" + profilePicture.getOriginalFilename()));
        }
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            System.out.println("Looking storage! No data in flash attr of the session!");
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute(spitter);
        }

        return "profile";
    }
}
