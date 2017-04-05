package com.routeone.interview.util;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.StringTokenizer;

public class Util {

	public static void close(Reader reader) {
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}
	}

	public static URL findFile(String path) {
		return getContextOrClassLoader().getResource(path);
	}

	public static String getNextToken(StringTokenizer tokenizer) {
		if (tokenizer.hasMoreTokens()) {
			return tokenizer.nextToken();
		}
		return null;
	}

	public static String getNextToken(StringTokenizer tokenizer, String delim) {
		if (tokenizer.hasMoreTokens()) {
			return tokenizer.nextToken(delim);
		}
		return null;
	}

	public static ClassLoader getClassLoader() {
		return Util.class.getClassLoader();
	}

	public static ClassLoader getContextOrClassLoader() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		if (cl == null)
			return getClassLoader();
		else
			return cl;
	}
}
