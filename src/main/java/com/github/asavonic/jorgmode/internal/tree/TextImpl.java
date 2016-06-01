package com.github.asavonic.jorgmode.internal.tree;

import com.github.asavonic.jorgmode.tree.*;

public class TextImpl extends Element implements Text {
    private String content;
    private static int DUMP_CHARS_LIMIT = 256;

    public TextImpl(String content) {
        this.content = content;
    }

    @Override
    public short getNodeType() {
        return Node.TEXT_NODE;
    }

    @Override
    public String dump() {
        if (content == null) {
            return "TextImpl:empty";
        }

        return "TextImpl:" +
            ((content.length() < DUMP_CHARS_LIMIT) ? content
             : content.substring(0, DUMP_CHARS_LIMIT));
    }

    @Override
    public String getWholeText() {
        return content;
    }
}
