**Functional specification**<br>
This software is a business model to 
store and manipulate data of cars, owners and incidents. 
The data is stored in a PostgreSQL database, the frontend is written in 
React, Rest requests handled by a Spring module. You can add, modify, delete and view 
elements in the database. The major work with design patterns was made in the business 
model itself (models, validation, database managment, etc.) the frontend is only made to give graphical 
representation to the work made. 
The software works on the model-DAO-service principle and I tried to utilize more design patterns through the whole process. 
Since I am learning business IT this software leans more towards that side of functionality.<br>
**Patterns used:**<br>
Singleton: For managing database connection.<br>
Strategy: Adding and updating data.<br>
Composite: Connecting together the DAO, the service.<br>
State:Used in the frontend to show data.<br>
Others will be used later on the development.<br>
**Unit tests:**<br>
Model tests: All exceptions where tested to ensure that validation works.<br>
DAO tests: All 5 data manipulations where tested.<br>
Database test: Database connector.<br>
Service test: Services are tested.
