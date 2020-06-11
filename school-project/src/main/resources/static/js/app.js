(function() {
	'use strict';
	window.addEventListener('load', function() {
		var forms = document.getElementsByClassName('needs-validation');
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
})();
$(document).ready(function() {
	$('input[name*="phone"]').mask('(000) 000 0000');
	$.fn.datepicker.defaults.language = 'tr';
	$('.datepicker').datepicker({
	   format: "dd/mm/yyyy",
	   autoclose: true
	});


	$('a.userEdit').click(function(e){
		var id = $(e.currentTarget).data('id');
		$.ajax({
	        type: "GET",
	        contentType: "application/json",
	        url: "/admin/user/"+id,
	        dataType: 'json',
	        cache: false,
	        success: function (data) {
	        	var modal = $('#userEditModal');
	        	modal.find('#userId').val(data.id);
	        	modal.find('#email').val(data.email);
	        	modal.find('#expireDate').datepicker('update', data.expireDate);
	        	modal.modal();
	        },
	        error: function (e) {
	            console.log("ERROR : ", e);
	        }
	    });
	});
	
	function toggleAlert(){
	    $(".alert-success").toggleClass('d-none'); 
	    return false; 
	}

	$('#bsalert').on('close.bs.alert', toggleAlert)
	
	$('#userEditConfirm').click(function(e){
		$('#userEditForm').submit();
	});
	

});