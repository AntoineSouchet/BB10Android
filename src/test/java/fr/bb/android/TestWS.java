package fr.bb.android;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

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
	public void Test02()
	{
		SecureRandom random = new SecureRandom();
		String test = new BigInteger(130, random).toString(32);
		test = test.substring(1, 9);
		System.out.println(test);
	}

}
