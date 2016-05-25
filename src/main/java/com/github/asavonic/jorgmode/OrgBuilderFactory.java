package com.github.asavonic.jorgmode;

public abstract class OrgBuilderFactory {
    /**
     * Obtain new instance of an OrgBuilderFactory
     */
    public static OrgBuilderFactory newInstance() {
        return null;
    }

    /**
     * Obtain new instance of an OrgBuilder
     */
    abstract public OrgBuilder newOrgBuilder();
}
