package org.jfritz.proxy.api;

import org.jfritz.proxy.ProxyService;


public class ProxyFacade {

	private static IProxyService proxyService = new ProxyService();

	/**
	 * Returns the implementation of IProxyService
	 * @return
	 */
	public static IProxyService getProxyService() {
		return proxyService;
	}
}