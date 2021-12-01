# blog-demo

## SpringBootプロジェクト作成
1. [Eclipse](https://mergedoc.osdn.jp/)等のIDEからでも良いので、[Spring Initializr](https://start.spring.io/) よりプロジェクトのベースをダウンロード・インポート
   ```
   Java version: 17
   packaging: Jar
   ```
   | name              | explanation                    |
   | ----------------- | ------------------------------ |
   | Spring Web        | Webアプリケーション用のstarter |
   | [MyBatis](https://mybatis.org/mybatis-3/ja/) Framework | データベースとのやりとり       |
   | [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf_ja.html)     | Template Engine                |
   | Lombok            | Modelの記載の簡略化            |
   
1. SQLiteを使用するため、下記コードを `pom.xml` に追記(Mavenの場合)
   ```xml
   <dependency>
     <groupId>org.xerial</groupId>
     <artifactId>sqlite-jdbc</artifactId>
     <version>3.21.0.1</version>
   </dependency>
   ```
   
1. プロジェクトを更新(dependencesの更新)
1. プロジェクト内にDBファイルを作成(SQLiteを使用してDBを作成)
1. DB接続用のConfigクラスを作成
   `(pkg)com.example.demo > (pkg)config > AppConfig.java`
   ```java
   package com.example.demo.config;
   
   import javax.sql.DataSource;
   
   import org.mybatis.spring.SqlSessionFactoryBean;
   import org.mybatis.spring.annotation.MapperScan;
   import org.springframework.context.annotation.Bean;
   import org.springframework.context.annotation.Configuration;
   
   @Configuration
   @MapperScan(basePackages = "com.example.demo.mapper")
   public class AppConfig {
   	@Bean
       public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
           SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
           sessionFactoryBean.setDataSource(dataSource);
           return sessionFactoryBean;
       }
   }
   ```

1. `application.propaties` ファイルに以下を記載
   ```
   spring.datasource.driver-class-name=org.sqlite.JDBC
   spring.datasource.url=jdbc:sqlite:hello.db
   spring.datasource.username=
   spring.datasource.password=
   ```
   
1. Cording & Build & Execute
