package general.date;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.OffsetTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
	/**
	 * 获取当天日期
	 * @return
	 */
	public static LocalDate getDate(){
		return LocalDate.now();
	}
	
	/**
	 * 获取年月日
	 * @return
	 */
	public static String getYMD(){
		LocalDate localDate = getDate();
		return "year:"+localDate.getYear() + 
				" month:" + localDate.getMonthValue() + 
				" day:" + localDate.getDayOfMonth();
	}
	
	/**
	 * 获取特定的日期
	 * @param yyyy	年
	 * @param MM	月
	 * @param dd	日
	 * @return
	 */
	public static LocalDate getSpecialDate(int yyyy, int MM, int dd){
		LocalDate date = LocalDate.of(yyyy, MM, dd);
		return date;
	}
	
	/**
	 * 判断两个日期是否相等
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean equals(LocalDate date1, LocalDate date2){
		return date1.equals(date2);
	}
	
	/**
	 * 通过月日判读是否是生日
	 * @param birthday
	 * @return
	 */
	public static boolean isBirthday(LocalDate birthday){
		MonthDay birthdayMonthDay = MonthDay.of(birthday.getMonthValue(), birthday.getDayOfMonth());
		LocalDate now = getDate();
		MonthDay today = MonthDay.of(now.getMonthValue(), now.getDayOfMonth());
		return today.equals(birthdayMonthDay);
	}
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static LocalTime getTime(){
		return LocalTime.now();
	}
	
	/**
	 * 增加当前时间的小时数
	 * @param amount
	 * @return
	 */
	public static LocalTime plusHours(int amount){
		return getTime().plusHours(amount);
	}
	
	/**
	 * 获取下周的日期
	 * @return
	 */
	public static LocalDate nextWeek(){
		LocalDate date = getDate();
		LocalDate nextWeek = date.plus(1, ChronoUnit.WEEKS);
		return nextWeek;
	}
	
	/**
	 * 获取明年今天的日期
	 * @return
	 */
	public static LocalDate nextYear(){
		LocalDate now = getDate();
		return now.plus(1, ChronoUnit.YEARS);
	}

	/**
	 * 
	 * @return
	 */
	public static Clock getClock(){
		Clock systemUTC = Clock.systemUTC();//System.currentTimeInMillis()
		Clock systemDefaultZone = Clock.systemDefaultZone();//TimeZone.getDefault() 
		return systemDefaultZone;
	}
	
	
	/**
	 * 判断日期先后
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEarlier(LocalDate date1, LocalDate date2){
		return date1.isBefore(date2);
	}
	
	/**
	 * 处理时区
	 * @return
	 */
	public static ZonedDateTime getNewYorkTime(){
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime newYork = ZonedDateTime.of(now, ZoneId.of("America/New_York"));
		return newYork;
	}
	
	/**
	 *	指定年月  （信用卡过期时间）
	 * @param yyyy
	 * @param MM
	 * @return
	 */
	public static YearMonth getDeadline(int yyyy, int MM){
		YearMonth yearMonth = YearMonth.of(yyyy, MM);
		return yearMonth;
	}
	
	/**
	 * 当前日期是否是闰年
	 * @return
	 */
	public static boolean isLeapYear(){
		return getDate().isLeapYear();
	}
	
	/**
	 * 带偏移量的运算
	 * @param offset "+5:30"
	 * @return
	 */
	public static OffsetTime getDateTimeWithOffset(String offset){
		ZoneOffset zoneOffset = ZoneOffset.of(offset);
		OffsetTime offsetTime = OffsetTime.of(getTime(), zoneOffset);
		return offsetTime;
	}
	
	/**
	 * 获取时间戳   可以与date互转
	 * @return
	 */
	public static Instant getTimestamp(){
		return Instant.now();
	}
	
	/**
	 * 日期格式化
	 * @param yyyyMMdd
	 * @return
	 */
	public static LocalDate string2Date(String yyyyMMdd){
		LocalDate localDate = LocalDate.parse(yyyyMMdd, DateTimeFormatter.BASIC_ISO_DATE);
		return localDate;
	}
	
	/**
	 * 字符串转日期
	 * @param pattern
	 * @param date
	 * @return
	 */		
	public static LocalDate string2Date(String pattern, String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(date, formatter);
	}
	
	/**
	 * 日期转字符串
	 * @param datetime
	 * @param pattern
	 * @return
	 */
	public static String dateTime2String(LocalDateTime datetime, String pattern){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return datetime.format(formatter);
	}
	
}
