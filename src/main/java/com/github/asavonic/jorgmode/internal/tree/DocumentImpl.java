package com.github.asavonic.jorgmode.internal.tree;

import com.github.asavonic.jorgmode.tree.*;
import com.github.asavonic.jorgmode.internal.tree.*;

public class DocumentImpl implements Document {
    private Node root = new Element();

    public DocumentImpl() {
    }

    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public Text createText(String data) {
        return new TextImpl(data);
    }

}
