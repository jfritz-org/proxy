package org.jfritz.proxy.api;

import java.net.Proxy;

public interface IProxyService {

	/**
	 * Returns a java.net.Proxy instance for the given host and port or Proxy.NO_PROXY if enabled==false
	 * @param enabled
	 * @param host
	 * @param port
	 * @return
	 */
	public abstract Proxy getProxy(final boolean enabled, final String host, final int port);

	/**
	 * Returns a java.net.Proxy instance for the given host and port or Proxy.NO_PROXY if enabled==false
	 * Does also authenticate user
	 * @param enabled
	 * @param host
	 * @param port
	 * @param user
	 * @param password
	 * @return
	 */
	public abstract Proxy getProxy(final boolean enabled, final String host, final int port, final String user, final String password);
}
