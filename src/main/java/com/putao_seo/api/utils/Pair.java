package com.putao_seo.api.utils;

public class Pair<S, T> {

	private S first;
	private T second;

	public S getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	
	public Pair(S first, T second) {
		this.first = first;
		this.second = second;
	}
}
