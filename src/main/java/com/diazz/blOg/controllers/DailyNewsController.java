package com.diazz.blOg.controllers;

import com.diazz.blOg.models.DailyNews;
import com.diazz.blOg.repo.DailyNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class DailyNewsController {

    @Autowired
    private DailyNewsRepository dailyNewsRepository;

    @GetMapping("/dailynews")
    public String dailyNewsMain(Model model){
        Iterable<DailyNews> dailyNewsList = dailyNewsRepository.findAll();
        model.addAttribute("dailyNewsList", dailyNewsList);
        return "dailynews-main";
    }

    @GetMapping("/dailynews/add")
    public String dailyNewsAdd(Model model) {
        return "dailynews-add";
    }

    @PostMapping("/dailynews/add")
    public String blogDailyNewsAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text) {
        DailyNews dailyNews = new DailyNews(title, anons, full_text);
        dailyNewsRepository.save(dailyNews);
        return "redirect:/dailynews";
    }

    @GetMapping("/dailynews/{id}")
    public String dailyNewsDetails(@PathVariable(value = "id") long id, Model model) {
        if (!dailyNewsRepository.existsById(id)) {
            return "redirect:/dailynews";
        }

        Optional<DailyNews> dailyNews = dailyNewsRepository.findById(id);
        dailyNews.ifPresent(p -> model.addAttribute("dailyNews", p));
        return "dailynews-details";
    }

    @PostMapping("/dailynews/{id}/edit")
    public String dailyPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        DailyNews dailyNews = dailyNewsRepository.findById(id).orElseThrow();
        dailyNews.setTitle(title);
        dailyNews.setAnons(anons);
        dailyNews.setFull_text(full_text);
        dailyNewsRepository.save(dailyNews);
        return "redirect:/dailyNews";
    }

    @PostMapping("/dailynews/{id}/remove")
    public String dailyNewsPostDelete(@PathVariable(value = "id") long id, Model model) {
        DailyNews dailyNews = dailyNewsRepository.findById(id).orElseThrow();
        dailyNewsRepository.delete(dailyNews);
        return "redirect:/dailynews";
    }
}
