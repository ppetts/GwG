package uk.org.getwellgamers.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepositry extends JpaRepository<Stock, String> {

}
