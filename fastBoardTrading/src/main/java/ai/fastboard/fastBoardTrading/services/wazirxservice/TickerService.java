package ai.fastboard.fastBoardTrading.services.wazirxservice;

import java.util.List;

import org.springframework.stereotype.Service;

import ai.fastboard.fastBoardTrading.services.wazirxservice.dto.Ticker;

@Service
public class TickerService {
	final String className = TickerService.class.getName();

	public List<Ticker> getAllTickers() {
		return WazirxRestServiceClient.getAllTickers();
	}
}
