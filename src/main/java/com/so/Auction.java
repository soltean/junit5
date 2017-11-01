package com.so;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Auction {

	private List<Bid> bids = new ArrayList<>();

	@Getter
	@Setter
	private List<Item> items;

	public void sendBidForItem(Item item, int amount) {
		Bid bid = new Bid(item, amount);
		Optional.ofNullable(bids).ifPresent(b -> b.add(bid));
	}

	public List<Bid> getAllBidsForItem(final Item item) {
		return bids.stream().filter(bid -> bid.getItem().getCode().equals(item.getCode())).collect(Collectors.toList());
	}

	public Bid sellItem(Item item) {
		return bids.stream().filter(bid -> bid.getItem().getCode().equals(item.getCode())).max(Comparator.comparing(Bid::getAmount))
				.filter(hb -> hb.getAmount() > item.getReservePrice())
				.orElseThrow(() -> new UnsupportedOperationException("Cannot sell item " + item.getCode() + " below the reserve price"));
	}
}
