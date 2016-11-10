package com.udp.server.helper;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * UDP Socket帮助类
 * @author yline 2016/11/10 --> 22:12
 * @version 1.0.0
 */
public class UDPHelper
{
    private static final String TAG = UDPHelper.class.getSimpleName();
    
    private static final boolean DEBUG = true;
    
    private SendRunnable sendRunnable;
    
    private OnUDPReceiverCallback callback;
    
    private ReceiverRunnable receiverRunnable;
    
    private UDPHelper()
    {
    }
    
    public static UDPHelper getInstance()
    {
        return UDPHelperHolder.sInstance;
    }
    
    public static class UDPHelperHolder
    {
        private static UDPHelper sInstance = new UDPHelper();
    }
    
    /**
     * 发送数据,若之前未设置过host,port则会报错
     * @param data
     * @return
     */
    public boolean sendMessage(String data)
    {
        if (null != sendRunnable)
        {
            sendRunnable.setData(data);
            new Thread(receiverRunnable).start();
            return true;
        }
        return false;
    }
    
    /**
     * @param data 发送的数据
     * @param host 服务端host
     * @param port 服务端端口
     */
    public void sendMessage(String data, String host, int port)
    {
        if (null == sendRunnable)
        {
            sendRunnable = new SendRunnable(host, port);
        }
        sendRunnable.setData(data).setHost(host).setPort(port);
        new Thread(sendRunnable).start();
    }
    
    private class SendRunnable implements Runnable
    {
        private DatagramSocket sendDatagramSocket;
        
        private DatagramPacket sendDatagramPacket;
        
        /** 发送的数据 */
        private byte[] data;
        
        /** 服务端host */
        private String host;
        
        /** 服务端端口 */
        private int port;
        
        SendRunnable(String host, int port)
        {
            this.host = host;
            this.port = port;
        }
        
        public SendRunnable setData(String data)
        {
            if (null != data)
            {
                this.data = data.getBytes();
            }
            else
            {
                this.data = new byte[0];
            }
            return this;
        }
        
        public SendRunnable setHost(String host)
        {
            if (null != host)
            {
                this.host = host;
            }
            return this;
        }
        
        public SendRunnable setPort(int port)
        {
            if (-1 != port)
            {
                this.port = port;
            }
            return this;
        }
        
        private InetAddress getInetAddress()
            throws UnknownHostException
        {
            return InetAddress.getByName(host);
        }
        
        private byte[] getSendData()
        {
            if (null == data)
            {
                data = new byte[0];
            }
            return data;
        }
        
        private int getPort()
        {
            return port;
        }
        
        @Override
        public void run()
        {
            try
            {
                if (null == sendDatagramSocket)
                {
                    sendDatagramSocket = new DatagramSocket();
                }
                
                if (null == sendDatagramPacket)
                {
                    sendDatagramPacket =
                        new DatagramPacket(getSendData(), getSendData().length, getInetAddress(), getPort());
                }
                else
                {
                    sendDatagramPacket.setData(getSendData());
                    sendDatagramPacket.setAddress(getInetAddress());
                    sendDatagramPacket.setPort(getPort());
                }
                
                if (DEBUG)
                {
                    System.out.println("SendRunnable DatagramSocket -> " + "LocalPort = "
                        + sendDatagramSocket.getLocalPort() + ",Port = " + sendDatagramSocket.getPort() + ",Timeout = "
                        + sendDatagramSocket.getSoTimeout());
                    System.out.println("SendRunnable DatagramPacket -> " + new String(sendDatagramPacket.getData())
                        + ",HostAddress = " + sendDatagramPacket.getAddress().getHostAddress() + ",Port = "
                        + sendDatagramPacket.getPort());
                }
                
                sendDatagramSocket.send(sendDatagramPacket);
                
                System.out.println(TAG + "SendRunnable send success");
            }
            catch (SocketException e)
            {
                System.out.println(TAG + "SendRunnable -> send SocketException");
            }
            catch (UnknownHostException e)
            {
                System.out.println(TAG + "SendRunnable -> send UnknownHostException");
            }
            catch (IOException e)
            {
                System.out.println(TAG + "SendRunnable -> send IOException");
            }
        }
        
        @Override
        public String toString()
        {
            return "SendRunnable{" + "host='" + host + '\'' + ", data=" + Arrays.toString(data) + ", port=" + port
                + '}';
        }
    }
    
    /**
     * @param callback
     * @return 若之前从未设定过端口, 则可能开启接收失败
     */
    public boolean startListener(OnUDPReceiverCallback callback)
    {
        if (null != receiverRunnable)
        {
            new Thread(receiverRunnable).start();
            this.callback = callback;
            callback.onStart(false);
            return true;
        }
        return false;
    }
    
    /**
     * @param aPort 本地接收用的端口
     */
    public void startListener(int aPort, OnUDPReceiverCallback callback)
    {
        if (null == receiverRunnable)
        {
            receiverRunnable = new ReceiverRunnable();
        }
        receiverRunnable.setAPort(aPort);
        this.callback = callback;
        new Thread(receiverRunnable).start();
    }
    
    public class ReceiverRunnable implements Runnable
    {
        private DatagramSocket receiverDatagramSocket;
        
        private DatagramPacket receiverDatagramPacket;
        
        /** 本地接收用的端口 */
        private int aPort;
        
        /** 超时时间,默认为永不超时 */
        private int timeout = 0;
        
        public ReceiverRunnable setAPort(int aPort)
        {
            this.aPort = aPort;
            return this;
        }
        
        /**
         * @param timeout the timeout in milliseconds or 0 for no timeout.
         */
        public ReceiverRunnable setSoTimeout(int timeout)
        {
            this.timeout = Math.abs(timeout);
            return this;
        }
        
        @Override
        public void run()
        {
            while (true)
            {
                if (null != callback)
                {
                    callback.onStart(true);
                }
                
                try
                {
                    if (null == receiverDatagramSocket)
                    {
                        receiverDatagramSocket = new DatagramSocket(aPort); // local port
                    }
                    else if (receiverDatagramSocket.getLocalPort() != aPort)
                    {
                        // 若端口变化了,则重新新建
                        receiverDatagramSocket = new DatagramSocket(aPort);
                    }
                    
                    byte data[] = new byte[2048];
                    if (null == receiverDatagramPacket)
                    {
                        receiverDatagramPacket = new DatagramPacket(data, data.length);
                    }
                    
                    if (DEBUG)
                    {
                        System.out.println(TAG + " DatagramSocket -> " + "LocalPort = "
                            + receiverDatagramSocket.getLocalPort() + ",Port = " + receiverDatagramSocket.getPort()
                            + ",Timeout = " + receiverDatagramSocket.getSoTimeout());
                        System.out.println(TAG + " DatagramPacket -> " + "Port = " + receiverDatagramPacket.getPort()
                            + ",data = " + new String(receiverDatagramPacket.getData()));
                    }
                    
                    receiverDatagramSocket.receive(receiverDatagramPacket);
                    receiverDatagramSocket.setSoTimeout(timeout);
                    
                    /** 除去1024无用的数据 */
                    byte[] result = new byte[receiverDatagramPacket.getLength()];
                    System.arraycopy(receiverDatagramPacket.getData(),
                        0,
                        result,
                        0,
                        receiverDatagramPacket.getLength());
                    
                    if (null != callback)
                    {
                        callback.onFinish(result);
                    }
                }
                catch (SocketException e)
                {
                    e.printStackTrace();
                    System.out.println(TAG + "ReceiverRunnable -> receiver SocketException");
                    if (null != callback)
                    {
                        callback.onFinish(null);
                    }
                }
                catch (IOException e)
                {
                    System.out.println(TAG + "ReceiverRunnable -> receiver IOException");
                    if (null != callback)
                    {
                        callback.onFinish(null);
                    }
                }
            }
        }
    }
    
    public interface OnUDPReceiverCallback
    {
        /**
         * 这一次监听是否 开始成功
         * @param isStartSuccess
         */
        void onStart(boolean isStartSuccess);
        
        /**
         * 监听结果
         * @param result
         */
        void onFinish(byte[] result);
    }
}
