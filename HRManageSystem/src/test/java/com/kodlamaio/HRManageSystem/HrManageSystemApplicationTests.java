package com.kodlamaio.HRManageSystem;

import com.kodlamaio.HRManageSystem.dataAccess.abstracts.PersonalDao;
import com.kodlamaio.HRManageSystem.entities.concreates.Personal;
import com.kodlamaio.HRManageSystem.entities.concreates.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static org.rnorth.visibleassertions.VisibleAssertions.assertEquals;
import static org.rnorth.visibleassertions.VisibleAssertions.info;

@SpringBootTest
class HrManageSystemApplicationTests extends AbstractIntegrationTest{

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	PersonalDao personalDao;
	/*
        @Test
	public void simpleTest() {
		System.out.println("Start of simpleTest ************");
		String fooResource = "http://localhost:8080/api/personals/";

		info("putting 'bar' to " + fooResource);
		restTemplate.put(fooResource, "bar");
		System.out.println("returned : "+ restTemplate.getForObject(fooResource, String.class));
		assertEquals("value is set", "bar", restTemplate.getForObject(fooResource, String.class));
	}*/

	@Test
	public void simpleJPATest() {System.out.println("Start of simpleJPATest ************");
		//City city = new City(0,"Demo City 1",new ArrayList<>());

		//cityDao.save(city);

		Personal result = restTemplate.getForObject("http://localhost:8080/api/personals/" + 1/*city.getCityId()*/, Personal.class);
		System.out.println("returned : "+result.getEmail());
		assertEquals("value is set", "example2@hotmail.com", result.getEmail());
	}

	@Test
	void contextLoads() {
	}

}
