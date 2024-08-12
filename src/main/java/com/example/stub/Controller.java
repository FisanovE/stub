package com.example.stub;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/post-message")
@RequiredArgsConstructor
public class Controller {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> getResponseMessage(@RequestBody RequestMessage message) {
        boolean sent = messageService.sendMessage(message);

        if (sent) {
            return ResponseEntity.ok("200 OK");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("500 Internal Server Error");
        }
    }

}
