package com.github.asavonic.jorgmode;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.github.asavonic.jorgmode.*;
import com.github.asavonic.jorgmode.tree.*;

/**
 * Unit test for simple App.
 */
public class BasicTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public BasicTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BasicTest.class);
    }

    /**
     * Test Text element
     */
    public void testTextElement() {
        String text = "This is just a text\n" +
                      "No formatting at all.";
        Document doc = docFromString(text);

        Node root = doc.getRoot();
        // check document has exactly one element: the text
        assertEquals(root.getFirstChild(), root.getLastChild());
        assertEquals(Node.TEXT_NODE, root.getFirstChild().getNodeType());

        Text textNode = (Text) root.getFirstChild();
        assertEquals(text, textNode.getWholeText());
    }

    private Document docFromString(String str) {
        OrgBuilder builder = OrgBuilderFactory.newInstance().newOrgBuilder();
        try (InputStream stream = getStream(str)) {
            return builder.parse(stream);
        } catch (IOException e) {
            return null;
        }
    }

    private InputStream getStream(String str) {
        try {
            return new ByteArrayInputStream(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
