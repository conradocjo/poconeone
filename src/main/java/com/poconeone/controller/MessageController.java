package com.poconeone.controller;

import com.poconeone.entity.Title;
import com.poconeone.repository.MessageRepository;
import com.poconeone.repository.TitleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@RestController
@RequestMapping("/message")
public class MessageController {

    public MessageController(MessageRepository messageRepository, TitleRepository titleRepository) {
        this.messageRepository = messageRepository;
        this.titleRepository = titleRepository;
    }

    private final MessageRepository messageRepository;

    private final TitleRepository titleRepository;

    @PostMapping("/new")
    public ResponseEntity<String> newMessage() {
        var firstTitle = titleRepository.getReferenceById(1L);
        try {
            if (isNotEmpty(firstTitle.getId())) {
                saveMessage(firstTitle, "O Rato roeu a roupa do rei de roma.");
            } else {
                saveGenericMessage();
            }
        } catch (EntityNotFoundException e) {
            saveGenericMessage();
        }
        return ResponseEntity.ok("OK.");
    }

    private void saveGenericMessage() {
        saveMessage(Title.builder()
                .titleText("Title Example 1")
                .build(), "Body Example text ....");
    }

    private void saveMessage(Title firstTitle, String bodyText) {
        messageRepository.save(com.poconeone.entity.Message.builder()
                .bodyText(bodyText)
                .title(firstTitle)
                .build());
    }

}
