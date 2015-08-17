package org.thoughtworks.regx;


import org.junit.Test;
import org.thoughtworks.regx.express.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExpressEngineTest {

    @Test
    public void should_compile_regular_express_with_group_when_express_is_single_dot() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = ".";

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new AnyCharacterExpress("."))));

    }


    @Test
    public void should_compile_regular_express_with_group_when_express_is_dot_and_star() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = ".*";

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new AnyCharacterExpress("."), new AnyTimesExpress("*"))));

    }

    @Test
    public void should_compile_regular_express_with_group_when_express_is_mutil_character() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = "abc+.*";
        // "[a-c]+"

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new NormalExpress("abc"), new AtLestOncesExpress("+"), new AnyCharacterExpress("."), new AnyTimesExpress("*"))));

    }

    @Test
    public void should_compile_regular_express_with_group_when_express_end_with_mutil_character() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = "abc+.*efg";
        // "[a-c]+"

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new NormalExpress("abc"), new AtLestOncesExpress("+"), new AnyCharacterExpress("."), new AnyTimesExpress("*"), new NormalExpress("efg"))));

    }

    @Test
    public void should_compile_regular_express_with_group_when_express_with_slash() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = "\\*abc";

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new EscapeExpress("\\*"), new NormalExpress("abc"))));

    }

    @Test
    public void should_compile_regular_express_with_group_when_express_with_range() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = "[0-9]+";

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new RangeExpress("[0-9]"), new AtLestOncesExpress("+"))));

    }

    @Test
    public void should_compile_regular_express_with_group_when_mutil_express() {

        // given
        ExpressEngine expressEngine = new ExpressEngine();
        String express = "b[a-z]*r[s-u]*";

        // when
        List<Express> result = expressEngine.compile(express);

        // then
        assertThat(result, is(expected(new NormalExpress("b"),
                new RangeExpress("[a-z]"), new AnyTimesExpress("*"),
                new NormalExpress("r"), new RangeExpress("[s-u]"), new AnyTimesExpress("*"))));

    }


    private List<Express> expected(Express... expresses) {
        List<Express> expected = new ArrayList<Express>();
        Collections.addAll(expected, expresses);
        return expected;
    }

}