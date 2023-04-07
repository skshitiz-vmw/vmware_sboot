package com.examples.boot.rest.service;

import com.examples.boot.rest.model.Greetings;

import java.util.Collection;
import java.util.List;

public interface GreetingService {
    public void createGreetings(Greetings greetings);
    public void updateGreetings(int id, Greetings greetings);
    public Greetings viewGreetings(int id);
    public Collection<Greetings> viewAllGreetings();
    public void deleteGreetings(int id);
}
