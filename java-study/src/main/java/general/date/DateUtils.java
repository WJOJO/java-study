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
	 * ��ȡ��������
	 * @return
	 */
	public static LocalDate getDate(){
		return LocalDate.now();
	}
	
	/**
	 * ��ȡ������
	 * @return
	 */
	public static String getYMD(){
		LocalDate localDate = getDate();
		return "year:"+localDate.getYear() + 
				" month:" + localDate.getMonthValue() + 
				" day:" + localDate.getDayOfMonth();
	}
	
	/**
	 * ��ȡ�ض�������
	 * @param yyyy	��
	 * @param MM	��
	 * @param dd	��
	 * @return
	 */
	public static LocalDate getSpecialDate(int yyyy, int MM, int dd){
		LocalDate date = LocalDate.of(yyyy, MM, dd);
		return date;
	}
	
	/**
	 * �ж����������Ƿ����
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean equals(LocalDate date1, LocalDate date2){
		return date1.equals(date2);
	}
	
	/**
	 * ͨ�������ж��Ƿ�������
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
	 * ��ȡ��ǰʱ��
	 * @return
	 */
	public static LocalTime getTime(){
		return LocalTime.now();
	}
	
	/**
	 * ���ӵ�ǰʱ���Сʱ��
	 * @param amount
	 * @return
	 */
	public static LocalTime plusHours(int amount){
		return getTime().plusHours(amount);
	}
	
	/**
	 * ��ȡ���ܵ�����
	 * @return
	 */
	public static LocalDate nextWeek(){
		LocalDate date = getDate();
		LocalDate nextWeek = date.plus(1, ChronoUnit.WEEKS);
		return nextWeek;
	}
	
	/**
	 * ��ȡ������������
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
	 * �ж������Ⱥ�
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isEarlier(LocalDate date1, LocalDate date2){
		return date1.isBefore(date2);
	}
	
	/**
	 * ����ʱ��
	 * @return
	 */
	public static ZonedDateTime getNewYorkTime(){
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime newYork = ZonedDateTime.of(now, ZoneId.of("America/New_York"));
		return newYork;
	}
	
	/**
	 *	ָ������  �����ÿ�����ʱ�䣩
	 * @param yyyy
	 * @param MM
	 * @return
	 */
	public static YearMonth getDeadline(int yyyy, int MM){
		YearMonth yearMonth = YearMonth.of(yyyy, MM);
		return yearMonth;
	}
	
	/**
	 * ��ǰ�����Ƿ�������
	 * @return
	 */
	public static boolean isLeapYear(){
		return getDate().isLeapYear();
	}
	
	/**
	 * ��ƫ����������
	 * @param offset "+5:30"
	 * @return
	 */
	public static OffsetTime getDateTimeWithOffset(String offset){
		ZoneOffset zoneOffset = ZoneOffset.of(offset);
		OffsetTime offsetTime = OffsetTime.of(getTime(), zoneOffset);
		return offsetTime;
	}
	
	/**
	 * ��ȡʱ���   ������date��ת
	 * @return
	 */
	public static Instant getTimestamp(){
		return Instant.now();
	}
	
	/**
	 * ���ڸ�ʽ��
	 * @param yyyyMMdd
	 * @return
	 */
	public static LocalDate string2Date(String yyyyMMdd){
		LocalDate localDate = LocalDate.parse(yyyyMMdd, DateTimeFormatter.BASIC_ISO_DATE);
		return localDate;
	}
	
	/**
	 * �ַ���ת����
	 * @param pattern
	 * @param date
	 * @return
	 */		
	public static LocalDate string2Date(String pattern, String date){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return LocalDate.parse(date, formatter);
	}
	
	/**
	 * ����ת�ַ���
	 * @param datetime
	 * @param pattern
	 * @return
	 */
	public static String dateTime2String(LocalDateTime datetime, String pattern){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return datetime.format(formatter);
	}
	
}
