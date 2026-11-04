package dev.ikm.tql;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {
    @Test
    void verifyHello() {
        assertEquals("Hello World!", new Api().getMessage());
    }
}
