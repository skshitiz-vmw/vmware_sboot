package com.examples.boot.rest.service;

import com.examples.boot.rest.model.Greetings;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GreetingServiceImpl implements GreetingService {

    private Map<Integer, Greetings> greetingsMap = new HashMap<>();

    @Override
    public void createGreetings(Greetings greetings) {
        greetings.setId(greetingsMap.size() + 1);
        greetingsMap.put(greetings.getId(), greetings);
    }

    @Override
    public void updateGreetings(int id, Greetings greetings) {
        greetingsMap.put(id, greetings);
    }

    @Override
    public Greetings viewGreetings(int id) {
        return greetingsMap.get(id);
    }

    @Override
    public Collection<Greetings> viewAllGreetings() {
        return greetingsMap.values();
    }

    @Override
    public void deleteGreetings(int id) {
        greetingsMap.remove(id);
    }
}
