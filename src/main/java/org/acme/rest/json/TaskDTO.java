package org.acme.rest.json;

public class TaskDTO {

    public String key;
    public String task;

    public TaskDTO() {
    }

    public TaskDTO(String key, String task) {
        this.key = key;
        this.task = task;
    }
    
}
