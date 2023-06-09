package com.websocket.chatapp;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/Echo")
public class Echo
{

    private Session session;

    @OnOpen
    public void connect(Session session)
    {
        this.session = session;

        System.out.println("Session "+session);
    }

    @OnClose
    public void close()
    {
        this.session=null;

        System.out.println("Closed ");
    }

    @OnMessage
    public void onMessage(String message)
    {

        System.out.println("msg = "+message);

        this.session.getAsyncRemote().sendText("Echo"+message);
    }



}