package org.thoughtworks.regx;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegxEngineTest {

    @Test
    public void should_match_normal_character_when_express_is_character() {

        // given
        String express = "a";
        String input = "a";
        RegxEngine regxEngine = new RegxEngine();

        // when
        String result = regxEngine.transfor(express, input);

        // then
        assertThat(result, is("(a)"));

    }

}