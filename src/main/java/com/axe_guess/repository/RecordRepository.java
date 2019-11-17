package com.axe_guess.repository;

import com.axe_guess.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findFirst15ByOrderByScoreDesc();
}
