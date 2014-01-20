/**
 * encrypt/decrypt test
 */
$(document).ready(function() {

	$('#testBtn').click(function() {
		console.log('start ......');

		var password = 'trubo12344555';

		console.log('Password : ' + password);

		$.jCryption.authenticate(password, appPath + "/RsaServlet", appPath + "/AesServlet", function(AESKey) {

			$("#testBtn").val('Successfull !');

			console.log('...... end');
		}, function() {
			$("#testBtn").val('Failed !');

			console.log('...... end');
		});

		setTimeout('$("#testBtn").val("Test")', 5000);

		return false;
	});

	$.jCryption.defaultOptions = {
		submitElement: false,
		submitEvent: "click",
		getKeysURL: appPath + "/RsaServlet",
		handshakeURL: appPath + "/AesServlet",
		beforeEncryption: function() {
			return true;
		},
		postVariable: "jCryption",
		formFieldSelector: ":input"
	};

	$("#normal").jCryption();

});