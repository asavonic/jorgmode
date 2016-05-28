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
public class TreeTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TreeTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TreeTest.class);
    }

    /**
     * Test Text element
     */
    public void testTree() {
        OrgBuilder builder = OrgBuilderFactory.newInstance().newOrgBuilder();
        Document doc = builder.newDocument();
        doc.getRoot().appendNode(doc.createText("A"));
        doc.getRoot().appendNode(doc.createText("B"));
        doc.getRoot().appendNode(doc.createText("C"));
        doc.getRoot().appendNode(doc.createText("D"));

        Node A = doc.getRoot().getFirstChild();
        Node B = A.getNextSibling();
        Node C = B.getNextSibling();

        C.appendNode(doc.createText("CA"));
        C.appendNode(doc.createText("CB"));

        Node D = C.getNextSibling();

        Node CA = C.getFirstChild();
        Node CB = CA.getNextSibling();

        assertEquals(((Text) A).getWholeText(), "A");
        assertEquals(((Text) B).getWholeText(), "B");
        assertEquals(((Text) C).getWholeText(), "C");
        assertEquals(((Text) D).getWholeText(), "D");
        assertEquals(((Text) CA).getWholeText(), "CA");
        assertEquals(((Text) CB).getWholeText(), "CB");
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
