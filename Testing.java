import static org.junit.Assert.*;
import org.junit.Test;
public class Testing {
    @Test
    public void testPart3(){
        assertEquals("CoconutValley", Solution.sol("Regular",new String[]{"16Mar2009", "17Mar2009", "18Mar2009"}));
        assertEquals("AakulamLake", Solution.sol("Regular",new String[]{"20Mar2009", "21Mar2009", "22Mar2009"}));
        assertEquals("VeliBeach", Solution.sol("Rewards",new String[]{"26Mar2009", "27Mar2009", "28Mar2009"}));
    }
}
