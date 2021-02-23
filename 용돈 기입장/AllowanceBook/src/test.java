import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	private SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	private SimpleDateFormat Fyear = new SimpleDateFormat("yyyyMMdd");
	private Date now = new Date();
	private String time = format.format(now);
	private String Ryear = Fyear.format(now);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test t = new test();
		System.out.println(t.Ryear);
		System.out.println(t.time);
	}
}
