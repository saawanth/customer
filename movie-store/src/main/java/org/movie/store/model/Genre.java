package org.movie.store.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Genre {
	ACTION, THRILLER, HORROR, DRAMA;

	@JsonValue
	public String getValue() {
		return name();
	}

	@JsonCreator
	public static Genre create(String val) {
		Genre[] genreTypes = Genre.values();
		for (Genre genreType : genreTypes) {
			if (genreType.name().equalsIgnoreCase(val)) {
				return genreType;
			}
		}
		return ACTION;
	}
}
