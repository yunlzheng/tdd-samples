package org.thoughtworks.regx.express;

import java.util.List;

public class AnyCharacterExpress extends BaseExpress {

    public AnyCharacterExpress(String express) {
        super(express);
    }

    public AnyCharacterExpress() {

    }

    @Override
    public String process(String express, List<Express> result) {
        return processSingleExpress(express, result);
    }


}
