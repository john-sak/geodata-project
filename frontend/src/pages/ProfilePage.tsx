import { useState, useEffect } from "react";
import Link from 'next/link'
import ImportFormPoi from "@/components/Profile/ImportFormPoi";
import ImportFormCat from "@/components/Profile/ImportFormCat";

const ProfilePage = () => {
  const [selectedOption, setSelectedOption] = useState('info');
  const [userBio, setUserBio] = useState('This is my bio...');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userObject, setUserObject] = useState(null);

  useEffect(() => {
    if(localStorage.getItem('user') != null){
      const userStr = localStorage.getItem('user')!;
      const parsedUserObject = JSON.parse(userStr);

      parsedUserObject.bio = 'This is my bio...';
      parsedUserObject.avatar = 'avatar.png';

      setUserObject(parsedUserObject); // Set userObject state with parsed user data
      setIsLoggedIn(true);
    }
  }, []);

  var user;
  if (userObject!=null){
    user = userObject;
  }
  else {
    user = {
      name: 'John',
      surname: 'Doe',
      username: 'JohnDoe',
      email: 'johndoe@example.com',
      phoneNumber: '1234567890',
      role: 'ADMIN',
      bio: 'This is my bio...',
      avatar: 'avatar.png' 
    };
  }

  const handleOptionSelect = (option: string) => {
    setSelectedOption(option);
  };

  const handleBioChange = (event: React.ChangeEvent<HTMLTextAreaElement>) => {
    setUserBio(event.target.value);
  };

  let mainContent;
  if (selectedOption === 'info') {
    mainContent = (
      <div className="bg-white p-4 shadow">
        <img
            className="w-44 h-44 rounded-full mx-auto"
            src={user.avatar}
            alt="User Avatar"
        />
        <h2 className="text-xl text-center font-bold">{user.username}</h2>
        <p className="mb-4 text-lg">Ονοματεπώνυμο: {user.name} {user.surname}</p>
        <p className="mb-4 text-lg">Τηλέφωνο: {user.phoneNumber}</p>
        <p className="mb-4 text-lg">Email: {user.email}</p>
        <h2 className="text-lg font-bold mb-2">About Me</h2>
        <textarea
          className="w-full p-2 border rounded"
          value={userBio}
          onChange={handleBioChange}
        ></textarea>
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
  else if (selectedOption === 'importpoi') {
    mainContent = <ImportFormPoi />;
  }
  else if (selectedOption === 'importcat') {
    mainContent = <ImportFormCat />;
  }


  if(isLoggedIn && user.role == 'USER'){
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
                      selectedOption === 'favorites'
                        ? 'text-white bg-sky-950'
                        : 'text-black-400 hover:text-white hover:bg-sky-800'
                    }`}
                    onClick={() => handleOptionSelect('favorites')}
                  >
                    Αγαπημένα
                  </button>
                </li>
                <li className="mt-10">
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
  }
  else if(isLoggedIn && user.role == 'ADMIN'){
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
                      selectedOption === 'importpoi'
                        ? 'text-white bg-sky-950'
                        : 'text-black-400 hover:text-white hover:bg-sky-800'
                    }`}
                    onClick={() => handleOptionSelect('importpoi')}
                  >
                    Εισαγωγή νέων points of interest
                  </button>
                </li>
                <li className="mb-2">
                  <button
                    className={`flex items-center py-2 px-4 rounded ${
                      selectedOption === 'importcat'
                        ? 'text-white bg-sky-950'
                        : 'text-black-400 hover:text-white hover:bg-sky-800'
                    }`}
                    onClick={() => handleOptionSelect('importcat')}
                  >
                    Εισαγωγή νέων categories
                  </button>
                </li>
                <li className="mt-10">
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
  }
};

export default ProfilePage;