package org.thoughtworks.regx.express;

import java.util.List;

public abstract class BaseExpress implements Express {

    protected String express;

    public BaseExpress() {
    }

    public BaseExpress(String express) {
        this.express = express;
    }

    public String getExpress() {
        return express;
    }

    protected String processSingleExpress(String express, List<Express> result) {
        result.add(new AnyCharacterExpress(express.substring(0, 1)));
        express = express.substring(1, express.length());
        return express;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BaseExpress && ((BaseExpress) obj).getExpress().equals(getExpress());
    }

    @Override
    public String toString() {
        return "BaseExpress{" +
                "express='" + express + '\'' +
                '}';
    }
}
