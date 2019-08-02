package parser.reader;


import parser.connector.IConnector;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AliexpressReader implements IReader {

    private IConnector connector;

    public AliexpressReader(IConnector connector) {
        this.connector = connector;
    }

    public String getStringFromConnection() {
        StringBuffer stringFromConnection = null;
        String inputLine;
        try {
            BufferedReader  in = new BufferedReader(
                    new InputStreamReader(connector.getConnect().getInputStream()));

            stringFromConnection = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                stringFromConnection.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int start = stringFromConnection.charAt('(') + 1;
        int end = stringFromConnection.lastIndexOf(")");
        String JsonString = stringFromConnection.substring(start, end);
        return JsonString;
    }


}


