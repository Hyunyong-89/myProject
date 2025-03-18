

DATE = {
	
	getLastDay : function(year,month){
		let last = new Date(year,month,'0');
		return String(last.getDate()).padStart(2,"0");
	},
	
	getFirstDay : function(){
		return '1'		
	},
	
	getYearCalc : function(year, month, day, num, calc){
		let result = "";
		let date = new Date(year, month, day);
		
		if(calc == "+"){
			result = date.getFullYear() + num;
		}else if(calc == "-"){
			result = date.getFullYear() - num;
		}else{
			result = "error"
		}
		
		return result;
	},
	
	getDateCalc : function(year, month, day, num, calc, mode){
		let result = "";
		let date = new Date(year, month, day);
		
		if(calc == "+"){
			result = date.getMonth() + num;
		}else if(calc == "-"){
			result = date.getMonth() - num;
		}else{
			result = "error"
		}
		
		return String(result).padStart(2,"0");
	},
	
	getMonthCalc : function(year, month, day, num, calc){
		let result = "";
		let date = new Date(year, month, day);
		
		if(calc == "+"){
			result = date.getMonth() + num;
		}else if(calc == "-"){
			result = date.getMonth() - num;
		}else{
			result = "error"
		}
		
		return String(result).padStart(2,"0");
	},
	
	getDayCalc : function(year, month, day, num, calc){
		let result = "";
		let date = new Date(year, month, day);
		
		if(calc == "+"){
			result = date.getDate() + num;
		}else if(calc == "-"){
			result = date.getDate() - num;
		}else{
			result = "error"
		}
		
		return String(result).padStart(2,"0");
	},
	
	getDateCalc : function(year, month, day, num, calc){
		let result = "";
		let date = new Date(year, month, day);
		
		if(calc == "+"){
			result = date.getDate() + num;
		}else if(calc == "-"){
			result = date.getDate() - num;
		}else{
			result = "error"
		}
		
		return String(result).padStart(2,"0");
	},
	
	getSum(){
		
	}
	
} 