package com.github.asavonic.jorgmode;

import com.github.asavonic.jorgmode.tree.*;
import java.io.InputStream;
import java.io.File;

public abstract class OrgBuilder {
    /**
     * Obtain new instance of a Org document
     */
    abstract public Document newDocument();

    /**
     * Parse InputStream and return new instance of a Org document
     */
    abstract public Document parse(InputStream is);

    /**
     * Parse File and return new instance of a Org document
     */
    abstract public Document parse(File f);
}
