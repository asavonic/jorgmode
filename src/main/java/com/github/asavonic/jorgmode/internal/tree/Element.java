package com.github.asavonic.jorgmode.internal.tree;

import com.github.asavonic.jorgmode.tree.*;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Element implements Node {
    private List<Node> childNodes = new ArrayList<>();

    public Element() {
    }

    @Override
    public short getNodeType() {
        return Node.ELEMENT_NODE;
    }

    @Override
    public String dump() {
        return "";
    }

    @Override
    public Node getFirstChild() {
        ListIterator<Node> it = childNodes.listIterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override
    public Node getLastChild() {
        ListIterator<Node> it = childNodes.listIterator();
        if (it.hasPrevious()) {
            return it.previous();
        }
        return null;
    }

    /**
     * @returns The node immediately following this node
     */
    public Node getNextSibling() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @returns The node immediately preceding this node
     */
    public Node getPreviousSibling() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Adds the node newChild to the end of the list of children of this node
     */
    public Node appendNode(Node newChild) {
        childNodes.add(newChild);
        return newChild;
    }
}
