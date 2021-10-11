# mh1021

The tools available for rental are as follows:

| Tool Type        	| Brand           	| Tool Code  	|
| ------------- 	|-------------		| -----			|
| Ladder       		| Werner 			| LADW 			|
| Chainsaw     		| Stihl       		| CHNS 			|
| Jackhammer  		| Ridgid      		| JAKR 			|
| Jackhammer  		| DeWalt      		| JAKD 			|

where..

Tool Code - Unique identifier for a tool instance

Brand - The brand of the ladder, chain saw or jackhammer.

Tool Type - The type of tool. The type also specifies the daily rental charge, and the days for which the daily
rental charge applies:

| Tool         	| Daily charge  | Weekday charge	| Weekend charge	| Holiday charge	|
| ------------- |-------------	| -----				| -----				| -----	 			|
| Ladder       	| $1.99 		| Yes 				| Yes				| No				|
| Chainsaw     	| $1.49 		| Yes 				| No				| Yes				|
| Jackhammer  	| $2.99 		| Yes 				| No				| No				|

***

Holidays:
1. Independence Day, July 4th - If falls on weekend, it is observed on the closest weekday (if Sat, then
Friday before, if Sunday, then Monday after)
2. Labor Day - First Monday in September


***

Time Spent:

* October 3rd: 1 hour (computer/project setup, problem review)
* October 6th: 2 hours (project structure, objects, initial unit tests)
* October 8th: 1.5 hours (charge calculations, partial date calculations)
* October 10th: 1 hour (charge day count calculator)
* October 11th: 1 hour (finish checkout service, finalize)