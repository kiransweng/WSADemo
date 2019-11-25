package com.dxc.restdemo.stepdefinitions;

import static org.hamcrest.MatcherAssert.assertThat;

import com.dxc.restdemo.entity.GeoPlugin;
import com.dxc.restdemo.repository.GeoPluginRepository;
import com.dxc.restdemo.services.DemoServices;
import com.dxc.restdemo.utils.GlobalConstants;
import com.dxc.restdemo.utils.ScenarioContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.matchers.CompareMatcher;

public class RestServicesTestSteps {

    private static final Logger logger = LogManager.getLogger(RestServicesTestSteps.class);

    @Autowired ScenarioContext scenarioContext;
    @Autowired DemoServices demoServices;
    @Autowired GeoPluginRepository geoRepo;


    @Given("^Database has the required data$")
    public void getRecordsFromDb() throws Throwable {

        List<GeoPlugin> geop = geoRepo.findAll();
        scenarioContext.setLst_geoPluginDataBase(geoRepo.findAll());
        System.out.println("\n\n");
        System.out.println("************Below is the content of the Database table:************\r\n" + geop);

    }

    @When("^Hit the GeoPlugin Service to get response in XML format$")
    public void getGeoPluginDetails() throws Throwable {
        Response response = demoServices.getWeatherResponse();
        System.out.println("************Displaying API response:************ \n" + response.getBody().asString());

        JAXBContext jaxbContext = JAXBContext.newInstance(GeoPlugin.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        GeoPlugin geo = (GeoPlugin) unmarshaller.unmarshal(new StringReader(response.getBody().asString()));
        scenarioContext.setGeoPluginApi(geo);

        System.out.println("************API Response Stored in Java Object:************ \r\n" + geo);
        System.out.println("\n\n");
        geoRepo.save(geo);

    }

    @Then("^Compare the API response with Database records$")
    public void compareDetails() throws Throwable {
        System.out.println("************Comparing the Database Record with API Response:************ \r\n");

            boolean matched = true;
            if(!scenarioContext.getGeoPluginApi().getGeoplugin_request().equalsIgnoreCase(
                    scenarioContext.getLst_geoPluginDataBase().get(0).getGeoplugin_request())){
                System.out.println("The field 'Geoplugin_request' does not match: " + scenarioContext.getGeoPluginApi().getGeoplugin_request());
                matched=false;
            }
            Assert.assertTrue(matched);

    }

    @Then("^Verify that the given elements have values in API response$")
    public void verifyElementsInResponse() throws Throwable {
        Response response = demoServices.getWeatherResponse();
        System.out.println("************Displaying API response:************ \n" + response.getBody().asString());

        JAXBContext jaxbContext = JAXBContext.newInstance(GeoPlugin.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        GeoPlugin geo1 = (GeoPlugin) unmarshaller.unmarshal(new StringReader(response.getBody().asString()));

        Assert.assertEquals(geo1.getGeoplugin_request(),GlobalConstants.REQUEST_IP);
        Assert.assertEquals(geo1.getGeoplugin_countryName(),GlobalConstants.COUNTRY_NAME);

    }

    @Then("^Compare the API response with Database records in XML formats$")
    public void compareXMLFiles() throws Throwable {

        assertThat(scenarioContext.getResponse().getBody().asString(),
                CompareMatcher.isIdenticalTo(scenarioContext.getResponse().getBody().asString()));


        Diff d = DiffBuilder.compare(scenarioContext.getResponse().getBody().asString()).
                withTest(scenarioContext.getResponse().getBody().asString()).build();
    }

    @Then("^Compare the API response with Database records in XML formats - Negative$")
    public void compareXMLFilesNegative() throws Throwable {

        JAXBContext jaxbContext = JAXBContext.newInstance(GeoPlugin.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(scenarioContext.getLst_geoPluginDataBase().get(0),sw);
        String dbXml = sw.toString();


        Diff d = DiffBuilder.compare(dbXml).
                withTest(scenarioContext.getResponse().getBody().asString()).build();

        System.out.println(d.toString());
        System.out.println(d.getDifferences());

        assertThat(dbXml,
                CompareMatcher.isIdenticalTo(scenarioContext.getResponse().getBody().asString()));

    }

}