//Create reference to Firebase Database
//const databaseRef = firebase.database().ref().child();


function logIn(brugernavn, password) {
    firebase.database().ref('User/').set({
        Username: brugernavn,
        Password: password,
    });
    var url = "http://localhost:8080/FM/spil.jsp";
    $(location).attr('href', url);
}