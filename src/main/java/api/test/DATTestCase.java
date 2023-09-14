package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DATTestCase {
	
	
	@Test(priority=1,dataProvider="Data", dataProviderClass=DataProviders.class)
	void multiplePOSTRequest(String UserID,String UName, String FName, String LName, String UserEmail, String Pass, String Ph)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setUsername(UName);
		userpayload.setFirstname(FName);
		userpayload.setLastname(LName);
		userpayload.setEmail(UserEmail);
		userpayload.setPassword(Pass);
		userpayload.setPhone(Ph);
		
		Response response=UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2,dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByName(String userName)
	{
		Response res=UserEndPoints.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
