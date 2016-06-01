package com.github.asavonic.jorgmode.internal.tree;

import com.github.asavonic.jorgmode.tree.*;

public class HeadingImpl extends Element implements Heading {
    private String header;
    private short level;
    private static int DUMP_CHARS_LIMIT = 256;

    public HeadingImpl(String header, short level) {
        this.header = header;
        this.level = level;
    }

    @Override
    public short getNodeType() {
        return Node.HEADING_NODE;
    }

    @Override
    public String dump() {
        return "HeadingImpl:" +
            ((header.length() < DUMP_CHARS_LIMIT) ? header
             : header.substring(0, DUMP_CHARS_LIMIT));
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public short getLevel() {
        return level;
    }
}
