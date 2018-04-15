package uk.org.getwellgamers.stock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

	@Autowired
	private StockRepositry StockRep;

	public List<Stock> getAllStocks() {
		List<Stock> allStocks = new ArrayList<Stock>();
		StockRep.findAll().forEach(allStocks::add);
		return allStocks;
	}

	public Stock getStock(String id) {
		System.out.println("getStock:" + id);
		return StockRep.findOne(id);
	}

	public void updateStock(Stock stock) {
		StockRep.save(stock);
	}

	public void deleteStock(Stock stock) {
		StockRep.delete(stock);
	}

	public void addStock(Stock stock) {
		StockRep.save(stock);
	}
}