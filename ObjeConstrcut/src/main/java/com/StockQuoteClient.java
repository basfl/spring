package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import gen.GetCountryRequest;
import gen.GetCountryResponse;

public class StockQuoteClient  extends WebServiceGatewaySupport {
	
	 
		public GetCountryResponse stockQuote(String company) {
		 GetCountryRequest re=new GetCountryRequest();
		 re.setName("Spain");
		GetCountryResponse resp = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
					re,
					new SoapActionCallback(
							"http://localhost:9999/ws/countries.wsdl"));
			return resp;
	 
//			GetQuote quote = new GetQuote();
//			quote.setSymbol(company);
//	 
//			GetQuoteResponse quoteResp = (GetQuoteResponse) getWebServiceTemplate()
//					.marshalSendAndReceive(
//							quote,
//							new SoapActionCallback(
//									"http://www.webserviceX.NET/GetQuote"));
//			return quoteResp;
//	 
		}
		public void printResp(GetCountryResponse res) {
			String data=res.getCountry().getName();
			System.out.println("stock quote response :");
			System.out.println(data);
		}
	 
	}
