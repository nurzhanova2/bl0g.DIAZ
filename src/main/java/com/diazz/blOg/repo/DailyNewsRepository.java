package com.diazz.blOg.repo;

import com.diazz.blOg.models.DailyNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyNewsRepository extends JpaRepository<DailyNews,Long> {
}
