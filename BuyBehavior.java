import java.util.*;

// defines the strategy method for roam
// Classes defining each method of roam will implement the RoamBehavior

interface BuyBehavior{
	public List<Roll> buy(StoreInventory storeInventory);
}