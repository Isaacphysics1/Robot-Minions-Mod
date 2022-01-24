package net.bigtony20.robot_minions.Socket;

import java.util.EventListener;

public interface MessageListener extends EventListener {
    public void myEventOccurred(NewMessage evt);
}
