import java.util.Date;

public class BaikaAction {

    public static void main(String[] args) {

         // 今の時間
         Date nowTime = new Date();

         String strNowDate = RokuyoLogic.parseDateToString(nowTime);
         String nowY = strNowDate.substring(0,4);
         String nowM = strNowDate.substring(5,7);
         String nowD = strNowDate.substring(8,10);
         String nowH = strNowDate.substring(11,13);
         String nowS = strNowDate.substring(14,16);

         // 東京は19分プラスする
         int addtime = 19;

         String Ryokuyo = RokuyoLogic.RokuYo(Integer.parseInt(nowY),
                                             Integer.parseInt(nowM),
                                             Integer.parseInt(nowD));

         String stOldCalenderDay = (Ryokuyo.substring(4,14)+" "+ nowH+":"+ nowS);

         System.out.println("現在時刻:  " + strNowDate);
         System.out.println("旧暦:      " + BaikaLogic.addMinute(stOldCalenderDay, addtime));

         String ichin = BaikaLogic.ichin(BaikaLogic.addMinute(stOldCalenderDay, addtime));
         System.out.println(ichin);
    }
}
