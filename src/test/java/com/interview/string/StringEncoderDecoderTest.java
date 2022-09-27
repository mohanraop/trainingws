package com.interview.string;

import com.interview.TestUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringEncoderDecoderTest {

    @Test
    public void testDifferentCases() {
        StringEncoderDecoder stringEncoderDecoder = new StringEncoderDecoder();
        List<String> input = new ArrayList<>();
        input.add("mohan");
        input.add("rao");
        input.add("");
        String encoded = stringEncoderDecoder.encode(input);
        List<String> result = stringEncoderDecoder.decode(encoded);
        TestUtil<String> testUtil = new TestUtil();
        testUtil.compareList(input, result);
    }
}
