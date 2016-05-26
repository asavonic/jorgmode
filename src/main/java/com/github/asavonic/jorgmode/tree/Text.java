package com.github.asavonic.jorgmode.tree;

public interface Text extends Node {
    /**
     * Returns all text of Text nodes logically-adjacent text nodes to this
     * node, concatenated in document order
     */
    public String getWholeText();
}
