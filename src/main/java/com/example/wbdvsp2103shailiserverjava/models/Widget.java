package com.example.wbdvsp2103shailiserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String type;
  private Integer widgetOrder;
  private String text;
  private String src;
  private String url;
  private Integer size;
  private Integer width;
  private Integer height;
  private String cssClass;
  private String style;
  private String value;
  private String topicId;
  private Boolean ordered;

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public Boolean getOrdered() {
    return ordered;
  }
  public void setOrdered(Boolean ordered){
    this.ordered = ordered;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Widget() {
  }

  public Widget(Long id, String topicId, String type, Integer size, String text, String src, Integer width, Integer height, Boolean ordered) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
    this.src = src;
    this.width = width;
    this.height = height;
    this.ordered = ordered;
  }
}

