package com.github.asavonic.jorgmode;

import com.github.asavonic.jorgmode.internal.SimpleBuilderFactory;

public abstract class OrgBuilderFactory {
    /**
     * Obtain new instance of an OrgBuilderFactory
     */
    public static OrgBuilderFactory newInstance() {
        // TODO: DI for builder type
        return new SimpleBuilderFactory();
    }

    /**
     * Obtain new instance of an OrgBuilder
     */
    abstract public OrgBuilder newOrgBuilder();
}
