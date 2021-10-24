# BankService

#Content</b> 
Eureka</b> 
    service discovery service </b> 
AccountService </b> 
    AccountCompositeService</b> 
        Spring webrelated service which is contains controller classes and </b> swagger component </b> 

    AccountCoreService </b> 
        contains all model classes , Sevice classes , AOP classes and </b> Repository classes </b> 

How to run the application </b> 
    install Docker in host computer </b> 
    run </b> 
        docker-compose build </b> 
        docker-copmpose up </b> 

access endpoints </b> 
    swagget ui - >  http://localhost:8082/swagger-ui.html </b> 
    get accounts by user Id - > http://localhost:8082/api/accounts/1?page=0&size=4&sort=accountName

    get transactions by account Id -> </b> 
    http://localhost:8082/api/transactions/564342?page=0&size=4&sort=valueDate