# ExcelNotificator
Микросервисное приложение для пасринга xlsx файлов и рассылки сообщений по почте. 
### Stack
ExcelParser service:
- Springboot 3, Spring Data Jpa, Spring MVC
- ORM: Hibernate
- DB: Postgress
- Message Broker: Kafka
  
Notificator service:
- Springboot 3, Spring Data Jpa, Spring MVC, Spring Cache
- ORM: Hibernate
- DB: Postgress
- Cache: Redis 
- Mail: Spring mail, Gmail smpt service
- Message Broker: Kafka
  

