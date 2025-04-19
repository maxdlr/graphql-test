package com.maxdlr.graphql_test.controller.views;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxdlr.graphql_test.model.TeamModel.TeamInfo;
import com.maxdlr.graphql_test.service.models.TeamService;
import com.maxdlr.graphql_test.ws_comm.WsMessageResponse;
import com.maxdlr.graphql_test.ws_comm.WsMessageType;

@RestController
@RequestMapping("team-details")
public class TeamDetailController {

  private TeamService teamService;
  private String topic = "/topic/team-detail";

  public TeamDetailController(TeamService teamService) {
    this.teamService = teamService;
  }

  @GetMapping
  public WsMessageResponse getAll() {
    WsMessageType type = new WsMessageType(this.topic, "request");
    List<TeamInfo> teamInfo = this.teamService.getAllInfo();
    return new WsMessageResponse(type, teamInfo);
  }
}
