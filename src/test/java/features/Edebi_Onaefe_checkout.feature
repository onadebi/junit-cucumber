Feature: Checkout System with Pricing Schemes

  Scenario Outline: Single item pricing
    Given the checkout system is initialized with pricing rules
    When an item with SKU '<item>' is scanned
    Then the total price should be '<totalPrice>'

    Examples:
      | item | totalPrice |
      | A    | 50 cents   |
      | B    | 30 cents   |
      | C    | 20 cents   |
      | D    | 15 cents   |

  Scenario Outline: Multi-priced items
    Given the checkout system is initialized with pricing rules
    When '<quantity>' items with SKU '<item>' are scanned
    Then the total price should be '<totalPrice>'

    Examples:
      | item | quantity | totalPrice |
      | A    | 3        | $1.30      |
      | B    | 2        | 45 cents   |
      | C    | 1        | 20 cents   |
      | D    | 1        | 15 cents   |

  Scenario Outline: Multiple items with different SKUs
    Given the checkout system is initialized with pricing rules
    When items with SKUs '<items>' are scanned
    Then the total price should be '<totalPrice>'

    Examples:
      | items | totalPrice |
      | ABCD  | $1.15      |
      | ACDB  | $1.15      |
      | BACD  | $1.15      |
      | DCBA  | $1.15      |

  Scenario Outline: Items scanned in any order
    Given the checkout system is initialized with pricing rules
    When items with SKUs '<items>' are scanned
    Then the total price should be '<totalPrice>'

    Examples:
      | items | totalPrice |
      | BBABB | $1.70      |
      | ADCB  | $1.15      |
      | DCCB  | $1.00      |
      | CCC   | 60 cents   |

  Scenario Outline: Changing pricing rules
    Given the checkout system is initialized with initial pricing rules
    When a set of new pricing rules is provided
    And items are scanned according to the new pricing rules
    Then the total price should be '<totalPrice>'

    Examples:
      | item | unitPrice | specialPrice | totalPrice |
      | A    | 50        | 3 for 130    | $1.80      |
      | B    | 30        | 2 for 45     | 75 cents   |
      | C    | 20        |              | 20 cents   |
      | D    | 15        |              | 45 cents   |