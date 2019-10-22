package com.brightstar.http.server.controller.get.xml;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName ="XmlResponse")
public class XmlResponse {

		
		String name;
		
		@JacksonXmlElementWrapper(localName ="certnoList")
		@JacksonXmlProperty(localName ="order")
		List<String> certs;

		public XmlResponse(String name) {
			super();
			this.name = name;
		}
		
		@JacksonXmlProperty()
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getCerts() {
			return certs;
		}

		public void setCerts(List<String> certs) {
			this.certs = certs;
		}
		
		public void addCert(String cert) {
			if(this.certs==null) {
				this.certs = new ArrayList<String>();
			}
			certs.add(cert);
		}

		@Override
		public String toString() {
			return "XmlResponse [name=" + name + ", certs=" + certs + "]";
		}
		


}
