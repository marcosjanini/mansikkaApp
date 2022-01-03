// studentList.js (This is the simple ES6 compliant version with no error handling) 

function main() {

getDataFromServer("http://localhost:8080/MansikkaApp/clients", printClients)
}

function printClients(clientList) {
	
	var divOutput = document.getElementById("data_table");
	var outputText = "<tr> <th>Id</th> <th>First name</th> <th>Last name</th> <th>Phone</th> <th>E-mail</th> <th>Tax Id</th> <th>Street</th> <th>Postcode</th> <th>City</th> </tr>";
	console.log(clientList);
	for (var client of clientList) {
		outputText += "<tr> <td>" + client.id + "</td>  <td>" + client.firstname + "</td> <td>" + client.lastname + "</td>  <td>" + client.phone + "</td>  <td>" + client.email + "</td> <td>" + client.taxId + "</td><td>" + client.streetaddress + "</td><td>" + client.postcode + "</td><td>" + client.city + "</td> </tr>";
	}

	divOutput.innerHTML = outputText;

	console.log("hei");
}

// Call the main function when the browser loads the HTML page
main();

// End