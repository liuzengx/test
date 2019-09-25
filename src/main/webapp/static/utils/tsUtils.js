/**
 * Created by majunpeng on 2017/3/20.
 */
var sysui = sysui || {};
var sysObj = sysObj || {};
var strFullPath=window.document.location.href;
var strPath=window.document.location.pathname;
var pos=strFullPath.indexOf(strPath);
var prePath=strFullPath.substring(0,pos);
var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
var path = prePath + postPath;

document.write('<script src="'+postPath+'/static/utils/sysDate.js" type="text/javascript"></script>');
document.write('<script src="'+postPath+'/static/utils/sysNumber.js" type="text/javascript"></script>');
document.write('<script src="'+postPath+'/static/utils/sysString.js" type="text/javascript"></script>');
document.write('<script src="'+postPath+'/static/utils/sysForm.js" type="text/javascript"></script>');


var tsUtils = (function ($) {
    var tmp = {};                        //用来存储一些临时变量

    var obj = {
        printHtml       :       '',
        version         :       '1.0',
        getExplorer     :       getExplorer,
        encodeBase64    :       encodeBase64,
		handleError     :       handleError,
        getRootPath     :       getRootPath,
		getProjectPath	:		getProjectPath,
		removeIframe    :       removeIframe,
		isUrl			:		isUrl,
		setIframeHeight	:		setIframeHeight
    };
    return obj;

    function handleError(errorMsg,detailMsg){
        //var response = JSON.parse(responseText);
        var statusCode = XMLHttpRequest.status;
        layer.open({
            type:1,
            title:false,
            move:'.title',
            closeBtn:0,
            shadeClose:true,
            skin:'error-window',
            area:['400px','auto'],
            content:'<div style="width: 100%;height: 35px;background: #F8F8F8"><div class="left title" style="line-height: 35px;width:80%;text-indent: 1em"><i class="icon iconfont icon-icon" style="color: darkred;"></i>&nbsp;江苏税软</div><div class="right" style="width: 35px;line-height: 35px;text-align: center"><i class="icon iconfont icon-tuichu" style="cursor: pointer"></i></div><div class="clear"></div></div>'+
            '<div class="error-content" style="width: 100%;height: auto;min-height:80px;text-indent: 2em;padding: 5px;">'+ errorMsg +'</div>' +
            '<div class="error-detail" style="width: 100%;height: 30px;background: #F8F8F8"><div class="left" style="width: 70%;height: 30px;line-height: 30px;text-indent: 2em">详细信息</div><div class="right" style="width: 7%;height: 30px;line-height: 30px"><i style="cursor:pointer" class="icon iconfont icon-jiantouxia"></i></div><div class="clear"></div></div>',
            success:function () {
                $('.error-detail i').on('click',function () {
                    var height = $('.error-window').attr('height');
                    var expandHeight = height + 105;

                    if($(this).hasClass('icon-jiantouxia')){
						$(this).removeClass('icon-jiantouxia').addClass('icon-jiantoushang');
						$('.error-window').animate({height:expandHeight + 'px'},200);
						$('.error-window').append('<div class="error-detail-window" style="width:100%;height: 100px;text-indent: 2em;padding-top: 5px;padding-left: 5px;overflow: auto">'+detailMsg+'</div>');
                    }else{
						$(this).removeClass('icon-jiantoushang').addClass('icon-jiantouxia');
						$('.error-detail-window').remove();
						$('.error-window').animate({height:height + 'px'},200);
                    }
				});

                $('i.icon-tuichu').on('click',function () {
                    layer.close(layer.index);
				})


			}
        })
    }

    /**
     * base64转码解码
     * @param input
     * @returns {string}
     * 注：外部一般不调用此方法
     */
    function encodeBase64(input) {
        var _keyStr= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;

        input = encode_utf_8(input);

        while (i < input.length) {

            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);

            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;

            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }

            output = output +
                _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +
                _keyStr.charAt(enc3) + _keyStr.charAt(enc4);

        }

        return output;
    }

    /**
     * utf-8转码
     * @param string
     * @returns {string}
     * 注:外部一般不调用此方法
     */
    function encode_utf_8(string) {
        string = string.replace(/\r\n/g,"\n");
        var utftext = "";

        for (var n = 0; n < string.length; n++) {

            var c = string.charCodeAt(n);

            if (c < 128) {
                utftext += String.fromCharCode(c);
            }
            else if((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            }
            else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }

        }

        return utftext;
    }

    /**
     * 获取浏览器类型
     * @returns {*}
     * 注:获取浏览器类型  返回字符串  分别为  'ie' 'Firefox'  'Chrome'  'Opera'  'Safari'
     */
    function  getExplorer() {
        var explorer = window.navigator.userAgent ;
        //ie
        if (explorer.indexOf("MSIE 8.0") > 0) {
            return 'ie8';
        }
        else if(explorer.indexOf("MSIE 9.0") >0){
            return 'ie9';
        }
        //firefox
        else if (explorer.indexOf("Firefox") >= 0) {
            return 'Firefox';
        }
        //Chrome
        else if(explorer.indexOf("Chrome") >= 0){
            return 'Chrome';
        }
        //Opera
        else if(explorer.indexOf("Opera") >= 0){
            return 'Opera';
        }
        //Safari
        else if(explorer.indexOf("Safari") >= 0){
            return 'Safari';
        }

        else{
            return 'ie';
        }
    }

    /**判断对象是否为空*/
    function isEmpty(obj) {
        if(obj==""||obj==undefined||obj==null){
            return true;
        }else {
            return false;
        }
    }
    /**转换为string类型*/
    function toString(obj) {
        if(isEmpty(obj)){
            return "";
        }else {
            return obj.toString();
        }
    }

	/**
     * 获得根目录
	 * @returns {string}
	 */
	function getRootPath() {
		var path = $('#path').val();
		return path;
	}

	/**
	 * 获得项目路径
	 */
	function getProjectPath(){
		var path = $('#path').val();
		var scheme = $('#scheme').val();
		var serverName = $('#serverName').val();
		var serverPort = $('#serverPort').val();
		var basePath = scheme + '://' + serverName +':'+ serverPort + path +'/';
		return basePath;
	}

	/**
     * 关闭当前iframe
	 */
	function removeIframe(){
		var topWindow = $(window.parent.document),
			iframe = topWindow.find('#iframe_box .show_iframe'),
			tab = topWindow.find(".acrossTab li"),
			showTab = topWindow.find(".acrossTab li.active"),
			showBox=topWindow.find('.show_iframe:visible'),
			i = showTab.index();
		tab.eq(i-1).addClass("active");
		tab.eq(i).remove();
		iframe.eq(i-1).show();
		iframe.eq(i).remove();
	}

	/**
	 * 判断是否是url
	 * @param str
	 * @returns {boolean}
	 */
	function isUrl(str){
		if(str.indexOf('/') == -1){
			return false;
		}else{
			return true;
		}
	}

	function setIframeHeight(){
		var height = window.parent.document.getElementById('iframe_box').offsetHeight;
		$('body').css('height',height);
	}
})(jQuery);