package com.maxdlr.graphql_test.ws_comm;

public class WsMessageType {
  private String topic;
  private String triggeredBy;

  public WsMessageType(String topic, String triggeredBy) {
    this.topic = topic;
    this.triggeredBy = triggeredBy;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getTriggeredBy() {
    return triggeredBy;
  }

  public void setTriggeredBy(String triggeredBy) {
    this.triggeredBy = triggeredBy;
  }

}
