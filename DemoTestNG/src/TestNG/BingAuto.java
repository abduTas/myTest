package TestNG;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.gson.JsonObject;

public class BingAuto {
	  String grant_type = "client_credentials" ;
	  String scope = "http://api.microsofttranslator.com";
	  String clientId= "abdulla" ;
	  String clientSecret= "ULmCt0a5kjI0kmaedKpZ8r07hYTbFqpRbjV74qFTWTQ=";
	  static	final String USER_AGENT = "Mozilla/5.0";
	  static	final String ENCODING = "UTF-8";

	public static void main(String[] args) throws IOException, JSONException {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.bing.com/translator");	

		String csvLine;
		BufferedReader br = null ;
		String splitter=",";

		try{
			br= new BufferedReader(new FileReader("/home/abdullatasleem/Documents/bing.csv"));
		while((csvLine=br.readLine())!=null){
			String line[] = csvLine.split(splitter);
			
				System.out.println( line[0] +line[1]+line[2] );
				WebElement element = driver.findElement(By.id("srcText"));
				List<WebElement> list =  driver.findElements(By.id("LS_LangList"));
				System.out.println(list.get(1));
				WebElement dest = list.get(1);
				dest.click();
				Actions actions = new Actions(driver);
				WebElement submenu = driver.findElement(By.xpath("//*[@id='LS_LangList']/table/tbody/tr[12]/td[1]"));
				System.out.println(submenu.getText());
				actions.moveToElement(submenu).click();
				//actions.click().build().perform();
				driver.findElement(By.id("LS_LangList")).click();
				actions.moveToElement(driver.findElement(By.xpath("//*[@id='LS_LangList']/table/tbody/tr[16]/td[1]"))).click();
				element.clear();
				element.sendKeys(line[2]);
				Thread.sleep(2000);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		String str =  BingAuto.getToken();
     JSONObject json = new JSONObject(str);
     String tokenP = json.getString("access_token");
     int exp = json.getInt("expires_in");
     String token = "Bearer" +tokenP ; 
     System.out.println("token is " + token);
     System.out.println("it expires in " +exp);
     
	}	
	public static String getToken() throws IOException
	     {
		String uri = "https://datamarket.accesscontrol.windows.net/v2/OAuth2-13";
	URL url = new URL(uri);
	HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
	//add request header
	String id=URLEncoder.encode("abdulla", "UTF-8");
	String pass=URLEncoder.encode("mfEFOhwx6kjDKyUZj6VR5rKvuJPvNZ3toSIcuqFqWFE=", "UTF-8");
	String urlParameters = "grant_type=client_credentials&scope=http://api.microsofttranslator.com"
	       + "&client_id=abdulla" + 
	       "&client_secret=ULmCt0a5kjI0kmaedKpZ8r07hYTbFqpRbjV74qFTWTQ="  ;
	con.setRequestProperty("Content-Type","application/x-www-form-urlencoded; charset=" + ENCODING);
	con.setRequestProperty("Accept-Charset",ENCODING);
	con.setRequestMethod("POST");
	con.setDoOutput(true);
	
	OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
	wr.write(urlParameters);
	wr.flush();
	
	
	wr.close();
	
	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);
	
	BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
	
	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	System.out.println(response);
	in.close();
	return response.toString();
 }
}

			
//			
//	   private String retrieveResponse(final URL url) throws Exception {
//
//	        
//	           String tokenJson = getToken(clientId,clientSecret);
//	           JSONObject jas = new JSONObject(tokenJson);
//	           Integer expiresIn = Integer.parseInt((String)((JSONObject)JSONValue.parse(tokenJson)).get("expires_in"));
//	           tokenExpiration = System.currentTimeMillis()+((expiresIn*1000)-1);
//	           token = "Bearer " + (String)((JSONObject)JSONValue.parse(tokenJson)).get("access_token");
//	        
//	        final HttpURLConnection uc = (HttpURLConnection) url.openConnection();
//	        if(referrer!=null)
//	            uc.setRequestProperty("referer", referrer);
//	        uc.setRequestProperty("Content-Type",contentType + "; charset=" + ENCODING);
//	        uc.setRequestProperty("Accept-Charset",ENCODING);
//	        if(token!=null) {
//	            uc.setRequestProperty("Authorization",token);
//	        }
//	        uc.setRequestMethod("GET");
//	        uc.setDoOutput(true);
//}
//}