package com.example.task.dto;

public class TeacherSummary {
    private Long id;
    private String name;
 
    public TeacherSummary() {
    }
    public TeacherSummary(Long id, String name) {
          this.id = id;
          this.name = name;
     }
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

}
   