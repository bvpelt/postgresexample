# Fun01

## Initial Setup project
Goto the [spring io](https://start.spring.io/) site and choose for
- Jersey (JAX-RS)
- JPA
- H2 (only for test)
- PostgreSQL (only for prod)
- Integration
- Actuator Docs

## Bron
- See [source code](https://gist.github.com/bcambel/4572404)
- See [jpa](https://springframework.guru/spring-boot-web-application-part-3-spring-data-jpa/)

## Examples used
- [Reading from rest api](https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-rest-api/)
- Hibernate
	- [One to many](https://en.wikibooks.org/wiki/Java_Persistence/OneToMany)
	- [One to one](https://en.wikibooks.org/wiki/Java_Persistence/OneToOne)
	- [Flushing](http://stackoverflow.com/questions/2302802/object-references-an-unsaved-transient-instance-save-the-transient-instance-be)

## Find dependencies
Find additional dependencies from [nexus](https://repository.sonatype.org).

Add
- spring batch
``` 
<dependency>
  <groupId>org.springframework.batch</groupId>
  <artifactId>spring-batch-infrastructure</artifactId>
  <version>3.0.7.RELEASE</version>
</dependency>
```

## Convert .Net Date to Java
See [article](http://www.androidpuzzles.info/33_18874069/)

Input Date like string with format "\/Date(1262300400000+0100)\/" 
``` 
String numbers = str.replaceAll("\\\\/Date\\((\\d+\\+\\d+)\\)\\\\/", "$1+$2");

String parts = numbers.split("\\+");

Date d = new Date(Long.parseLong(parts[0]));
```
See [regular expression tester](http://www.regexplanet.com/advanced/java/index.html) for online java regular expression tester.
## JSON converter
See [article](http://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial) about jackson json parser

## Postgresql
Commandline query example
``` 
psql -h localhost fun bvpelt -c 'select * from fun_objectdto limit 1'
```
After running the program find selected data with sql querie from the command line
``` 
psql -h localhost fun bvpelt -c "select adres, verkoop_status, makelaar_naam, koopprijs, woon_oppervlakte, (koopprijs/woon_oppervlakte) as prijsperm2, publicatie_datum, url from fun_objectdto where woon_oppervlakte > 100 and verkoop_status = 'StatusBeschikbaar' order by prijsperm2"

              adres              |  verkoop_status   |           makelaar_naam            | koopprijs | woon_oppervlakte | prijsperm2 |  publicatie_datum   |                                            url                                            
---------------------------------+-------------------+------------------------------------+-----------+------------------+------------+---------------------+-------------------------------------------------------------------------------------------
 Adriaen van Ostadelaan 33 bis   | StatusBeschikbaar | Van Ginkel & Van Bemmelen          |    162500 |              101 |       1608 | 2016-11-30 01:35:11 | http://www.funda.nl/koop/veenendaal/appartement-49075986-adriaen-van-ostadelaan-33-bis/
 De Korenbeurs 3                 | StatusBeschikbaar | Van Dijk Van Essen                 |    449000 |              250 |       1796 | 2016-03-11 01:35:58 | http://www.funda.nl/koop/veenendaal/appartement-49764379-de-korenbeurs-3/
 Zandstraat 5 BIS                | StatusBeschikbaar | Snel ERA makelaars                 |    209000 |              106 |       1971 | 2017-04-10 00:00:00 | http://www.funda.nl/koop/veenendaal/appartement-49100464-zandstraat-5-bis/
 Julianastraat 101               | StatusBeschikbaar | Diepeveen Makelaars                |    250000 |              115 |       2173 | 2015-08-28 01:35:40 | http://www.funda.nl/koop/veenendaal/appartement-49571825-julianastraat-101/
 Jac.P. Thijsselaan 66           | StatusBeschikbaar | Van Ginkel & Van Bemmelen          |    289000 |              130 |       2223 | 2017-02-11 01:35:13 | http://www.funda.nl/koop/veenendaal/appartement-49047544-jacp-thijsselaan-66/
 Spoorlaan 47                    | StatusBeschikbaar | Ditters Makelaars                  |    274000 |              120 |       2283 | 2012-12-04 01:05:12 | http://www.funda.nl/koop/veenendaal/appartement-48675866-spoorlaan-47/
 Scheepjeshof 193                | StatusBeschikbaar | Zonnenberg Makelaardij             |    335000 |              143 |       2342 | 2014-09-17 01:05:15 | http://www.funda.nl/koop/veenendaal/appartement-84583692-scheepjeshof-193/
 Zandstraat 69                   | StatusBeschikbaar | Burgland Makelaars Veenendaal B.V. |    319000 |              132 |       2416 | 2016-01-23 01:35:49 | http://www.funda.nl/koop/veenendaal/appartement-85078053-zandstraat-69/
 Spoorlaan 73                    | StatusBeschikbaar | Zonnenberg Makelaardij             |    288000 |              106 |       2716 | 2016-12-15 01:35:06 | http://www.funda.nl/koop/veenendaal/appartement-85446355-spoorlaan-73/
 Kerkewijk 128                   | StatusBeschikbaar | Diepeveen Makelaars                |    398000 |              145 |       2744 | 2016-10-12 00:00:00 | http://www.funda.nl/koop/veenendaal/appartement-49917590-kerkewijk-128/
 Mr. Dr. Schokkingstraat 89      | StatusBeschikbaar | Diepeveen Makelaars                |    399500 |              140 |       2853 | 2017-02-23 01:35:10 | http://www.funda.nl/koop/veenendaal/appartement-49159875-mr-dr-schokkingstraat-89/
 Kerkewijk 74 F                  | StatusBeschikbaar | Van Dijk Van Essen                 |    499000 |              174 |       2867 | 2013-09-20 01:05:10 | http://www.funda.nl/koop/veenendaal/appartement-48807252-kerkewijk-74-f/
 Kerkewijk 74 f                  | StatusBeschikbaar | Diepeveen Makelaars                |    499900 |              174 |       2872 | 2016-08-27 01:35:12 | http://www.funda.nl/koop/veenendaal/appartement-49960233-kerkewijk-74-f/
 Kerkewijk 70 E                  | StatusBeschikbaar | Van Dijk Van Essen                 |    498000 |              170 |       2929 | 2014-12-18 01:05:17 | http://www.funda.nl/koop/veenendaal/appartement-48230475-kerkewijk-70-e/
 Kerkewijk 75 K                  | StatusBeschikbaar | Van Ginkel & Van Bemmelen          |    399000 |              129 |       3093 | 2016-05-24 01:35:08 | http://www.funda.nl/koop/veenendaal/appartement-49744586-kerkewijk-75-k/
 Gilbert van Schoonbekestraat 34 | StatusBeschikbaar | Van Ginkel & Van Bemmelen          |    432000 |              116 |       3724 | 2017-04-01 01:35:07 | http://www.funda.nl/koop/veenendaal/appartement-49193848-gilbert-van-schoonbekestraat-34/
 Kerkewijk 74 H                  | StatusBeschikbaar | Van Dijk Van Essen                 |    575000 |              150 |       3833 | 2014-10-01 01:05:14 | http://www.funda.nl/koop/veenendaal/appartement-48145384-kerkewijk-74-h/
(17 rows)

```
### Create database
To create the postgres database(s) normal and for test
- login as root
- start tye postgres database service
- become postgres
- create database
``` 
[root@pluto ~]# systemctl start postgresql
[root@pluto ~]# su - postgres
-bash-4.3$ psql
psql (9.5.6)
Type "help" for help.

postgres=# create database funtest owner bvpelt;
CREATE DATABASE
postgres=# exit
postgres-# \q
-bash-4.3$ logout
[root@pluto ~]# 
```