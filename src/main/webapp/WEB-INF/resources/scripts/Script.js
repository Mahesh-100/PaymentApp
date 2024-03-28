/**
 * 
 */


document.getElementById("bankDetailsForm").addEventListener("submit", function(event) {
            var bankName = document.getElementById("bankName").value.trim();
            var accountNumber = document.getElementById("accountNumber").value.trim();
            var ifscCode = document.getElementById("ifscCode").value.trim();

            if (!validateBankName(bankName)) {
                alert("Please enter a valid bank name.");
                event.preventDefault();
            }

            if (!validateAccountNumber(accountNumber)) {
                alert("Please enter a valid account number.");
                event.preventDefault();
            }

            if (!validateIFSCCode(ifscCode)) {
                alert("Please enter a valid IFSC code.");
                event.preventDefault();
            }
        });

        function validateBankName(bankName) {
            // Basic validation - can be extended based on requirements
            return bankName.length > 0;
        }

        function validateAccountNumber(accountNumber) {
            // Basic validation - can be extended based on requirements
            return /^[0-9]{9,14}$/.test(accountNumber); // Assuming account number is between 9 to 18 digits
        }

        function validateIFSCCode(ifscCode) {
            // Basic validation - can be extended based on requirements
            return /^[A-Za-z]{4}[0][0-9]{6}$/.test(ifscCode); // Assuming IFSC code format is AAAA0XXXXXX
        }




document.getElementById('myForm').addEventListener('submit', function (event) {
            var isValid = validateForm();
            if (!isValid) {
                event.preventDefault();
            }
        });
        
         function validateForm() {
            var isValid = true;
            
             // Name validation
            var name = document.getElementById('fullName').value.trim();
            if (name === '') {
                isValid = false;
                document.getElementById('nameError').innerText = 'Name is required';
            } else if (/^\s|\s$|\s{2,}/.test(name)) {
                isValid = false;
                document.getElementById('nameError').innerText = 'Invalid name format';
            }
            else {
                document.getElementById('nameError').innerText = '';
            }
            // Contact validation
            var contact = document.getElementById('phoneNumber').value.trim();
            var contactPattern = /^[0-9]{10}$/;
            if (!contactPattern.test(contact)) {
                isValid = false;
                document.getElementById('contactError').innerText = 'Enter a valid 10-digit phone number';
            } else {
                document.getElementById('contactError').innerText = '';
            }

            // Email validation
            var email = document.getElementById('email').value.trim();
            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                isValid = false;
                document.getElementById('emailError').innerText = 'Enter a valid email address';
            } else {
                document.getElementById('emailError').innerText = '';
            }
            
           return isValid;
           
    }
            

function validateAndRedirect(action) {
            var selectedAccount = document.querySelector('input[name="selectedAccount"]:checked');
            if (!selectedAccount) {
                alert("Please select an account before proceeding.");
                return false;
            }
            // Add logic to set the action parameter and submit the form
            document.getElementById('selectedAction').value = action;
            document.getElementById('accountForm').submit();
            return true;
        
  }

