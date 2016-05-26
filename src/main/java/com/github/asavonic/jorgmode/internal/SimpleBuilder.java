package com.github.asavonic.jorgmode.internal;

import com.github.asavonic.jorgmode.OrgBuilder;
import com.github.asavonic.jorgmode.tree.*;
import java.io.InputStream;
import java.io.File;

class SimpleBuilder extends OrgBuilder {
    @Override
    public Document newDocument() {
        // TODO: unimplemented
        return null;
    }

    @Override
    public Document parse(InputStream is) {
        // TODO: unimplemented
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        String text = s.hasNext() ? s.next() : "";

        return null;
    }

    @Override
    public Document parse(File f) {
        // TODO: unimplemented
        return null;
    }
}
