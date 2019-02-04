package com.example.bazel.lombok.stringlist;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class StringListTest {

	@Test
	public void can_build_with_default() {
		StringList stringList = StringList.builder().build();
		assertThat(stringList, notNullValue());
		assertThat(stringList.getStrings(), instanceOf(ArrayList.class));
		assertThat(stringList.getStrings(), is(empty()));
	}

	@Test
	public void can_build_with_own_values() {
		StringList stringList = StringList.builder()
				.strings(Arrays.asList("one fish", "two fish", "red fish", "blue fish"))
				.build();
		assertThat(stringList, notNullValue());
		assertThat(stringList.getStrings(), contains("one fish", "two fish", "red fish", "blue fish"));
	}
}