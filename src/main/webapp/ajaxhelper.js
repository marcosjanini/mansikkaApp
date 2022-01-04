/**
 * 
 */

function getDataFromServer(URL, request) {

	fetch(URL)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw "HTTP status code is " + response.status;
			}
		})
		//	.then(status => processResponseStatus(status))
		//	.then(data => request(data))
		.then(clientList => request(clientList))
		.catch(errorText => alert("getDataFromServer failed: " + errorText));


}

 function postDataToServer(URL, requestParameters, callBack){
	console.log(URL);
	
	console.log(requestParameters);

	console.log(callBack);

	let requestOptions = {
		method: "POST",
		headers: { "Content-Type": "application/x-www-form-urlencoded" },
		body: requestParameters
	};
	
	fetch(URL, requestOptions)
		.then(response => {
			if (response.ok) {
				return response.json();

			} else {
				throw "HTTP status code is " + response.status;
			}
		})
		.then(result => callBack(result))
		.catch(errorText => alert("getDataFromServer failed: " + errorText));
}