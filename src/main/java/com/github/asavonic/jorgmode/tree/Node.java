package com.github.asavonic.jorgmode.tree;

public interface Node {
    public static final short ELEMENT_NODE = 1;
    public static final short TEXT_NODE = 2;
    public static final short HEADING_NODE = 3;

    /**
     * @returns A code representing the type of underlying object
     */
    public short getNodeType();

    /**
     * @returns A debug string representing the node
     */
    public String dump();

    /**
     * @returns The parent of this node
     */
    public Node getParentNode();

    /**
     * @returns The first child of this node
     */
    public Node getFirstChild();

    /**
     * @returns The last child of this node
     */
    public Node getLastChild();

    /**
     * @returns The node immediately following this node
     */
    public Node getNextSibling();

    /**
     * @returns The node immediately preceding this node
     */
    public Node getPreviousSibling();

    /**
     * Adds the node newChild to the end of the list of children of this node
     */
    public Node appendNode(Node newChild);
}
