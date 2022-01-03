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
/* .then((responseJson) => {
})
.catch((error) => {
	
  console.log(error)
});
} 

	fetch(url, requestOptions)
		.then(response => {
			if (response.ok) {
				console.log("response ok");
				return response.json();

			} else {
				throw "HTTP status code is " + response.status;
			}
		})
		console.log("fetch 1")
		
		//this gives me error:
		.then(result => callBack(result))
		console.log("fetch 2")
		.catch(errorText => alert("postDataToServer failed: " + errorText));
		console.log("fetch 3")

} 
function postDataToServer(URL, requestParameters, callBack){
	
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
		
}*/