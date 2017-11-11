package org.jfritz.proxy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;

public class ProxyTest {

    private ProxyService proxyService;
    private Proxy proxy;

    @Before
    public void init() {
        proxyService = new ProxyService();
    }

    @Test
    public void testProxy() throws IOException {
        proxy = proxyService.getProxy(true, "abc", 8888);
        Assert.assertEquals("HTTP @ abc:8888", proxy.toString());
    }

    @Ignore
    @Test
    public void testConnection() throws IOException {
        proxy = proxyService.getProxy(true, "192.168.30.7", 8118);

        URL url = new URL("http://p.p");
        HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);
        uc.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            line = line.trim();
            if (line.contains("<title>Privoxy@")) {
                return;
            }
        }
        Assert.fail();
    }

    @Test(expected = UnknownHostException.class)
    public void testDisabled() throws IOException {
        proxy = proxyService.getProxy(false, "192.168.30.7", 8118);

        URL url = new URL("http://p.p/");
        HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);
        uc.connect();
    }
}
