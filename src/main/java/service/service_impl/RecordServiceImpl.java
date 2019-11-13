package service.service_impl;

import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.RecordRepository;
import service.RecordService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Comparator;
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
}
