package conversion;

public class utils {
	public static String getRomanNumber(int number) {
		//待完成，个十百使用循环获得
		char[] romanNumber = {'I','V','X','L','C','D','M'}; 
		String sReturn = "";
		String sqian = "";
		String sbai = "";
		String sshi = "";
		String sge = "";
		
		if(number/1000!=0) {//获得number千位
			int qian = number/1000;
			for(int i =0 ; i < qian ; i++) {
				sqian += romanNumber[6];
			}							
		}
		if(number/100!=0) {//获得number百位
			int bai = number%1000/100;
			if(bai<4) {
				for(int i =0 ;i<bai;i++) {
					sbai += romanNumber[4];
				}
			}else if(bai<5) {
				for(int i =0 ;i<(5-bai);i++) {
					sbai += romanNumber[4];
				}
				sbai += romanNumber[5];
			}else if(bai<9) {
				sbai += romanNumber[5];
				for(int i =0 ;i<(bai-5);i++) {
					sbai += romanNumber[4];
				}
			}else {
				sbai = romanNumber[4]+""+romanNumber[6];
			}			
		}	
		if(number/10!=0) {//获得number十位
			int shi = number%100/10;
			if(shi<4) {
				for(int i =0 ;i<shi;i++) {
					sshi += romanNumber[2];
				}			
			}else if(shi<5) {
				for(int i =0 ;i<(5-shi);i++) {
					sshi += romanNumber[2];
				}
				sshi += romanNumber[3];
			}else if(shi<9) {
				sshi += romanNumber[3];
				for(int i =0 ;i<(shi-5);i++) {
					sshi += romanNumber[2];
				}
			}else {
				sshi = romanNumber[2]+""+romanNumber[4];
			}
		}		
		//获得number个位
		int ge = number%10;
		if(ge<4) {
			for(int i =0 ;i<ge;i++) {
				sge += romanNumber[0];
			}			
		}else if(ge<5) {
			for(int i =0 ;i<(5-ge);i++) {
				sge += romanNumber[0];
			}
			sge += romanNumber[1];
		}else if(ge<9) {
			sge += romanNumber[1];
			for(int i =0 ;i<(ge-5);i++) {
				sge += romanNumber[0];
			}
		}else {
			sge = romanNumber[0]+""+romanNumber[2];
		}
		sReturn = sqian + sbai + sshi + sge;
		return sReturn;
	}
	public static String getRomanNumberString(String str) {
		String[] symbol = {"."," ","-","/"};
		String[] sa = null;
		while(true) {			
			if(str.contains(symbol[0])) {
				sa = str.trim().split("\\"+symbol[0]);			
				break;
			}else if(str.contains(symbol[1])) {
				sa = str.trim().split(symbol[1]);
				break;
			}else if(str.contains(symbol[2])) {
				sa = str.trim().split(symbol[2]);
				break;
			}else if(str.contains(symbol[3])) {
				sa = str.trim().split(symbol[3]);
				break;
			}else {
				break;
			}			
		}
		String year = getRomanNumber(Integer.parseInt(sa[0]));
		String month = getRomanNumber(Integer.parseInt(sa[1]));
		String day = getRomanNumber(Integer.parseInt(sa[2]));
		return year+"."+month+"."+day;
	}
}
