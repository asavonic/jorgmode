package com.github.asavonic.jorgmode.internal;

import com.github.asavonic.jorgmode.OrgBuilderFactory;

public class SimpleBuilderFactory extends OrgBuilderFactory {
    @Override
    public SimpleBuilder newOrgBuilder() {
        return new SimpleBuilder();
    }
}
