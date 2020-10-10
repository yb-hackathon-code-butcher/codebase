package io.github.butcher.butcher.back.service.dto;


public class OptionDTO {

  private Long id;
  private String name;
  private Long risk;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getRisk() {
    return risk;
  }

  public void setRisk(Long risk) {
    this.risk = risk;
  }
}
