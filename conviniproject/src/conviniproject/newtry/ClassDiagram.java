package conviniproject.newtry;

public class ClassDiagram {

}

/*
							
							+----------------+        +------------------+       +----------------+            +----------------+
							|    Main        |        |   POSSystem      |       |  Transaction   |            |   Paycheck     |
							+----------------+        +------------------+       +----------------+            +----------------+
							| - posSystem    | <----> | -  methods...    |       | - product      |            | - WAGE_PER_    |
							| + main()       |        |                  |       | - quantity     |            |   MINUTE       |
							+----------------+        +------------------+       | - transactionTime           | - totalMinutes |
							                                                     | - totalSalesYesterday       |    Worked      |
							                                                     | - totalSalesToday           |                |
							                                                     +----------------+            +----------------+
							                                                     | + Transaction()|            | + Paycheck()   |
							                                                     | - updateStock()|            | + addWorkTime()|
							                                                     | - updateSales()|            | + calcDailyWage|
							                                                     | + getTotalPrice()           | + getTotalMin  |
							                                                     | + getTotalSalesYesterday()  | + calcDailyWage|
							                                                     | + getTotalSalesToday()      |  (static)      |
							                                                     +----------------+            +----------------+
							+----------------+       +------------------+        +----------------+            +----------------+
							|      User      |       |   Inventory      |        |    Product     |            |   Timecheck    |
							+----------------+       +------------------+        +----------------+            +----------------+
							| - username     |       | - products       |        | - name         |            | - timecheck    |
							| - password     |       +------------------+        | - id           |            +----------------+
							| - isLoggedIn   |       | + addProduct()   |        | - price        |            | + setLoginTime |
							| - age          |       | + removeProduct()|        | - stock        |            +----------------+
							| - balance      |       | + getProduct()   |        | - expiryDate   |
							+----------------+       | + getProducts()  |        +----------------+
							| + User()       |       | + checkInventory()        | + Product()    |
							| + getName()    |       +------------------+        | + getName()    |
							| + getAge()     |                                   | + getId()      |
							| + isMinor()    |                                   | + getPrice()   |
							| + getBalance() |                                   | + getStock()   |
							| + purchase()   |                                   | + setStock()   |
							| + addFunds()   |                                   | + getExpiryDate|
							| + login()      |                                   | + isRestricted()
							| + logout()     |                                   +----------------+
							| + isLoggedIn() |
							| + getUsername()|
							+----------------+


*/