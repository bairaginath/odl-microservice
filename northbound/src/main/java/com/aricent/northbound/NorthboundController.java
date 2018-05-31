package com.aricent.northbound;

import java.util.ArrayList;
//import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

/**
* @author bairagi 30-May-2018 2:33:53 AM NorthboundController.java
*
*/

//@RequestMapping(name="/v1")
@RestController 
public class NorthboundController {
	
	             public NE getNE(String name,String status,String host,int port,List<String> capacity){
	            	     NE ne=new NE();
                     ne.setApiVersion("1.0.0");
                     ne.setKind("Node");
                     ne.setHost(host);
                     ne.setPort(port);
                     ne.setStatus(status);
                     Metadata metadata=new Metadata();
                     metadata.setCreationTimestamp(new Date().toString());
                     metadata.setName(name);
                     metadata.setResourceVersion("resourceVersion");
                     metadata.setSelfLink("/api/v1beta3/nodes/"+name);
                     metadata.setUid(name);
                     ne.setMetadata(metadata);
                     ne.setCapacity(capacity);
                     return ne;
                     
	            	 
	             }
                
                
                
                @GetMapping(name="/topology")
                Object getTopology(){
                	
                	RestTemplate restTemplate = new RestTemplate();
                	String url
                	  = "http://localhost:8181/restconf/operational/network-topology:network-topology/topology/topology-netconf/";
                	String plainCreds = "admin:admin";
                	
                	String base64Creds = "YWRtaW46YWRtaW4=";

                	HttpHeaders headers = new HttpHeaders();
                	headers.add("Authorization", "Basic " + base64Creds);
                	HttpEntity<String> request = new HttpEntity<String>(headers);
                	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
                	
                	DocumentContext document=JsonPath.parse(response.getBody());
                	List<Map<String,Object>> nodes= document.read("$.topology.[0].node");
                	Map<String,Object> output=new HashMap<>();
                Map<String,NE> items=new HashMap<>();
                	for(int i=0;i<nodes.size();i++){
                	 System.out.println("========="+nodes.get(i).get("node-id"));
                	 Map<String,Object> node=nodes.get(i);
                	 String nodeId=(String)node.get("node-id");
                	 String host=(String)node.get("netconf-node-topology:host");
                	 int port=(int)node.get("netconf-node-topology:port");
                	 String status=(String)node.get("netconf-node-topology:connection-status");
                	 List<String> capacity=null;
                	 if(node.get("netconf-node-topology:available-capabilities")!=null)
                	  {
                		 Map<String,List<String>> oo=(Map<String,List<String>>)node.get("netconf-node-topology:available-capabilities");
                	     capacity=oo.get("available-capability");
                		 System.out.println(capacity);
                	  }
                	 NE ne=getNE(nodeId,status,host,port,capacity);
                	 items.put(ne.getMetadata().getName(),ne);  
                		 
                	 
                	}   
                     List<Link> relations =new ArrayList<>();
                     relations.add(new Link().setSource("router1").setTarget("router2"));
                     output.put("items",items);
                     output.put("relations", relations);
                     return output;
                                
                                
                                
                                //return "{\r\n  \"items\": {\r\n    \"router1\": {\r\n      \"apiVersion\": \"v1beta3\",\r\n      \"kind\": \"Node\",\r\n      \"metadata\": {\r\n        \"creationTimestamp\": \"2015-06-01T18:51:33Z\",\r\n        \"name\": \"router1\",\r\n        \"resourceVersion\": \"10065\",\r\n        \"selfLink\": \"/api/v1beta3/nodes/node-1.rha\",\r\n        \"uid\": \"router1\"\r\n      },\r\n      \"spec\": {\r\n        \"externalID\": \"router1\"\r\n      },\r\n      \"status\": {\r\n        \"capacity\": {\r\n          \"cpu\": \"1\",\r\n          \"memory\": \"4047776Ki\"\r\n        },\r\n        \"conditions\": [{\r\n          \"lastHeartbeatTime\": \"2015-06-02T15:41:47Z\",\r\n          \"lastTransitionTime\": \"2015-06-01T18:52:24Z\",\r\n          \"reason\": \"kubelet is posting ready status\",\r\n          \"status\": \"True\",\r\n          \"type\": \"Ready\"\r\n        }],\r\n        \"nodeInfo\": {\r\n          \"bootID\": \"d51f8e13-399c-4245-9e88-3091c4d1f6f2\",\r\n          \"containerRuntimeVersion\": \"docker://1.6.0\",\r\n          \"kernelVersion\": \"4.0.4-301.fc22.x86_64\",\r\n          \"kubeProxyVersion\": \"v0.16.2-659-g63182318c5876b\",\r\n          \"kubeletVersion\": \"v0.16.2-659-g63182318c5876b\",\r\n          \"machineID\": \"0fed1fe218d1a8449292cce385ada4e6\",\r\n          \"osImage\": \"Red Hat Enterprise Linux Atomic Host 7.1\",\r\n          \"systemUUID\": \"0FED1FE2-18D1-A844-9292-CCE385ADA4E6\"\r\n        }\r\n      }\r\n    },\r\n    \"router2\": {\r\n      \"apiVersion\": \"v1beta3\",\r\n      \"kind\": \"Service\",\r\n      \"metadata\": {\r\n        \"creationTimestamp\": \"2015-06-01T18:51:33Z\",\r\n        \"labels\": {\r\n          \"component\": \"apiserver\",\r\n          \"provider\": \"kubernetes\"\r\n        },\r\n        \"name\": \"router2\",\r\n        \"namespace\": \"default\",\r\n        \"resourceVersion\": \"5\",\r\n        \"selfLink\": \"/api/v1beta3/namespaces/default/services/kubernetes\",\r\n        \"uid\": \"router2\"\r\n      },\r\n      \"spec\": {\r\n        \"portalIP\": \"10.254.0.2\",\r\n        \"ports\": [{\r\n          \"name\": \"\",\r\n          \"port\": 443,\r\n          \"protocol\": \"TCP\",\r\n          \"targetPort\": 443\r\n        }],\r\n        \"selector\": null,\r\n        \"sessionAffinity\": \"None\"\r\n      },\r\n      \"status\": {}\r\n    }\r\n  },\r\n  \"relations\": [ {\r\n    \"source\": \"router1\",\r\n    \"target\": \"router2\"\r\n  }]\r\n}";
                }

}

