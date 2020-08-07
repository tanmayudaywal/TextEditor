var customer = prompt('Please enter your name'); 
var companyName = prompt('Please enter your company name'); 
alert('Hello ' + (customer || companyName || 'Valued Customer'));
