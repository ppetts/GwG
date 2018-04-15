package uk.org.getwellgamers.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	
	@Autowired
	StockService StockService;

	@RequestMapping("/stock")
	public List<Stock> getAllStock() {
		return StockService.getAllStocks();
	}

	@RequestMapping("/stock/{id}")
	public Stock getStock(@PathVariable String id) {
		return StockService.getStock(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/stock/{id}")
	public Stock addStock(@RequestBody Stock Stock) {
		StockService.addStock(Stock);
		return Stock;
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/stock/{id}")
	public void deleteStock(@RequestBody Stock Stock) {
		StockService.deleteStock(Stock);
	}
}