package kku.nuttapongklaokliang.connectpython;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by BonuZz on 7/1/2560.
 */

public class SendMsg extends AsyncTask<String, Void, Void> {
    private Exception exception;
    private String ip;

    public SendMsg(String i) {
        super();
        this.ip = i;
    }

    @Override
    protected Void doInBackground(String... strings) {
        try {
            try{
                Socket socket = new Socket(ip,8888);
                PrintWriter toServer = new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
                toServer.print(strings[0]);
                toServer.flush();
             }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        catch (Exception e){
            this.exception = e;
            return null;
        }
        return  null;
    }
}
