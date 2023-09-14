package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UserTest {
	
	Faker faker;
	User userPayload;
	public static Logger logger;
	@BeforeClass
	public void setupData() throws InterruptedException
	{
		logger=logger.getLogger("UserTest");
		PropertyConfigurator.configure("log4j.properties");
		faker=new Faker();
		userPayload=new User();
		
		userPayload.setId(faker.idNumber().hashCode());Thread.sleep(2000);
		userPayload.setUsername(faker.name().username());Thread.sleep(2000);
		userPayload.setFirstname(faker.name().firstName());Thread.sleep(2000);
		userPayload.setLastname(faker.name().lastName());Thread.sleep(2000);
		userPayload.setEmail(faker.internet().emailAddress());Thread.sleep(2000);
		userPayload.setPassword(faker.internet().password(5, 10));Thread.sleep(2000);
		userPayload.setPhone(faker.phoneNumber().cellPhone());Thread.sleep(2000);
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("************Creating User***********");
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGETUserByName()
	{		logger.info("************Getting User Details***********");

		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void testPUTUserByName() throws InterruptedException
	{
		logger.info("************Update User Details***********");
//		Update data using payload
		userPayload.setFirstname(faker.name().firstName());Thread.sleep(2000);
		userPayload.setLastname(faker.name().lastName());Thread.sleep(2000);
		userPayload.setEmail(faker.internet().emailAddress());Thread.sleep(2000);
		
		Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Checking data after updation
		Response responseAfterUpdate=UserEndPoints.readUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

	}
	
	@Test(priority=4)
	void testDeleteUserByName()
	{
		logger.info("************Delete User ***********");
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
