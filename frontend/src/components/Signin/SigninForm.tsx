import React, { useState } from 'react';
import axios from 'axios'
import Link from 'next/link'

const SigninForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [errorMessage, setErrorMessage] = useState('');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(`Submitted: ${username} ${password}`);

    try {
      // Making POST request to the backend API endpoint for registration
      const response = await axios.post('http://localhost:8080/api/login', {
        username,
        password
      });
      // If request is succesful, show response in console and add access token to local storage
      console.log('Registration response:', response.data);

      const { userDto, accessToken, refreshToken} = response.data;

      //console.log('acc: ', accessToken, 'ref: ', refreshToken, 'user: ', userDto)

      // Save tokens and user data in local storage
      window.localStorage.setItem('access_token', accessToken);
      window.localStorage.setItem('refresh_token', refreshToken);
      window.localStorage.setItem('user', JSON.stringify(userDto));

      console.log(window.localStorage.getItem('user'));
      
      setIsLoggedIn(true);                // Used to print succesful login message
    } 
    catch (error) {
      console.error('Registration error:', error);
      // Handle registration error, display error message
      setErrorMessage('Μη έγκυρα στοιχεία.');
    }
  };

  if(isLoggedIn){
    return (
      <div className="flex w-full mb-auto rounded-xl mx-auto py-8 px-24 flex-col items-center">
      Συνδεθήκατε με επιτυχία!
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
        <h1 className="text-3xl mb-4 ">Σύνδεση στον Λογαριασμό</h1>
        {errorMessage && <p className="text-red-500 mb-4">{errorMessage}</p>}
        <div className="grid w-11/12 grid-cols-1 gap-3">
          <label>
            <input
              type="text"
              value={username}
              onChange={(event) => setUsername(event.target.value)}
              placeholder='Username'
              className="border border-gray-400 py-1 px-2 w-full"
            />
          </label>
          <br />
          <label>
            <input
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              placeholder='Κωδικός Πρόσβασης'
              className="border border-gray-400 py-1 px-2 w-full"
            />
          </label>
        </div>
        <button type="submit" className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-2 px-4 mt-3 rounded"> Σύνδεση</button>
        <p className="text-base mb-1 mt-8 ">Δεν έχετε Λογαριασμό;</p>
        <Link href="/SignupPage">
          <button className="bg-orange-600 text-white hover:bg-blue-400 font-bold py-1 px-4 rounded"> Εγγραφείτε εδώ!</button>
        </Link>
      </div>
    </form>
  );
};

export default SigninForm;