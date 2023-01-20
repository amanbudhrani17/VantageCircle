import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {
    public static String sol(String customerType, String[] dates){
//        Storing the hotels in a list.
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("CoconutValley",3,new dayType(1100,800),new dayType(900,800)));
        hotels.add(new Hotel("AakulamLake",4,new dayType(1600,1100),new dayType(600,500)));
        hotels.add(new Hotel("VeliBeach",5,new dayType(2200,1000),new dayType(1500,400)));

        Map<String,Integer> map = new HashMap<>();
        map.put("Jan",1);
        map.put("Feb",2);
        map.put("Mar",3);
        map.put("Apr",4);
        map.put("May",5);
        map.put("Jun",6);
        map.put("Jul",7);
        map.put("Aug",8);
        map.put("Sep",9);
        map.put("Oct",10);
        map.put("Nov",11);
        map.put("Dec",12);

//        Counting the weekdays and weekend days
        int weekdays = 0;
        int weekends = 0;
        for(String date:dates){
            String d = date.substring(0,2);
            String month = date.substring(2,5);
            String year = date.substring(5,9);
            Date date1 = new Date(Integer.parseInt(year),map.get(month),Integer.parseInt(d)-1900);
            Format f = new SimpleDateFormat("EEEE");
            String str = f.format(date1);
            if(str.equals("Saturday") || str.equals("Sunday")){
                weekends++;
            }
            else weekdays++;
        }
        int res = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<hotels.size(); i++){
            Hotel hotel = hotels.get(i);
            int price = 0;
            if(customerType.equals("Regular")){
                price=weekdays*hotel.weekday.regularCustomerPrice+weekends*hotel.weekend.regularCustomerPrice;
            }
            else {
                price=weekdays*hotel.weekday.rewardCustomerPrice+weekends*hotel.weekend.rewardCustomerPrice;
            }
            if(min>price){
                min=price;
                res=i;
            } else if (min==price) {
//              If cost of two hotels are equal hotel with greater rating will be preferred.
                res = (hotels.get(res).rating<hotel.rating)?i:res;
            }
        }
        return hotels.get(res).name;
    }
}
class Hotel {
    String name;
    int rating;
    dayType weekday;
    dayType weekend;

    public Hotel(String name, int rating, dayType weekday, dayType weekend) {
        this.name = name;
        this.rating = rating;
        this.weekday = weekday;
        this.weekend = weekend;
    }
}

class dayType {
    int regularCustomerPrice;
    int rewardCustomerPrice;

    public dayType(int regularCustomerPrice, int rewardCustomerPrice) {
        this.regularCustomerPrice = regularCustomerPrice;
        this.rewardCustomerPrice = rewardCustomerPrice;
    }
}

