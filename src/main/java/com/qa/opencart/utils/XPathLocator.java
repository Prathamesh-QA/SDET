/**
 * 
 */
package com.qa.opencart.utils;

/**
 * @author P.Dhamanaskar
 *
 */
public enum XPathLocator {
	
	BY_ID("//*[@id='{0}']"),
	BY_CLASS("//*[@class='{0}']"),
	BUTTON("//*[@value='{0}']");
	
	private final String xpath;

	private XPathLocator(final String xpath) {
		this.xpath = xpath;
	}

	private XPathLocator(final XPathLocator parent, final String path) {
		this.xpath = parent.xpath + path;
	}

	public String get(final String... values) {
		String newPath = xpath;
		for (int i = 0; i < values.length; i++) {
			newPath = newPath.replaceAll("\\{" + i + "\\}", values[i]);
		}

		return newPath;
	}

	@Override
	public String toString() {
		return xpath;
	}
}
