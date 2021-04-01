package com.example.wbdvsp2103shailiserverjava.controllers;

import com.example.wbdvsp2103shailiserverjava.models.Widget;
import com.example.wbdvsp2103shailiserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;

  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidgetForTopic(
          @PathVariable("tid") String topicId,
          @RequestBody Widget widget) {
    widget.setTopicId(topicId);
    return service.createWidget(widget);
  }

  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(
          @PathVariable("tid") String topicId
  ) {
    return service.findWidgetsForTopic(topicId);
  }

  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget(
          @PathVariable("wid") Long id,
          @RequestBody Widget widget) {
    return service.updateWidget(id, widget);
  }

  @DeleteMapping("/api/widgets/{wid}")
  public Integer deleteWidget(@PathVariable("wid") Long id) {
    return service.deleteWidget(id);
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(
          @PathVariable("wid") Long id) {
    return service.findWidgetById(id);
  }

}

