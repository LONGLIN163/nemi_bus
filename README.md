# nemi_bus

# Unit Testing

### `run all test`

The repository test need to connect to real db.
If we want to run all the test, we need to run the application and connect to **real db**.
(You can check the config/properites file to set a postgresDB)

### `run all tests without connect real db`
For the service test, we don't need to connect db.
We can disable repositrory test then run all the test.
Or we can just go to run specific service test.