package general.leetcode;

/**
 * 8. �ַ���ת������ (atoi)
 * ������ʵ��һ�� atoi ������ʹ���ܽ��ַ���ת����������
 * ���ȣ��ú����������Ҫ�������õĿ�ͷ�ո��ַ���ֱ��Ѱ�ҵ���һ���ǿո���ַ�Ϊֹ��
 * ������Ѱ�ҵ��ĵ�һ���ǿ��ַ�Ϊ�����߸���ʱ���򽫸÷�����֮���澡���ܶ���������������������Ϊ�������������ţ������һ���ǿ��ַ������֣���ֱ�ӽ�����֮�������������ַ�����������γ�������
 * ���ַ���������Ч����������֮��Ҳ���ܻ���ڶ�����ַ�����Щ�ַ����Ա����ԣ����Ƕ��ں�����Ӧ�����Ӱ�졣
 * ע�⣺������ַ����еĵ�һ���ǿո��ַ�����һ����Ч�����ַ����ַ���Ϊ�ջ��ַ����������հ��ַ�ʱ������ĺ�������Ҫ����ת����
 * ���κ�����£����������ܽ�����Ч��ת��ʱ���뷵�� 0��
 * 
 * @author javon
 *
 */
public class Question8 {
	
	public int myAtoi(String str) {
		if(str == null)	return 0;
		str = str.trim();
		if("".equals(str) || "0".equals(str) || "+".equals(str) || "-".equals(str)) return 0;
		boolean isPositive;
		if(str.charAt(0)==(int)'+')
			{isPositive = true; str = str.substring(1);}
		else if(str.charAt(0) <= (int)'9' 
				&& str.charAt(0) >= (int)'0')
			isPositive = true;
		else if(str.charAt(0)==(int)'-')
			{isPositive = false; str = str.substring(1);}
		else
			return 0;
		
		while(str.startsWith("0")){
			str = str.substring(1);
		}
		if("".equals(str)) return 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <='9')	sb.append(str.charAt(i));
			else	break;
		}
		
		str = sb.toString();
		if("".equals(str)) return 0;
		if(str.length() < 10) return isPositive ? Integer.valueOf(str):-Integer.valueOf(str);
		else if(str.length() > 10) return isPositive ? Integer.MAX_VALUE:Integer.MIN_VALUE;
		else{
			int rem = Integer.parseInt(str.substring(str.length()-1));
			int result = Integer.parseInt(str.substring(0, str.length()-1));
			if((Integer.MAX_VALUE - rem) / 10 < result && isPositive){
				return Integer.MAX_VALUE;
			}
			if(! isPositive ){
				if((result > (rem + Integer.MIN_VALUE)/-10))
					return Integer.MIN_VALUE;
				else 
					return Integer.parseInt("-" +str);
			}
			return Integer.valueOf(str);
		}
    }
	
	public static void main(String[] args) {
		Question8 question8 = new Question8();
		System.out.println(Integer.MIN_VALUE);
		int myAtoi = question8.myAtoi("-2147483648");
		System.out.println(myAtoi);
	}

}
