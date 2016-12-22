Frameworks used:
Spring boot version 1.3.3.RELEASE
Spring data mongodb: 1.8.4.RELEASE
mongo-java-driver: 2.13.3.RELEASE

Used mongoDB as the data store
MongoDB version 3.4.1 

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
