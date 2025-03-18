package com.example.nrs.config;

public class Constants {

	//수행사 코드
	public static final String COM_CD_SK 	= "01"; //SK
	public static final String COM_CD_LG 	= "02"; //LG
	public static final String COM_CD_KCC 	= "03"; //KCC
	
	//사업자구분
	public static final String COM_CORPORATE_NAME  		= "법인"; //
	public static final String COM_INDIVIDUAL_NAME 		= "개인"; //
	public static final String COM_WITH_HOLODING_NAME	= "원천징수"; //
	public static final String COM_SECTION_ERROR		= "에러"; //
	
	//프로젝트 상태코드
	public static final String COM_PRJ_STAT_START 	= "0"; //정상
	public static final String COM_PRJ_STAT_END 	= "1"; //종료
	
	//세금계산서 시트 이름
    public static final String TAX_BILL_SHEET_NAME = "엑셀업로드양식";
	
    public static final String TAX_BILL_ROW_1 = "엑셀업로드양식(전자세금계산서-일반(영세율))";
    public static final String TAX_BILL_ROW_2 = "★주황색으로표시된부분은필수입력항목으로반드시입력하셔야합니다.\r\n" 
    										  + "★아래'항목설명'시트를참고하여작성하시기바랍니다.";
    public static final String TAX_BILL_ROW_3 = "★실제업로드할DATA는7행부터입력하여야합니다.최대100건까지입력이가능하나,발급은최대10건씩처리가됩니다.(100건초과자료는처리안됨)\r\n" 
    										  + "★임의로행을추가하거나삭제하는경우파일을제대로읽지못하는경우가있으므로,주어진양식안에반드시작성을하시기바랍니다.";
    public static final String TAX_BILL_ROW_4 = "★전자(세금)계산서종류는엑셀업로드양식에따라해당전자(세금)계산서종류코드를반드시입력하셔야합니다.\r\n"
    										  + "★품목은1건이상입력해야합니다.\r\n"
    										  + "★공급받는자등록번호는사업자등록번호,주민등록번호를입력할수있습니다.\r\n"
    										  + "외국인인경우'9999999999999'를입력하시고,비고란에외국인등록번호또는여권번호를입력하시기바랍니다.";
    public static final String TAX_BILL_ROW_5 = "";


    public static final String TAX_BILL_ROW_6_CELL_1  = "전자(세금)계산서종류 (01:일반,02:영세율)";
	public static final String TAX_BILL_ROW_6_CELL_2  = "작성일자";
	public static final String TAX_BILL_ROW_6_CELL_3  = "공급자등록번호 (\"\"-\"\"없이입력)";
	public static final String TAX_BILL_ROW_6_CELL_4  = "공급자 종사업장번호";
	public static final String TAX_BILL_ROW_6_CELL_5  = "공급자상호";
	public static final String TAX_BILL_ROW_6_CELL_6  = "공급자성명";
	public static final String TAX_BILL_ROW_6_CELL_7  = "공급자사업장주소";
	public static final String TAX_BILL_ROW_6_CELL_8  = "공급자업태";
	public static final String TAX_BILL_ROW_6_CELL_9  = "공급자종목";
	public static final String TAX_BILL_ROW_6_CELL_10 = "공급자이메일";
	public static final String TAX_BILL_ROW_6_CELL_11 = "공급받는자등록번호 (\"\"-\"\"없이입력)";
	public static final String TAX_BILL_ROW_6_CELL_12 = "공급받는자 종사업장번호";
	public static final String TAX_BILL_ROW_6_CELL_13 = "공급받는자상호";
	public static final String TAX_BILL_ROW_6_CELL_14 = "공급받는자성명";
	public static final String TAX_BILL_ROW_6_CELL_15 = "공급받는자사업장주소";
	public static final String TAX_BILL_ROW_6_CELL_16 = "공급받는자업태";
	public static final String TAX_BILL_ROW_6_CELL_17 = "공급받는자종목";
	public static final String TAX_BILL_ROW_6_CELL_18 = "공급받는자이메일1";
	public static final String TAX_BILL_ROW_6_CELL_19 = "공급받는자이메일2";
	public static final String TAX_BILL_ROW_6_CELL_20 = "공급가액";
	public static final String TAX_BILL_ROW_6_CELL_21 = "세액";
	public static final String TAX_BILL_ROW_6_CELL_22 = "비고";
	public static final String TAX_BILL_ROW_6_CELL_23 = "일자1(2자리,작성년월제외)";
	public static final String TAX_BILL_ROW_6_CELL_24 = "품목1";
	public static final String TAX_BILL_ROW_6_CELL_25 = "규격1";
	public static final String TAX_BILL_ROW_6_CELL_26 = "수량1";
	public static final String TAX_BILL_ROW_6_CELL_27 = "단가1";
	public static final String TAX_BILL_ROW_6_CELL_28 = "공급가액1";
	public static final String TAX_BILL_ROW_6_CELL_29 = "세액1";
	public static final String TAX_BILL_ROW_6_CELL_30 = "품목비고1";
	public static final String TAX_BILL_ROW_6_CELL_31 = "일자2(2자리,작성년월제외)";
	public static final String TAX_BILL_ROW_6_CELL_32 = "품목2";
	public static final String TAX_BILL_ROW_6_CELL_33 = "규격2";
	public static final String TAX_BILL_ROW_6_CELL_34 = "수량2";
	public static final String TAX_BILL_ROW_6_CELL_35 = "단가2";
	public static final String TAX_BILL_ROW_6_CELL_36 = "공급가액2";
	public static final String TAX_BILL_ROW_6_CELL_37 = "세액2";
	public static final String TAX_BILL_ROW_6_CELL_38 = "품목비고2";
	public static final String TAX_BILL_ROW_6_CELL_39 = "일자3(2자리,작성년월제외)";
	public static final String TAX_BILL_ROW_6_CELL_40 = "품목3";
	public static final String TAX_BILL_ROW_6_CELL_41 = "규격3";
	public static final String TAX_BILL_ROW_6_CELL_42 = "수량3";
	public static final String TAX_BILL_ROW_6_CELL_43 = "단가3";
	public static final String TAX_BILL_ROW_6_CELL_44 = "공급가액3";
	public static final String TAX_BILL_ROW_6_CELL_45 = "세액3";
	public static final String TAX_BILL_ROW_6_CELL_46 = "품목비고3";
	public static final String TAX_BILL_ROW_6_CELL_47 = "일자4(2자리,작성년월제외)";
	public static final String TAX_BILL_ROW_6_CELL_48 = "품목4";
	public static final String TAX_BILL_ROW_6_CELL_49 = "규격4";
	public static final String TAX_BILL_ROW_6_CELL_50 = "수량4";
	public static final String TAX_BILL_ROW_6_CELL_51 = "단가4";
	public static final String TAX_BILL_ROW_6_CELL_52 = "공급가액4";
	public static final String TAX_BILL_ROW_6_CELL_53 = "세액4";
	public static final String TAX_BILL_ROW_6_CELL_54 = "품목비고4";
	public static final String TAX_BILL_ROW_6_CELL_55 = "현금";
	public static final String TAX_BILL_ROW_6_CELL_56 = "수표";
	public static final String TAX_BILL_ROW_6_CELL_57 = "어음";
	public static final String TAX_BILL_ROW_6_CELL_58 = "외상미수금";
	public static final String TAX_BILL_ROW_6_CELL_59 = "영수(01),청구(02)";

    
    
    
    
}
