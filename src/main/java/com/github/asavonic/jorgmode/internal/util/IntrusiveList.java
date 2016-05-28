package com.github.asavonic.jorgmode.internal.util;

public class IntrusiveList<T> {
    private T elem;
    private IntrusiveList<T> next;
    private IntrusiveList<T> prev;

    public IntrusiveList(T elem) {
        this.elem = elem;
    }

    public IntrusiveList<T> getNext() {
        return next;
    }

    public IntrusiveList<T> getPrev() {
        return prev;
    }

    public T getElem() {
        return elem;
    }

    public IntrusiveList<T> insertAfter(IntrusiveList<T> other) {
        this.next = other.next;
        this.prev = other;

        if (other.next != null) {
            other.next.prev = this;
        }

        other.next = this;

        return this;
    }
}
