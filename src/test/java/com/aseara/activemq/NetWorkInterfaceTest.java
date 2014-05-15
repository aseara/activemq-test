package com.aseara.activemq;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 2014/5/15
 * Time: 9:51
 */
public class NetWorkInterfaceTest {

    @Test
    public void test() throws Exception {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface next = networkInterfaces.nextElement();

            Enumeration<InetAddress> inetAddresses = next.getInetAddresses();
            if (inetAddresses.hasMoreElements()) {
                System.out.println(next + ": ");
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    if (inetAddress instanceof Inet4Address) {
                        System.out.println(inetAddress);
                    }
                }
                System.out.println(next + " end.\n\n");
            }
        }
    }
}
