# my-couchbase-learning
  
  Couchbase cache implementation with spring-boot

## Steps to run the application
  
  - mvn clean package  
  
  - java -jar target\my-couchbase-1.0-SNAPSHOT.jar

## Launch URL
  
  - To create the document in the bucket by ID
    
    http://localhost:9901/vehicleByID?id=1
  
  - To create the document in the bucket by type
    
    http://localhost:9901/vehicleByType?type=4WD
  
  - To update the document value
    
    http://localhost:9901/update?model=Sunny&id=2
  
  - To flush the document by ID or type    
    
    http://localhost:9901/flushByID?id=1
    
    http://localhost:9901/flushByType?type=AWD

## Important tips
  
  - Remember to create a bucket with name VEHICLE in your local couchbase server.
  
  - Invalid password error?
    Check the username in security tab of couchbase server, the value of username should be same to the bucket name.
    (For the couchbase server version > 5, we need to define the user in security tab for defining the password for the bucket)
