function formClient() {
        var form = document.forms["formClient"];
        var requestParameters =
                "&id=" + form["id"].value +
                "&firstname=" + form["firstname"].value +
                "&lastname=" + form["lastname"].value +
                "&phone=" + form["phone"].value +
                "&email=" + form["email"].value +
                "&taxId=" + form["taxId"].value +
                "&streetaddress=" + form["streetaddress"].value +
                "&postcode=" + form["postcode"].value +
                "&city=" + form["city"].value;
               
        var url = "http://localhost:8080/MansikkaApp/addClient";
       
        postDataToServer(url, requestParameters, processResponseStatus);
}

function processResponseStatus(data) {
        console.log("Status: " + data);
        if (data === 0) {
                alert("Client added!");
        }
        else if (data === 1) {
                alert("Cannot add the Client. Id already in use");
        }
        else {
                alert("Unknown error has occurred");
        }
}