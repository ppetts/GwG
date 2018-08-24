package uk.org.getwellgamers.stock;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import uk.org.getwellgamers.hospital.Hospital;
import uk.org.getwellgamers.hospital.HospitalService;

@Order(3)
@Component
public class StockDatabaseSeeder implements CommandLineRunner {

	//Generate the Donation Data for the Database 
	private StockRepositry stockResp;
	private HospitalService hospService;
	
	@Autowired
	public StockDatabaseSeeder(StockRepositry stockResp, HospitalService hospService) {
		this.stockResp = stockResp;
		this.hospService = hospService;
	}

	@Override
	public void run(String... arg0) throws Exception {

		ArrayList<Stock> allstock = new ArrayList<Stock>();

		Stock stock = new Stock();
		stock.setStockId("STK0000001");
		
		Hospital hosp = hospService.getHospital("NTN41");
		if(null!=hosp) {
			stock.setHospital(hosp);
		}
		
		stock.setBrand("Sony");
		stock.setModel("PS4");
		stock.setStatus("Working");
		allstock.add(stock);
		

							
		stockResp.save(allstock);
		
		System.out.println("Donation Staff added :" + allstock.size());
	}
}