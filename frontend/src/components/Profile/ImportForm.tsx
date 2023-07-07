import React, { useState } from 'react';
import axios from 'axios';

const ImportForm = () => {
    /*
  const [selectedFile, setSelectedFile] = useState(null);

  const handleFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    // Create a FormData object to send the file
    const formData = new FormData();
    formData.append('file', selectedFile);

    try {
      // Make the API call to import the file
      await axios.post('http://localhost:8080/api/import', formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });

      // Handle success and display a success message
      // ...
    } catch (error) {
      // Handle error and display an error message
      // ...
    }
  };
  */

  return (
    <div className="bg-white p-4 shadow">
      <h2 className="text-lg font-bold mb-2">Εισαγωγή νέου csv αρχείου</h2>
       {/* <form onSubmit={handleSubmit}>
        <input type="file" onChange={handleFileChange} />
        <button type="submit">Upload</button>
      </form> */}
      <button className="bg-purple-900 text-white hover:bg-blue-400 font-bold py-1 px-4 mt-3 rounded">Upload</button>
    </div>
  );
};

export default ImportForm;