/**
 * 페이징 처리 함수
 */
function pageFirst(selectTeamVal){
	if(selectTeamVal == ""){
		location.href = "./playerList.do?page=1";
	}else{
		location.href = "./playerList.do?page=1&teamVal="+selectTeamVal;
	}
}

function pagePrev(stagePage, countPage, selectTeamVal){
	var page = (stagePage - countPage) < 0 ? 1 : (stagePage-countPage);
	if(selectTeamVal == ""){
		location.href = "./playerList.do?page="+page;
	}else{
		location.href = "./playerList.do?page="+page+"&teamVal="+selectTeamVal;
	}
}

function page(page, selectTeamVal){
	console.log("페이지 선택 : ",page);
	console.log("선택 팀 : ",selectTeamVal);
	if(selectTeamVal == ""){
		location.href="./playerList.do?page="+page;
	}else{
		location.href="./playerList.do?page="+page+"&teamVal="+selectTeamVal;
	}
		
}

function pageNext(stagePage, countPage, selectTeamVal){
	console.log("선택 팀 : ",selectTeamVal);
	if(selectTeamVal == ""){
		location.href="./playerList.do?page="+(stagePage+countPage);
	}else{
		location.href="./playerList.do?page="+(stagePage+countPage)+"&teamVal="+selectTeamVal;
	}
}

function pageLast(totalPage, selectTeamVal){
	console.log("선택 팀 : ",selectTeamVal);
	if(selectTeamVal == ""){
		location.href="./playerList.do?page="+totalPage;
	}else{
		location.href="./playerList.do?page="+totalPage+"&teamVal="+selectTeamVal;
	}
}

function teamSearch(){
	var team = document.getElementById("teameSelect");
	var selectTeamVal = team.options[team.selectedIndex].value;
	console.log(selectTeamVal);
	if(selectTeamVal == "--팀 번호(조회)--"){
		location.href="./playerList.do";
	}else{
		location.href="./playerList.do?teamVal="+selectTeamVal;
	}
	
	
}