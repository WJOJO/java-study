package general.ip;

/**
 * IP��intת��
 * �������ݿ⣬�����Ҫ���������ѯip������תΪlong���ͣ�����intΪ����
 * @author javons
 *
 */
public class StoreIPv4 {
	
	public int ipv42int(String ip){
		String[] strings = ip.split("\\.");
		int a = Integer.parseInt(strings[0]);
		int b = Integer.parseInt(strings[1]);
		int c = Integer.parseInt(strings[2]);
		int d = Integer.parseInt(strings[3]);
		return (a << 24) | (b << 16) | (c << 8) | d;
	}
	
	
	public String int2ip(int num){
		int n0 = num >> 24 ;
		int n1 = num >> 16 & 0xFF;
		int n2 = num >> 8 & 0xFF;
		int n3 = num & 0xFF;
		return n0 + "."
				+ n1 + "."
				+ n2 + "."
				+ n3;
	}
	
}
