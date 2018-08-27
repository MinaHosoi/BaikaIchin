import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class BaikaLogic {

    /*
     * 卦を出す
     */
    static String ichin(String strdate) {

    ArrayList<Integer> dayintList = DayList(strdate);

    int year  = dayintList.get(0);
    int month = dayintList.get(1);
    int day   = dayintList.get(2);
    int hh    = dayintList.get(3);
    int mm    = dayintList.get(4);

    int upichin   = ((year+day+hh)%8 + 1);
    int downichin = ((year+day+hh+mm)%8 + 1);
    int kou       = ((year+day+hh+mm)%6 + 1);

    return String.valueOf("梅花心易:"+hushIchin(upichin,downichin,kou));
    }

    /*
     * 卦の詳細を出す
     */
    static String hushIchin(int upichin, int downichin, int kou) {

        HashMap<Integer,String> ichinmap = new HashMap<Integer,String>();

	ichinmap.put(1, "山");
        ichinmap.put(2, "地");
        ichinmap.put(3, "天");
        ichinmap.put(4, "沢");
        ichinmap.put(5, "火");
        ichinmap.put(6, "雷");
        ichinmap.put(7, "風");
        ichinmap.put(8, "水");

        return String.valueOf(ichinmap.get(upichin) + ichinmap.get(downichin) + kou);
    }


    /*
     * 時間の増減 東京なら１９分足す
     */
    static String addMinute(String yymmddhhmm, int addtime) {

	ArrayList<Integer> dayintList = new ArrayList<Integer>();

	dayintList = DayList(yymmddhhmm);

	int year = dayintList.get(0);
	int month = dayintList.get(1);
	int day = dayintList.get(2);
	int hh = dayintList.get(3);
	int mm = dayintList.get(4);

        Calendar cal1 = Calendar.getInstance();

        // 表示用フォーマットを設定します
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd HH:mm");

        cal1.set(year, month, day, hh, mm);

        //tokyo add 19minute
        cal1.add(cal1.MINUTE, addtime);
        //cal1.add(cal1.MONTH, -1);

	    return sdf1.format(cal1.getTime());
    }

    /*
     * 日付をstrからintに変換し要素に詰める。
     */
    static ArrayList<Integer> DayList (String yymmddhhmm) {
        ArrayList<Integer> dayInt = new ArrayList<Integer>();

        try {
            dayInt.add(Integer.parseInt(yymmddhhmm.substring(0,4)));
            dayInt.add(Integer.parseInt(yymmddhhmm.substring(5,7)));
            dayInt.add(Integer.parseInt(yymmddhhmm.substring(8,10)));
            dayInt.add(Integer.parseInt(yymmddhhmm.substring(11,13)));
            dayInt.add(Integer.parseInt(yymmddhhmm.substring(14,16)));

	} catch (NumberFormatException e) {
            System.out.println("number format error");
        }
        return dayInt;
    }

}
