package com.github.asavonic.jorgmode;

public class OrgException extends RuntimeException {
    public static final long serialVersionUID = 33316722886L;

    /**
     * If a node inserted somewhere it doesn't belong
     */
    public static final short HIERARCHY_REQUEST_ERR = -5;

    public short code;
    public OrgException(short code, String message) {
        super(message);
        this.code = code;
    }
}
