package parser.connector;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConnectorToAliexpress implements IConnector {
    private int offset;

    public HttpURLConnection getConnect() {
        HttpURLConnection connection = null;
        try {
            /*goods are added asynchronously, and since they are parsed with a tool with a js interpreter (headless browser, etc.)
             which causes enumeration by memory, network and process, I found a way to parse them with a get request,
              similar to what is wired in js logic. Increasing the offset by 12 gives us a new page with goods.*/
            URL url = new URL("https://gpsfront.aliexpress.com/queryGpsProductAjax.do?" +
                    "callback=jQuery18308837264126129163_1564698375898&widget_id=5547572&platform=pc&limit=12" +
                    "&offset="+offset+"&phase=1&productIds2Top=&postback=5d26986e-c068-499e-8628-d275b6326d85&_=1564698396398");
            connection = (HttpURLConnection) url.openConnection();
            /*By editing cookies, you can receive products with prices and descriptions in different languages.
            It is also responsible for issuing,  with different cookies may be different issuance*/
            connection.setRequestProperty("Cookie", "ali_apache_id=11.227.116.108.1564576602609.370130.8; xman_us_f=x_l=0&x_locale=en_US&no_popup_today=n&x_user=UA|UA|shopper|ifm|2107164754&zero_order=y&last_popup_time=1564576636358; aep_usuc_f=region=US&site=glo_n&b_locale=en_US&isb=y&x_alimid=2107164754&c_tp=USD; intl_common_forever=1Z59pwGOA/Xk6nqAl1BfN/Cqwu7d2KcQ9keiA5HT+SVAbJKZCGmzVg==; xman_f=lnEmsfuRVRICakrj3E5HMzzhB5fa8pbAQOJt/v9S/nBmdwpXSGbVadmndLfhMr4b4O8nJwCvAVnmJ2Vru8urnv94ueeVfI9y7MWrMCy+JR3QzPeIjSVrvnEziclKx/KLybo6JOQTMCKzODpeyvA72b4WmeuegO7IIEDeduA1CtsBU+gGhNh+PS7V2BJChS+SFB02PzVnQ4nUuMnDcTfb6kv5FMljrjpAfSN/0wp8C62dsAa2pga2SGavypmTQ0OClGrnD3UjNxMILzkcDgKRXmI8tiZ2rcabDG1de7rqjYMCNm8GeOr0hDr+3QjtBxu5r1/GCMW1RBupBCDUtVkQzLVgNfobEBsnPi1o1eQz+ZSKvG/yFufqDd+lG5JqGQ6P17HZpsWEEKNz3x5s9GA0AS8HgA35gF7ZHi0VUQG4CAFcPMkGZglP01OF47bEqp0HQ6yOVV2OXu0=; ali_apache_track=mt=1|mid=ua507625758wifae; cna=8nSmFRynTU8CASU2zlWNTtA2; isg=BK6u9pp-f9rT_4s8g7pW3iTm_A2wB3bNlw4aCNh3XbFbu04VQD0KuMu5c__yeGrB; l=cBQs7rhPqbbRW6q2BOCaquI84obtKIOYYuPRwFYXi_5Iz68o4lbOkSmRhFJ6cOWdtfYB4kk0KTJ9-eteitZsy9q4t6gR.; _ga=GA1.2.929081100.1564576605; _gid=GA1.2.349397137.1564576605; _fbp=fb.1.1564576605852.829393330; _m_h5_tk=0c9a476335ad78bcd2237f16594cd20a_1564681192290; _m_h5_tk_enc=ca2d12b84abc25199cb92155dc4dad08; aep_common_f=r9v1Lx0ldE8XuROBw131mKQDn9/IzadtUFHjX51BXhNnE7JWuWkz6A==; _uab_collina=156457708327660474868557; RT=\"sl=2&ss=1564673040191&tt=7338&obo=1&sh=1564673191374%3D2%3A1%3A7338%2C1564673047543%3D1%3A0%3A7338&dm=aliexpress.com&si=fccf02c0-9e3e-41ff-b5ab-6346c0fe14dc&se=900&bcn=%2F%2F0211c83f.akstat.io%2F&ld=1564673191374&r=https%3A%2F%2Fwww.aliexpress.com%2Fstore%2F4394025&ul=1564673191377&hd=1564673191606\"; aep_history=keywords%5E%0Akeywords%09%0A%0Aproduct_selloffer%5E%0Aproduct_selloffer%0932838577721%0932838577721; acs_usuc_t=x_csrf=otrdxg4mvrws&acs_rt=dcc4715dff1e419098e3ad71f1744656; ali_apache_tracktmp=W_signed=Y; XSRF-TOKEN=c401b36c-4a69-4a43-9922-4ee05a37e587; _hvn_login=13; aep_usuc_t=ber_l=A0; xman_t=CKwFeiahkpJ1rUFpKDlNB90ipnXsHo/qeM7S2RAkUG5kvchzTJ7iEzD/BOjHjpAL");
            connection.setRequestMethod("GET");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;

    }
    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
