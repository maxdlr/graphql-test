package com.maxdlr.graphql_test.ws_comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

public class WsMessageResponse {

  private SimpMessageHeaderAccessor headerAccessor;
  private Message<Object> message;
  @Autowired
  private SimpMessagingTemplate messagingTemplate;
  private WsMessageType messageType;

  public WsMessageResponse(WsMessageType messageType, Object payload) {
    this.messageType = messageType;
    this.buildheaders();
    this.buildMessage(payload);
    this.send();
  }

  private void buildheaders() {
    this.headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
    this.headerAccessor.setHeader("trigger", this.messageType.getTriggeredBy());
  }

  private void buildMessage(Object payload) {
    this.message = MessageBuilder.withPayload(
        payload).setHeaders(this.headerAccessor).build();
  }

  public void send() {
    messagingTemplate.convertAndSend(this.messageType.getTopic(), this.message);
  }

}
