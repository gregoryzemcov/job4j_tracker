package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
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
        Deque<Character> stringEven = new LinkedList<>();
        StringBuilder strEven = new StringBuilder();
        for (int i = 0; i <= size - 1; i++) {
            Character ch = evenElements.poll();
            if (i % 2 == 0) {
                stringEven.add(ch);
            }
        }
        for (Character s : stringEven) {
            strEven.append(s);
        }
        return strEven.toString();
    }

    private String getDescendingElements() {
        Deque<String> stringDescending = new LinkedList<>();
        StringBuilder strDescending = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            stringDescending.add(String.valueOf(iterator.next()));
        }
        for (String s : stringDescending) {
            strDescending.append(s);
        }
        return strDescending.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
