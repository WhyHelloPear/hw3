# hw3 - Specialty Food Business Simulator


### Team Members
Kristian Montoya

Christian Robb

Ryan LaRocque

## Instructions To Run Code:
`java Store`

## Language & Environment:
Language: Java

Environment: IntelliJ Idea, Atom, Others.

## Description

We have the following classes doing the following things:
- `StoreInventory`:
  - Keeps track of the store's inventory and ledger
  - Handles announcements and reports about inventory, revenue, etc.
- `Store`: Runs the daily operations of the store
  - creates customers, manages when customers purchase rolls, etc.
  - Tells `StoreInventory` when to make reports, when to restock, etc.
- `Customer` and its children `CasualCustomer`, `BuisnessCustomer`, and `CateringCustomer`
  - Manage purchases with `Buy` method
- `BuyBehavior` and its children `CasualBuy`, `BuisnessBuy`, and `CateringBuy`
  - Manage the purchase behavior of a `Customer` object: wether to buy (e.g. if the store is out of the rolls they wanted) and what to buy.
- `Roll` and its children `EggRoll`, `SpringRoll`, etc.
  - Each `Roll` object represents a roll in the store. Keeps track of price, type, etc.
- `RollExtra` and its children `ExtraFilling`, `ExtraSauce`, and `ExtraTopping`
  - Decorate a `Roll` object. Keep track of extras and prices
