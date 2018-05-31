package com.aricent.northbound;

import java.util.List;
import java.util.Map;

public class NE {
                
                private String apiVersion;
                private String kind;
                private Metadata metadata;
                private Map<String,String> spec;
                private List<String> capacity;
                /**
				 * @return the capacity
				 */
				public List<String> getCapacity() {
					return capacity;
				}
				/**
				 * @param capacity the capacity to set
				 */
				public void setCapacity(List<String> capacity) {
					this.capacity = capacity;
				}
				private Map<String,Object> nodeInfo;
                private String status;
                private String host;
                private int port;
                /**
				 * @return the host
				 */
				public String getHost() {
					return host;
				}
				/**
				 * @param host the host to set
				 */
				public void setHost(String host) {
					this.host = host;
				}
				/**
				 * @return the port
				 */
				public int getPort() {
					return port;
				}
				/**
				 * @param port the port to set
				 */
				public void setPort(int port) {
					this.port = port;
				}
				public String getApiVersion() {
                                return apiVersion;
                }
                public void setApiVersion(String apiVersion) {
                                this.apiVersion = apiVersion;
                }
                public String getKind() {
                                return kind;
                }
                public void setKind(String kind) {
                                this.kind = kind;
                }
                public Metadata getMetadata() {
                                return metadata;
                }
                public void setMetadata(Metadata metadata) {
                                this.metadata = metadata;
                }
                public Map<String, String> getSpec() {
                                return spec;
                }
                public void setSpec(Map<String, String> spec) {
                                this.spec = spec;
                }
                
                public Map<String, Object> getNodeInfo() {
                                return nodeInfo;
                }
                public void setNodeInfo(Map<String, Object> nodeInfo) {
                                this.nodeInfo = nodeInfo;
                }
                public String getStatus() {
                                return status;
                }
                public void setStatus(String status) {
                                this.status = status;
                }
                
                
                
                
                

}
