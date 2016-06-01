package com.github.asavonic.jorgmode.internal.parsers;

import com.github.asavonic.jorgmode.tree.*;
import java.io.InputStream;

public abstract class Parser {
    private Document doc;
    private InputStream is;

    public Parser(InputStream is, Document doc) {
        this.is = is;
        this.doc = doc;
    }

    public InputStream getStream() {
        return is;
    }

    public Document getDoc() {
        return doc;
    }

    public abstract Heading parseHeading(InputStream is);
    public abstract Text parseText(InputStream is);
}
