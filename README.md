# SouslesensUserManager 
A Springboot based service to fetch Ontoportal instance users and store them in Mysql database, in addition to a scheduled job that does the same every HOUR, This can be usefull if you want to synchronize your other servers with appliance version.

## 1- Config 
There's two general configuration files to take care of "Config.java" and "application.properties"

### 1.1- Config.java  
You can find this file in `/src/main/java/fr/enit/industryportal/souslesensusermanager/config/Config.java`, and there's only two constants to define, one is the **API_URL** and the **API-KEY**  as follows  

```java

package fr.enit.industryportal.souslesensusermanager.config;

/**
 * @author Abdelwadoud Rasmi
 * Config file to hold app needed constants
 */
public interface Config {
    String API_URL = "http://data.industryportal.enit.fr/";
    String API_KEY = "";
}

```  

### 1.2- application.properties  
You can find this file in `/main/resources/application.properties`, this file holds the database connection credentials, all you need to do is to define your username and password, if you have another type of SQL DB like (H2 ext...) or you DB server is running on an other port you have to change the `spring.datasource.url` too.

```yaml
spring.application.name="souslesens-user-manager"
server.port=8081
spring.jackson.serialization.INDENT_OUTPUT=true
#mysql connection
spring.datasource.url=jdbc:mysql://localhost:3306/souslesens
spring.jpa.hibernate.ddl-auto=update
spring.datasource.username=root
spring.datasource.password=
#
server.error.whitelabel.enabled=false

```  

## 2- Deployment
You can deploy the **war** in **Tomcat** **webapps** folder, or just run it using "java" commandline "`java -jar yourservice.war` " or  
 "`java -jar -p8082 yourservice.war` ", the default port for this app is 8081 you can change it in application.properties
