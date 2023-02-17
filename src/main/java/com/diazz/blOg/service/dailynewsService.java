package com.diazz.blOg.service;

import com.diazz.blOg.models.DailyNews;
import com.diazz.blOg.repo.DailyNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dailynewsService {

    @Autowired
    private DailyNewsRepository dailyNewsRepository;

    public dailynewsService(DailyNewsRepository dailyNewsRepository) {
        super();
        this.dailyNewsRepository = dailyNewsRepository;
    }

    public List<DailyNews> getAllDailyNews(){

        return dailyNewsRepository.findAll();
    }
}