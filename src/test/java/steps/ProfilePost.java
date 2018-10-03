package steps;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.ServiceRunner;

public class ProfilePost {
	@When("^user hits Profile GET request with \"([^\"]*)\"$")
	public void user_hits_Profile_GET_request_with(String uri) throws Throwable {
		ServiceRunner.runGetRquest(uri);
	}

	@Then("^user should get \"([^\"]*)\" status code$")
	public void user_should_get_status_code(String statusCode) throws Throwable {
		int statusCodeInt = Integer.valueOf(statusCode);

		Assert.assertEquals(statusCodeInt, ServiceRunner.getStatusCode());
	}
	
	@Then("^user verifies mandatory attributes for profile$")
	public void user_verifies_mandatory_attributes_for_profile() throws Throwable {
		String name = ServiceRunner.getResponse().getName();
		String location = ServiceRunner.getResponse().getLocation();
		String address = ServiceRunner.getResponse().getAddress();

		Assert.assertTrue("Mandatory attribute 'name' failed " + name != null);
		Assert.assertTrue("Mandatory attribute 'location' failed " + location != null);
		Assert.assertTrue("Mandatory attribute 'address' failed " + address != null);

	}

}
