package ru.job4j.queue;

import java.util.Deque;
import java.lang.StringBuilder;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        final int size = evenElements.size();
        StringBuilder strEven = new StringBuilder();
        for (int i = 0; i <= size - 1; i++) {
            Character ch = evenElements.poll();
            if (i % 2 == 0) {
                strEven.append(ch);
            }
        }
        return strEven.toString();
    }

    private String getDescendingElements() {
        StringBuilder strDescending = new StringBuilder();
        for (Character s : descendingElements) {
            strDescending.append(s);
        }
        return strDescending.reverse().toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
