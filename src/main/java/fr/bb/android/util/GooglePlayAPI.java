package fr.bb.android.util;

import java.io.File;
import java.io.FileOutputStream;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.AppsRequest;
import com.gc.android.market.api.model.Market.AppsResponse;
import com.gc.android.market.api.model.Market.GetImageRequest;
import com.gc.android.market.api.model.Market.GetImageRequest.AppImageUsage;
import com.gc.android.market.api.model.Market.GetImageResponse;
import com.gc.android.market.api.model.Market.ResponseContext;




public class GooglePlayAPI {
	
	
	private String id;
	
	public String getId(String name)
	{
		System.out.println("Recup de l'id");
		MarketSession session = new MarketSession();
        session.login("antoine.souchet@gmail.com", "XXX");
		String query = name;
		AppsRequest appsRequest = AppsRequest.newBuilder()
                .setQuery(query)
                .setStartIndex(0).setEntriesCount(1)
                .setWithExtendedInfo(false)
                .build();
		id = "";
		Callback<AppsResponse> callback = null;
		try {
			callback = new Callback<AppsResponse> () {
				@Override
				public void onResult(ResponseContext context, AppsResponse response) {
					try {
						id = response.getApp(0).getId();
					}
					catch(Exception e)
					{
						System.out.println("impossible de récupérer l'ID");
					}
					
				}
				
			};
		} catch (Exception e) {
			id = "";
		}
		
			session.append(appsRequest, callback);
			session.flush();
			return id;
	}
	
	
	public String getImage(final String MonId,final String name)
	{
			MarketSession session = new MarketSession();
	        session.login("antoine.souchet@gmail.com", "XXX");

			GetImageRequest imgReq = GetImageRequest.newBuilder().setAppId(MonId)
	                .setImageUsage(AppImageUsage.PROMO_BADGE)
	                .setImageId("1")
	                .build();

					session.append(imgReq, new Callback<GetImageResponse>() {
	                
	                @Override
	                public void onResult(ResponseContext context, GetImageResponse response) {
	                        try {
	                        		File file = new File("/var/www/img/" + name + ".png");
	                                FileOutputStream fos = new FileOutputStream(file);
	                                fos.write(response.getImageData().toByteArray());
	                                fos.close();
	                        } catch(Exception ex) {
	                                ex.printStackTrace();
	                        }
	                }
					});
					session.flush();


				return  name;
	}

}
