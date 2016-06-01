package com.github.asavonic.jorgmode.internal.parsers;

import com.github.asavonic.jorgmode.tree.*;
import java.io.InputStream;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.Scanner;

public class RegexParser extends Parser {
    private Pattern patternHeading;
    private Scanner scan;

    public RegexParser(InputStream is, Document doc) {
        super(is, doc);
        scan = new Scanner(getStream());
    }

    @Override
    public Heading parseHeading(InputStream is) {
        if (patternHeading == null) {
            patternHeading = Pattern.compile(
                "(\\*+) " /* heading mark, captures level */ +
                "(.*)" /* heading */);
        }

        if (scan.findInLine(patternHeading) == null) {
            return null;
        }

        MatchResult match = scan.match();

        short level = (short) match.group(1).length();
        String header = match.group(2);

        scan.nextLine();

        Heading heading = getDoc().createHeading(header, level);
        return heading;
    }

    @Override
    public Text parseText(InputStream is) {
        if (scan.hasNextLine()) {
            return getDoc().createText(scan.nextLine());
        }

        return null;
    }
}
