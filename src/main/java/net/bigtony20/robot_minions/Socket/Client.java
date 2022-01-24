package net.bigtony20.robot_minions.Socket;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.w3c.dom.events.Event;

import javax.swing.event.EventListenerList;
import java.util.EventListener;
import java.util.EventObject;

import java.net.URISyntaxException;

public class Client extends Thread {
    public String LastMessage;
    protected EventListenerList listenerList = new EventListenerList();
    public void addMyEventListener(MessageListener listener) {
        listenerList.add(MessageListener.class, listener);
    }
    public void removeMyEventListener(MessageListener listener) {
        listenerList.remove(MessageListener.class, listener);
    }
    void FireMessage(NewMessage evt) {
        Object[] listeners = listenerList.getListenerList();
        for (int i = 0; i < listeners.length; i = i+2) {
            if (listeners[i] == MessageListener.class) {
                ((MessageListener) listeners[i+1]).myEventOccurred(evt);
            }
        }
    }

    Socket socket;
    @Override
    public void run() {

        try {
            socket = IO.socket("http://localhost:8080");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println("Connected to server!");
            }

        });
        socket.on("time", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println("Time: " + args[0]);
            }
        });
        socket.on("message", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                LastMessage = (String)args[0];
                FireMessage(new NewMessage(this));
            }
        });
        socket.connect();
    }
    public void SendMessage(String Msg){
        socket.emit("message",Msg);
    }
}
