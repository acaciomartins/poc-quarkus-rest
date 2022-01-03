package org.acme;


import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.rest.json.TaskDTO;
import org.acme.service.TaskService;

@Path("/")
public class TaskResource {
    
    @Inject
    TaskService taskService;
    
    
    @GET
    @Path("/task/{key}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("key") String key) {
        
       return taskService.get(key);
    }

    @POST
    @Path("/add/task")
    public Set<TaskDTO> add(TaskDTO task) {
        System.out.println("task...: " + task);
        Set<TaskDTO> tasks = taskService.addTask(task);
        return tasks;
    }
}
