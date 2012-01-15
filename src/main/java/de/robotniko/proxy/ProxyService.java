package de.robotniko.proxy;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import de.robotniko.proxy.api.IProxyService;

public class ProxyService implements IProxyService {

	public Proxy getProxy(final boolean enabled, final String host, final int port) {
		Proxy result;
		if (enabled) {
			result = initProxy(host, port);
		} else {
			result = Proxy.NO_PROXY;
		}
		return result;
	}

	public Proxy getProxy(final boolean enabled, final String host, final int port, final String user, final String password) {
		Proxy result;
		if (enabled) {
			result = initProxy(host, port);
			Authenticator.setDefault(new ProxyAuthentication(user, password));
		} else {
			result = Proxy.NO_PROXY;
			Authenticator.setDefault(null);
		}
		return result;
	}

	private static Proxy initProxy(final String host, final int port) {
		return new Proxy(Type.HTTP, new InetSocketAddress(host, port));
	}
}
