package com.components;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.json.JSONArray;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.Database.DatabaseComponent;
import com.baseClasses.BaseClass_Web;
import com.baseClasses.PDFResultReport;
import com.baseClasses.ThreadLocalWebdriver;
import com.components.eTenderComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class API_Component extends BaseClass_Web {
	
	public eTenderComponent etendercomponentobj = new eTenderComponent(pdfResultReport);
	public Dynamicity dynamicity=new Dynamicity(pdfResultReport);
	public API_Component(PDFResultReport pdfresultReport) {

		this.pdfResultReport = pdfresultReport;
	}
	private static String jwt=null;
	private static String token=null;
	public static String temResponse=null;
	public static JsonPath js;
	public static String js_S;
	public static String js_S1;
	public static String js_S2;
	private static final String BASE_URL = null;
	//public static int prRandomint=69046168;
	public static int prRandomint=getrandomInterger( 1, 99999999);
	public static int lineItemNumber;
	public static int materialCodes;
	public static String PR_Number = String.valueOf(prRandomint);
	public static String userPassword= null;
	private static ExecutorService executor = Executors.newSingleThreadExecutor();
    private static Future<?> future;
    //public static String username =getDataFromPropertiesFile("pr_Tendercreator");
  	public static String username =null;
  	public static String uName =getDataFromPropertiesFile("TenderCreator", filePath_4);
  	public static String activityID=null;
  	
    public static int getrandomInterger(int min, int max) {
		return ((int) (Math.random() * (max - min))) + min;
	}
	public static String getDataFromPropertiesFile(String value)  {
		FileInputStream fileReader = null;
		Properties properties = null;
		String propertyValue;
		try {
			final String filePath = System.getProperty("user.dir")
					+ "//src//main//java//com//DataProperties//GeneralInfo.properties";

			fileReader = new FileInputStream(filePath);

			properties = new Properties();
			properties.load(fileReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		propertyValue = properties.getProperty(value);

		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propertyValue;

	}
	public static String getDataFromPropertiesFile(String value, String filepath ) {
		FileInputStream fileReader = null;
		Properties properties = null;
		String propertyValue;
		try {
			final String filePath = filepath;

			fileReader = new FileInputStream(filePath);

			properties = new Properties();
			properties.load(fileReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		propertyValue = properties.getProperty(value);

		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return propertyValue;

	}
	public static void testconversion(String rp) {
  		js = new JsonPath(rp);
  		js_S =rp;
  		cd_S=rp;
  		Dynamicity.jsResponse=js;
  	}
	public static void testconversion_v1(String rp) {
		js_S1 =rp;
		uniqueTG=Dynamicity.getUniqueTemplateGroupIds(rp);
  		js = new JsonPath(rp);
  		Dynamicity.jsResponse_v1=js;
  	}
	public static void testconversion_v2(String rp) {
		js_S2 =rp;
  		js = new JsonPath(rp);
  		Dynamicity.jsResponse_v2=js;
  	}
	public static void testconversion_cd(String rp) {
  		js = new JsonPath(rp);
  		js_S =rp;
  		Dynamicity.jsResponse_cd=js;
  	}
	private static String payload = "{\n" + "  \"userCode\": \""+username+"\",\n"
			+ "  \"password\": \""+userPassword+"\",\n"
			+ "  \"rememberme\": \"false\"\n" + "}";
	
	private static String payload_bid = "{\n" + "  \"userCode\": \"cts_auto_01\",\n"
			+ "  \"password\": \"$2a$12$CTS1AUTO1011234567890uM0A9GuYoChAV9glxvWOXkXvMeEyiKty\",\n"
			+ "  \"rememberme\": \"false\"\n" + "}";

	public static String jp() {
		lineItemNumber=getrandomInterger( 1, 9999);
    	materialCodes=getrandomInterger( 1, 99999999);
    	PR_Nu=prRandomint;
		return "[\r\n" + 
		"  {\r\n" + 
		"    \"prNumber\": \""+prRandomint+"\",\r\n" + 
		"    \"erpDataItemList\": [\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+lineItemNumber+"."+materialCodes+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      }\r\n" + 
		"	  ]\r\n" + 
		"  }\r\n" + 
		"]";
	}
    
	public static String jp_AddMorePR() {
		lineItemNumber=getrandomInterger( 1, 9999);
    	materialCodes=getrandomInterger( 1, 99999999);
    	
		return "[\r\n" + 
		"  {\r\n" + 
		"    \"prNumber\": \""+prRandomint+"\",\r\n" + 
		"    \"erpDataItemList\": [\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+lineItemNumber+"."+materialCodes+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      }\r\n" + 
		"	  ]\r\n" + 
		"  }\r\n" + 
		"]";
	}
    
	public static String jp_MI() {
		lineItemNumber=getrandomInterger( 1, 9999);
    	materialCodes=getrandomInterger( 1, 99999999);
    	PR_Nu=prRandomint;
		return "[\r\n" + 
		"  {\r\n" + 
		"    \"prNumber\": \""+prRandomint+"\",\r\n" + 
		"    \"erpDataItemList\": [\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(1+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(1+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(1+lineItemNumber)+"."+(1+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(2+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(2+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(2+lineItemNumber)+"."+(2+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(3+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(3+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(3+lineItemNumber)+"."+(3+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(4+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(4+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(4+lineItemNumber)+"."+(4+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(5+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(5+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(5+lineItemNumber)+"."+(5+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(6+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(6+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(6+lineItemNumber)+"."+(6+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(7+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(7+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(7+lineItemNumber)+"."+(7+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(8+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(8+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(8+lineItemNumber)+"."+(8+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(9+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(9+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(9+lineItemNumber)+"."+(9+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(10+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(10+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(10+lineItemNumber)+"."+(10+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(11+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(11+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(11+lineItemNumber)+"."+(11+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(12+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(12+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(12+lineItemNumber)+"."+(12+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(13+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(13+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(13+lineItemNumber)+"."+(13+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(14+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(14+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(14+lineItemNumber)+"."+(14+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(15+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(15+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(15+lineItemNumber)+"."+(15+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(16+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(16+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(16+lineItemNumber)+"."+(16+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(17+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(17+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(17+lineItemNumber)+"."+(17+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(18+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(18+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(18+lineItemNumber)+"."+(18+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(19+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(19+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(19+lineItemNumber)+"."+(19+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(20+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(20+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(20+lineItemNumber)+"."+(20+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(21+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(21+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(21+lineItemNumber)+"."+(21+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(22+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(22+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(22+lineItemNumber)+"."+(22+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(23+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(23+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(23+lineItemNumber)+"."+(23+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(24+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(24+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(24+lineItemNumber)+"."+(24+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(25+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(25+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(25+lineItemNumber)+"."+(25+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(27+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(27+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(27+lineItemNumber)+"."+(27+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(28+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(28+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(28+lineItemNumber)+"."+(28+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(29+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(29+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(29+lineItemNumber)+"."+(29+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(30+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(30+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(30+lineItemNumber)+"."+(30+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(31+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(31+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(31+lineItemNumber)+"."+(31+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(32+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(32+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(32+lineItemNumber)+"."+(32+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(33+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(33+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(33+lineItemNumber)+"."+(33+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(34+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(34+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(34+lineItemNumber)+"."+(34+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(35+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(35+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(35+lineItemNumber)+"."+(35+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(36+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(36+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(36+lineItemNumber)+"."+(36+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(37+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(37+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(37+lineItemNumber)+"."+(37+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(38+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(38+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(38+lineItemNumber)+"."+(38+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(39+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(39+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(39+lineItemNumber)+"."+(39+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(40+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(40+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(40+lineItemNumber)+"."+(40+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(41+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(41+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(41+lineItemNumber)+"."+(41+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(42+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(42+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(42+lineItemNumber)+"."+(42+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(43+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(43+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(43+lineItemNumber)+"."+(43+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(44+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(44+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(44+lineItemNumber)+"."+(44+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(45+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(45+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(45+lineItemNumber)+"."+(45+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(46+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(46+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(46+lineItemNumber)+"."+(46+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(47+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(47+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(47+lineItemNumber)+"."+(47+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(48+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(48+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(48+lineItemNumber)+"."+(48+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(49+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(49+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(49+lineItemNumber)+"."+(49+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(50+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(50+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(50+lineItemNumber)+"."+(50+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prOriginalNo\": \""+prRandomint+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+(26+lineItemNumber)+"\",\r\n" + 
		"        \"materialCode\": \""+(26+materialCodes)+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+prRandomint+"."+(26+lineItemNumber)+"."+(26+materialCodes)+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      }\r\n" + 
		"	  ]\r\n" + 
		"  }\r\n" + 
		"]";
	}
	
	// Method to perform a POST request with a payload
    public static Response postWithPayload(String endpoint, String requestBody) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestBody);

        return request.post(BASE_URL + endpoint);
    }

    // Method to perform a POST request with parameters
    public static Response postWithParameters(String endpoint, String param1, String param2) {
        RequestSpecification request = RestAssured.given();
        request.param("param1", param1);
        request.param("param2", param2);

        return request.post(BASE_URL + endpoint);
    }
    public static String baseURL() throws InterruptedException, IOException {
    	
    	String ENV=Dynamicity.getDataFromPropertiesFile("Environment", filePath_4);
    	String Environment=null;
    	if(ENV.equalsIgnoreCase("QA")) {
    		Environment="https://epsnewprodaws.mjunction.in/EPSV2Web/";
		}
		else{
			Environment="https://epsstagingaws.mjunction.in/EPSV2Web/";
			}
    	return Environment;
    }
    public static String Authority() throws InterruptedException, IOException {
    	
    	String ENV=Dynamicity.getDataFromPropertiesFile("Environment", filePath_4);
    	String authority=null;
    	if(ENV.equalsIgnoreCase("QA")) {
    		authority="epsnewprodaws.mjunction.in";
		}
		else{
			authority="epsstagingaws.mjunction.in";
			}
    	return authority;
    }
    
    public static String provideTokenObject() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
		String response = given().header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).when()
				.post("rest/login/provideTokenObject").then().extract().response().asString();
		JsonPath js = new JsonPath(response);
		jwt=js.getString("jwt");
        return jwt;
		
    }
    public static String Login() throws IOException, InterruptedException {
    	userPassword = DatabaseComponent.encryptedPWD();
    	username=Dynamicity.getDataFromPropertiesFile("tokenExtractor", filePath_4);
    	String payload1 = "{\n" + "  \"userCode\": \""+username+"\",\n"
    			+ "  \"password\": \""+userPassword+"\",\n"
    			+ "  \"rememberme\": \"false\"\n" + "}";
    	RestAssured.baseURI = baseURL();
		String response = given().header("Authorization", jwt).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br").header("Accept-Language", "en-US,en;q=0.9,te;q=0.8")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).contentType(ContentType.JSON).body(payload1).when().post("rest/login/login").then().extract().response().asString();
		JSONArray array = new JSONArray(response);
		String fulltoken = array.get(0).toString();
		token=fulltoken;
        return token;
    }
    
    public static String Login_AfterTenderCreation(String SN) throws IOException, InterruptedException {
    	userPassword = DatabaseComponent.encryptedPWD_AferTenderCreation(SN);
    	username=SN;
    	String payload1 = "{\n" + "  \"userCode\": \""+username+"\",\n"
    			+ "  \"password\": \""+userPassword+"\",\n"
    			+ "  \"rememberme\": \"false\"\n" + "}";
    	RestAssured.baseURI = baseURL();
		String response = given().header("Authorization", jwt).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br").header("Accept-Language", "en-US,en;q=0.9,te;q=0.8")
				.header("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).contentType(ContentType.JSON).body(payload1).when().post("rest/login/login").then().extract().response().asString();
		JSONArray array = new JSONArray(response);
		String fulltoken = array.get(0).toString();
		token=fulltoken;
        return token;
    }
    
    public static void templateGroupDetails(String QueryParameter) throws InterruptedException, IOException {
    	//RestAssured.baseURI = BASE_URL;
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token).queryParam("id", QueryParameter).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).when().post("rest/templategroup/templateGroupWithTemplateAndFieldsView").then().extract().response().asString();testconversion(response);inCheck=1; poCheck=1; 
    }
    public static void templateGroupDetails_AfterTenderCreation(String QueryParameter) throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token)
				.queryParam("id", QueryParameter).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/templategroup/templateGroupWithTemplateAndFieldsView").then().extract().response().asString();testconversion(response); inCheck=1;
    }
    public static void sDQISWDBTD() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token)
				.queryParam("tenderId", sTID).header("Accept", "application/json, text/plain, */*").header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).when().post("rest/quotation/showDraftQuotationInsertScreenWithDataByTenderId").then().extract().response().asString();JsonPath js = new JsonPath(response);js_SGI=js;brc=1;
    }
    public static void gttd_BS() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token)
				.queryParam("tenderId", sTID).queryParam("bidderId", vUID).queryParam("bidPartNo", "0").queryParam("quotationId", dQID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).when().post("rest/quotation/getTemplateTabDetailsByBidPartNoAndBidderId").then().extract().response().asString();testconversion(response);
    }
    public static String gDQTD(int tgID) throws InterruptedException, IOException {
    	try {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token)
				.queryParam("quotationId", dQID).queryParam("templategroupid", tgID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/quotation/getDraftQuotationTabFieldDtls").then().extract().response().asString();
				return response;
    	}
    	catch(Exception e) {
    		response=null;
    		return response;
    	}
    }
    public static void gTIBRFQ() throws InterruptedException, IOException {
    	try {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token).queryParam("tenderId", sTID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/tender/getTenderInfoByTenderId").then().extract().response().asString();testconversion(response);
    	}
    	catch(Exception e) {
    		response=null;
    	}
    }
    public static void sBAD() throws InterruptedException, IOException {
    	try {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token).queryParam("tenderId", sTID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/bidactivity/showBidOpeningActivityDetailsByTenderId").then().extract().response().asString();JsonPath js = new JsonPath(response);activityID=js.getString("activityId");
    	}
    	catch(Exception e) {
    		response=null;
    	}
    }
    public static void sBLRFQId() throws InterruptedException, IOException {
    	try {
    	RestAssured.baseURI = baseURL();
				response = given().header("Authorization", token).queryParam("tenderId", sTID).queryParam("docTypeId", 10).queryParam("appDetailId", 0).queryParam("activityId", activityID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/bidactivity/showBidderListByTenderIdForInitiatorNew").then().extract().response().asString();testconversion(response);
    	}
    	catch(Exception e) {
    		response=null;
    	}
    }
    public static void gQBCId() throws InterruptedException, IOException {
    	try {
    	RestAssured.baseURI = baseURL();
				qID = given().header("Authorization", token).queryParam("tenderId", sTID).queryParam("bidderId", bID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/quotation/getQuotationByCreatorId").then().extract().response().asString();inCheck=1;
				
    	}
    	catch(Exception e) {
    		response=null;
    	}
    }
    static int roleId=0;
    public static void gDQDetails(int bidPart) throws InterruptedException, IOException {
    	try {
    	String approvalType="No";
    	if(approvalType.equalsIgnoreCase("Yes")) {
    		roleId=2;
    	}
    	else {
    		roleId=5;
    	}
    	RestAssured.baseURI = baseURL();
				 response = given().header("Authorization", token).queryParam("tenderId", sTID).queryParam("bidderId", bID).queryParam("bidPartNo", bidPart).queryParam("negotiationId", 0).queryParam("quotationId", qID).queryParam("roleId", roleId).queryParam("approvalDetailId", 0)
						.header("Accept", "application/json, text/plain, */*").header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
						.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/bidactivity/getDecriptedQuotationDetailsByBidPartNoAndBidderId").then().extract().response().asString();inCheck=1;

				 WebDriver driver=ThreadLocalWebdriver.getDriver();
				 if (driver != null) {
					    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
					    String script = "return JSON.parse(arguments[0]);";
					    Object result = jsExecutor.executeScript(script, response);
					    testconversion(result.toString());
					} else {
					    System.out.println("WebDriver is not initialized.");
					}
    	}
    	catch(Exception e) {
    		response=null;
    	}
    }
    public static void getSanctionDetails_S() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	String SanctionID=DatabaseComponent.getSanctionID();
		String response = given().header("Authorization", token)
				.queryParam("sanctionId", SanctionID).queryParam("callFromInitialSave", "true").queryParam("withTemplate", "true")
				.queryParam("sanctionDetailRequiredFlag", "true").header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/sanctionnote/getSanctionBySanctionId").then().extract().response().asString();testconversion(response);inCheck=1;
    }
    public static void cd_SNfromPR() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	String SanctionID=DatabaseComponent.getSanctionID();
    	String payload="{\"prSnidentifierNo\":\""+SanctionID+"\",\"sanctionRefNo\":\""+ReferenceNoLocatorText_msn+"\",\"sanctionGroupId\":"+sanctionGroupID+",\"sanctionDetailRequiredFlag\":\"Y\"}";
		String response = given().header("Authorization", token).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
				.header("authority", Authority()).contentType(ContentType.JSON).body(payload).when().post("rest/sanctionnote/initialSaveAndGetSanctionDetailForFreshSNNew").then().extract().response().asString();testconversion_cd(response);
    }
    public static void getSanctionDetails_MS() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	String payload_msn = "{\"prSnidentifierNo\":\"0\",\"sanctionRefNo\":\"test_legacy code\",\"sanctionGroupId\":"+sanctionGroupID+",\"sanctionDetailRequiredFlag\":\"Y\"}";
		String response = given().header("Authorization", token)
				.header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).contentType(ContentType.JSON).body(payload_msn).when().post("rest/sanctionnote/initialSaveAndGetSanctionDetailForFreshSNNew").then().extract().response().asString();testconversion(response); inCheck=1;
    }
    public static void getSanctionDetails_Indent() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	String SanctionID=DatabaseComponent.getSanctionID_Indent();
		String response = given().header("Authorization", token)
				.queryParam("sanctionId", SanctionID).queryParam("callFromInitialSave", "false").queryParam("withTemplate", "true")
				.queryParam("sanctionDetailRequiredFlag", "true").header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/sanctionnote/getSanctionBySanctionId").then().extract().response().asString();testconversion(response);   inCheck=1;
    }
    public static void getSanctionDetails_PR() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	String SanctionID=DatabaseComponent.getSanctionID_PR();
		String response = given().header("Authorization", token)
				.queryParam("sanctionId", SanctionID).queryParam("callFromInitialSave", "false").queryParam("withTemplate", "true")
				.queryParam("sanctionDetailRequiredFlag", "true").header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7").header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/sanctionnote/getSanctionBySanctionId").then().extract().response().asString();testconversion(response);inCheck=1;
    }
    public static void gTD(String tGID) throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	String payload1 = "{\"tenderId\":"+sTID+",\"templategroupId\":"+tGID+",\"approvalId\":0,\"userRoleId\":5}";
		String response = given().header("Authorization", token).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).contentType(ContentType.JSON).body(payload1).when().post("rest/tender/getTenderDetailNew").then().extract().response().asString();testconversion_v2(response);
    }
    public static void pT_V() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	DatabaseComponent.sysTID();
		String response = given().header("Authorization", token)
				.queryParam("userTypeId", "2").queryParam("tenderId", sTID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/tender/previewTenderByTenderIdNew").then().extract().response().asString();testconversion_v1(response);
    }
    public static void pI_V() throws InterruptedException, IOException {
    	RestAssured.baseURI = baseURL();
    	DatabaseComponent.sysIID();
		String response = given().header("Authorization", token).queryParam("indentId", sIID).header("Accept", "application/json, text/plain, */*")
				.header("Accept-Encoding", "gzip, deflate, br, zstd").header("Accept-Language", "en-US,en;q=0.9,bn;q=0.8,hi;q=0.7")
				.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36").header("authority", Authority()).when().post("rest/indent/previewIndentByIndentId").then().extract().response().asString();testconversion_v1(response);
    }
    public static void startPrUpload() throws IOException {
        future = executor.submit(() -> {
            try {
                prUpload();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void stopPrUpload() {
        if (future != null && !future.isDone()) {
            future.cancel(true); // Interrupt the execution if it's not finished
        }
    }
    static boolean status200=false;
    public static void prUpload() throws InterruptedException, IOException {
    	while(status200==false) {
    	try {
    	String ENV=Dynamicity.getDataFromPropertiesFile("Environment", filePath_4);
    	String Environment=null;
    	if(ENV.equalsIgnoreCase("QA")) {
    		Environment="https://epsnewprodaws.mjunction.in/ERPIntegrationWeb";
		}
		else{
			Environment="https://epsstagingaws.mjunction.in/ERPIntegrationWeb";
			}
    	
    	waitForObj(2000);
    	lineItemNumber=getrandomInterger( 1, 9999);
    	materialCodes=getrandomInterger( 1, 99999999);
    	RestAssured.baseURI = Environment;
    	String response1 = given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZUlkIjoxLCJzdWIiOiIxMzcyLiIsIm9yZ2FuaXphdGlvbk5hbWUiOiJIUENMLU1pdHRhbCBFbmVyZ3kgTGltaXRlZCIsImN1cnJlbnRMb2NhbGUiOiJlbiIsImlzcyI6IkFuaW1lc2giLCJ2ZW5kb3JJZCI6MCwidXNlclJvbGVMaXN0IjpbNl0sImJpZGRlckNvbXBhbnlOYW1lIjpudWxsLCJ1c2VyQ29kZSI6IkhQQ0wgTUlUVEFMIEVORVJHWSBMSU1JVEVEX1NVUEVSX0FETUlOIiwib3JnSWQiOiIxMzcyIiwiYXVkIjoiMTM3MiIsImV4cCI6MTk3NjQ5NzkyMCwiaWF0IjoxNjYxMTM3OTIwLCJqdGkiOiIzMDk4OCJ9.nkGaSTDS3ubw-MC6L9EQktqR7_48oF9X0zS982-mQuY")
				.header("Content-Type", "application/json").header("orgkey", "HMEL_PR")
				.contentType(ContentType.JSON).body(jp_MI()).when()
				.post("rest/erpintegration/prImport").then().extract().response().asString();
		lineItemNumber=0;
    	materialCodes=0;
		System.out.println(response1);
		status200=true;
    	}
    	catch(Exception e){
    		status200=false;
    		}
    	}
    }
    public static void prUpload_CR(String pl) throws InterruptedException, IOException {
    	while(status200==false) {
    	try {
    	String ENV=Dynamicity.getDataFromPropertiesFile("Environment", filePath_4);
    	String Environment=null;
    	if(ENV.equalsIgnoreCase("QA")) {
    		Environment="https://epsnewprodaws.mjunction.in/ERPIntegrationWeb";
		}
		else{
			Environment="https://epsstagingaws.mjunction.in/ERPIntegrationWeb";
			}
    	
    	waitForObj(2000);
    	lineItemNumber=getrandomInterger( 1, 9999);
    	materialCodes=getrandomInterger( 1, 99999999);
    	RestAssured.baseURI = Environment;
    	String response1 = given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZUlkIjoxLCJzdWIiOiIxMzcyLiIsIm9yZ2FuaXphdGlvbk5hbWUiOiJIUENMLU1pdHRhbCBFbmVyZ3kgTGltaXRlZCIsImN1cnJlbnRMb2NhbGUiOiJlbiIsImlzcyI6IkFuaW1lc2giLCJ2ZW5kb3JJZCI6MCwidXNlclJvbGVMaXN0IjpbNl0sImJpZGRlckNvbXBhbnlOYW1lIjpudWxsLCJ1c2VyQ29kZSI6IkhQQ0wgTUlUVEFMIEVORVJHWSBMSU1JVEVEX1NVUEVSX0FETUlOIiwib3JnSWQiOiIxMzcyIiwiYXVkIjoiMTM3MiIsImV4cCI6MTk3NjQ5NzkyMCwiaWF0IjoxNjYxMTM3OTIwLCJqdGkiOiIzMDk4OCJ9.nkGaSTDS3ubw-MC6L9EQktqR7_48oF9X0zS982-mQuY")
				.header("Content-Type", "application/json").header("orgkey", "HMEL_PR")
				.contentType(ContentType.JSON).body(pl).when()
				.post("rest/erpintegration/prImport").then().extract().response().asString();
		lineItemNumber=0;
    	materialCodes=0;
		System.out.println(response1);
		status200=true;
    	}
    	catch(Exception e){
    		status200=false;
    		}
    	}
    }
    static boolean status200_s=false;
    public static void prUploadForSingleItem() throws InterruptedException, IOException {
    	while(status200_s==false) {
    	try {
    	String ENV=Dynamicity.getDataFromPropertiesFile("Environment", filePath_4);
    	String Environment=null;
    	if(ENV.equalsIgnoreCase("QA")) {
    		Environment="https://epsnewprodaws.mjunction.in/ERPIntegrationWeb";
		}
		else{
			Environment="https://epsstagingaws.mjunction.in/ERPIntegrationWeb";
			}
    
    	waitForObj(2000);
    	lineItemNumber=getrandomInterger( 1, 9999);
    	materialCodes=getrandomInterger( 1, 99999999);
    	RestAssured.baseURI = Environment;
    	String response1 = given().header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZUlkIjoxLCJzdWIiOiIxMzcyLiIsIm9yZ2FuaXphdGlvbk5hbWUiOiJIUENMLU1pdHRhbCBFbmVyZ3kgTGltaXRlZCIsImN1cnJlbnRMb2NhbGUiOiJlbiIsImlzcyI6IkFuaW1lc2giLCJ2ZW5kb3JJZCI6MCwidXNlclJvbGVMaXN0IjpbNl0sImJpZGRlckNvbXBhbnlOYW1lIjpudWxsLCJ1c2VyQ29kZSI6IkhQQ0wgTUlUVEFMIEVORVJHWSBMSU1JVEVEX1NVUEVSX0FETUlOIiwib3JnSWQiOiIxMzcyIiwiYXVkIjoiMTM3MiIsImV4cCI6MTk3NjQ5NzkyMCwiaWF0IjoxNjYxMTM3OTIwLCJqdGkiOiIzMDk4OCJ9.nkGaSTDS3ubw-MC6L9EQktqR7_48oF9X0zS982-mQuY")
				.header("Content-Type", "application/json").header("orgkey", "HMEL_PR")
				.contentType(ContentType.JSON).body(jp()).when()
				.post("rest/erpintegration/prImport").then().extract().response().asString();	
		System.out.println(response1);
		lineItemNumber=0;
    	materialCodes=0;
    	status200_s=true;
    	}
    	catch(Exception e) {
    		status200_s=false;
    		}
    	}
		
    }
    
    //====================For Particular CR Testing========================\\
    public static String jp_MI_1() {
		int lineItemNumber1=001;
    	int materialCodes1=1111;
		int lineItemNumber2=002;
    	int materialCodes2=2222;
		int lineItemNumber3=003;
    	int materialCodes3=3333;
    	PR_Nu=prRandomint;
		return "[\r\n" + 
				"    {\r\n" + 
				"        \"prNumber\": \""+PR_Nu+"\",\r\n" + 
				"        \"erpDataItemList\": [\r\n" + 
				"            {\r\n" + 
				"                \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
				"                \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
				"                \"creatorName\": \"Tester\",\r\n" + 
				"                \"serialNo\": "+lineItemNumber1+",\r\n" + 
				"                \"materialCode\": \""+materialCodes1+"\",\r\n" + 
				"                \"shortDesc\": \"Consultancy charges\",\r\n" + 
				"                \"longDesc\": \"NA\",\r\n" + 
				"                \"uom\": \"12\",\r\n" + 
				"                \"quantityReq\": 1,\r\n" + 
				"                \"estimatedPrice\": 2000,\r\n" + 
				"                \"purchaseOrder1\": \" \",\r\n" + 
				"                \"vendor1\": \" \",\r\n" + 
				"                \"po1BasicPrice\": 0,\r\n" + 
				"                \"purchaseOrder2\": \" \",\r\n" + 
				"                \"vendor2\": \" \",\r\n" + 
				"                \"po2BasicPrice\": 0,\r\n" + 
				"                \"purchaseOrder3\": \" \",\r\n" + 
				"                \"vendor3\": \" \",\r\n" + 
				"                \"po3BasicPrice\": 0,\r\n" + 
				"                \"hsnCode\": \"NA\",\r\n" + 
				"                \"deliveryLocation\": \"Kolkata\",\r\n" + 
				"                \"companyName\": \"PCBL\",\r\n" + 
				"                \"rfqCreatorId\": \"PCBL_ADMIN\",\r\n" + 
				"                \"prCategory\": \"term service\",\r\n" + 
				"                \"materialGroup\": \"2220003:Consultancy Charges\",\r\n" + 
				"                \"wbsCode\": \"NA\",\r\n" + 
				"                \"projectCode\": \":\",\r\n" + 
				"                \"plantDescription\": \"testing-PCBL\",\r\n" + 
				"                \"epsMaterialCode\": \"9210005781.10.2000010\",\r\n" + 
				"                \"estimatedTotalValue\": 2000,\r\n" + 
				"                \"trackingNo\": \"NA\",\r\n" + 
				"                \"strPrDate\": \"19.02.2024\",\r\n" + 
				"                \"strDeliveryDate\": \"23.02.2024\",\r\n" + 
				"                \"strOrderDate1\": \" \",\r\n" + 
				"                \"strOrderDate2\": \" \",\r\n" + 
				"                \"strOrderDate3\": \" \",\r\n" + 
				"                \"strPrCreationDate\": \"19.02.2024\",\r\n" + 
				"                \"currency\": \"INR\",\r\n" + 
				"                \"prVersionNo\": \"00000000\",\r\n" + 
				"                \"orgHierarhcy\": \"PHILLIPS CARBON BLACK LIMITED\",\r\n" + 
				"                \"parentMaterialCode\": \" \",\r\n" + 
				"                \"fileUrl\": null,\r\n" + 
				"                \"fileName\": \" \",\r\n" + 
				"                \"prDescription\": \"test\",\r\n" + 
				"                \"additionalInfo7\": \"K\",\r\n" + 
				"                \"itemCategory\": \"d\",\r\n" + 
				"                \"requestedBy\": \"PRJ\",\r\n" + 
				"                \"additionalInfo3\": \"NA\",\r\n" + 
				"                \"additionalInfo2\": \"NA\",\r\n" + 
				"                \"additionalInfo1\": \"NA\",\r\n" + 
				"                \"additionalInfo4\": \"\", \r\n" + 
				"                \"po1Currency\": \" \",\r\n" + 
				"                \"po2Currency\": \" \",\r\n" + 
				"                \"po3Currency\": \" \",\r\n" + 
				"                \"po1ItemSequence\": \" \",\r\n" + 
				"                \"po2ItemSequence\": \" \",\r\n" + 
				"                \"po3ItemSequence\": \" \",\r\n" + 
				"                \"po1DelvIncoTerms\": \" \",\r\n" + 
				"                \"po2DelvIncoTerms\": \" \",\r\n" + 
				"                \"po3DelvIncoTerms\": \" \",\r\n" + 
				"                \"po1landedPrice\": 0,\r\n" + 
				"                \"po2landedPrice\": 0,\r\n" + 
				"                \"po3landedPrice\": 0,\r\n" + 
				"                \"tagModelSerialNo\": \"NA / NA / NA / NA\", //Tag / Model / Serial No.\r\n" + 
				"                \"itemTextForMaterial\": \" \",\r\n" + 
				"                \"inspectionInformation\": \" \",\r\n" + 
				"                \"costCenter\": \" \",\r\n" + 
				"				\"purchasingGroup\": \"H09\",\r\n" + 
				"				\"purchasingOrganization\": \"H001\",\r\n" + 
				"				\"additionalInfo5\":\"test\",\r\n" + 
				"				\"additionalInfo6\":\"test\"\r\n" + 
				"\r\n" + 
				"            },\r\n" + 
				"			{\r\n" + 
				"                \"purchaseRequisitionNo\": \"9210005781\",\r\n" + 
				"                \"prOriginalNo\": \"9210005781\",\r\n" + 
				"                \"creatorName\": \"Tester\",\r\n" + 
				"                \"serialNo\": 10,\r\n" + 
				"                \"materialCode\": \"2000010\",\r\n" + 
				"                \"shortDesc\": \"Consultancy charges\",\r\n" + 
				"                \"longDesc\": \"NA\",\r\n" + 
				"                \"uom\": \"12\",\r\n" + 
				"                \"quantityReq\": 1,\r\n" + 
				"                \"estimatedPrice\": 2000,\r\n" + 
				"                \"purchaseOrder1\": \" \",\r\n" + 
				"                \"vendor1\": \" \",\r\n" + 
				"                \"po1BasicPrice\": 0,\r\n" + 
				"                \"purchaseOrder2\": \" \",\r\n" + 
				"                \"vendor2\": \" \",\r\n" + 
				"                \"po2BasicPrice\": 0,\r\n" + 
				"                \"purchaseOrder3\": \" \",\r\n" + 
				"                \"vendor3\": \" \",\r\n" + 
				"                \"po3BasicPrice\": 0,\r\n" + 
				"                \"hsnCode\": \"NA\",\r\n" + 
				"                \"deliveryLocation\": \"Kolkata\",\r\n" + 
				"                \"companyName\": \"PCBL\",\r\n" + 
				"                \"rfqCreatorId\": \"PCBL_ADMIN\",\r\n" + 
				"                \"prCategory\": \"term service\",\r\n" + 
				"                \"materialGroup\": \"2220003:Consultancy Charges\",\r\n" + 
				"                \"wbsCode\": \"NA\",\r\n" + 
				"                \"projectCode\": \":\",\r\n" + 
				"                \"plantDescription\": \"testing-PCBL\",\r\n" + 
				"                \"epsMaterialCode\": \"9210005781.10.2000010\",\r\n" + 
				"                \"estimatedTotalValue\": 2000,\r\n" + 
				"                \"trackingNo\": \"NA\",\r\n" + 
				"                \"strPrDate\": \"19.02.2024\",\r\n" + 
				"                \"strDeliveryDate\": \"23.02.2024\",\r\n" + 
				"                \"strOrderDate1\": \" \",\r\n" + 
				"                \"strOrderDate2\": \" \",\r\n" + 
				"                \"strOrderDate3\": \" \",\r\n" + 
				"                \"strPrCreationDate\": \"19.02.2024\",\r\n" + 
				"                \"currency\": \"INR\",\r\n" + 
				"                \"prVersionNo\": \"00000000\",\r\n" + 
				"                \"orgHierarhcy\": \"PHILLIPS CARBON BLACK LIMITED\",\r\n" + 
				"                \"parentMaterialCode\": \" \",\r\n" + 
				"                \"fileUrl\": null,\r\n" + 
				"                \"fileName\": \" \",\r\n" + 
				"                \"prDescription\": \"test\",\r\n" + 
				"                \"additionalInfo7\": \"K\",\r\n" + 
				"                \"itemCategory\": \"d\",\r\n" + 
				"                \"requestedBy\": \"PRJ\",\r\n" + 
				"                \"additionalInfo3\": \"NA\",\r\n" + 
				"                \"additionalInfo2\": \"NA\",\r\n" + 
				"                \"additionalInfo1\": \"NA\",\r\n" + 
				"                \"additionalInfo4\": \"\", \r\n" + 
				"                \"po1Currency\": \" \",\r\n" + 
				"                \"po2Currency\": \" \",\r\n" + 
				"                \"po3Currency\": \" \",\r\n" + 
				"                \"po1ItemSequence\": \" \",\r\n" + 
				"                \"po2ItemSequence\": \" \",\r\n" + 
				"                \"po3ItemSequence\": \" \",\r\n" + 
				"                \"po1DelvIncoTerms\": \" \",\r\n" + 
				"                \"po2DelvIncoTerms\": \" \",\r\n" + 
				"                \"po3DelvIncoTerms\": \" \",\r\n" + 
				"                \"po1landedPrice\": 0,\r\n" + 
				"                \"po2landedPrice\": 0,\r\n" + 
				"                \"po3landedPrice\": 0,\r\n" + 
				"                \"tagModelSerialNo\": \"NA / NA / NA / NA\", //Tag / Model / Serial No.\r\n" + 
				"                \"itemTextForMaterial\": \" \",\r\n" + 
				"                \"inspectionInformation\": \" \",\r\n" + 
				"                \"costCenter\": \" \",\r\n" + 
				"				\"purchasingGroup\": \"H09\",\r\n" + 
				"				\"purchasingOrganization\": \"H001\",\r\n" + 
				"				\"additionalInfo5\":\"test\",\r\n" + 
				"				\"additionalInfo6\":\"test\"\r\n" + 
				"\r\n" + 
				"            },\r\n" + 
				"			{\r\n" + 
				"                \"purchaseRequisitionNo\": \"9210005781\",\r\n" + 
				"                \"prOriginalNo\": \"9210005781\",\r\n" + 
				"                \"creatorName\": \"Tester\",\r\n" + 
				"                \"serialNo\": 10,\r\n" + 
				"                \"materialCode\": \"2000010\",\r\n" + 
				"                \"shortDesc\": \"Consultancy charges\",\r\n" + 
				"                \"longDesc\": \"NA\",\r\n" + 
				"                \"uom\": \"12\",\r\n" + 
				"                \"quantityReq\": 1,\r\n" + 
				"                \"estimatedPrice\": 2000,\r\n" + 
				"                \"purchaseOrder1\": \" \",\r\n" + 
				"                \"vendor1\": \" \",\r\n" + 
				"                \"po1BasicPrice\": 0,\r\n" + 
				"                \"purchaseOrder2\": \" \",\r\n" + 
				"                \"vendor2\": \" \",\r\n" + 
				"                \"po2BasicPrice\": 0,\r\n" + 
				"                \"purchaseOrder3\": \" \",\r\n" + 
				"                \"vendor3\": \" \",\r\n" + 
				"                \"po3BasicPrice\": 0,\r\n" + 
				"                \"hsnCode\": \"NA\",\r\n" + 
				"                \"deliveryLocation\": \"Kolkata\",\r\n" + 
				"                \"companyName\": \"PCBL\",\r\n" + 
				"                \"rfqCreatorId\": \"PCBL_ADMIN\",\r\n" + 
				"                \"prCategory\": \"term service\",\r\n" + 
				"                \"materialGroup\": \"2220003:Consultancy Charges\",\r\n" + 
				"                \"wbsCode\": \"NA\",\r\n" + 
				"                \"projectCode\": \":\",\r\n" + 
				"                \"plantDescription\": \"testing-PCBL\",\r\n" + 
				"                \"epsMaterialCode\": \"9210005781.10.2000010\",\r\n" + 
				"                \"estimatedTotalValue\": 2000,\r\n" + 
				"                \"trackingNo\": \"NA\",\r\n" + 
				"                \"strPrDate\": \"19.02.2024\",\r\n" + 
				"                \"strDeliveryDate\": \"23.02.2024\",\r\n" + 
				"                \"strOrderDate1\": \" \",\r\n" + 
				"                \"strOrderDate2\": \" \",\r\n" + 
				"                \"strOrderDate3\": \" \",\r\n" + 
				"                \"strPrCreationDate\": \"19.02.2024\",\r\n" + 
				"                \"currency\": \"INR\",\r\n" + 
				"                \"prVersionNo\": \"00000000\",\r\n" + 
				"                \"orgHierarhcy\": \"PHILLIPS CARBON BLACK LIMITED\",\r\n" + 
				"                \"parentMaterialCode\": \" \",\r\n" + 
				"                \"fileUrl\": null,\r\n" + 
				"                \"fileName\": \" \",\r\n" + 
				"                \"prDescription\": \"test\",\r\n" + 
				"                \"additionalInfo7\": \"K\",\r\n" + 
				"                \"itemCategory\": \"d\",\r\n" + 
				"                \"requestedBy\": \"PRJ\",\r\n" + 
				"                \"additionalInfo3\": \"NA\",\r\n" + 
				"                \"additionalInfo2\": \"NA\",\r\n" + 
				"                \"additionalInfo1\": \"NA\",\r\n" + 
				"                \"additionalInfo4\": \"\", \r\n" + 
				"                \"po1Currency\": \" \",\r\n" + 
				"                \"po2Currency\": \" \",\r\n" + 
				"                \"po3Currency\": \" \",\r\n" + 
				"                \"po1ItemSequence\": \" \",\r\n" + 
				"                \"po2ItemSequence\": \" \",\r\n" + 
				"                \"po3ItemSequence\": \" \",\r\n" + 
				"                \"po1DelvIncoTerms\": \" \",\r\n" + 
				"                \"po2DelvIncoTerms\": \" \",\r\n" + 
				"                \"po3DelvIncoTerms\": \" \",\r\n" + 
				"                \"po1landedPrice\": 0,\r\n" + 
				"                \"po2landedPrice\": 0,\r\n" + 
				"                \"po3landedPrice\": 0,\r\n" + 
				"                \"tagModelSerialNo\": \"NA / NA / NA / NA\", //Tag / Model / Serial No.\r\n" + 
				"                \"itemTextForMaterial\": \" \",\r\n" + 
				"                \"inspectionInformation\": \" \",\r\n" + 
				"                \"costCenter\": \" \",\r\n" + 
				"				\"purchasingGroup\": \"H09\",\r\n" + 
				"				\"purchasingOrganization\": \"H001\",\r\n" + 
				"				\"additionalInfo5\":\"test\",\r\n" + 
				"				\"additionalInfo6\":\"test\"\r\n" + 
				"\r\n" + 
				"            }\r\n" + 
				"			\r\n" + 
				"        ]\r\n" + 
				"	}\r\n" + 
				"]";
	}
	public static String jp_MI_2() {
		int lineItemNumber1=001;
    	int materialCodes1=1111;
		int lineItemNumber4=004;
    	int materialCodes4=4444;
		int lineItemNumber5=005;
    	int materialCodes5=5555;
		return "[\r\n" + 
		"  {\r\n" + 
		"    \"prNumber\": \""+PR_Nu+"\",\r\n" + 
		"    \"erpDataItemList\": [\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber1+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes1+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber1+"."+materialCodes1+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber4+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes4+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber4+"."+materialCodes4+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber5+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes5+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber5+"."+materialCodes5+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      }\r\n" + 
		"	  ]\r\n" + 
		"  }\r\n" + 
		"]";
	}
	public static String jp_MI_3() {
		int lineItemNumber1=001;
    	int materialCodes1=1111;
		int lineItemNumber6=006;
    	int materialCodes6=6666;
		int lineItemNumber7=007;
    	int materialCodes7=7777;
		return "[\r\n" + 
		"  {\r\n" + 
		"    \"prNumber\": \""+PR_Nu+"\",\r\n" + 
		"    \"erpDataItemList\": [\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber1+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes1+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber1+"."+materialCodes1+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber6+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes6+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber6+"."+materialCodes6+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber7+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes7+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber7+"."+materialCodes7+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      }\r\n" + 
		"	  ]\r\n" + 
		"  }\r\n" + 
		"]";
	}
	public static String jp_MI_4() {
		int lineItemNumber1=001;
    	int materialCodes1=1111;
		String lineItemNumber8="008";
    	int materialCodes8=8888;
		String lineItemNumber9="009";
    	int materialCodes9=9999;
		return "[\r\n" + 
		"  {\r\n" + 
		"    \"prNumber\": \""+PR_Nu+"\",\r\n" + 
		"    \"erpDataItemList\": [\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber1+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes1+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber1+"."+materialCodes1+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber8+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes8+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber8+"."+materialCodes8+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      },\r\n" + 
		"	  {\r\n" + 
		"        \"purchaseRequisitionNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prOriginalNo\": \""+PR_Nu+"\",\r\n" + 
		"        \"prVersionNo\": \"00000000\",\r\n" + 
		"        \"prDescription\": \"Material(EIL)\",\r\n" + 
		"        \"prCategory\": \"ZMAP\",\r\n" + 
		"        \"additionalInfo7\": \"A\",\r\n" + 
		"        \"additionalInfo6\": \"10001970:Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"itemCategory\": \"d\",\r\n" + 
		"        \"strPrDate\": \"06.09.2022\",\r\n" + 
		"        \"strPrCreationDate\": \"06.09.2022\",\r\n" + 
		"        \"creatorName\": \"Sourav Arka Amrita Ipshita Priyanka Utpal\",\r\n" + 
		"        \"requestedBy\": \"CIV-CDU\",\r\n" + 
		"        \"trackingNo\": \"NA\",\r\n" + 
		"        \"rfqCreatorId\": \""+uName+"\",\r\n" + 
		"        \"orgHierarhcy\": \"HMEL\",\r\n" + 
		"        \"additionalInfo5\": \" \",\r\n" + 
		"        \"materialGroup\": \"0068:WR\",\r\n" + 
		"        \"additionalInfo4\": \"9100\",\r\n" + 
		"        \"companyName\": \"HPCL-Mittal Energy Ltd.\",\r\n" + 
		"        \"plantDescription\": \"9112\",\r\n" + 
		"        \"projectCode\": \":\",\r\n" + 
		"        \"wbsCode\": \"00000000\",\r\n" + 
		"        \"costCenter\": \" \",\r\n" + 
		"        \"additionalInfo3\": \"NA\",\r\n" + 
		"        \"additionalInfo2\": \"NA\",\r\n" + 
		"        \"additionalInfo1\": \"NA\",\r\n" + 
		"        \"parentMaterialCode\": \" \",\r\n" + 
		"        \"serialNo\": \""+lineItemNumber9+"\",\r\n" + 
		"        \"materialCode\": \""+materialCodes9+"\",\r\n" + 
		"        \"epsMaterialCode\": \""+PR_Nu+"."+lineItemNumber9+"."+materialCodes9+"\",\r\n" + 
		"        \"hsnCode\": \"85446090\",\r\n" + 
		"        \"shortDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"longDesc\": \"CBL ELE ARM 1.1KV CU SCRND 12C 2.5MM2\",\r\n" + 
		"        \"uom\": \"M\",\r\n" + 
		"        \"quantityReq\": 1,\r\n" + 
		"        \"currency\": \"INR\",\r\n" + 
		"        \"estimatedPrice\": 208,\r\n" + 
		"        \"estimatedTotalValue\": 832,\r\n" + 
		"        \"strDeliveryDate\": \"31.10.2022\",\r\n" + 
		"        \"deliveryLocation\": \"Bathinda\",\r\n" + 
		"        \"purchaseOrder1\": \"7480000022\",\r\n" + 
		"        \"strOrderDate1\": \"21.06.2022\",\r\n" + 
		"        \"vendor1\": \"1900004355:Dorf Ketal Chemical\",\r\n" + 
		"        \"po1Currency\": \"INR\",\r\n" + 
		"        \"po1ItemSequence\": \"00140\",\r\n" + 
		"        \"po1BasicPrice\": 100,\r\n" + 
		"        \"po1DelvIncoTerms\": \"EXW\",\r\n" + 
		"        \"purchaseOrder2\": \"5400013055\",\r\n" + 
		"        \"strOrderDate2\": \"08.03.2017\",\r\n" + 
		"        \"vendor2\": \"3300000025:KEC International L\",\r\n" + 
		"        \"po2Currency\": \"INR\",\r\n" + 
		"        \"po2ItemSequence\": \"00460\",\r\n" + 
		"        \"po2BasicPrice\": 235.1,\r\n" + 
		"        \"po2DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"purchaseOrder3\": \"5400002739\",\r\n" + 
		"        \"strOrderDate3\": \"24.11.2016\",\r\n" + 
		"        \"po3Currency\": \"INR\",\r\n" + 
		"        \"po3ItemSequence\": \"00180\",\r\n" + 
		"        \"vendor3\": \"2100000054:KEI Industries Ltd\",\r\n" + 
		"        \"po3BasicPrice\": \"204.37\",\r\n" + 
		"        \"po3DelvIncoTerms\": \"FOT\",\r\n" + 
		"        \"fileName\": \" \",\r\n" + 
		"        \"fileUrl\": \"---\"\r\n" + 
		"      }\r\n" + 
		"	  ]\r\n" + 
		"  }\r\n" + 
		"]";
	}
    //======================================================================\\
    
    public static void main(String[] args) throws InterruptedException, IOException {
    	//provideTokenObject();
    	//Login();
    	prUpload();
  
	} 	
}