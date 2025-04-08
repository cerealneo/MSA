package kr.co.mimmin.controller;

import kr.co.mimmin.dto.User1DTO;
import kr.co.mimmin.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1")
    public ResponseEntity list(){
        Map<Object, Object> resultMap = user1Service.findAll();
        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/user1/{uid}")
    public ResponseEntity user(@PathVariable("uid") String uid){
        User1DTO user1DTO = user1Service.findByUid(uid);
        return new ResponseEntity<>(user1DTO, HttpStatus.OK);
    }

    @PostMapping("/user1")
    public ResponseEntity register(User1DTO user1DTO){
        user1Service.save(user1DTO);
        return ResponseEntity.ok().body("register");
    }

    @PutMapping("/user1")
    public ResponseEntity modify(User1DTO user1DTO){
        user1Service.update(user1DTO);
        return ResponseEntity.ok().body("modify");
    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        user1Service.delete(uid);
        return ResponseEntity.ok().body("delete");
    }
}