package com;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import gen.GetCountryResponse;

@SpringBootApplication
public class ObjeConstrcutApplication {
	private static Logger log = Logger.getLogger(ObjeConstrcutApplication.class);

	public static void main(String[] args) {
		 log.info("Logger enabled: Entering main \n\n");
	ConfigurableApplicationContext cnt = SpringApplication.run(ObjeConstrcutApplication.class, args);
	StockQuoteClient stock = cnt.getBean(StockQuoteClient.class);
	GetCountryResponse respon = stock.stockQuote("spain");
	stock.printResp(respon);
		
		
	}
	@Bean	
	  public Jaxb2Marshaller getMarshaller(){
		  Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		  marshaller.setContextPath("gen");
		  return marshaller;
	  }
	  
	  @Bean
	  public StockQuoteClient getStockClient(){
		  
		  StockQuoteClient wsclient=new StockQuoteClient();
		  wsclient.setMarshaller(getMarshaller());
		  wsclient.setUnmarshaller(getMarshaller());
		  wsclient.setDefaultUri("http://localhost:9999/ws/countries.wsdl");
		  return wsclient;
	  }
//	@Bean
//	public A getA() throws InstantiationException, IllegalAccessException, JAXBException{
//		return new A();
//	}
//	@Bean
//	public Mesg mesg(){
//		return new Mesg();
//	}
//@Bean
//public WebServiceTemplate webServiceTemplate(Marshaller marshaller){
//	WebServiceTemplate webServiceTemplate=new WebServiceTemplate(marshaller);
//	return webServiceTemplate;
//}
//@Bean
//public Jaxb2Marshaller marshaller(){
//	Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
//	marshaller.setPackagesToScan(getClass().getPackage().getName());
//	return marshaller;
//	
//}
}
