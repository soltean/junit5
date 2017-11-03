package com.so;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(ItemExtension.class)
class AuctionTest {

	/*@Rule
	ItemRule itemRule = new ItemRule();*/

	/*@BeforeAll
	void buildItems() {
		items.add(new Item("code1", 100));
		items.add(new Item("code2", 1500));
	}*/

	List items;

	AuctionTest(List items) {
		this.items = items;
	}

	@Test
	@Disabled("I don't wanna run this one")
	void testShouldBeDisabled() {
	}

	@Test
	@DisplayName("Items should be sell at the auction")
	@Tag("pass")
	void testSellItemAtAuction(TestInfo testInfo) {
		int bid1 = 100;
		int bid2 = 200;
		int bid3 = 300;
		Auction auction = new Auction();
		auction.setItems(items);
		Item goldPen = auction.getItems().get(0);
		auction.sendBidForItem(goldPen, bid1);
		auction.sendBidForItem(goldPen, bid2);
		auction.sendBidForItem(goldPen, bid3);
		assertEquals(auction.getAllBidsForItem(goldPen).size(), 3);
		Bid winningBid = auction.sellItem(goldPen);
		assertEquals(winningBid.getAmount(), bid3);
	}

	@Test
	@DisplayName("Items should NOT be sell at the auction")
	@Tag("pass")
	void testCannotSellItemAtAuction3() {
		int bid1 = 1000;
		int bid2 = 800;
		Auction auction = new Auction();
		auction.setItems(items);
		Item goldWatch = auction.getItems().get(1);
		auction.sendBidForItem(goldWatch, bid1);
		auction.sendBidForItem(goldWatch, bid2);
		assertEquals(auction.getAllBidsForItem(goldWatch).size(), 2);
		Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
			auction.sellItem(goldWatch);
		});
		assertEquals("Cannot sell item " + goldWatch.getCode() + " below the reserve price", exception.getMessage());
	}

	@Test
	@DisplayName("This should fail")
	@Tag("fail")
	void testExpectToFail() {
		int bid1 = 100;
		int bid2 = 200;
		int bid3 = 300;

		Auction auction = new Auction();
		auction.setItems(items);
		Item goldPen = auction.getItems().get(0);
		auction.sendBidForItem(goldPen, bid1);
		auction.sendBidForItem(goldPen, bid2);
		auction.sendBidForItem(goldPen, bid3);

		assertAll("bid assertions", () -> assertEquals(auction.getAllBidsForItem(goldPen).size(), 3, "There are 3 bids for the gold pen"), () -> {
			Bid winningBid = auction.sellItem(goldPen);
			assertEquals(winningBid.getAmount(), bid3 + 1, "The winning bid is " + bid3);
		});
	}

}
