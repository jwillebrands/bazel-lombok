package com.example.bazel.lombok.stringlist;

import java.util.Arrays;

public class Application {
	public static void main(String[] args) {
		Arrays.asList(
				StringList.builder().build(),
				StringList.builder().strings(Arrays.asList("one fish", "two fish")).build(),
				StringList.builder().strings(Arrays.asList("red fish", "blue fish")).build()
		).forEach(System.out::println);
	}
}
