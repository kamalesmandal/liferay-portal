/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.kernel.search;

import java.util.List;

/**
 * @author Raymond Augé
 */
public class IndexerRegistryUtil {

	public static Indexer getIndexer(Class<?> classObj) {
		return getIndexerRegistry().getIndexer(classObj.getName());
	}

	public static Indexer getIndexer(String className) {
		return getIndexerRegistry().getIndexer(className);
	}

	public static IndexerRegistry getIndexerRegistry() {
		return _indexerRegistry;
	}

	public static List<Indexer> getIndexers() {
		return getIndexerRegistry().getIndexers();
	}

	public static void register(Indexer indexer) {
		for (String className : indexer.getClassNames()) {
			register(className, indexer);
		}

		register(indexer.getClass().getName(), indexer);
	}

	public static void register(
		String className, Indexer indexer) {

		getIndexerRegistry().register(className, indexer);
	}

	public static void unregister(Indexer indexer) {
		for (String className : indexer.getClassNames()) {
			unregister(className);
		}

		unregister(indexer.getClass().getName());
	}

	public static void unregister(String className) {
		getIndexerRegistry().unregister(className);
	}

	public void setIndexerRegistry(IndexerRegistry indexerRegistry) {
		_indexerRegistry = indexerRegistry;
	}

	private static IndexerRegistry _indexerRegistry;

}