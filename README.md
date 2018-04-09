# spring-boot-test-demo
<b>Run the application through docker</b> <p>
docker run -p 8080:8080 -t wletmp5/spring-boot-test-demo <p>
Reference <a href="https://spring.io/guides/gs/spring-boot-docker/">https://spring.io/guides/gs/spring-boot-docker/</a> <p>
<b>Maven's settings.xml</b>
``` 
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      https://maven.apache.org/xsd/settings-1.0.0.xsd">

  <servers>
      <server>
        <id>docker.io</id>
        <username>[USERNAME]</username>
        <password>[PASSWORD]</password>
        <configuration>
          <email>[EMAIL]</email>
        </configuration>
      </server>
  </servers>

</settings>
```
