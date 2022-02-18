package ai.fastboard.fastBoardTrading.controllers.wazixcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.fastboard.fastBoardTrading.services.wazirxservice.TickerService;
import ai.fastboard.fastBoardTrading.services.wazirxservice.dto.Ticker;

@RestController
@RequestMapping("wazirx")
public class PublicController {

	
	@Autowired
	private TickerService tickerService;
	
	@GetMapping("getAllTickers")
	public ResponseEntity<List<Ticker>> getAllTicker(){
		return ResponseEntity.ok(tickerService.getAllTickers());
	}
}
