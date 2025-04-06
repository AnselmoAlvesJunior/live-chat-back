package com.message.livechat.controller

import com.message.livechat.domain.ChatInput
import com.message.livechat.domain.ChatOutput
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils

@Controller
class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    fun newMessage(input: ChatInput): ChatOutput {
        return ChatOutput(HtmlUtils.htmlEscape(input.user + ": " + input.message))
    }
}