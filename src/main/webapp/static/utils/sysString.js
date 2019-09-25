/**
 * Created by majunpeng on 2017/5/4.
 */
var sysString = (function ($) {
	var obj = {
		isEmpty				:		isEmpty,
		isEqual				:		isEqual,
		isEqualIgnorecase	:		isEqualIgnorecase,
		isNum				:		isNum,
		isChinese			:		isChinese
	};
	return obj;

	/**
	 * 判断字符串是否为空
	 * @param str
	 * @returns {boolean}
	 */
	function isEmpty(str) {
		if(str == '' || str == null || typeof str == undefined || !str){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 比较两个字符串是否相等
	 * @param str1
	 * @param str2
	 * @returns {boolean}
	 */
	function isEqual(str1,str2){
		if(str1 == str2)
			return true;
		else
			return false;
	}

	/**
	 * 忽略大小写判断字符串是否相同
	 * @param str1
	 * @param str2
	 * @returns {boolean}
	 */
	function isEqualIgnorecase(str1,str2) {
		if(str1.toUpperCase() == str2.toUpperCase())
			return true;
		else
			return false;
	}

	/**
	 * 判断是否是数字
	 * @param str
	 * @returns {boolean}
	 */
	function isNum(str) {
		if(str != null && str.length > 0 && isNaN(str) == false){
			return true
		}else {
			return false
		}
	}

	/**
	 * 判断是否是中文
	 * @param str
	 * @returns {boolean}
	 */
	function isChinese(str) {
		var reg = /^([u4E00-u9FA5]|[uFE30-uFFA0])*$/;
		if(reg.test(str)){
			return false
		}else{
			return true
		}
	}

	/**
	 * 将字符串转化为大写
	 * @param str
	 * @returns {string}
	 */
	function toUpperCase(str) {
		return str.toLocaleUpperCase();
	}

	/**
	 * 将字符串转化为小写
	 * @param str
	 * @returns {*|string}
	 */
	function toLowerCase(str) {
		return str.toLowerCase()
	}
})(jQuery);