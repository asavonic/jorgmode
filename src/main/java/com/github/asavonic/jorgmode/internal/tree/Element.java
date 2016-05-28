package com.github.asavonic.jorgmode.internal.tree;

import com.github.asavonic.jorgmode.tree.*;
import com.github.asavonic.jorgmode.OrgException;
import com.github.asavonic.jorgmode.internal.util.IntrusiveList;

public class Element implements Node {
    private IntrusiveList<Node> childNodes;
    private IntrusiveList<Node> lastChild;

    private IntrusiveList<Node> self;
    private IntrusiveList<Node> parent;

    public Element() {
    }

    public void setListItem(IntrusiveList<Node> self) {
        this.self = self;
    }

    public void setParentListItem(IntrusiveList<Node> parent) {
        this.parent = parent;
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
        if (childNodes != null) {
            return childNodes.getElem();
        }
        return null;
    }

    @Override
    public Node getLastChild() {
        if (lastChild != null) {
            return lastChild.getElem();
        }
        return null;
    }

    @Override
    public Node getNextSibling() {
        IntrusiveList<Node> next = self.getNext();
        if (next != null) {
            return next.getElem();
        }
        return null;
    }

    @Override
    public Node getPreviousSibling() {
        IntrusiveList<Node> prev = self.getPrev();
        if (prev != null) {
            return prev.getElem();
        }
        return null;
    }

    @Override
    public Node appendNode(Node child) {
        if (!(child instanceof Element)) {
            throw new OrgException(OrgException.HIERARCHY_REQUEST_ERR,
                                   "child must be an instance of Element class");
        }
        Element childElem = (Element) child;

        IntrusiveList<Node> newChild = new IntrusiveList<>(child);
        childElem.setListItem(newChild);
        childElem.setParentListItem(self);

        if (childNodes == null) {
            childNodes = newChild;
            lastChild = newChild;
            return child;
        }

        newChild.insertAfter(lastChild);
        lastChild = newChild;
        return child;
    }
}
