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

    /**
     * Creates new heading node, representing the one-line header (and child
     * nodes representing the body)
     */
    public Heading createHeading(String header, short level);
}
