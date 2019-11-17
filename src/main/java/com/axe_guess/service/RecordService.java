package com.axe_guess.service;

import com.axe_guess.model.Record;

import java.util.List;

public interface RecordService {
    Record save(Record record);
    Record getOne(Long id);
    List<Record> findFirst10ByOrderByScoreDesc();
}
