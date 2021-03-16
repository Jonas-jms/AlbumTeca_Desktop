//Referencia: https://stackoverflow.com/questions/4442192/how-to-use-an-internet-time-server-to-get-the-time
package Class;
import java.net.InetAddress;
import java.util.Date;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
public class gera_data
{
    public static Date gera_data() throws Exception
    {
        String TIME_SERVER = "time-a.nist.gov";   
        NTPUDPClient timeClient = new NTPUDPClient();
        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
        TimeInfo timeInfo = timeClient.getTime(inetAddress);
        
        long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
        Date time = new Date(returnTime);
        return time;
    }
    public static Date gera_data_offline()
    {
        long offline_time = System.currentTimeMillis();
        Date time = new Date(offline_time);
        return time;
    }
}
