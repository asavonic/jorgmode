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
        // String text = "This is just a text\n" +
        //               "No formatting at all.\n" +
        //               "Really, this should work.\n";
        // Document doc = docFromString(text);

        // Node root = doc.getRoot();

        // assertNotNull(root.getFirstChild());

        // StringBuilder str = new StringBuilder();
        // Node first = root.getFirstChild();
        // for (Node iter = first; iter != null; iter = iter.getNextSibling()) {
        //     assertEquals(Node.TEXT_NODE, iter.getNodeType());
        //     str.append(((Text)iter).getWholeText());
        //     str.append("\n");
        // }

        // String gotText = str.toString();
        // assertEquals(text, gotText);
    }

    /**
     * Test Heading element
     */
    public void testHeadingElement() {
        String text = "* Foo\n" +
                      "** Bar\n" +
                      "* Baz\n";

        Document doc = docFromString(text);
        Node root = doc.getRoot();

        assertNotNull(root.getFirstChild());

        Node foo = root.getFirstChild();
        Node bar = foo.getFirstChild();
        Node baz = foo.getNextSibling();

        // assertNull(baz.getNextSibling());

        assertEquals("Foo", ((Heading)foo).getHeader());
        assertEquals("Bar", ((Heading)bar).getHeader());
        assertEquals("Baz", ((Heading)baz).getHeader());

        assertEquals(1, ((Heading)foo).getLevel());
        assertEquals(2, ((Heading)bar).getLevel());
        assertEquals(1, ((Heading)baz).getLevel());
    }

    /**
     * Test Heading element with Text inside
     */
    public void testHeadingWithText() {
        String text = "* Foo\n" +
                      "foo text\n" +
                      "** Bar\n" +
                      "bar text\n";

        Document doc = docFromString(text);
        Node root = doc.getRoot();

        assertNotNull(root.getFirstChild());

        Node foo = root.getFirstChild();
        Node fooText = foo.getFirstChild();

        Node bar = fooText.getNextSibling();
        Node barText = bar.getFirstChild();

        assertEquals("Foo", ((Heading)foo).getHeader());
        assertEquals("foo text", ((Text)fooText).getWholeText());

        assertEquals("Bar", ((Heading)bar).getHeader());
        assertEquals("bar text", ((Text)barText).getWholeText());

        assertEquals(1, ((Heading)foo).getLevel());
        assertEquals(2, ((Heading)bar).getLevel());
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
