package com.chinanx.springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository {
    String getDailyReport(String date);
}
