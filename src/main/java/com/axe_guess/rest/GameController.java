package com.axe_guess.rest;

import com.axe_guess.model.Record;
import com.axe_guess.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    static final private int MAX_NUMBER_OF_TRY = 5;

    private final RecordService recordService;

    public GameController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping(value = "/recordsByScore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Record>> getRecordsByScore() {
        List<Record> result = recordService.findFirst20ByOrderByScoreDesc();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/roll/{recordId}/{axeNumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Integer> roll(@PathVariable("recordId") Long recordId, @PathVariable("axeNumber") Long axeNumber) {
        int rollResult = randomRoll();
        Record record = recordService.getOne(recordId);
        if (rollResult == axeNumber) {
            record.setScore(record.getScore() + 1);
        } else {
            record.setNumberOfTry(record.getNumberOfTry() - 1);
        }
        recordService.save(record);
        if (record.getNumberOfTry() <= 0) {
            return new ResponseEntity<>(-1, HttpStatus.OK);
        }
        return new ResponseEntity<>(rollResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/startGame/{nickname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Long> createRecord(@PathVariable("nickname") String nickname) {
        Record record = new Record();
        record.setName(nickname);
        record.setScore(0);
        record.setNumberOfTry(MAX_NUMBER_OF_TRY);
        record = recordService.save(record);
        return new ResponseEntity<>(record.getId(), HttpStatus.OK);
    }

    private int randomRoll() {
        return (int) (Math.random() * (3) + 1);
    }
}
