package com.example.wbdvsp2103shailiserverjava.services;

import com.example.wbdvsp2103shailiserverjava.models.Widget;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.example.wbdvsp2103shailiserverjava.models.Widget;
import com.example.wbdvsp2103shailiserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

  @Autowired
  WidgetRepository repository;
  public Widget createWidget(Widget widget) {
    return repository.save(widget);
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
  }

  public List<Widget> findAllWidgets() {
    return repository.findAllWidgets();
  }


  public Widget findWidgetById(Long id) {
    return repository.findWidgetById(id);
  }

  public Integer updateWidget(Long id, Widget newWidget) {
    Widget originalWidget = findWidgetById(id);
    originalWidget.setText(newWidget.getText());
    originalWidget.setSrc(newWidget.getSrc());
    originalWidget.setSize(newWidget.getSize());
    originalWidget.setType(newWidget.getType());
    originalWidget.setWidth(newWidget.getWidth());
    originalWidget.setHeight(newWidget.getHeight());
    originalWidget.setListOrdered(newWidget.getListOrdered());
    repository.save(originalWidget);
    return 1;
  }


  public Integer deleteWidget(Long id) {
    repository.deleteById(id);
    return 1;
  }



}

