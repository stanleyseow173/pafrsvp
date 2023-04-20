package sg.edu.nus.iss.pafrsvp.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.pafrsvp.model.RSVP;
import sg.edu.nus.iss.pafrsvp.service.RSVPService;

@RestController
@RequestMapping(path="/api/rsvp", produces= MediaType.APPLICATION_JSON_VALUE)
public class RSVPRestController {
    @Autowired
    private RSVPService svc;

    @PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveRSVP(@RequestBody String json){
        JsonObject errorResp;
        RSVP rResult = null;
        JsonObject respResult = null;
        try {
            RSVP r =  RSVP.create(json);
            rResult = this.svc.insertRSVP(r);
            respResult = Json.createObjectBuilder()
                .add("rsvpId", rResult.getId())
                .build();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            errorResp = (JsonObject) Json.createObjectBuilder()
                        .add("error",e.getMessage())
                        .build();
            
            return ResponseEntity.badRequest().body(errorResp.toString());
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(respResult.toString());
    }
}
