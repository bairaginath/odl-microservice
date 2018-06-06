package com.aricent.northbound;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NeController {
	
	//@Autowired
	//private Environment env;
	String southboundUrl="http://10.204.249.67:8181";
	
	
	@PostMapping("/registerNE")
	Message registerNE(@RequestBody Node node){
		
		RestTemplate restTemplate = new RestTemplate();
    	String url
    	  = southboundUrl+"/restconf/config/opendaylight-inventory:nodes/node/controller-config/yang-ext:mount/config:modules/module/odl-sal-netconf-connector-cfg:sal-netconf-connector/"+node.getName();
    	String plainCreds = "admin:admin";
    	
    	String base64Creds = "YWRtaW46YWRtaW4=";

    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Authorization", "Basic " + base64Creds);
    	headers.add("Content-Type","application/xml");
    	HttpEntity<String> request = new HttpEntity<String>(headers);
    	
    	String data="<?xml version=\"1.0\" encoding=\"UTF-8\"?><module xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:config\">"
    			+ "<type xmlns:prefix=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">prefix:sal-netconf-connector</type>"
    			+ "<name>"+node.getName()+"</name><address xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"+node.getHostname()+"</address>"
    			+ "<port xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"+node.getPort()+"</port>"
    			+ "<username xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">root</username>"
    			+ "<password xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">root</password>"
    			+ "<tcp-only xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">false</tcp-only>"
    			+ "<event-executor xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"
    			   + "<type xmlns:prefix=\"urn:opendaylight:params:xml:ns:yang:controller:netty\">prefix:netty-event-executor</type>"
    			   + "<name>global-event-executor</name></event-executor><binding-registry xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"
    			   + "<type xmlns:prefix=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:binding\">prefix:binding-broker-osgi-registry</type>"
    			   + "<name>binding-osgi-broker</name></binding-registry><dom-registry xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"
    			   + "<type xmlns:prefix=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:dom\">prefix:dom-broker-osgi-registry</type>"
    			   + "<name>dom-broker</name></dom-registry><client-dispatcher xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"
    			   + "<type xmlns:prefix=\"urn:opendaylight:params:xml:ns:yang:controller:config:netconf\">prefix:netconf-client-dispatcher</type>"
    			   + "<name>global-netconf-dispatcher</name></client-dispatcher><processing-executor xmlns=\"urn:opendaylight:params:xml:ns:yang:controller:md:sal:connector:netconf\">"
    			   + "<type xmlns:prefix=\"urn:opendaylight:params:xml:ns:yang:controller:threadpool\">prefix:threadpool</type>"
    			   + "<name>global-netconf-processing-executor</name></processing-executor></module>";
    	
    	
    	//request.setBody(data);
    	HttpEntity<String> entity = new HttpEntity<String>(data, headers);
    	 //restTemplate.put(url,entity);
    	ResponseEntity<Void> response=restTemplate.exchange(url, HttpMethod.PUT,entity, Void.class);
    	String responseCode=response.getStatusCode().toString();
    	System.out.println(responseCode);
    	Message message=new Message();
    	if("200".equalsIgnoreCase(responseCode))
    		return message.setResult("Success");
    	return message.setResult("Failed");
		
		
	}
	
	
	
	@GetMapping("/getInterfaceConfiguration")
	String getInterfaceConfiguration(@PathParam("nodeName") String nodeName, @PathParam("interfaceId") String interfaceId) {

		RestTemplate restTemplate = new RestTemplate();
//		String url = southboundUrl
//				+ "/restconf/config/network-topology:network-topology/topology/topology-netconf/node/" + nodeName
//				+ "/yang-ext:mount/";
		
		String url = southboundUrl
				+ "/restconf/config/network-topology:network-topology/topology/topology-netconf/node/"
				+ nodeName
				+ "/yang-ext:mount/router:interfaces/"
				+ interfaceId;
		
		System.out.println("URL: " + url);

		String plainCreds = "admin:admin";

		String base64Creds = "YWRtaW46YWRtaW4=";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
		String res = response.getBody();
		System.out.println("Response for getConfiguration: " + res);
		return res;
	}
	
	@PutMapping("/updateInterfaceConfiguration")
	Message updateInterfaceConfiguration(@RequestBody Interfaces interfaces, @PathParam("nodeName") String nodeName) {

		RestTemplate restTemplate = new RestTemplate();
		String url = southboundUrl
				+ "/restconf/config/network-topology:network-topology/topology/topology-netconf/node/"
				+ nodeName
				+ "/yang-ext:mount/router:interfaces/"
				+ interfaces.getId();

		

		String data = "<interfaces xmlns=\"urn:sdnhub:odl:tutorial:router\">" + "<id>" + interfaces.getId() + "</id>"
				+ "<ip-address>" + interfaces.getIpAddress() + "</ip-address>" + "</interfaces>";

		System.out.println("URL: " + url + "\nData: " + data);
		
		String plainCreds = "admin:admin";

		String base64Creds = "YWRtaW46YWRtaW4=";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		headers.add("Content-Type", "application/xml");

		HttpEntity<String> entity = new HttpEntity<String>(data, headers);
		// restTemplate.put(url,entity);
		ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.PUT, entity, Void.class);
		String responseCode = response.getStatusCode().toString();
		System.out.println(responseCode);
		Message message=new Message();
		if ("200".equalsIgnoreCase(responseCode))
			return message.setResult("Success");
		return message.setResult("Failed");
	}


	
	

}
