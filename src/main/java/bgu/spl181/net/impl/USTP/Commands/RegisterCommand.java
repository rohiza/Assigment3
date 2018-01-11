package bgu.spl181.net.impl.USTP.Commands;

import bgu.spl181.net.api.bidi.Connections;
import bgu.spl181.net.impl.USTP.SharedData;
import bgu.spl181.net.impl.USTP.User;

import java.io.IOException;
import java.util.List;


public class RegisterCommand extends baseCommand {
    protected String username;
    protected String password;


    public RegisterCommand(List<String> args, SharedData data, Connections connections, Integer connectionId) {
        super(args, data, connections, connectionId);
        username =args.get(0);
        password =args.get(1);
    }

    public void execute() {
        if(username == null
                || password == null
                || data.containUserByName(username)
                || !islogin){
          errorCommand();
        }
        else{

            data.addUser(username,password);
            ackCommand();
        }
    }

    public void errorCommand(){
        try {
            connections.send(connectionId, "ERROR registration failed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ackCommand(){
        try {
            connections.send(connectionId, "ACK registration succeeded");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
