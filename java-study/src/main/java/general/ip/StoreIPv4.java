package general.ip;

/**
 * IP与int转换
 * 存入数据库，如果需要按照区间查询ip，则需转为long类型，避免int为负数
 * @author javon
 *
 */
public class StoreIPv4 {
	
	public int ipv42int(String ip){
		String[] strings = ip.split("\\.");
		int a = Integer.valueOf(strings[0]);
		int b = Integer.valueOf(strings[1]);
		int c = Integer.valueOf(strings[2]);
		int d = Integer.valueOf(strings[3]);
		return (a << 24) | (b << 16) | (c << 8) | d;
	}
	
	
	public String int2ip(int num){
		int n0 = num >> 24 ;
		int n1 = num >> 16 & 0xFF;
		int n2 = num >> 8 & 0xFF;
		int n3 = num & 0xFF;
		return String.valueOf(n0) + "." 
				+ String.valueOf(n1) + "." 
				+ String.valueOf(n2) + "." 
				+ String.valueOf(n3);
	}
	
}
