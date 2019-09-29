package com.brightstar.http.server.controller.get.xml;

import lombok.Data;

@Data
public class XmlResponse {

		String name;

		public XmlResponse(String name) {
			super();
			this.name = name;
		}


}
