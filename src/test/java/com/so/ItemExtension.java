package com.so;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class ItemExtension implements ParameterResolver {

	private List<Item> buildItems() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("code1", 100));
		items.add(new Item("code2", 1500));
		return items;
	}

	@Override
	public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return parameterContext.getParameter().getType().equals(List.class) || parameterContext.getParameter().getName().equals("items");
	}

	@Override
	public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
		return buildItems();
	}
}
