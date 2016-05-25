package com.github.asavonic.jorgmode.tree;

public interface Node {
    public static final short TEXT_NODE = 1;
    public static final short HEADING_NODE = 2;

    /**
     * @returns A debug string representing the node
     */
    public String dump();

    /**
     * @returns A code representing the type of underlying object
     */
    public short getNodeType();
}
