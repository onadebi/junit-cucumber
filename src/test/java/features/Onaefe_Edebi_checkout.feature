Feature: Module that acts as checkout system for handling pricing schemes

Scenario Outline: Checkout system calculates the total price for individual items
	Given the checkout system has the following pricing rules
	When the cashier scans the following items in any order: "<item>" with unit price of <unitPrice>. Posible specialPrice is "<specialPrice>"
	Then the total price should be <unitPrice> cents

    Examples: 
      |item|unitPrice|specialPrice|
      | A |   50 | 3 for 130 |
      | B |   30 | 2 for 45  |
      | C |   20 |           |
      | D |   15 |           |
      | B |   30 | 2 for 45  |
      
      
#Scenario Outline: Checkout system applies special price for multi-priced items regardless of order
  #Given the checkout system has the following pricing rules
  #When the cashier scans the following items: A, B, A, A
  #Then the total price should be 175 cents  
#	  Examples:
#	    | item | unitPrice | specialPrice |
#	    | YA,B,A,A    | 50        | 3 for 130    |
#	    | B    			 | 30        | 2 for 45     |
#	    | C    			 | 20        |              |
#	    | D    			 | 15        |              |
    