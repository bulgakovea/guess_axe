package service;

import model.Record;

import java.util.List;

public interface RecordService {
    Record save(Record record);
    List<Record> findAllOrderedByScore();
}
