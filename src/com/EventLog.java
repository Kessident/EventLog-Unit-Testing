package com;

import java.util.*;

public class EventLog {
    private List<Event> eventList;

    public EventLog (){
        eventList = new ArrayList<>();
    }

    public boolean addEvent(Event event){
        if (event == null || event.getAction() == null || event.getName() == null){
            throw new IllegalArgumentException();
        } else if (!isValidAction(event.getAction())){
            throw new IllegalArgumentException();
        }
        System.out.println(event);
        eventList.add(event);
        return true;
    }

    public int getNumEvents () {
        return eventList.size();
    }

    private static boolean isValidAction(String value) {
        return Arrays.stream(ActionTypes.values()).anyMatch(e -> e.name().equals(value));
    }
}
