package com.udp.server;

import com.udp.server.helper.UDPHelper;
import com.udp.server.helper.UDPHelper.OnUDPReceiverCallback;

public class Main
{
    public static void main(String[] args)
    {
        // send
        final String msg = "hello world";
        // final String serverIp = "255.255.255.255"; // 广播形式发出去
        // final String serverIp = "0.0.0.0"; // 广播形式发出去
        final String serverIp = "192.168.1.100";
        final int serverPort = 2002;
        
        new UDPSender().send(msg, serverIp, serverPort);
        
        // receiver
        final int aPort = 1001;
        final int timeout = 0;
        
        initUDPServer(aPort, timeout);
    }
    
    private static void initUDPServer(int aPort, int timeout)
    {
        System.out.println("main initUDPServer thread start");
        UDPHelper.getInstance().startListener(aPort, new OnUDPReceiverCallback()
        {
            
            @Override
            public void onStart(boolean isStartSuccess)
            {
                System.out.println("Main initUDPServer onStart isStartSuccess = " + isStartSuccess);
            }
            
            @Override
            public void onFinish(byte[] result)
            {
                System.out.println("Main initUDPServer onFinish result = " + new String(result));
            }
        });
    }
}
