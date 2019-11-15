package com.axe_guess.service.service_impl;

import com.axe_guess.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.axe_guess.repository.RecordRepository;
import com.axe_guess.service.RecordService;

import java.util.List;


@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordRepository recordRepository;

    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<Record> findAllOrderedByScore() {
        return recordRepository.findAllOrderedByScore();
    }
    @Override
    public  Record getOne(Long id){
        return recordRepository.getOne(id);
    }
}
