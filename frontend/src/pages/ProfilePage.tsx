import React, { useState } from 'react';
import Link from 'next/link'

const ProfilePage = () => {
  const [selectedOption, setSelectedOption] = useState('profile');
  const [userBio, setUserBio] = useState('This is my bio...');

  const user = {
    name: 'John Doe',
    email: 'johndoe@example.com',
    bio: 'This is my bio',
    avatar: 'avatar.png',
    role: 'user'
  };

  const handleOptionSelect = (option: string) => {
    setSelectedOption(option);
  };

  const handleBioChange = (event: React.ChangeEvent<HTMLTextAreaElement>) => {
    setUserBio(event.target.value);
  };

  let mainContent;
  if (user.role === 'admin') {
    mainContent = (
      <div className="bg-white p-4 shadow">
        <h2 className="text-lg font-bold mb-2">Admin Dashboard</h2>
        {/* Render admin-specific content */}
      </div>
    );
  } else {
    if (selectedOption === 'info') {
      mainContent = (
        <div className="bg-white p-4 shadow">
          <img
              className="w-44 h-44 rounded-full mx-auto"
              src={user.avatar}
              alt="User Avatar"
          />
          <h2 className="text-xl text-center font-bold">{user.name}</h2>
          <p className="mb-8 text-lg">Email: {user.email}</p>
          <h2 className="text-lg font-bold mb-2">About Me</h2>
          <textarea
            className="w-full p-2 border rounded"
            value={userBio}
            onChange={handleBioChange}
          ></textarea>
        </div>
      );
    } else if (selectedOption === 'interest') {
      mainContent = (
        <div className="bg-white p-4 shadow">
          <h2 className="text-lg font-bold mb-2">Χάρτης</h2>
        </div>
      );
    }
    else if (selectedOption === 'favorites') {
      mainContent = (
        <div className="bg-white p-4 shadow">
          <h2 className="text-lg font-bold mb-2">Αγαπημένα</h2>
        </div>
      );
    } 
    else if (selectedOption === 'app') {}
  }

  return (
    <div className="flex">
      <aside className="relative h-[690px] bg-cyan-200 text-black w-1/5">
        <div className="p-4">
          <img
            className="w-16 h-16 rounded-full mx-auto mb-4"
            src={user.avatar}
            alt="User Avatar"
          />
          <h2 className="text-xl font-bold text-center mb-10">{user.name}</h2>
          <nav>
            <ul>
              <li className="mb-2">
                <button
                  className={`flex items-center py-2 px-4 rounded ${
                    selectedOption === 'info'
                      ? 'text-white bg-sky-950'
                      : 'text-black-400 hover:text-white hover:bg-sky-800'
                  }`}
                  onClick={() => handleOptionSelect('info')}
                >
                  Πληροφορίες Λογαριασμού
                </button>
              </li>
              <li className="mb-2">
                <button
                  className={`flex items-center py-2 px-4 rounded ${
                    selectedOption === 'interest'
                      ? 'text-white bg-sky-950'
                      : 'text-black-400 hover:text-white hover:bg-sky-800'
                  }`}
                  onClick={() => handleOptionSelect('interest')}
                >
                  Περιοχή Ενδιαφέροντος
                </button>
              </li>
              <li className="mb-2">
                <button
                  className={`flex items-center py-2 px-4 rounded ${
                    selectedOption === 'favorites'
                      ? 'text-white bg-sky-950'
                      : 'text-black-400 hover:text-white hover:bg-sky-800'
                  }`}
                  onClick={() => handleOptionSelect('favorites')}
                >
                  Αγαπημένα
                </button>
              </li>
              <li className="mb-2">
                <Link href="/">
                <button
                  className={`flex items-center py-2 px-4 rounded ${
                    selectedOption === 'app'
                      ? 'text-white bg-sky-950'
                      : 'text-black-400 hover:text-white hover:bg-sky-800'
                  }`}
                  onClick={() => handleOptionSelect('app')}
                >
                  Μεταφορά στην εφαρμογή
                </button>
                </Link>
              </li>
            </ul>
          </nav>
        </div>
      </aside>
      <main className="flex-grow p-4">{mainContent}</main>
    </div>
  );
};

export default ProfilePage;