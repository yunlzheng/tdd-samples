package org.thoughtworks.regx.express;

import java.util.List;

public class AnyTimesExpress extends BaseExpress {

    public AnyTimesExpress(String express) {
        super(express);
    }

    public AnyTimesExpress() {

    }

    @Override
    public String process(String express, List<Express> result) {
        return processSingleExpress(express, result);
    }
}
