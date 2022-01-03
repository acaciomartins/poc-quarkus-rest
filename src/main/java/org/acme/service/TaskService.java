package org.acme.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.acme.rest.json.TaskDTO;

import io.quarkus.redis.client.RedisClient;
import io.quarkus.redis.client.reactive.ReactiveRedisClient;

@Singleton
public class TaskService {

    @Inject
    RedisClient redisClient; 

    @Inject
    ReactiveRedisClient reactiveRedisClient; 
    
    private Set<TaskDTO> tasks = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public String get(String key) {
        return redisClient.get(key).toString();
    }
    
    // Salvar no REDIS
    public Set<TaskDTO> addTask(TaskDTO task) {
        // tasks.add(task);
        redisClient.set(Arrays.asList(task.key, task.task));
        return tasks;
    }
}
