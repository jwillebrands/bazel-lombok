package com.example.bazel.lombok.stringlist;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class StringList {
	@Builder.Default
	@Getter
	private List<String> strings = new ArrayList<>();

	@Override
	public String toString() {
		return "StringList: [" + String.join(", ", strings) + "]";
	}
}