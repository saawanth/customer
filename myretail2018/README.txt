Frameworks used:
Spring boot version 1.5.12.RELEASE
Spring data mongodb: 1.5.12.RELEASE
mongo-java-driver: 3.7.0.RELEASE

Used mongoDB as the data store
MongoDB version 3.4.3

UserName:rajesh
Password:aj4JR96alLBdn7Bw 

mongodb://rajesh:aj4JR96alLBdn7Bw@myretailcluster-shard-00-00-szy5j.mongodb.net:27017,myretailcluster-shard-00-01-szy5j.mongodb.net:27017,myretailcluster-shard-00-02-szy5j.mongodb.net:27017/test?ssl=true&replicaSet=myretailcluster-shard-0&authSource=admin

To test it locally
1. Install latest and stable version of the MongoDB.
2. Start the database
C:\Program Files\MongoDB\Server\3.4\bin>mongo.exe
MongoDB shell version v3.4.1
connecting to: mongodb://127.0.0.1:27017
3. To connect to the mongo DB running on a different host, specify the properties in application.properties.
4. To start the application launch the main MyRetailCommandLineRunner class.


Both product and product price informatin are stored in the same data store that is mongodb.

Domain classes created:
Product: Stores product information based on an product id.
ProductPrice: Stored product price information based on product id.


Sample Output from testing.

1. Find product and price information based on product id.

url:localhost:8081/v1/products/{productid}
method:GET
request:13860428
response:
{
  "id": 13860428,
  "name": "The Big Lebowski (Blu-ray) (Widescreen)",
  "current_price": {
    "price": 599.99,
    "currencyCode": "USD"
  }
}

2. Update product price based on product id.

url: localhost:8081/v1/products/{productid}
method: PUT
HEADERS: content-type=application/json
pathVariable: 13860428
request body:
{
  "id": 13860428,
  "name": "The Big Lebowski (Blu-ray) (Widescreen)",
  "current_price": {
    "price": 589.99,
    "currencyCode": "USD"
  }
}

response:
{
  "id": 13860428,
  "name": "The Big Lebowski (Blu-ray) (Widescreen)",
  "current_price": {
    "price": 589.99,
    "currencyCode": "USD"
  }
}
