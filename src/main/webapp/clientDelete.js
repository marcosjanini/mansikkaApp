function clientDelete() {


	var form = document.forms["formDeleteClient"];

	var requestParameters =
		"&id=" + form["id"].value;

	var url = "http://localhost:8080/MansikkaApp/deleteClient";

	postDataToServer(url, requestParameters, processResponseStatus)

	form["id"].value = "";

}
function clientSelectedDelete(clientId) {
	
	var requestParameters = "&id="+clientId;
	
	var url = "http://localhost:8080/MansikkaApp/deleteClient";

	postDataToServer(url, requestParameters, processResponseStatus)
}

function processResponseStatus(data) {
	console.log("Status: " + data);
	if (data === 1) {
		alert("Client deleted!");
	}
	else if (data === 0) {
		alert("Cannot delete the Client. Id not found");
	}
	else {
		alert("Unknown error has occurred");
	}
}