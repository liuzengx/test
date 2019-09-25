/**
 * Created by majunpeng on 2017/5/19.
 */

var sysForm = (function ($) {
	var obj = {
		getFormData		: 		getFormData,
		setForm			:		setForm,
		resetForm		:		resetForm
	};
	return obj;

	function getFormData(id){
		var data = {};
		$('#'+id+' input').each(function () {
			if($(this).attr('type') == 'checkbox'){
				if($(this).val() == 'on'){
					data[$(this).attr('name')] = '1';
				}else{
					data[$(this).attr('name')] = '0';
				}
			}else{
				data[$(this).attr('name')] = $(this).val();
			}
		});
		$('#'+id+' select').each(function () {
			data[$(this).attr('name')] = $(this).find('option:selected').attr('value')
		});
		return data;
	}

	function setForm(data) {
		$.each(data,function(key,value){
			if( $('#'+key).attr('type') == 'checkbox'){
				if(value == '1'){
					$('#'+key).attr('checked',true);
				}else{
					$('#'+key).attr('checked',false);
				}
			}else if($('#'+key).is('select')){
				var optionArr = $('#'+key+' option');
				$.each(optionArr,function (i,v) {
					var obj = $(this);
					if(obj.val() == value){
						obj.attr('selected',true);
					}
				});
			}else{
				$('#'+key).val(value);
			}
		})
	}

	function resetForm(id) {
		$('#'+id)[0].reset();
		$('#'+id+' :input').attr('value','');
	}
})(jQuery);