package com.github.asavonic.jorgmode.tree;

import java.util.List;

public interface Document {
    /**
     * @returns The root element of the document
     */
    public Node getRoot();

    
    /**
     * Creates new text node, representing the specified string
     */
    public Text createText(String data);
}
