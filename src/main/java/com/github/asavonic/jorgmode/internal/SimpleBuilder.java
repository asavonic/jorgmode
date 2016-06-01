package com.github.asavonic.jorgmode.internal;

import com.github.asavonic.jorgmode.OrgBuilder;
import com.github.asavonic.jorgmode.tree.*;
import com.github.asavonic.jorgmode.internal.tree.*;
import com.github.asavonic.jorgmode.internal.parsers.Parser;
import com.github.asavonic.jorgmode.internal.parsers.RegexParser;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

public class SimpleBuilder extends OrgBuilder {
    public int MAX_READ_ELEMENTS = 1000 * 1000;
    @Override
    public Document newDocument() {
        return new DocumentImpl();
    }

    static class ParserState {
        public Document doc;
        public short currentLevel = 0;
        public Node currentContainer;

        public ParserState(Document doc) {
            this.doc = doc;
            currentContainer = doc.getRoot();
        }
    }

    @Override
    public Document parse(InputStream is) {
        Document doc = new DocumentImpl();
        Parser parser = new RegexParser(is, doc);
        ParserState state = new ParserState(doc);

        int iter = 0;
        while (true) {
            boolean notFinished = parse(is, parser, state);

            if (!notFinished) {
                break;
            }

            iter++;
            if (notFinished && iter > MAX_READ_ELEMENTS) {
                // TODO: better error handling
                throw new RuntimeException("exceed maximum number of iterations");
            }
        }

        return doc;
    }

    @Override
    public Document parse(File f) {
        // TODO: unimplemented
        return null;
    }

    private boolean parse(InputStream is, Parser p, ParserState state) {
        if (tryParseHeading(is, p, state)) return true;
        if (tryParseText(is, p, state)) return true;

        return false;
    }

    private boolean tryParseHeading(InputStream is, Parser p, ParserState state) {
        Heading heading = p.parseHeading(is);
        if (heading == null) {
            return false;
        }

        short level = heading.getLevel();
        if (level == state.currentLevel) {
            // * foo
            // ** bar <-- current state: level = 2, container = bar
            // ** baz <-- parser cursor
            //
            state.currentContainer.getParentNode().appendNode(heading);
            state.currentContainer = heading;

        } else if (level > state.currentLevel) {
            // * foo
            // ** bar <-- current state: level = 2, container = bar
            // *** baz <-- parser cursor
            //
            state.currentContainer.appendNode(heading);
            state.currentContainer = heading;
            state.currentLevel = level;

        } else {
            // * foo
            // ** bar <-- current state: level = 2, container = bar
            // * baz <-- parser cursor
            //
            state.currentContainer.getParentNode().getParentNode()
                .appendNode(heading);
            state.currentContainer = heading;
            state.currentLevel = level;
        }

        return true;
    }

    private boolean tryParseText(InputStream is, Parser p, ParserState state) {
        Text text = p.parseText(is);
        if (text == null) {
            return false;
        }

        // * foo
        // ** bar <-- current state: level = 2, container = bar
        // Baz. Some text here <-- parser cursor
        //
        state.currentContainer.appendNode(text);

        return true;
    }
}
