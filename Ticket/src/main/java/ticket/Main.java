package ticket;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        passengerService ps = new passengerService();
        //    ps.Booking(new passengerDetails(1,"abc","Hyd","Mlg"));
        //  ps.Booking(new passengerDetails(2,"bcd","Hyd","nlg"));
        // ps.Booking(new passengerDetails(3,"def","Hyd","piduguralla"));
        // ps.Booking(new passengerDetails(4,"efg","piduguralla","Mlg"));
        // ps.Booking(new passengerDetails(5,"hij","piduguralla","guntur"));
        // ps.Booking(new passengerDetails(6,"klm","guntur","chityala"));
       // List<passengerDetails> psd = ps.allpassengerdetails();
       // for (passengerDetails pd : psd) {
       //     System.out.println(pd);
        //}
        
//        String x="nlg";
//        List<passengerDetails> pps=  ps.particularpassenger(x);
//        for (passengerDetails pd : pps) {
//            System.out.println(pd);
   //     }
    ps.count("login");
    }
}

