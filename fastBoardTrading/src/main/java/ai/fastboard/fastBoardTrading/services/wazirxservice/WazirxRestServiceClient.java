package ai.fastboard.fastBoardTrading.services.wazirxservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import ai.fastboard.fastBoardTrading.commonutil.FbtConstants;
import ai.fastboard.fastBoardTrading.exception.SystemException;
import ai.fastboard.fastBoardTrading.services.wazirxservice.dto.Ticker;

public class WazirxRestServiceClient {
	private static final String CLASS_NAME = WazirxRestServiceClient.class.getName();
	private static final String API_KEY = "api_key";
	private static final String GET_ALL_TICKER_API = "tickers/24hr";
	
	
	private static SimpleClientHttpRequestFactory getClientHttpRequestFactory() {
	    SimpleClientHttpRequestFactory clientHttpRequestFactory
	                      = new SimpleClientHttpRequestFactory();
	    //Connect timeout
	    clientHttpRequestFactory.setConnectTimeout(5000);
	     
	    //Read timeout
	    clientHttpRequestFactory.setReadTimeout(5000);
	    return clientHttpRequestFactory;
	}
	
	public static List<Ticker>  getAllTickers() {
		
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		String url = FbtConstants.WAZIRX_BASE_ENDPOINT + FbtConstants.WAZIRX_API + GET_ALL_TICKER_API;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);

	    
		ResponseEntity<Ticker[]> response = restTemplate.exchange(url, HttpMethod.GET,entity, Ticker[].class);
		Ticker[] ticker = response.getBody();
		if(response.getStatusCode().compareTo(HttpStatus.OK) == 0 ) {
			 throw new SystemException("Status code is not 200. Status Code:"+response.getStatusCode() , null);
		} 
		return Arrays.asList(ticker);
	}
}

 