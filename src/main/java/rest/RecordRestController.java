package rest;

import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.RecordService;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordRestController {
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

}
