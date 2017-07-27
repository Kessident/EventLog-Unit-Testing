package com;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EventLogTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    EventLog eLog = new EventLog();

    @Test
    public void addEvent() throws Exception {
        boolean addedProperly = eLog.addEvent(new Event("Event Name", "Face2Face"));
        assertTrue(addedProperly);
        assertEquals("size of log should be 1", 1, eLog.getNumEvents());
    }

    @Test
    public void expectExceptionWhenNullEvent() {
        thrown.expect(IllegalArgumentException.class);
        eLog.addEvent(null);
    }

    @Test
    public void expectExceptionWhenNullName() {
        thrown.expect(IllegalArgumentException.class);
        eLog.addEvent(new Event(null, "Face2Face"));
    }

    @Test
    public void expectExceptionWhenNullAction() {
        thrown.expect(IllegalArgumentException.class);
        eLog.addEvent(new Event("Event name", null));
    }

    @Test
    public void expectExceptionWhenBadAction() {
        thrown.expect(IllegalArgumentException.class);
        eLog.addEvent(new Event("Event name", "Event Action"));
    }
}