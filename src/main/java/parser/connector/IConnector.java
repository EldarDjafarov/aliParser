package parser.connector;

import java.net.HttpURLConnection;

public interface IConnector {
     HttpURLConnection getConnect();

     void setOffset(int offset);

     int getOffset();
}