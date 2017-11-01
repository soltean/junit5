package com.so;

import java.util.List;
import org.junit.Rule;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuctionTest {

	@Rule
	public ItemRule itemRule = new ItemRule();

	private List<Item> buildItems() {
		return itemRule.getItems();
	}

	@Test
	@Disabled("I don't wanna run this one")
	public void testShouldBeDisabled() {
	}

	@Test
	@DisplayName("Items should be sell at the auction")
	public void testSellItemAtAuction() {
		int bid1 = 100;
		int bid2 = 200;
		int bid3 = 300;
		Auction auction = new Auction();
		auction.setItems(buildItems());
		Item goldPen = auction.getItems().get(0);
		auction.sendBidForItem(goldPen, bid1);
		auction.sendBidForItem(goldPen, bid2);
		auction.sendBidForItem(goldPen, bid3);
	/*	Assertions.assertThat(auction.getAllBidsForItem(goldPen)).as("There are 3 bids for the gold pen").hasSize(3);
		Assertions.assertThat(auction.getAllBidsForItem(goldPen)).as("The bids are " + bid1 + "," + bid2 + "," + bid3).extracting("amount")
				.contains(bid1, bid2, bid3);
		Bid winningBid = auction.sellItem(goldPen);
		Assertions.assertThat(winningBid.getAmount()).as("The winning bid is " + bid3).isEqualTo(bid3);*/
	}

	@Test
	@DisplayName("Items should NOT be sell at the auction")
	public void testCannotSellItemAtAuction3() {
		int bid1 = 1000;
		int bid2 = 800;
		Auction auction = new Auction();
		auction.setItems(buildItems());
		Item goldWatch = auction.getItems().get(1);
		auction.sendBidForItem(goldWatch, bid1);
		auction.sendBidForItem(goldWatch, bid2);
/*		Assertions.assertThat(auction.getAllBidsForItem(goldWatch)).as("There are 2 bids for the gold watch").hasSize(2);
		Assertions.assertThat(auction.getAllBidsForItem(goldWatch)).as("The bids are " + bid1 + "," + bid2).extracting("amount").contains(bid1, bid2);

		assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> auction.sellItem(goldWatch))
				.withMessage("Cannot sell item " + goldWatch.getCode() + " below the reserve price");*/
	}

	@Test
	@DisplayName("This should fail")
	public void testExpectToFail() {
		int bid1 = 100;
		int bid2 = 200;
		int bid3 = 300;

		Auction auction = new Auction();
		auction.setItems(buildItems());
		Item goldPen = auction.getItems().get(0);
		auction.sendBidForItem(goldPen, bid1);
		auction.sendBidForItem(goldPen, bid2);
		auction.sendBidForItem(goldPen, bid3);

		/*SoftAssertions softly = new SoftAssertions();
		softly.assertThat(auction.getAllBidsForItem(goldPen)).as("There are 3 bids for the gold pen").hasSize(2);
		softly.assertThat(auction.getAllBidsForItem(goldPen)).as("The bids are " + bid1 + "," + bid2 + "," + bid3).extracting("amount")
				.contains(bid1 + 1, bid2 + 1, bid3 + 1);
		Bid winningBid = auction.sellItem(goldPen);
		softly.assertThat(winningBid.getAmount()).as("The winning bid is " + bid3).isEqualTo(bid3 + 1);
		softly.assertAll();*/
	}

}
