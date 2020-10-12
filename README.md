# hw3

Store starts with 30 types of each roll

### Roll types:
<ul>
  <li>Spring Rolls</li>
  <li>Egg Rolls</li>
  <li>Pastry Rolls</li>
  <li>Sausage Rolls</li>
  <li>Jelly Rolls</li>
</ul>
Each roll must be given a unique cost/price.

### Addons to rolls:
<ul>
  <li>Extra sauce</li>
  <li>Extra filling</li>
  <li>Extra topping</li>
</ul>
Each addon has a different cost for each roll type.
The store has an unlimited supply of these addons.

### Customer types:
<ul>
  <li>Casual</li>
  <ul>
    <li>Count of 1-12 each day.</li>
    <li>Buys 1-3 random rolls</li>
    <li>If selected rolls are out of stock:</li>
      <ul>
        <li>Will select any available roll.</li>
        <li>Will accept less than their ideal total (will take 2 if 3 aren't available).</li>
      </ul>
  </ul>
  <li>Business</li>
  <ul>
    <li>Count of 1-3 each dya.</li>
    <li>Buys 10 rolls; two of each type</li>
    <li>If selected rolls are out of stock:</li>
      <ul>
        <li>Will NOT buy order; only takes their exact original order.</li>
      </ul>
  </ul>
  <li>Catering</li>
  <ul>
    <li>Count of 1-3 each day.</li>
    <li>Buys 15 rolls; 5 rolls of 3 random types</li>
    <li>If selected rolls are out of stock:</li>
      <ul>
        <li>Will select any available roll.</li>
        <li>Will accept less than their ideal total (will take 10 if 15 aren't available).</li>
      </ul>
  </ul>
</ul>

### Rules
<ul>
  <li>When a certain roll sells out, no more may be sold that day.</li>
  <ul>
    <li>Notice must be given (message).</li>
    <li>30 more rolls will be made the next day.</li>
    <li>Customer type must be recorded; a total of this count must be kept for each customer for the dialy report).</li>
  </ul>
  <li>Store closes and notice is given when everything sells out.</li>
  <ul>
    <li>Customers will not visit this store at this point</li>
  <li>If roll still has inventory, use the same inventory for the next day; only reset inventory if we have none.</li>
  <li>Customers arrive randomly every day in random order.</li>
  <li>Every individual roll will have (all costs are added to roll order cost):</li>
    <ul>
      <li>0-3 extra sauces</li>
      <li>0-1 extra fillings</li>
      <li>0-2 extra toppings</li>
    </ul>
  </ul>
