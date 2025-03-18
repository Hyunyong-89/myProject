
//TODO
//history Back 추가

$(document).ready(function(){
	
	$("#stDate, #endDate").datepicker({
		showButtonPanel: true,
		currentText: '오늘 날짜',
		closeText: '닫기',
		changeMonth: true,
		changeYear: true,
		dateFormat: "yy-mm-dd"

	});

});

$(document).on('keyup','input[text-form=numeric]',function(event){
	this.value = this.value.replace(/[^0-9]/g,'');   // 입력값이 숫자가 아니면 공백
	this.value = this.value.replace(/,/g,'');          // ,값 공백처리
	this.value = this.value.replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 정규식을 이용해서 3자리 마다 , 추가 	
}); 

function txtFrmNum(num){
	let number = num.toString();;
	number = number.replace(/[^0-9]/g,'');   // 입력값이 숫자가 아니면 공백
	number = number.replace(/,/g,'');          // ,값 공백처리
	number = number.replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 정규식을 이용해서 3자리 마다 , 추가 
	return number;
}


// form object JSON 변환
function objectifyForm(formArray) {
    //serialize data function
    var returnArray = {};
    for (var i = 0; i < formArray.length; i++){
        returnArray[formArray[i]['name']] = formArray[i]['value'];
    }
    return returnArray;
}