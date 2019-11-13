package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/game")
public class GameController {
    @RequestMapping(value = "/roll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Boolean> roll(){
        return new ResponseEntity<Boolean>(randomRoll(), HttpStatus.OK);
    }

    private boolean randomRoll(){
        return Math.random() < 0.33;
    }
}
