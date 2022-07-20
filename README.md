# BankService

#Content
-Eureka
    -service discovery service
-AccountService
    -AccountCompositeService 
        -Spring webrelated service which is contains controller classes and swagger component

    -AccountCoreService 
        -contains all model classes 
        -Sevice classes 
        -AOP classes and 
        -Repository classes 

-How to run the application

    1.install Docker in host computer 
    
    2.run
    
    -docker-compose build
    
    -docker-copmpose up

-access endpoints

    -swagget ui - >  http://localhost:8082/swagger-ui.html 
    
    -get accounts by user Id - > http://localhost:8082/api/accounts/1?page=0&size=4&sort=accountName
    
    -get transactions by account Id -> http://localhost:8082/api/transactions/564342?page=0&size=4&sort=valueDate
