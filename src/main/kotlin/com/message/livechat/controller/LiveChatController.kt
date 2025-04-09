package com.message.livechat.controller

import com.message.livechat.domain.ChatInput
import com.message.livechat.domain.ChatOutput
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

@Controller
class LiveChatController(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {
    @MessageMapping("/new-message")
    fun newMessage(input: ChatInput) {
        kafkaTemplate.send("livechat-topic", input.user + ": " + input.message)
    }
}