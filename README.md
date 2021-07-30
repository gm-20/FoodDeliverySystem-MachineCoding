# FoodDeliverySystem-MachineCoding

Duration: 90 mins

Implement an online food ordering system which can be integrated with restaurants. The features of the system are as described below
Each restaurant has a menu with all the items and their respective prices. 
Restaurants have a rating out of 5
Each restaurant, at any given time can process only a certain number of orders. This number is defined as max_no_orders. The system should not assign further orders beyond max_no_of_orders, until any of the ongoing orders is COMPLETED and ready to be dispatched.   
Once an order is ACCEPTED, the restaurant can mark it as COMPLETED when the order is ready to be dispatched. This will free up the processing capacity of the restaurant. A restaurant can’t CANCEL an ACCEPTED order. 
An order will be auto-assigned to a restaurant based on a selection strategy. Eg: Assign by lowest cost or best rating. 
An order will be auto-assigned to a restaurant only if all the items in an order can be fulfilled by a single restaurant. Else the order will not be ACCEPTED.
An order placed once cannot be modified

The software application MUST meet the following requirements
Ability to onboard a new restaurant.
Onboarded restaurant should be able to update its menu. ( Deletion of items in the menu is not allowed )
Ability to mark an ACCEPTED order as COMPLETED
A customer should be able to place an order with the following details
Items and their quantity
Selection Strategy
Implement at least one of the two selection strategies
Lowest Bill Cost
Highest Rating 


EXPECTATIONS

MUST HAVES
Working code which is demoable
Functional correctness
Selection Strategy should be pluggable
Proper entity/domain object modelling, separation of concerns
Modular code with is unit-testable
Exception and Error Handling

GOOD TO HAVES
Use of design patterns

DO NOT make use of any kind of database to store information. All information should be in-memory using the appropriate data structures. 

DO NOT emphasize and spend too much time on reading the input. Input data can be taken in any manner. Hard-code in the main driver program. Read from file etc. It should be flexible enough to modify quickly and easily if needed by the interviewer.



SAMPLE TEST CASES

Onboard Restaurant
	Name: R1
	Max_no_of_orders: 5
	Menu:
            		Veg Biryani : INR 100
           		Chicken Biryani : INR 150
            Rating: 4.5 

	Name: R2
	Max_no_of_orders: 5
	Menu:
 		Idli : INR 10
	    	Dosa : INR 50
                 	Veg Biryani : INR 80
                 	Chicken Biryani : INR 175
            Rating: 4 

	Name: R3
	Max_no_of_orders: 1
	Menu:
 		Idli : INR 15
	    	Dosa : INR 30
		Gobi Manchurian : INR 150
                 	Chicken Biryani : INR 175
            Rating: 4.9

Update Restaurant Menu
	Operation: ADD
	Name: R1
	Menu:
		Chicken65 : INR 250

	Operation: UPDATE
	Name: R2
	Menu:
		Chicken Biryani : INR 150

Place Orders

Order 01
	Input:
		User: Ashwin
		Items:
			Idli : 3
			Dosa : 1
		Selection: Lowest Cost
	Output:
		Order assigned to R3
( R2 and R3 can fulfil the order, Bill Cost for R2 = INR 80, R3 = INR 75 )

Order 02
	Input:
		User: Harish
		Items:
			Idli : 3
			Dosa : 1
		Selection: Lowest Cost
	Output:
		Order assigned to R2
( Since R3 capacity is full, only R2 can fulfill the order )

Order 03
	Input:
		User: Shruthi
		Items:
			Veg Biryani : 3
			Dosa : 1
		Selection: Highest Rating
	Output:
		Order assigned to R1
( Both R1 and R2 can fulfil the order. Rating of R1 is higher than R2 )

Update Orders
	R3 marks Order 01 as COMPLETED

Place Orders

Order 04
	Input:
		User: Harish
		Items:
			Idli : 3
			Dosa : 1
		Selection: Lowest Cost
	Output:
		Order assigned to R3
( R2 and R3 can fulfil the order, Bill Cost for R2 = INR 80, R3 = INR 75 )

Order 05
	Input:
		User: Diya
		Items:
			Idli : 3
			Paneer Tikka : 1
		Selection: Lowest Cost
	Output:
		Cannot assign the order
( None of the restaurants can fulfil the order)
