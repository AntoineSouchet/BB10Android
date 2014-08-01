package fr.bb.android;

import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.AppsRequest;
import com.gc.android.market.api.model.Market.AppsResponse;
import com.gc.android.market.api.model.Market.GetImageRequest;
import com.gc.android.market.api.model.Market.GetImageRequest.AppImageUsage;
import com.gc.android.market.api.model.Market.GetImageResponse;
import com.gc.android.market.api.model.Market.ResponseContext;



public class TestWS {
	
	
	@Test
	public void TEST01()
	{
		String url = "https://play.google.com/store/apps/details?id=com.kongregate.mobile.tinydicedungeon.google";
		RestTemplate rest = new RestTemplate();
		String t = "";
		t  = rest.postForObject(url, null, String.class);
		t = t.trim();
		System.out.println(t);
	}
	
	
	@Test
	public void TestImage()
	{
		MarketSession session = new MarketSession();
        session.login("antoine.souchet@gmail.com", "coucou2031");
        
        //v2:com.sg.js.Doubles:1:3
        //-7934792861962808905
		GetImageRequest imgReq = GetImageRequest.newBuilder().setAppId("8885807488756673114")
                .setImageUsage(AppImageUsage.ICON)
                .setImageId("1")
                .build();

				session.append(imgReq, new Callback<GetImageResponse>() {
                
                @Override
                public void onResult(ResponseContext context, GetImageResponse response) {
                        try {
                        	File file = new File("/Temps/ico.png");
                                FileOutputStream fos = new FileOutputStream(file);
                                fos.write(response.getImageData().toByteArray());
                                fos.close();
                        } catch(Exception ex) {
                                ex.printStackTrace();
                        }
                }
});
session.flush();
	}
	
	@Test
	public void TestName()
	{
		MarketSession session = new MarketSession();
        session.login("antoine.souchet@gmail.com", "coucou2031");
		String query = "SoldierRun";
		AppsRequest appsRequest = AppsRequest.newBuilder()
                .setQuery(query)
                .setStartIndex(0).setEntriesCount(1)
                .setWithExtendedInfo(false)
                .build();

Callback<AppsResponse> callback = new Callback<AppsResponse> () {
@Override
public void onResult(ResponseContext context, AppsResponse response) {
	System.out.println(response.getAppCount());
System.out.println(response.getApp(0).getTitle());
System.out.println(response.getApp(0).getId());
}
};
session.append(appsRequest, callback);
session.flush();
}
	
}
	
