package com.github.asavonic.jorgmode.internal.tree;

import com.github.asavonic.jorgmode.tree.*;
import com.github.asavonic.jorgmode.internal.tree.*;
import com.github.asavonic.jorgmode.internal.util.IntrusiveList;

public class DocumentImpl implements Document {
    private Element root;
    private IntrusiveList<Node> rootListIterm;

    public DocumentImpl() {
        root = new Element();
        rootListIterm = new IntrusiveList<Node>(root);
        root.setListItem(rootListIterm);
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public Text createText(String data) {
        return new TextImpl(data);
    }

    @Override
    public Heading createHeading(String header, short level) {
        return new HeadingImpl(header, level);
    }

}
