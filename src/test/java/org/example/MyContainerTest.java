package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyContainerTest {
    private MyContainer<String> container;

    @BeforeEach
    void setUp() {
        container = new MyContainer<>(5);
    }

    @Test
    void testAddAndGet() {
        container.add("A");
        container.add("B");
        assertEquals(2, container.getSize());
        assertEquals("A", container.get(0));
        assertEquals("B", container.get(1));
    }

    @Test
    void testCapacityIncrease() {
        for (int i = 0; i < 10; i++) {
            container.add("Item " + i);
        }
        assertEquals(10, container.getSize());
        assertEquals(20, container.getCapacity());
    }

    @Test
    void testContains() {
        container.add("A");
        container.add("B");
        assertTrue(container.contains("A"));
        assertFalse(container.contains("C"));
    }

    @Test
    void testRemove() {
        container.add("A");
        container.add("B");
        assertTrue(container.contains("A"));
        container.remove("A");
        assertFalse(container.contains("A"));
        assertEquals(1, container.getSize());
        assertEquals("B", container.get(0));
    }

    @Test
    void testRemoveNonExistingElement() {
        container.add("A");
        container.remove("B");
        assertEquals(1, container.getSize());
    }

    @Test
    void testGetInvalidIndex() {
        container.add("A");
        assertNull(container.get(-1));
        assertNull(container.get(1));
    }
}

