import React, { useState } from 'react';
import axios from 'axios';
import Link from 'next/link';

const SignupForm = () => {
  const [name, setName] = useState('');
  const [surname, setSurname] = useState('');
  const [username, setUsername] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const [nameError, setNameError] = useState('');
  const [surnameError, setSurnameError] = useState('');
  const [usernameError, setUsernameError] = useState('');
  const [phoneNumberError, setPhoneNumberError] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [confirmPasswordError, setConfirmPasswordError] = useState('');

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(`Submitted: ${name} ${surname} ${username} ${phoneNumber} ${email} ${password} ${confirmPassword}`);

    // Reset previous error messages
    setNameError('');
    setSurnameError('');
    setUsernameError('');
    setPhoneNumberError('');
    setEmailError('');
    setPasswordError('');
    setConfirmPasswordError('');

    const isValidEmail = (email: string) => {
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return emailPattern.test(email);
    };

    const isValidPhoneNumber = (phoneNumber: string) => {
      const phonePattern = /^\d{10}$/; // Matches exactly 10 digits
      return phonePattern.test(phoneNumber);
    };

    const MIN_LENGTH = 4;
    const MAX_LENGTH = 30;

    // Validation
    let hasError = false;

    if (name.trim() === '') {
      setNameError('Συμπληρώστε το όνομά σας.');
      hasError = true;
    } else if (name.trim().length < MIN_LENGTH || name.trim().length > MAX_LENGTH) {
      setNameError('Το όνομα πρέπει να είναι μεταξύ 4 και 30 χαρακτήρων.');
      hasError = true;
    }

    if (surname.trim() === '') {
      setSurnameError('Συμπληρώστε το επώνυμο σας.');
      hasError = true;
    } else if (surname.trim().length < MIN_LENGTH || surname.trim().length > MAX_LENGTH) {
      setSurnameError('Το επώνυμο πρέπει να είναι μεταξύ 4 και 30 χαρακτήρων.');
      hasError = true;
    }

    if (username.trim() === '') {
      setUsernameError('Συμπληρώστε το username σας.');
      hasError = true;
    } else if (username.trim().length < MIN_LENGTH || username.trim().length > MAX_LENGTH) {
      setUsernameError('Το username πρέπει να είναι μεταξύ 4 και 30 χαρακτήρων.');
      hasError = true;
    }

    if (phoneNumber.trim() === '') {
      setPhoneNumberError('Συμπληρώστε τον αριθμό τηλεφώνου σας.');
      hasError = true;
    } else if (!isValidPhoneNumber(phoneNumber)) {
      setPhoneNumberError('Ο αριθμός τηλεφώνου δεν είναι έγκυρος.');
      hasError = true;
    }

    if (email.trim() === '') {
      setEmailError('Συμπληρώστε το email σας.');
      hasError = true;
    } else if (!isValidEmail(email)) {
      setEmailError('Το email δεν είναι έγκυρο.');
      hasError = true;
    }

    if (password.trim() === '') {
      setPasswordError('Συμπληρώστε τον κωδικό σας.');
      hasError = true;
    }

    if (confirmPassword.trim() === '') {
      setConfirmPasswordError('Συμπληρώστε την επαλήθευση του κωδικού σας.');
      hasError = true;
    }

    if (password !== confirmPassword) {
      setConfirmPasswordError('Οι κωδικοί δεν είναι ίδιοι.');
      hasError = true;
    }

    if (hasError) {
      return;
    }

    try {
      // Making POST request to the backend API endpoint for registration
      const response = await axios.post('http://localhost:8080/api/register', {
        name,
        surname,
        username,
        phoneNumber,
        email,
        password,
        confirmPassword,
      });
      console.log('Registration response:', response.data);
      const { userDto, accessToken, refreshToken} = response.data;

      //console.log('acc: ', accessToken, 'ref: ', refreshToken, 'user: ', userDto)

      // Save tokens and user data in local storage
      window.localStorage.setItem('access_token', accessToken);
      window.localStorage.setItem('refresh_token', refreshToken);
      window.localStorage.setItem('user', JSON.stringify(userDto));

      console.log(window.localStorage.getItem('user'));
      
      setIsLoggedIn(true);
    } catch (error: any) {
      console.error('Registration error:', error);
      if (error.response) {
        if (error.response.data.message == "USER_EMAIL_EXISTS"){
          setErrorMessage('Υπάρχει ήδη χρήστης με αυτό το email.');
        }
        else if(error.response.data.message == "USER_NAME_EXISTS"){
          setErrorMessage('Υπάρχει ήδη χρήστης με αυτό το username.');
        } else{
          setErrorMessage('Υπήρξε κάποιο πρόβλημα με την εγγραφή. Δοκιμάστε ξανά.');
        }
        
      } else if (error.request) {
        // The request was made but no response was received
        console.log('No response received:', error.request);
      } else {
        // Something happened in setting up the request that triggered an error
        console.log('Error:', error.message);
      }
    }
  };

  if(isLoggedIn){
    return (
      <div className="flex w-full mb-auto rounded-xl mx-auto py-8 px-24 flex-col items-center">
      Εγγραφήκατε με επιτυχία!
      <br />
      <Link href="/">
          <button className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-2 px-4 mt-3 rounded">
            Προχωρήστε στην εφαρμογή
          </button>
      </Link>
    </div>
    );
  }

  return (
    <form onSubmit={handleSubmit}>
      <div className="flex w-full mb-auto bg-white rounded-xl mx-auto shadow-lg py-8 px-24 flex-col items-center">
        <h1 className="text-3xl mb-4 ">Δημιουργία Λογαριασμού</h1>
        {errorMessage && <p className="text-red-500 mb-4">{errorMessage}</p>}
        <div className="grid w-11/12 grid-cols-1 gap-3">
          <label>
            <input
              type="text"
              value={name}
              onChange={(event) => setName(event.target.value)}
              placeholder='Όνομα'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {nameError && <p className="text-red-500 whitespace-nowrap">{nameError}</p>}
          </label>
          <label>
            <input
              type="text"
              value={surname}
              onChange={(event) => setSurname(event.target.value)}
              placeholder='Επώνυμο'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {surnameError && <p className="text-red-500 whitespace-nowrap">{surnameError}</p>}
          </label>
          <label>
            <input
              type="text"
              value={username}
              onChange={(event) => setUsername(event.target.value)}
              placeholder='Username'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {usernameError && <p className="text-red-500 whitespace-nowrap">{usernameError}</p>}
          </label>
          <label>
            <input
              type="text"
              value={phoneNumber}
              onChange={(event) => setPhoneNumber(event.target.value)}
              placeholder='Τηλέφωνο'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {phoneNumberError && <p className="text-red-500">{phoneNumberError}</p>}
          </label>
          <label>
            <input
              type="email"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
              placeholder='Email'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {emailError && <p className="text-red-500">{emailError}</p>}
          </label>
          <label>
            <input
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              placeholder='Κωδικός Πρόσβασης'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {passwordError && <p className="text-red-500">{passwordError}</p>}
          </label>
          <label>
            <input
              type="password"
              value={confirmPassword}
              onChange={(event) => setConfirmPassword(event.target.value)}
              placeholder='Επιβεβαίωση Κωδικού'
              className="border border-gray-400 py-1 px-2 w-full"
            />
            {confirmPasswordError && <p className="text-red-500">{confirmPasswordError}</p>}
          </label>
        </div>
        <button type="submit" className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-2 px-4 mt-3 rounded"> Εγγραφή</button>
      </div>
    </form>
  );
};

export default SignupForm;
