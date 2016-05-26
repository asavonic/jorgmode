package com.github.asavonic.jorgmode.internal;

import com.github.asavonic.jorgmode.OrgBuilder;
import com.github.asavonic.jorgmode.tree.*;
import com.github.asavonic.jorgmode.internal.tree.*;
import java.io.InputStream;
import java.io.File;

public class SimpleBuilder extends OrgBuilder {
    @Override
    public Document newDocument() {
        // TODO: unimplemented
        return null;
    }

    @Override
    public Document parse(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String text = s.hasNext() ? s.next() : "";

        Document doc = new DocumentImpl();
        Node root = doc.getRoot();
        root.appendNode(doc.createText(text));

        return doc;
    }

    @Override
    public Document parse(File f) {
        // TODO: unimplemented
        return null;
    }
}
