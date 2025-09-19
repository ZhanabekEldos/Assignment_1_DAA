package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSelectMiddle() {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 2;
        int expected = Arrays.stream(arr).sorted().toArray()[k];
        assertEquals(expected, DeterministicSelect.select(arr.clone(), k));
    }

    @Test
    void testSelectFirst() {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 0;
        int expected = Arrays.stream(arr).sorted().toArray()[k];
        assertEquals(expected, DeterministicSelect.select(arr.clone(), k));
    }

    @Test
    void testSelectLast() {
        int[] arr = {12, 3, 5, 7, 19};
        int k = arr.length - 1;
        int expected = Arrays.stream(arr).sorted().toArray()[k];
        assertEquals(expected, DeterministicSelect.select(arr.clone(), k));
    }

    @Test
    void testSelectRandom() {
        int[] arr = {5, 9, 1, 3, 14, 8, 2};
        for (int k = 0; k < arr.length; k++) {
            int expected = Arrays.stream(arr).sorted().toArray()[k];
            assertEquals(expected, DeterministicSelect.select(arr.clone(), k));
        }
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(new int[]{}, 0));
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(new int[]{1, 2, 3}, -1));
        assertThrows(IllegalArgumentException.class, () -> DeterministicSelect.select(new int[]{1, 2, 3}, 5));
    }
}
