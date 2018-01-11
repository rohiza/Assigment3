package bgu.spl181.net.impl.MovieRentalService;

import bgu.spl181.net.api.bidi.Connections;
import bgu.spl181.net.impl.USTP.Commands.RegisterCommand;
import bgu.spl181.net.impl.USTP.Commands.baseCommand;
import bgu.spl181.net.impl.USTP.SharedData;
import bgu.spl181.net.impl.USTP.User;

import java.io.IOException;
import java.util.List;

public class registerMovieUser extends RegisterCommand {
    private String country;

    public registerMovieUser(List<String> args, SharedData data, Connections connections, Integer connectionId) {
        super(args, data, connections, connectionId);
        this.country = args.get(2);
    }

    @Override
    public void execute() {
        if(username == null
                || password == null
                || data.containUserByName(username)
                || !islogin){
            errorCommand();
        }
        else{
            data.addUser(username, password, country);
            ackCommand();
        }
    }


    @Override
    public void errorCommand() {
        super.errorCommand();
    }

    @Override
    public void ackCommand() {
        super.ackCommand();
    }
}
