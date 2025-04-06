package com.message.livechat.config

import com.message.livechat.domain.ChatOutput
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component
import org.springframework.web.util.HtmlUtils

@Component
class KafkaConsumer(
    private val simpMessagingTemplate: SimpMessagingTemplate
) {

    @Component
    class KafkaConsumer(
        private val simpMessagingTemplate: SimpMessagingTemplate
    ) {

        @KafkaListener(topics = ["livechat-topic"], groupId = "livechat")
        fun listen(message: String) {
            val output = ChatOutput(HtmlUtils.htmlEscape(message))
            simpMessagingTemplate.convertAndSend("/topics/livechat", output)
        }
    }

}
