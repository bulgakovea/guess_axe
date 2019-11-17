package com.axe_guess.service.service_impl;

import com.axe_guess.model.Record;
import com.axe_guess.repository.RecordRepository;
import com.axe_guess.service.RecordService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordServiceImpl implements RecordService {

    private final RecordRepository recordRepository;

    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public Record save(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public List<Record> findFirst15ByOrderByScoreDesc() {
        return recordRepository.findFirst15ByOrderByScoreDesc();
    }
    @Override
    public  Record getOne(Long id){
        return recordRepository.getOne(id);
    }
}
