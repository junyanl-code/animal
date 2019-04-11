var loginFor = {
	logSession: $.cookie("LOGSESSION"),
	userName: "未登录",
	getUserInfo: function() {
		$.post("http://animal.actim.top:8092/data/login/check", {
			"LOGSESSION": $.cookie("LOGSESSION")
		}, function(data) {
			if(data && data.stat == "200") {
				loginFor.userName = data.userName;
				$(".userNameBar").text(data.userName);
			} else {
				location.href = "http://animal.actim.top:8092/data/loginPage/login1.html?redirectUrl=" + location.href;
				alert("您尚未登录");
			}
		}, "json").error(function() {
			alert("error");
			location.href = "http://animal.actim.top:8092/data/loginPage/login1.html?redirectUrl=" + location.href;
		});
	}
}