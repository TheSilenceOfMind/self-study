package org.practice.spitter.web;

import org.practice.spitter.Spittle;
import org.practice.spitter.data.SpittleRepository;
import org.practice.spitter.web.exception.SpittleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {

        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{spittleId}")
    public String spittle(@PathVariable long spittleId, Model model) {
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            model.addAttribute("spittleId", spittleId);
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/spit")
    public String spit(Model model) {
        model.addAttribute(new SpittleForm());
        return "spittleForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/spit")
    public String processSpitting(@Valid SpittleForm spittleForm, Errors errors) {
        if (errors.hasErrors())
            return "spittleForm";
        Spittle spittle = spittleForm.toSpittle();
        spittleRepository.save(spittle);
        return "redirect:/spittles";
    }
}
