package com.so;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bid {

	private Item item;
	private int amount;

}
