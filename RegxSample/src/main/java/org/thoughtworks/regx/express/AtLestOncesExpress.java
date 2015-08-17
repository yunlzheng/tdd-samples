package org.thoughtworks.regx.express;

import java.util.List;

public class AtLestOncesExpress extends BaseExpress {

    public AtLestOncesExpress(String express) {
        super(express);
    }

    public AtLestOncesExpress() {

    }

    @Override
    public String process(String express, List<Express> result) {
        return processSingleExpress(express, result);
    }
}
