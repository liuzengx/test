/**
 * Created by majunpeng on 2017/5/4.
 */

var sysNumber = (function ($) {
	var obj = {
		isBin		: 		isBin
	};
	return obj;

	/**
	 * 判断数字是否为二进制
	 * @param val
	 * @returns {boolean}
	 */
	function isBin(val) {
		var re = /^[0-1]+$/;
		return re.test(val);
	}

	/**
	 * 判断数字是否为整数
	 * @param val
	 * @returns {boolean}
	 */
	function isInt(val) {
		var re = /^[-+]?[0-9]+$/;
		return re.test(val);
	}

	/**
	 * 判断是否为小叔
	 * @param val
	 * @returns {boolean}
	 */
	function isFloat(val) {
		if ( typeof val == 'string' ) val = val.replace(/\s+/g,'').replace(',','').replace('.','.');
		return (typeof val === 'number' || (typeof val === 'string' && val !== ''))&& !isNaN(Number(val));
	}

	/**
	 * 判断是否为十六进制数
	 * @param val
	 * @returns {boolean}
	 */
	function isHex(val) {
		var re = /^[a-fA-F0-9]+$/;
		return re.test(val);
	}


})(jQuery);