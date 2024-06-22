package com.example.Task413.controller;

import com.example.Task413.dto.Message;
import com.example.Task413.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
public class MessageController {

    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Project 1", "Все выполнено", LocalDate.of(2024, 5,3)),
            new Message(2, "Project 2", "Сделано", LocalDate.of(2024, 6,2)),
            new Message(3, "Project 3", "Готово", LocalDate.of(2024, 3,8)),
            new Message(4, "Project 4", "Закончено", LocalDate.of(2024, 2,5))
    ));

    @GetMapping("/message")
    public Iterable<Message> getMessage() {
        return messages;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);
        return message;
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = - 1;
        for (Message p : messages) {
            if (p.getId() == id) {
                index = messages.indexOf(p);
                messages.set(index, message);
            }
        }
        return index == -1
                ? new ResponseEntity<>(addMessage(message), HttpStatus.CREATED)
                : new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
    }


}
