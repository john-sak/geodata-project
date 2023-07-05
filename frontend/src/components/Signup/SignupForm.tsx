import React, { useState } from 'react';
import axios from 'axios'

const SignupForm = () => {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(`Submitted: ${username} ${email} ${password} ${confirmPassword}`);

    try {
      // Making POST request to the backend API endpoint for registration
      const response = await axios.post('/api/register', {
        username,
        email,
        password,
        confirmPassword,
      });
      console.log('Registration response:', response.data);
      // Handle the registration response as needed, such as displaying a success message
    } catch (error) {
      console.error('Registration error:', error);
      // Handle registration error, display error message, etc.
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="flex w-full mb-auto bg-white rounded-xl mx-auto shadow-lg py-8 px-24 flex-col items-center">
        <h1 className="text-3xl mb-4 ">Δημιουργία Λογαριασμού</h1>
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
              type="email"
              value={email}
              onChange={(event) => setEmail(event.target.value)}
              placeholder='Email'
              className="border border-gray-400 py-1 px-2 w-full"
            />
          </label>
          <br />
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
          <br />
          <label>
            <input
              type="password"
              value={confirmPassword}
              onChange={(event) => setConfirmPassword(event.target.value)}
              placeholder='Επιβεβαίωση Κωδικού'
              className="border border-gray-400 py-1 px-2 w-full"
            />
          </label>
        </div>
        <button type="submit" className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-2 px-4 mt-3 rounded"> Εγγραφή</button>
      </div>
    </form>
  );
};

export default SignupForm;