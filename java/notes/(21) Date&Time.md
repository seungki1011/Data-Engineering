## 1) Date

* 날짜와 시간을 다루기 위한 클래스
* 대부분 deprecated
  * Thread safe 하지 않음(multi-thread 환경에서 이슈가 생길 수 있음)
  * 타입 안정성이 없음
  * Timezone 적용이 어려움
* ```java.time``` 패키지 사용이 권장 되지만, ```Date```를 사용하는 레거시 코드가 아직도 있음
* [Unix Time](https://en.wikipedia.org/wiki/Unix_time)의 millisecond 단위로 시간을 다룸

[```DateMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/DateMain.java)

```java
public class DateMain {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("new Date() = "+date); // 현재 시간

        // Epoch Time 기준으로 1 millisecond가 지남
        System.out.println("new Date(1) = "+(new Date(1)));

        // Epoch Time 기준으로 1 second가 지남
        System.out.println("new Date(1000) = "+(new Date(1000)));

        // 현재 시간 (date)이 Epoch Time 기준 1초 지난 시점 보다 이후가 맞기 때문에 -> true 반환
        System.out.println("new Date().after(new Date(1000)) = "+date.after(new Date(1000)));

        // 현재 시간(피연산자)이 파라미터로 넘긴 시간 보다 이후면 >0, 같으면 =1, 이전이면 <0
        System.out.println("new Date().compareTo(new Date(1000)) = "+new Date().compareTo(new Date(1000)));
        System.out.println("new Date(1000).compareTo(new Date()) = "+new Date(1000).compareTo(new Date()));
        
    }
}
```

```
new Date() = Sun Jan 14 17:03:30 KST 2024
new Date(1) = Thu Jan 01 09:00:00 KST 1970
new Date(1000) = Thu Jan 01 09:00:01 KST 1970
new Date().after(new Date(1000)) = true
new Date().compareTo(new Date(1000)) = 1
new Date(1000).compareTo(new Date()) = -1
```



## 2) ```Calendar```

* ```Date```를 개선한 클래스
* ```java.time``` 패키지 사용이 권장 되지만, ```Calendar```를 사용하는 레거시 코드가 아직도 있음
* 추상 클래스임
  * ```Calendar calendar = Calendar.getInstance();```와 같이 사용해야 함
* ```get()```으로 필드 가지고 옴
* ```set()```으로 날짜와 시간 지정
* ```clear()```로 필드 초기화
* [Java docs - ```Calendar```](https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html)

[```CalendarMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/CalendarMain.java)

```java
public class CalendarMain {
    public static void main(String[] args) {
        // 1. get()으로 필드 가져오기
        // Calendar는 추상 클래스, 일반 클래스 처럼 인스턴스 생성 불가
        System.out.println("------------using get------------");
        Calendar calendar = Calendar.getInstance(); // Set to current date and time

        int currentYear = calendar.get(Calendar.YEAR); // Current Year
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Current Month (zero based calendar)
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        Date currentDateTime = calendar.getTime();

        System.out.println("몇 년: " + currentYear);
        System.out.println("몇 월:" + currentMonth);
        System.out.println("몇 일: " + dayOfMonth);

        System.out.println("getTime(): "+currentDateTime);

        // 2. set()으로 날짜와 시간 지정
        System.out.println("------------using set------------");
        Calendar date = Calendar.getInstance();
        date.set(2024, 0, 1); // 2024년 1(Jan)월 1알 로 설정 (Month는 0 부터 시작)
        System.out.println("date.set(2024, 0, 1): "+date.getTime());
        date.set(Calendar.YEAR, 2026); // 년을 2026으로 설정
        System.out.println("date.set(Calendar.YEAR, 2026): "+date.getTime());

        // 3. 필드 초기화
        System.out.println("------------using clear------------");
        date.clear(); // 1970-1-1 00:00:00(Epoch Time) 으로 초기화
        System.out.println("date.getTime() after date.clear(): "+date.getTime());
    }
}
```

```
------------using get------------
몇 년: 2024
몇 월:1
몇 일: 14
getTime(): Sun Jan 14 02:00:19 KST 2024
------------using set------------
date.set(2024, 0, 1): Mon Jan 01 02:00:19 KST 2024
date.set(Calendar.YEAR, 2026): Thu Jan 01 02:00:19 KST 2026
------------using clear------------
date.getTime() after date.clear(): Thu Jan 01 00:00:00 KST 1970
```

* ```Calendar``` 에서 두 날짜의 차이, 시간 변환 등의 사용법 찾아보기



## 3) ```java.time``` package

* 기존의 ```Date```와 ```Calender```의 단점 개선
* type-safe 함
* immutable

> 시간과 날짜를 계산하는 방법은 여러가지가 있음. 여러 방법을 찾아보면서 적용해보면서 차이를 알아가면 됨.

### 3-1) ```LocalDate```

* 시간 없이 Year-Month-Day를 다루기 위한 클래스
* [Java docs - ```LocalDate```](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)

[```LocalDateMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/LocalDateMain.java)

```java
public class LocalDateMain {
    public static void main(String[] args) {
        // 1. static factory methods

        System.out.println("---------------static factory methods---------------");
        LocalDate localDate = LocalDate.now();
        // now() : 현재 날짜의 LocalDate 객체
        System.out.println("LocalDate.now() = "+localDate); // 현재 날짜

        // of() : 년, 월, 일을 설정한 객체 만듬
        System.out.println("LocalDate.of(2023, 10, 20) = "+LocalDate.of(2023, 10, 20));

        // parse() : String을 파싱해서 객체를 만듬
        System.out.println("LocalDate.parse(\"2028-03-03\") = "+LocalDate.parse("2028-03-03"));

        // 2. calculation
        System.out.println("--------------------calculation--------------------");
        System.out.println("LocalDate.now() = "+localDate);
        // 날짜 더하기
        LocalDate nextDay = LocalDate.now().plusDays(1); // 하루를 더해서 나온 날짜
        System.out.println("LocalDate.now().plusDays(1) = "+nextDay);
        System.out.println("LocalDate.now().plusDays(40) = "+LocalDate.now().plusDays(40));
        System.out.println("LocalDate.now().plusYears(10) = "+LocalDate.now().plusYears(10)); // 10년을 더해서

        // 날짜 빼기
        LocalDate previousMonthDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("LocalDate.now().minus(1, ChronoUnit.MONTHS) = "+previousMonthDate);
        System.out.println("LocalDate.now().minusMonths(1) = "+LocalDate.now().minusMonths(1));

        // 요일 찾기
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek(); // 현재 날짜의 요일
        System.out.println("LocalDate.now().getDayOfWeek() = "+dayOfWeek);

        // 날짜의 해당일
        int day = LocalDate.of(2500, 4, 20).getDayOfMonth(); // 20일 이니깐 20 리턴
        System.out.println("LocalDate.of(2500, 4, 20).getDayOfMonth() = "+day);

        // 윤년(leap year) 확인
        System.out.println("LocalDate.now().isLeapYear() = "+LocalDate.now().isLeapYear()); // 윤년이면 true 반환

        // 첫번째 날 반환
        // 설정한 날짜를 해당 달의 첫번째 날로 수정
        LocalDate firstDayOfMonth = LocalDate.parse("2024-01-26").with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("LocalDate.parse(\"2024-01-26\").with(TemporalAdjusters.firstDayOfMonth()) = "+firstDayOfMonth);

        // 3. comparison
        System.out.println("---------------------comparison--------------------");
        boolean compare1 = LocalDate.parse("2024-01-04").isBefore(LocalDate.parse("2005-01-04"));
        System.out.println("LocalDate.parse(\"2024-01-04\").isBefore(LocalDate.parse(\"2005-01-04\")) = "+compare1);
        boolean compare2 = LocalDate.parse("2024-01-04").isAfter(LocalDate.parse("2005-01-04"));
        System.out.println("LocalDate.parse(\"2024-01-04\").isAfter(LocalDate.parse(\"2005-01-04\")) = "+compare2);
        
    }
}
```

```
---------------static factory methods---------------
LocalDate.now() = 2024-01-14
LocalDate.of(2023, 10, 20) = 2023-10-20
LocalDate.parse("2028-03-03") = 2028-03-03
--------------------calculation---------------------
LocalDate.now() = 2024-01-14
LocalDate.now().plusDays(1) = 2024-01-15
LocalDate.now().plusDays(40) = 2024-02-23
LocalDate.now().plusYears(10) = 2034-01-14
LocalDate.now().minus(1, ChronoUnit.MONTHS) = 2023-12-14
LocalDate.now().minusMonths(1) = 2023-12-14
LocalDate.now().getDayOfWeek() = SUNDAY
LocalDate.of(2500, 4, 20).getDayOfMonth() = 20
LocalDate.now().isLeapYear() = true
LocalDate.parse("2024-01-26").with(TemporalAdjusters.firstDayOfMonth()) = 2024-01-01
---------------------comparison---------------------
LocalDate.parse("2024-01-04").isBefore(LocalDate.parse("2005-01-04")) = false
LocalDate.parse("2024-01-04").isAfter(LocalDate.parse("2005-01-04")) = true
```



### 3-2) LocalTime

* 시간만 다루고 싶을 때 사용
* [Java docs - ```LocalTime```](https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html)

[```LocalTime.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/LocalTimeMain.java)

```java
public class LocalTimeMain {
    public static void main(String[] args) {
        System.out.println("---------------static factory methods---------------");
        LocalTime currentTime = LocalTime.now();
        System.out.println("LocalTime.now() = "+currentTime); // 현재 시간
        System.out.println("LocalTime.of(20, 50) = "+LocalTime.of(20, 50));
        System.out.println("LocalTime.parse(\"09:30\") = "+LocalTime.parse("09:30")); // 시간 파싱 해서 사용
        System.out.println("LocalTime.parse(\"22:17\") = "+LocalTime.parse("22:17"));
        System.out.println("LocalTime.parse(\"00:03\") = "+LocalTime.parse("00:03"));

        // 계산
        System.out.println("--------------------calculation---------------------");
        System.out.println("LocalTime.of(3, 30) = "+LocalTime.of(3, 30));
        System.out.println("LocalTime.of(3, 30).plus(2, ChronoUnit.HOURS) = "+LocalTime.of(3, 30).plus(2, ChronoUnit.HOURS));
        System.out.println("LocalTime.of(3, 30).plusHours(2) = "+ LocalTime.of(3, 30).plusHours(2));
    }
}
```

```
---------------static factory methods---------------
LocalTime.now() = 21:46:27.992
LocalTime.of(20, 50) = 20:50
LocalTime.parse("09:30") = 09:30
LocalTime.parse("22:17") = 22:17
LocalTime.parse("00:03") = 00:03
--------------------calculation---------------------
LocalTime.of(3, 30) = 03:30
LocalTime.of(3, 30).plus(2, ChronoUnit.HOURS) = 05:30
LocalTime.of(3, 30).plusHours(2) = 05:30
```

* 비교는 ```LocalDate```와 마찬가지로 ```isBefore```, ```isAfter``` 등을 사용한다



### 3-3) ```LocalDateTime```

* ```LocalDate```, ```LocalTime``` 둘다 사용하는 경우 (날짜와 시간 둘다 표현해야 하는 경우)
* 표현 방법은 [```ISO-8601```](https://ko.wikipedia.org/wiki/ISO_8601) 을 따른다
* [Java docs - `LocalDateTime`](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html)

[```LocalDateTimeMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/LocalDateTimeMain.java)

```java
public class LocalDateTimeMain {
    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("LocalDateTime.now() = "+dateTime); // 현재 날짜와 시간, ISO-8601 standard
        System.out.println("LocalDateTime.parse(\"2030-10-15-0T04:20:00\") = "+LocalDateTime.parse("2020-10-15T04:20:00"));
        System.out.println("LocalDateTime.of(2020, Month.OCTOBER, 15, 4, 20) = "+LocalDateTime.of(2020, Month.OCTOBER, 15, 4, 20));
        System.out.println("LocalDateTime.now().getMonth() = "+LocalDateTime.now().getMonth()); // 현재 1월이니 January
    }
}
```

```
LocalDateTime.now() = 2024-01-14T22:57:13.696
LocalDateTime.parse("2030-10-15-0T04:20:00") = 2020-10-15T04:20
LocalDateTime.of(2020, Month.OCTOBER, 15, 4, 20) = 2020-10-15T04:20
LocalDateTime.now().getMonth() = JANUARY
```



### 3-4) ```ZonedDateTime```

* 타임존을 적용한 ```DateTime```
* 타임존(Timezone)은 동일한 로컬 시간을 따르는 지역
  * 예시 : ```UTC```, ```KST```, ```Asia/Seoul```, ```America/New_York```
* [일광 절약 시간제(Daylight Saving Time)](https://ko.wikipedia.org/wiki/%EC%9D%BC%EA%B4%91_%EC%A0%88%EC%95%BD_%EC%8B%9C%EA%B0%84%EC%A0%9C)을 알아서 처리 해줌
* [Java docs - `ZonedDateTime`](https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html)

[```ZonedDateTimeMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/ZonedDateTimeMain.java)

```java
public class ZonedDateTimeMain {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        System.out.println("ZoneId.of(\"Asia/Seoul\") = "+zoneId); // Asia/Seoul

        // Create a ZonedDateTime for the current date and time in the system default time zone
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Create a ZonedDateTime for a specific date and time in a specific time zone
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 14, 12, 0);
        ZoneId zoneId2 = ZoneId.of("America/New_York");

        ZonedDateTime specificDateTime = ZonedDateTime.of(localDateTime, zoneId2);
        System.out.println("Specific Date Time in New York: " + specificDateTime);

        // Converting ZonedDateTime to another time zone
        ZoneId zoneId3 = ZoneId.of("Europe/London");
        ZonedDateTime londonDateTime = specificDateTime.withZoneSameInstant(zoneId3);
        System.out.println("Specific Date Time in London: " + londonDateTime);

        // Offset calculation
        System.out.println("----------offset calculation----------");
        ZoneOffset offset = ZoneOffset.of("+03:00"); // +3hrs
        System.out.println("LocalDateTime.of(2022, 1, 14, 12, 0) = "+localDateTime);
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, offset);
        System.out.println("OffsetDateTime.of(localDateTime, offset) = "+offsetDateTime);
    }
}
```

```
ZoneId.of("Asia/Seoul") = Asia/Seoul
Current Date and Time: 2024-01-14T23:25:59.858+09:00[Asia/Seoul]
Specific Date Time in New York: 2022-01-14T12:00-05:00[America/New_York]
Specific Date Time in London: 2022-01-14T17:00Z[Europe/London]
----------offset calculation----------
LocalDateTime.of(2022, 1, 14, 12, 0) = 2022-01-14T12:00
OffsetDateTime.of(localDateTime, offset) = 2022-01-14T12:00+03:00
```



## 4) Period, Duration

* 날짜와 시간 사이의 기간을 표현하기 위해 ```Period```, ```Duration``` 클래스 사용
* type-safe 함
* [```TemporalAmount```](https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAmount.html) 구현하고 있음
* [```Period```](https://docs.oracle.com/javase/8/docs/api/java/time/Period.html) : 두 날짜 사이의 기간
* [```Duration```](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html) : 두 시간 사이의 간격, 비교

[```DateTimePDMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/DateTimePDMain.java)

```java
public class DateTimePDMain {
    public static void main(String[] args) {
        System.out.println("---------Using Period---------");
        LocalDate startDate = LocalDate.parse("2023-09-21");
        LocalDate endDate = LocalDate.parse("2024-01-15");

        // getDays()는 총 기간을 일로 환산해서 계산하는 것이 아니라 day 값만 반환
        // 2023-09-21 ~ 2024-01-15 -> 0년-3개월-25일
        int period1 = Period.between(startDate, endDate).getDays();
        // ChronoUnit.DAYS를 이용해서 총 일수 계산
        long period2 = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Period.between(startDate, endDate).getDays() = "+period1);
        System.out.println("ChronoUnit.DAYS.between(startDate, endDate) = "+period2);

        System.out.println("--------Using Duration--------");
        LocalTime startTime = LocalTime.parse("08:15:00");
        LocalTime endTime = LocalTime.parse("15:45:00");
        LocalTime endTime2 = startTime.plus(Duration.ofMinutes(30)); // startTime 30분 이후

        long duration1 = Duration.between(startTime, endTime).getSeconds();
        long duration2 = ChronoUnit.SECONDS.between(startTime, endTime);
        long duration3 = ChronoUnit.SECONDS.between(startTime, endTime2);

        System.out.println("Duration.between(startTime, endTime).getSeconds() = "+duration1);
        System.out.println("ChronoUnit.SECONDS.between(startTime, endTime) = "+duration2);
        System.out.println("ChronoUnit.SECONDS.between(startTime, endTime2) = "+duration3+" (30분 차이)");
        
    }
}
```

```
---------Using Period---------
Period.between(startDate, endDate).getDays() = 25
ChronoUnit.DAYS.between(startDate, endDate) = 116
--------Using Duration--------
Duration.between(startTime, endTime).getSeconds() = 27000
ChronoUnit.SECONDS.between(startTime, endTime) = 27000
ChronoUnit.SECONDS.between(startTime, endTime2) = 1800 (30분 차이)
```



## 5) ```Instant```

* ```Instant``` 클래스를 이용해서 ```Date```, ```Calendar``` 클래스과 변환이 가능
* 시간을 타임스탬프로 다루기 위해 사용 (한 순간의 시간을 다른 순간의 시간과 비교)
  * 정밀한 시간 측정이 필요한 경우 사용
* [Java docs - ```Instant```](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html)

[```InstantMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/InstantMain.java)

```java
public class InstantMain {
    public static void main(String[] args) {
        // 1. 두 Instant 사이 계산
        System.out.println("----------Calculate Two Instants----------");
        // Get the current instant
        Instant now = Instant.now();
        System.out.println("Current Instant: " + now);

        // sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the instant after the operation
        Instant later = Instant.now();
        System.out.println("Later Instant: " + later);

        // Calculate the duration between two instants
        Duration duration = Duration.between(now, later);
        System.out.println("Duration: " + duration.getSeconds() + " seconds");

        // 2. Date -> LocalDate 변환
        System.out.println("------------Date to LocalDate-------------");
        // Get the current Date
        Date date = new Date();

        // Convert Date to Instant
        Instant instant = date.toInstant();

        // Convert Instant to LocalDate
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("Date: " + date);
        System.out.println("LocalDate: " + localDate);

        // 3. LocalDateTime -> Date 변환
        System.out.println("-----------LocalDateTime to Date-----------");

        // Get the current LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();

        // Convert LocalDateTime to Date using Instant
        Instant instant2 = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date2 = Date.from(instant2); // from : Instant object -> Date object
        
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("Date: " + date2);
    }
}
```

```
----------Calculate Two Instants----------
Current Instant: 2024-01-14T20:45:02.810Z
Later Instant: 2024-01-14T20:45:04.856Z
Duration: 2 seconds
------------Date to LocalDate-------------
Date: Mon Jan 15 05:45:04 KST 2024
LocalDate: 2024-01-15
-----------LocalDateTime to Date-----------
LocalDateTime: 2024-01-15T05:45:04.883
Date: Mon Jan 15 05:45:04 KST 2024
```



## 6) ```Formatter```

* 미리 정의된 형식 사용
* [Java docs - ```DateTimeFormatter```](https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html)
* ```ISO_DATE```, ```MEDIUM```등 은 필요한 형식에 따라 설정해서 사용하면 됨
* ```parse()``` : 문자열을 파싱해서 ```LocalDateTime```의 인스턴스로 바꿔줌 
* ```format()``` : ```LocalDateTime``` 인스턴스를 문자열로 바꿔 줌
  * 위의 ```LocalDateTime```말고도 ```Date``` 등에도 사용


[```FormatterMain.java```](https://github.com/seungki1011/Data-Engineering/blob/main/java/start-java/src/main/java/de/java/datetime/FormatterMain.java)

```java
public class FormatterMain {
    public static void main(String[] args) {
        // Creating a LocalDateTime instance for January 25, 2022, at 6:30 AM
        LocalDateTime localDateTime = LocalDateTime.of(2030, Month.JANUARY, 15, 9, 30);

        // Formatting the LocalDateTime using ISO_DATE pattern
        String localDateString = localDateTime.format(DateTimeFormatter.ISO_DATE);

        // Formatting the LocalDateTime using a localized pattern with Medium style and Korean locale
        String formattedDateTime = localDateTime.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.KOREA)
        );

        System.out.println("Before Format : "+localDateTime);
        System.out.println("After Format : "+formattedDateTime);

    }
}
```

```
Before Format : 2030-01-15T09:30
After Format : 2030. 1. 15 오전 9:30:00
```



## Further Reading

* thread safety
  * immutablity and thread safety
* ```DecimalFormat```
* ```SimpleDateFormat```



## 참고

---

1. [자바의 정석-기초편](https://www.youtube.com/user/MasterNKS)
1. [패스트 캠퍼스 - 한번에 끝내는 데이터 엔지니어링](https://fastcampus.co.kr/data_online_engineering)
1. [Wikipedia - Unix Time](https://en.wikipedia.org/wiki/Unix_time)
1. [Java docs](https://docs.oracle.com/javase/8/docs/api/overview-summary.html)

