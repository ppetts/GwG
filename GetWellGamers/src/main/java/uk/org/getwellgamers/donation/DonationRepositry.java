package uk.org.getwellgamers.donation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepositry extends JpaRepository<Donation, String> {

}
