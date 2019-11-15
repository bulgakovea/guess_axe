package com.axe_guess.rest;

import com.axe_guess.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.axe_guess.service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private RecordService recordService;

    @RequestMapping(value = "/recordsByScore",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Record>> getRecordsByScore(){
        List<Record> result = recordService.findAllOrderedByScore();
        return new ResponseEntity<List<Record>>(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Record> updateRecord(@RequestBody Record record){
        return new ResponseEntity<Record>(recordService.save(record),HttpStatus.OK);
    }

    @RequestMapping(value = "/roll{recordId}{axeNumber}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> roll(@PathVariable("recordId") Long recordId,@PathVariable("axeNumber") Long axeNumber){
        int rollResult = randomRoll();
        if (rollResult == axeNumber){
            Record record = recordService.getOne(recordId);
            record.setScore(record.getScore()+1);
            recordService.save(record);
        }
        return new ResponseEntity<Integer>(rollResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/startGame{nickname}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Long> createRecord(@PathVariable("nickname") String nickname){
        Record record = new Record();
        record.setName(nickname);
        record.setScore(0);
        record =  recordService.save(record);
        return  new ResponseEntity<Long>(record.getId(),HttpStatus.OK);
    }

    private int randomRoll(){
        return (int) (Math.random() * (3) + 1);
    }
}
