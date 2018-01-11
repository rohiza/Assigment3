package bgu.spl181.net.impl.USTP.Commands;

import bgu.spl181.net.api.bidi.Connections;
import bgu.spl181.net.impl.USTP.SharedData;
import bgu.spl181.net.srv.ConnectionsImpl;

import java.io.IOException;
import java.util.List;

public class signOutCommand extends baseCommand {

    private String username;


    public signOutCommand(List<String> args, SharedData data, Connections connections, Integer connectionId) {
        super(args, data, connections, connectionId);
        this.username = args.get(0);
    }


    public void execute() {
        if(!islogin){
            errorCommand();
        }
        else {
            data.getLogInUsers().remove(connectionId);
            connections.disconnect(connectionId);
            ackCommand();
        }
    }

    public void errorCommand(){
        try {
            connections.send(connectionId, "ERROR signout failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ackCommand(){
        try {
            connections.send(connectionId, "ACK signout succeeded");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
