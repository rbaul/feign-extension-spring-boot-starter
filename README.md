# Feign extension Spring Boot Starter
[Spring Boot](https://spring.io/projects/spring-boot) Extension for feign spring boot

> Extension for feign spring boot
> Support pageable for feign clients

[![Build Status](https://travis-ci.com/rbaul/feign-extension-spring-boot-starter.svg?branch=master)](https://travis-ci.com/rbaul/feign-extension-spring-boot-starter)
[![Sonatype Nexus (Snapshots) badge](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.rbaul/feign-page-support-spring-boot-starter.svg)](https://oss.sonatype.org/#nexus-search;quick~feign-page-support-spring-boot-starter)
[![CodeFactor](https://www.codefactor.io/repository/github/rbaul/feign-extension-spring-boot-starter/badge)](https://www.codefactor.io/repository/github/rbaul/feign-extension-spring-boot-starter)
[![License](http://img.shields.io/:license-apache-brightgreen.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

## Build on
>* Java 8
>* Spring Boot 1.5.18

## Setup
###### Maven dependency
```xml
<repositories>
    <repository>
        <id>Sonatype</id>
        <name>Sonatype's repository</name>
        <url>https://oss.sonatype.org/content/groups/public/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.rbaul</groupId>
    <artifactId>feign-page-support-spring-boot-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

###### Gradle dependency
```groovy
repositories {
    maven { url "https://oss.sonatype.org/content/groups/public" }
}

compile 'com.github.rbaul:feign-page-support-spring-boot-starter:1.0.0-SNAPSHOT'
```


## Run Sample
> Run `FeignSampleSpringServerApplication.java` from `feign-extension-spring-boot-starter-server-samples`

Follow [http://localhost:8080/swagger-ui.html]()

## License

Licensed under the [Apache License, Version 2.0].  

[Apache License, Version 2.0]: LICENSE