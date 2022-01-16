
$.ajax({
    type: 'HEAD', // 获取头信息，type=HEAD即可
    url : window.location.href,
    async:false,
    success:function (data, status, xhr) {
        var lastUrl = xhr.getResponseHeader("lastUrl");
        console.log('lastUrl is '+lastUrl)
        if(lastUrl != null && !lastUrl.match("register")){
            location.href = lastUrl;
        }
    }
});