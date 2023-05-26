import React, { useState } from 'react';

const SigninForm = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(`Submitted: ${username} ${password}`);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="flex w-full mb-auto bg-white rounded-xl mx-auto shadow-lg py-8 px-24 flex-col items-center">
        <h1 className="text-3xl mb-4 ">Σύνδεση στον Λογαριασμό</h1>
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
        <button className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-2 px-4 mt-3 rounded"> Σύνδεση</button>
      </div>
    </form>
  );
};

export default SigninForm;