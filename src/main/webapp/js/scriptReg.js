 function Validate() {
        var pass1 = document.getElementById("pass").value;
        var pass2 = document.getElementById("rpass").value;
        if (pass1 != pass2) {
           alert("Passwords do not match.");
            return false;
        }
        return true;
    }