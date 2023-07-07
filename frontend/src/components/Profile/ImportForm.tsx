import React, { useState } from 'react';
import axios from 'axios';

const ImportForm = () => {
  const [selectedFile, setSelectedFile] = useState<File | null>(null);

  const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    if (event.target.files && event.target.files.length > 0) {
      setSelectedFile(event.target.files[0]);
    }
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();

    if (!selectedFile) {
      // No file selected, handle the error
      console.error('No file selected');
      return;
    }

    const accessToken = localStorage.getItem('access_token');

    // Create a FormData object to send the file
    const formData = new FormData();
    formData.append('file', selectedFile);

    try {
      // Make the API call to import the file
      await axios.post('http://localhost:8080/api/import', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
          Authorization: `Bearer ${accessToken}`, // Include the access token in the headers
        },
      });
  
      // Handle success and display a success message
      console.log('File imported successfully');
    } catch (error) {
      // Handle error and display an error message
      console.error('Error importing file:', error);
    }
  };

  return (
    <div className="bg-white p-4 shadow">
      <h2 className="text-lg font-bold mb-2">Εισαγωγή νέου csv αρχείου</h2>
       <form onSubmit={handleSubmit}>
        <input type="file" onChange={handleFileChange} />
        <button type="submit" className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-1 px-4 mt-3 rounded">Upload</button>
      </form>
    </div>
  );
};

export default ImportForm;