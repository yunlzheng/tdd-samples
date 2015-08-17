package org.thoughtworks.regx.express;

import java.util.List;

public class NormalExpress extends BaseExpress {

    public NormalExpress(String express) {
        super(express);
    }

    public NormalExpress() {

    }

    @Override
    public String process(String express, List<Express> result) {
        return express.substring(1, express.length());
    }
}
